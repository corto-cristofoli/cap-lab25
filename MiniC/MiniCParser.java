// Generated from MiniC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, EQ=3, NEQ=4, GT=5, LT=6, GTEQ=7, LTEQ=8, PLUS=9, MINUS=10, 
		MULT=11, DIV=12, MOD=13, NOT=14, COL=15, SCOL=16, COM=17, ASSIGN=18, OPAR=19, 
		CPAR=20, OBRACE=21, CBRACE=22, TRUE=23, FALSE=24, IF=25, ELSE=26, WHILE=27, 
		RETURN=28, PRINTLN_INT=29, PRINTLN_BOOL=30, PRINTLN_STRING=31, PRINTLN_FLOAT=32, 
		INTTYPE=33, FLOATTYPE=34, STRINGTYPE=35, BOOLTYPE=36, ID=37, INT=38, FLOAT=39, 
		STRING=40, COMMENT=41, SPACE=42;
	public static final int
		RULE_prog = 0, RULE_function = 1, RULE_vardecl_l = 2, RULE_vardecl = 3, 
		RULE_id_l = 4, RULE_block = 5, RULE_stat = 6, RULE_assignment = 7, RULE_if_stat = 8, 
		RULE_stat_block = 9, RULE_while_stat = 10, RULE_print_stat = 11, RULE_expr = 12, 
		RULE_atom = 13, RULE_typee = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "function", "vardecl_l", "vardecl", "id_l", "block", "stat", 
			"assignment", "if_stat", "stat_block", "while_stat", "print_stat", "expr", 
			"atom", "typee"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'!'", "':'", "';'", "','", "'='", "'('", 
			"')'", "'{'", "'}'", "'true'", "'false'", "'if'", "'else'", "'while'", 
			"'return'", "'println_int'", "'println_bool'", "'println_string'", "'println_float'", 
			"'int'", "'float'", "'string'", "'bool'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "NOT", "COL", "SCOL", "COM", "ASSIGN", "OPAR", 
			"CPAR", "OBRACE", "CBRACE", "TRUE", "FALSE", "IF", "ELSE", "WHILE", "RETURN", 
			"PRINTLN_INT", "PRINTLN_BOOL", "PRINTLN_STRING", "PRINTLN_FLOAT", "INTTYPE", 
			"FLOATTYPE", "STRINGTYPE", "BOOLTYPE", "ID", "INT", "FLOAT", "STRING", 
			"COMMENT", "SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgRuleContext extends ProgContext {
		public TerminalNode EOF() { return getToken(MiniCParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgRuleContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgRule(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new ProgRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTTYPE) {
				{
				{
				setState(30);
				function();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	 
		public FunctionContext() { }
		public void copyFrom(FunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends FunctionContext {
		public TerminalNode INTTYPE() { return getToken(MiniCParser.INTTYPE, 0); }
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public TerminalNode OBRACE() { return getToken(MiniCParser.OBRACE, 0); }
		public Vardecl_lContext vardecl_l() {
			return getRuleContext(Vardecl_lContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public TerminalNode CBRACE() { return getToken(MiniCParser.CBRACE, 0); }
		public FuncDefContext(FunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFuncDef(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		try {
			_localctx = new FuncDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(INTTYPE);
			setState(39);
			match(ID);
			setState(40);
			match(OPAR);
			setState(41);
			match(CPAR);
			setState(42);
			match(OBRACE);
			setState(43);
			vardecl_l();
			setState(44);
			block();
			setState(45);
			match(RETURN);
			setState(46);
			match(INT);
			setState(47);
			match(SCOL);
			setState(48);
			match(CBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Vardecl_lContext extends ParserRuleContext {
		public Vardecl_lContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl_l; }
	 
		public Vardecl_lContext() { }
		public void copyFrom(Vardecl_lContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclListContext extends Vardecl_lContext {
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public VarDeclListContext(Vardecl_lContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVarDeclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVarDeclList(this);
		}
	}

	public final Vardecl_lContext vardecl_l() throws RecognitionException {
		Vardecl_lContext _localctx = new Vardecl_lContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardecl_l);
		int _la;
		try {
			_localctx = new VarDeclListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) {
				{
				{
				setState(50);
				vardecl();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VardeclContext extends ParserRuleContext {
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
	 
		public VardeclContext() { }
		public void copyFrom(VardeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends VardeclContext {
		public TypeeContext typee() {
			return getRuleContext(TypeeContext.class,0);
		}
		public Id_lContext id_l() {
			return getRuleContext(Id_lContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public VarDeclContext(VardeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVarDecl(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vardecl);
		try {
			_localctx = new VarDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			typee();
			setState(57);
			id_l();
			setState(58);
			match(SCOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Id_lContext extends ParserRuleContext {
		public Id_lContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_l; }
	 
		public Id_lContext() { }
		public void copyFrom(Id_lContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdListBaseContext extends Id_lContext {
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public IdListBaseContext(Id_lContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIdListBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIdListBase(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdListContext extends Id_lContext {
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode COM() { return getToken(MiniCParser.COM, 0); }
		public Id_lContext id_l() {
			return getRuleContext(Id_lContext.class,0);
		}
		public IdListContext(Id_lContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIdList(this);
		}
	}

	public final Id_lContext id_l() throws RecognitionException {
		Id_lContext _localctx = new Id_lContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_id_l);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new IdListBaseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(ID);
				}
				break;
			case 2:
				_localctx = new IdListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(ID);
				setState(62);
				match(COM);
				setState(63);
				id_l();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatListContext extends BlockContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatListContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStatList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStatList(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			_localctx = new StatListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 145659789312L) != 0)) {
				{
				{
				setState(66);
				stat();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public While_statContext while_stat() {
			return getRuleContext(While_statContext.class,0);
		}
		public Print_statContext print_stat() {
			return getRuleContext(Print_statContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stat);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				assignment();
				setState(73);
				match(SCOL);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				if_stat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				while_stat();
				}
				break;
			case PRINTLN_INT:
			case PRINTLN_BOOL:
			case PRINTLN_STRING:
			case PRINTLN_FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				print_stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStatContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAssignStat(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			_localctx = new AssignStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(ID);
			setState(81);
			match(ASSIGN);
			setState(82);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statContext extends ParserRuleContext {
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
	 
		public If_statContext() { }
		public void copyFrom(If_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatContext extends If_statContext {
		public Stat_blockContext then_block;
		public Stat_blockContext else_block;
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public List<Stat_blockContext> stat_block() {
			return getRuleContexts(Stat_blockContext.class);
		}
		public Stat_blockContext stat_block(int i) {
			return getRuleContext(Stat_blockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public IfStatContext(If_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIfStat(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_stat);
		try {
			_localctx = new IfStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(IF);
			setState(85);
			match(OPAR);
			setState(86);
			expr(0);
			setState(87);
			match(CPAR);
			setState(88);
			((IfStatContext)_localctx).then_block = stat_block();
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(89);
				match(ELSE);
				setState(90);
				((IfStatContext)_localctx).else_block = stat_block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Stat_blockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(MiniCParser.OBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(MiniCParser.CBRACE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStat_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStat_block(this);
		}
	}

	public final Stat_blockContext stat_block() throws RecognitionException {
		Stat_blockContext _localctx = new Stat_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stat_block);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(OBRACE);
				setState(94);
				block();
				setState(95);
				match(CBRACE);
				}
				break;
			case IF:
			case WHILE:
			case PRINTLN_INT:
			case PRINTLN_BOOL:
			case PRINTLN_STRING:
			case PRINTLN_FLOAT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_statContext extends ParserRuleContext {
		public While_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stat; }
	 
		public While_statContext() { }
		public void copyFrom(While_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatContext extends While_statContext {
		public Stat_blockContext body;
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public WhileStatContext(While_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhileStat(this);
		}
	}

	public final While_statContext while_stat() throws RecognitionException {
		While_statContext _localctx = new While_statContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_stat);
		try {
			_localctx = new WhileStatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(WHILE);
			setState(101);
			match(OPAR);
			setState(102);
			expr(0);
			setState(103);
			match(CPAR);
			setState(104);
			((WhileStatContext)_localctx).body = stat_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Print_statContext extends ParserRuleContext {
		public Print_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stat; }
	 
		public Print_statContext() { }
		public void copyFrom(Print_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintlnintStatContext extends Print_statContext {
		public TerminalNode PRINTLN_INT() { return getToken(MiniCParser.PRINTLN_INT, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public PrintlnintStatContext(Print_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterPrintlnintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitPrintlnintStat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintlnstringStatContext extends Print_statContext {
		public TerminalNode PRINTLN_STRING() { return getToken(MiniCParser.PRINTLN_STRING, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public PrintlnstringStatContext(Print_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterPrintlnstringStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitPrintlnstringStat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintlnfloatStatContext extends Print_statContext {
		public TerminalNode PRINTLN_FLOAT() { return getToken(MiniCParser.PRINTLN_FLOAT, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public PrintlnfloatStatContext(Print_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterPrintlnfloatStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitPrintlnfloatStat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintlnboolStatContext extends Print_statContext {
		public TerminalNode PRINTLN_BOOL() { return getToken(MiniCParser.PRINTLN_BOOL, 0); }
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public TerminalNode SCOL() { return getToken(MiniCParser.SCOL, 0); }
		public PrintlnboolStatContext(Print_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterPrintlnboolStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitPrintlnboolStat(this);
		}
	}

	public final Print_statContext print_stat() throws RecognitionException {
		Print_statContext _localctx = new Print_statContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_print_stat);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINTLN_INT:
				_localctx = new PrintlnintStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(PRINTLN_INT);
				setState(107);
				match(OPAR);
				setState(108);
				expr(0);
				setState(109);
				match(CPAR);
				setState(110);
				match(SCOL);
				}
				break;
			case PRINTLN_FLOAT:
				_localctx = new PrintlnfloatStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(PRINTLN_FLOAT);
				setState(113);
				match(OPAR);
				setState(114);
				expr(0);
				setState(115);
				match(CPAR);
				setState(116);
				match(SCOL);
				}
				break;
			case PRINTLN_BOOL:
				_localctx = new PrintlnboolStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(PRINTLN_BOOL);
				setState(119);
				match(OPAR);
				setState(120);
				expr(0);
				setState(121);
				match(CPAR);
				setState(122);
				match(SCOL);
				}
				break;
			case PRINTLN_STRING:
				_localctx = new PrintlnstringStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(PRINTLN_STRING);
				setState(125);
				match(OPAR);
				setState(126);
				expr(0);
				setState(127);
				match(CPAR);
				setState(128);
				match(SCOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(MiniCParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitNotExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(MiniCParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterUnaryMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitUnaryMinusExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAtomExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitOrExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ExprContext {
		public Token myop;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MiniCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniCParser.MINUS, 0); }
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAdditiveExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ExprContext {
		public Token myop;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(MiniCParser.GT, 0); }
		public TerminalNode LT() { return getToken(MiniCParser.LT, 0); }
		public TerminalNode GTEQ() { return getToken(MiniCParser.GTEQ, 0); }
		public TerminalNode LTEQ() { return getToken(MiniCParser.LTEQ, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitRelationalExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExprContext extends ExprContext {
		public Token myop;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(MiniCParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MiniCParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiniCParser.MOD, 0); }
		public MultiplicativeExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterMultiplicativeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitMultiplicativeExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ExprContext {
		public Token myop;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MiniCParser.NEQ, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitEqualityExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitAndExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(133);
				match(MINUS);
				setState(134);
				expr(9);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(NOT);
				setState(136);
				expr(8);
				}
				break;
			case OPAR:
			case TRUE:
			case FALSE:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(141);
						((MultiplicativeExprContext)_localctx).myop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
							((MultiplicativeExprContext)_localctx).myop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(144);
						((AdditiveExprContext)_localctx).myop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AdditiveExprContext)_localctx).myop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(147);
						((RelationalExprContext)_localctx).myop = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
							((RelationalExprContext)_localctx).myop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(150);
						((EqualityExprContext)_localctx).myop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).myop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(153);
						match(AND);
						setState(154);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(156);
						match(OR);
						setState(157);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExprContext extends AtomContext {
		public TerminalNode OPAR() { return getToken(MiniCParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MiniCParser.CPAR, 0); }
		public ParExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(MiniCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MiniCParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterBooleanAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitBooleanAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIdAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIdAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatAtomContext extends AtomContext {
		public TerminalNode FLOAT() { return getToken(MiniCParser.FLOAT, 0); }
		public FloatAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFloatAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFloatAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntAtomContext extends AtomContext {
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public IntAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIntAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIntAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(MiniCParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStringAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atom);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(OPAR);
				setState(164);
				expr(0);
				setState(165);
				match(CPAR);
				}
				break;
			case INT:
				_localctx = new IntAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(FLOAT);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(170);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeeContext extends ParserRuleContext {
		public TypeeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typee; }
	 
		public TypeeContext() { }
		public void copyFrom(TypeeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicTypeContext extends TypeeContext {
		public Token mytype;
		public TerminalNode INTTYPE() { return getToken(MiniCParser.INTTYPE, 0); }
		public TerminalNode FLOATTYPE() { return getToken(MiniCParser.FLOATTYPE, 0); }
		public TerminalNode BOOLTYPE() { return getToken(MiniCParser.BOOLTYPE, 0); }
		public TerminalNode STRINGTYPE() { return getToken(MiniCParser.STRINGTYPE, 0); }
		public BasicTypeContext(TypeeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitBasicType(this);
		}
	}

	public final TypeeContext typee() throws RecognitionException {
		TypeeContext _localctx = new TypeeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typee);
		int _la;
		try {
			_localctx = new BasicTypeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((BasicTypeContext)_localctx).mytype = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) ) {
				((BasicTypeContext)_localctx).mytype = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u00b1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0005\u00024\b\u0002\n\u0002\f\u00027\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004A\b\u0004\u0001\u0005\u0005\u0005D\b\u0005\n\u0005\f\u0005"+
		"G\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006O\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\\\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tc\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0083\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u008b\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u009f"+
		"\b\f\n\f\f\f\u00a2\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u00ad\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0000\u0001\u0018\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0006\u0001\u0000\u000b\r\u0001"+
		"\u0000\t\n\u0001\u0000\u0005\b\u0001\u0000\u0003\u0004\u0001\u0000\u0017"+
		"\u0018\u0001\u0000!$\u00ba\u0000!\u0001\u0000\u0000\u0000\u0002&\u0001"+
		"\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000"+
		"\u0000\b@\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000\u0000\fN\u0001"+
		"\u0000\u0000\u0000\u000eP\u0001\u0000\u0000\u0000\u0010T\u0001\u0000\u0000"+
		"\u0000\u0012b\u0001\u0000\u0000\u0000\u0014d\u0001\u0000\u0000\u0000\u0016"+
		"\u0082\u0001\u0000\u0000\u0000\u0018\u008a\u0001\u0000\u0000\u0000\u001a"+
		"\u00ac\u0001\u0000\u0000\u0000\u001c\u00ae\u0001\u0000\u0000\u0000\u001e"+
		" \u0003\u0002\u0001\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005\u0000"+
		"\u0000\u0001%\u0001\u0001\u0000\u0000\u0000&\'\u0005!\u0000\u0000\'(\u0005"+
		"%\u0000\u0000()\u0005\u0013\u0000\u0000)*\u0005\u0014\u0000\u0000*+\u0005"+
		"\u0015\u0000\u0000+,\u0003\u0004\u0002\u0000,-\u0003\n\u0005\u0000-.\u0005"+
		"\u001c\u0000\u0000./\u0005&\u0000\u0000/0\u0005\u0010\u0000\u000001\u0005"+
		"\u0016\u0000\u00001\u0003\u0001\u0000\u0000\u000024\u0003\u0006\u0003"+
		"\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u00006\u0005\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u000089\u0003\u001c\u000e\u00009:\u0003\b\u0004\u0000"+
		":;\u0005\u0010\u0000\u0000;\u0007\u0001\u0000\u0000\u0000<A\u0005%\u0000"+
		"\u0000=>\u0005%\u0000\u0000>?\u0005\u0011\u0000\u0000?A\u0003\b\u0004"+
		"\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000A\t\u0001\u0000"+
		"\u0000\u0000BD\u0003\f\u0006\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u000b"+
		"\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0003\u000e\u0007"+
		"\u0000IJ\u0005\u0010\u0000\u0000JO\u0001\u0000\u0000\u0000KO\u0003\u0010"+
		"\b\u0000LO\u0003\u0014\n\u0000MO\u0003\u0016\u000b\u0000NH\u0001\u0000"+
		"\u0000\u0000NK\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NM\u0001"+
		"\u0000\u0000\u0000O\r\u0001\u0000\u0000\u0000PQ\u0005%\u0000\u0000QR\u0005"+
		"\u0012\u0000\u0000RS\u0003\u0018\f\u0000S\u000f\u0001\u0000\u0000\u0000"+
		"TU\u0005\u0019\u0000\u0000UV\u0005\u0013\u0000\u0000VW\u0003\u0018\f\u0000"+
		"WX\u0005\u0014\u0000\u0000X[\u0003\u0012\t\u0000YZ\u0005\u001a\u0000\u0000"+
		"Z\\\u0003\u0012\t\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\\u0011\u0001\u0000\u0000\u0000]^\u0005\u0015\u0000\u0000^_\u0003"+
		"\n\u0005\u0000_`\u0005\u0016\u0000\u0000`c\u0001\u0000\u0000\u0000ac\u0003"+
		"\f\u0006\u0000b]\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000c\u0013"+
		"\u0001\u0000\u0000\u0000de\u0005\u001b\u0000\u0000ef\u0005\u0013\u0000"+
		"\u0000fg\u0003\u0018\f\u0000gh\u0005\u0014\u0000\u0000hi\u0003\u0012\t"+
		"\u0000i\u0015\u0001\u0000\u0000\u0000jk\u0005\u001d\u0000\u0000kl\u0005"+
		"\u0013\u0000\u0000lm\u0003\u0018\f\u0000mn\u0005\u0014\u0000\u0000no\u0005"+
		"\u0010\u0000\u0000o\u0083\u0001\u0000\u0000\u0000pq\u0005 \u0000\u0000"+
		"qr\u0005\u0013\u0000\u0000rs\u0003\u0018\f\u0000st\u0005\u0014\u0000\u0000"+
		"tu\u0005\u0010\u0000\u0000u\u0083\u0001\u0000\u0000\u0000vw\u0005\u001e"+
		"\u0000\u0000wx\u0005\u0013\u0000\u0000xy\u0003\u0018\f\u0000yz\u0005\u0014"+
		"\u0000\u0000z{\u0005\u0010\u0000\u0000{\u0083\u0001\u0000\u0000\u0000"+
		"|}\u0005\u001f\u0000\u0000}~\u0005\u0013\u0000\u0000~\u007f\u0003\u0018"+
		"\f\u0000\u007f\u0080\u0005\u0014\u0000\u0000\u0080\u0081\u0005\u0010\u0000"+
		"\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082j\u0001\u0000\u0000\u0000"+
		"\u0082p\u0001\u0000\u0000\u0000\u0082v\u0001\u0000\u0000\u0000\u0082|"+
		"\u0001\u0000\u0000\u0000\u0083\u0017\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0006\f\uffff\uffff\u0000\u0085\u0086\u0005\n\u0000\u0000\u0086\u008b"+
		"\u0003\u0018\f\t\u0087\u0088\u0005\u000e\u0000\u0000\u0088\u008b\u0003"+
		"\u0018\f\b\u0089\u008b\u0003\u001a\r\u0000\u008a\u0084\u0001\u0000\u0000"+
		"\u0000\u008a\u0087\u0001\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u00a0\u0001\u0000\u0000\u0000\u008c\u008d\n\u0007\u0000\u0000"+
		"\u008d\u008e\u0007\u0000\u0000\u0000\u008e\u009f\u0003\u0018\f\b\u008f"+
		"\u0090\n\u0006\u0000\u0000\u0090\u0091\u0007\u0001\u0000\u0000\u0091\u009f"+
		"\u0003\u0018\f\u0007\u0092\u0093\n\u0005\u0000\u0000\u0093\u0094\u0007"+
		"\u0002\u0000\u0000\u0094\u009f\u0003\u0018\f\u0006\u0095\u0096\n\u0004"+
		"\u0000\u0000\u0096\u0097\u0007\u0003\u0000\u0000\u0097\u009f\u0003\u0018"+
		"\f\u0005\u0098\u0099\n\u0003\u0000\u0000\u0099\u009a\u0005\u0002\u0000"+
		"\u0000\u009a\u009f\u0003\u0018\f\u0004\u009b\u009c\n\u0002\u0000\u0000"+
		"\u009c\u009d\u0005\u0001\u0000\u0000\u009d\u009f\u0003\u0018\f\u0003\u009e"+
		"\u008c\u0001\u0000\u0000\u0000\u009e\u008f\u0001\u0000\u0000\u0000\u009e"+
		"\u0092\u0001\u0000\u0000\u0000\u009e\u0095\u0001\u0000\u0000\u0000\u009e"+
		"\u0098\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009f"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a1\u0019\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0013\u0000\u0000\u00a4"+
		"\u00a5\u0003\u0018\f\u0000\u00a5\u00a6\u0005\u0014\u0000\u0000\u00a6\u00ad"+
		"\u0001\u0000\u0000\u0000\u00a7\u00ad\u0005&\u0000\u0000\u00a8\u00ad\u0005"+
		"\'\u0000\u0000\u00a9\u00ad\u0007\u0004\u0000\u0000\u00aa\u00ad\u0005%"+
		"\u0000\u0000\u00ab\u00ad\u0005(\u0000\u0000\u00ac\u00a3\u0001\u0000\u0000"+
		"\u0000\u00ac\u00a7\u0001\u0000\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u001b\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0007\u0005\u0000\u0000\u00af\u001d\u0001\u0000\u0000"+
		"\u0000\f!5@EN[b\u0082\u008a\u009e\u00a0\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}