// Generated from MiniC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniCParser}.
 */
public interface MiniCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code progRule}
	 * labeled alternative in {@link MiniCParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgRule(MiniCParser.ProgRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progRule}
	 * labeled alternative in {@link MiniCParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgRule(MiniCParser.ProgRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDef}
	 * labeled alternative in {@link MiniCParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MiniCParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDef}
	 * labeled alternative in {@link MiniCParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MiniCParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclList}
	 * labeled alternative in {@link MiniCParser#vardecl_l}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclList(MiniCParser.VarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclList}
	 * labeled alternative in {@link MiniCParser#vardecl_l}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclList(MiniCParser.VarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link MiniCParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MiniCParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link MiniCParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MiniCParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idListBase}
	 * labeled alternative in {@link MiniCParser#id_l}.
	 * @param ctx the parse tree
	 */
	void enterIdListBase(MiniCParser.IdListBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idListBase}
	 * labeled alternative in {@link MiniCParser#id_l}.
	 * @param ctx the parse tree
	 */
	void exitIdListBase(MiniCParser.IdListBaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idList}
	 * labeled alternative in {@link MiniCParser#id_l}.
	 * @param ctx the parse tree
	 */
	void enterIdList(MiniCParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idList}
	 * labeled alternative in {@link MiniCParser#id_l}.
	 * @param ctx the parse tree
	 */
	void exitIdList(MiniCParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statList}
	 * labeled alternative in {@link MiniCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterStatList(MiniCParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statList}
	 * labeled alternative in {@link MiniCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitStatList(MiniCParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(MiniCParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(MiniCParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link MiniCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(MiniCParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link MiniCParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(MiniCParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MiniCParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MiniCParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MiniCParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MiniCParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(MiniCParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(MiniCParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MiniCParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MiniCParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MiniCParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MiniCParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnintStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnintStat(MiniCParser.PrintlnintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnintStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnintStat(MiniCParser.PrintlnintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnfloatStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnfloatStat(MiniCParser.PrintlnfloatStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnfloatStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnfloatStat(MiniCParser.PrintlnfloatStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnboolStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnboolStat(MiniCParser.PrintlnboolStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnboolStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnboolStat(MiniCParser.PrintlnboolStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printlnstringStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnstringStat(MiniCParser.PrintlnstringStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printlnstringStat}
	 * labeled alternative in {@link MiniCParser#print_stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnstringStat(MiniCParser.PrintlnstringStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MiniCParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MiniCParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(MiniCParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(MiniCParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MiniCParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MiniCParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MiniCParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MiniCParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(MiniCParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(MiniCParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(MiniCParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(MiniCParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(MiniCParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(MiniCParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(MiniCParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MiniCParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MiniCParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(MiniCParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(MiniCParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntAtom(MiniCParser.IntAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntAtom(MiniCParser.IntAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFloatAtom(MiniCParser.FloatAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFloatAtom(MiniCParser.FloatAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(MiniCParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(MiniCParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(MiniCParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(MiniCParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(MiniCParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link MiniCParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(MiniCParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicType}
	 * labeled alternative in {@link MiniCParser#typee}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(MiniCParser.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicType}
	 * labeled alternative in {@link MiniCParser#typee}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(MiniCParser.BasicTypeContext ctx);
}