MYNAME = JohnDoe
PACKAGE = MiniC
# Example: stop at the first failed test:
#   make PYTEST_OPTS=-x test
PYTEST_OPTS =
# Run the whole test infrastructure for a subset of test files e.g.
#   make FILTER='TypingAndInterpret/**/bad*.c' test
ifdef FILTER
export FILTER
endif

# code generation mode
ifdef MODE
MINICC_OPTS+=--mode $(MODE)
endif

export MINICC_OPTS

PYTEST_BASE_OPTS=-vv -rs --failed-first --cov="$(PWD)" --cov-report=term --cov-report=html

ifndef ANTLR4
abort:
	$(error variable ANTLR4 is not set)
endif

all: antlr

.PHONY: antlr
antlr MiniCLexer.py MiniCParser.py: $(PACKAGE).g4
	$(ANTLR4) $< -Dlanguage=Python3 -visitor -no-listener

main-deps: MiniCLexer.py MiniCParser.py TypingAndInterpret/MiniCInterpretVisitor.py TypingAndInterpret/MiniCTypingVisitor.py

doc: antlr
	sphinx-apidoc -e -f -o doc/api . TP* replace_* *Wrapper* MiniC* conf* test*
	make -C doc html

test: test-interpret



test-pyright: antlr
	pyright .

test-parse: test-pyright antlr
	MINICC_OPTS="$(MINICC_OPTS) --mode=parse" python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) ./test_codegen.py -k 'naive'

test-typecheck: test-pyright antlr
	MINICC_OPTS="$(MINICC_OPTS) --mode=typecheck" python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) ./test_codegen.py -k 'naive'

test-interpret: test-pyright test_interpreter.py main-deps
	python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) test_interpreter.py


ifndef MODE
# The export must be on the same line as the command (note the ';'), because
# make starts a new shell for each line.
LINEAR=export MINICC_OPTS="${MINICC_OPTS} --mode codegen-linear"; 
else
LINEAR=
endif

# Test for naive allocator (also runs test_expect to check // EXPECTED directives):
test-naive: test-pyright antlr
	$(LINEAR) python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) ./test_codegen.py -k 'test_naive or test_expect'

test-mem: test-pyright antlr
	$(LINEAR) python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) ./test_codegen.py -k 'test_alloc_mem'

test-hybrid: test-pyright antlr
	ALLOC_FILE=CodeGen/HybridNaiveAllocator.py ./test_replace_mem.py -vv --failed-first $(PYTEST_OPTS)
	$(LINEAR) python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) ./test_codegen.py -k 'test_alloc_hybrid'

# Test for all but the smart allocator, i.e. everything that lab4 should pass:
test-lab4: test-pyright antlr
	$(LINEAR) python3 -m pytest $(PYTEST_BASE_OPTS) $(PYTEST_OPTS) ./test_codegen.py -k 'not test_smart'

NAME_CLEAN = ${shell printf '%s' "$(MYNAME)" | tr -cd '[0-9a-zA-Z]'}
BASEDIR=$$(basename "$$PWD")
tar: clean
	dir=$$(basename "$$PWD") && cd .. && \
	tar cvfz "$$dir"-$(NAME_CLEAN).tgz --exclude=".git" --exclude=".pytest_cache"  \
	--exclude="htmlcov" "$$dir"
	@echo "Created ../$$(basename "$$PWD")-$(NAME_CLEAN).tgz"

# Remove any assembly file that was created by a test.
# Don't just find -name \*.s -exec rm {} \; because there may be legitimate .s files in the testsuite.
define CLEAN
import glob
import os
for file in glob.glob("**/tests/**/*.c", recursive=True):
	for s in (f"{file[:-2]}-{test}.s" for test in ("naive", "smart", "gcc", "all-in-mem", "hybrid")):
		try:
			os.remove(s)
			print("Removed {}".format(s))
		except OSError:
			pass
endef
export CLEAN
clean-tests:
	@python3 -c "$$CLEAN"
	find . -iname "*.riscv" -print0 | xargs -0 rm -rf \;

clean: clean-tests
	find . \( -iname "*~" -or -iname ".cache*" -or -iname "*.diff" -or -iname "log*.txt" -or -iname "__pycache__" -or -iname "*.tokens" -or -iname "*.interp" \) -print0 | xargs -0 rm -rf \;
	rm -rf *~ $(PACKAGE)Parser.py $(PACKAGE)Lexer.py $(PACKAGE)Visitor.py .coverage .benchmarks

.PHONY: install-deps
install-deps:
	python3 -m pip install --upgrade antlr4-python3-runtime==4.13.1 pytest pytest-cov pytest-xdist coverage graphviz networkx pygraphviz iniconfig 

.PHONY: test test-interpret test-codegen clean clean-tests tar antlr
# multiple invocations of pytest in parallel would share temporary file names
# and sometimes break. Parallelism can be achieved within pytest with
# pytest-xdist, which is efficient and safe.
.NOTPARALLEL:
