BASE=riscv64-unknown-elf
FLAGS=-march=rv64g
CC=$(BASE)-gcc
AS=$(BASE)-as
OBJDUMP=$(BASE)-objdump

STDLIB=libprint.s libprint.old.s
ALL=$(filter-out $(STDLIB),$(wildcard *.s))
ALLOBJ=$(ALL:.s=.o)
ALLBINARIES=$(ALL:.s=.riscv)

all: $(ALLBINARIES)

%.o: %.s 
	$(AS) $(FLAGS) -o $@ $< 

%.riscv: %.o libprint.o
	$(CC) $(FLAGS) -o $@  $^

%.lst: %.o
	$(OBJDUMP) -d $< > $@


.PHONY: clean

clean:
	rm -f *.o *.riscv *~ *.lst ex1.s
