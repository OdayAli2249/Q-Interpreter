package compiler;
import java.io.*;
import nodes.*;
import java.util.HashMap;
public class MyNewGrammar implements MyNewGrammarConstants {

  static HashMap<String,FunctionDef> functions = new HashMap<String,FunctionDef>();

    /**
     * @param args the command line arguments
     */
    public static String main(String[] args)throws ParseException,FileNotFoundException
     {

         FileInputStream fis = new FileInputStream("C:\u005c\u005cUsers\u005c\u005cOday Ali\u005c\u005ceclipse-workspace\u005c\u005ccomp_project\u005c\u005csrc\u005c\u005ctext.txt");
    MyNewGrammar parser = new MyNewGrammar(fis);
     AbstractTreeNode n = start();
    //  n.print("");
    Context context=new Context();
   n.execute(context);
   String list="";
  for(String s:context.getList())
  {list=list+s;
  }
return list;
    }

  static final public BlockNode start() throws ParseException {
  BlockNode n = new BlockNode();
  AbstractTreeNode c;
    label_1:
    while (true) {
      c = stmt();
                n.addChild(c);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RARROW:
      case LARROW:
      case IF:
      case WHILE:
      case FOR:
      case FUNC:
      case DEF:
      case ID:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode E() throws ParseException {
  Token t = null;
  ExpressionNode n1, n2 = null;
    n1 = F();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      t = jj_consume_token(PLUS);
      n2 = E();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    if (t == null)
        {if (true) return n1;}
    else
    {
        ExpressionNode en = new ExpressionNode();
        en.addChild(n1);
        en.addChild(n2);
        en.setOperator(t.image);
        {if (true) return en;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode F() throws ParseException {
  Token t = null;
  ExpressionNode n1,n2 = null;
    n1 = N();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULT:
      t = jj_consume_token(MULT);
      n2 = F();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    if (t == null)
        {if (true) return n1;}
    else
    {
        ExpressionNode en = new ExpressionNode();
        en.addChild(n1);
        en.addChild(n2);
        en.setOperator(t.image);
        {if (true) return en;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public FuncCallNode FuncCall() throws ParseException {
  FuncCallNode node = new FuncCallNode();
  Token t;
  AbstractTreeNode n;
    t = jj_consume_token(ID);
    jj_consume_token(LP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
    case LP:
    case DOUBLEQUT:
    case SINGLEQUT:
    case ID:
      n = E();
                           node.addChild(n);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 33:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
        jj_consume_token(33);
        n = E();
                node.addChild(n);
      }
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(RP);
    node.setFunctionName(t.image);
    node.setFunctions(functions);
    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode N() throws ParseException {
  Token t1 = null, t2 = null,t3=null,t4=null;
  ExpressionNode n= null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      t1 = jj_consume_token(NUM);
      break;
    case LP:
      jj_consume_token(LP);
      n = E();
      jj_consume_token(RP);
      break;
    default:
      jj_la1[5] = jj_gen;
      if (jj_2_1(2)) {
        n = FuncCall();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          t2 = jj_consume_token(ID);
          break;
        case DOUBLEQUT:
          jj_consume_token(DOUBLEQUT);
          t3 = jj_consume_token(ID);
          jj_consume_token(DOUBLEQUT);
          break;
        case SINGLEQUT:
          jj_consume_token(SINGLEQUT);
          t4 = jj_consume_token(ID);
          jj_consume_token(SINGLEQUT);
          break;
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    if (t1 != null)
    {ConstantNode cn = new ConstantNode();
      if(cn.isInteger(t1.image))
    {
      cn.setValue(Integer.parseInt(t1.image));}
    else
    {cn.setValue(Float.parseFloat(t1.image)); }
      {if (true) return cn;}
    }
    if(t3!=null)
    { ConstantNode cn = new ConstantNode();
      cn.setValue(t3.image);
      {if (true) return cn;}}
      if(t4!=null &&t4.image.length()==1)
      { ConstantNode cn = new ConstantNode();
      char c=t4.image.charAt(0);
      cn.setValue(c);
      {if (true) return cn;}}
    else if (n != null)
        {if (true) return n;}
    else
    {
      VariableNode vn = new VariableNode();
      vn.setName(t2.image);
      {if (true) return vn;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public IfNode ifStmt() throws ParseException {
  IfNode res = new IfNode();
  AbstractTreeNode n, nn;
  BlockNode cn = new BlockNode();
  BlockNode en = null;
    jj_consume_token(IF);
    jj_consume_token(LP);
    n = condor();
    jj_consume_token(RP);
    label_3:
    while (true) {
      nn = stmt();
      cn.addChild(nn);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RARROW:
      case LARROW:
      case IF:
      case WHILE:
      case FOR:
      case FUNC:
      case DEF:
      case ID:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
              en = new BlockNode();
      label_4:
      while (true) {
        nn = stmt();
                                                     en.addChild(nn);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RARROW:
        case LARROW:
        case IF:
        case WHILE:
        case FOR:
        case FUNC:
        case DEF:
        case ID:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(END);
    res.addChild(n);
    res.addChild(cn);
    if (en != null)
        res.addChild(en);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public WhileNode whileStmt() throws ParseException {
  WhileNode wnode = new WhileNode();
  BlockNode bnode = new BlockNode();
  AbstractTreeNode n,s;
    jj_consume_token(WHILE);
    jj_consume_token(LP);
    n = condor();
    jj_consume_token(RP);
    label_5:
    while (true) {
      s = stmt();
                 bnode.addChild(s);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RARROW:
      case LARROW:
      case IF:
      case WHILE:
      case FOR:
      case FUNC:
      case DEF:
      case ID:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_5;
      }
    }
    jj_consume_token(END);
    wnode.addChild(n);
    wnode.addChild(bnode);
    {if (true) return wnode;}
    throw new Error("Missing return statement in function");
  }

  static final public ForNode forStmt() throws ParseException {
  ForNode res = new ForNode();
  Token t;
  AbstractTreeNode n1,n2, n4 = null, tmp;
  BlockNode n3 = new BlockNode();
    jj_consume_token(FOR);
    t = jj_consume_token(ID);
    jj_consume_token(COLON);
    n1 = E();
    jj_consume_token(RARROW);
    n2 = E();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLON:
      jj_consume_token(COLON);
      n4 = E();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    label_6:
    while (true) {
      tmp = stmt();
                         n3.addChild(tmp);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RARROW:
      case LARROW:
      case IF:
      case WHILE:
      case FOR:
      case FUNC:
      case DEF:
      case ID:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(END);
          res.addChild(n1);
          res.addChild(n2);
          res.addChild(n3);
          res.setVarName(t.image);
          if (n4 != null)
                res.addChild(n4);
          {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignNode assignStmt() throws ParseException {
  Token t;
  AssignNode anode = new AssignNode();
  AbstractTreeNode n;
    t = jj_consume_token(ID);
    jj_consume_token(ASSIGN);
    n = E();
    jj_consume_token(SEMI);
          anode.setVarName(t.image);
          anode.addChild(n);
          {if (true) return anode;}
    throw new Error("Missing return statement in function");
  }

  static final public ReadNode readStmt() throws ParseException {
  ReadNode n = new ReadNode();
  Token t;
    jj_consume_token(RARROW);
    t = jj_consume_token(ID);
    jj_consume_token(SEMI);
          n.setVarName(t.image);
          {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public WriteNode writeStmt() throws ParseException {
  WriteNode n = new WriteNode();
  AbstractTreeNode nn;
    jj_consume_token(LARROW);
    nn = E();
    jj_consume_token(SEMI);
          n.addChild(nn);
          {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public Conditionlog condor() throws ParseException {
  Conditionlog n = new Conditionlog();
  BlockNode b=new BlockNode();
  AbstractTreeNode n1;
  Token t=null,s=null,f=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      t = jj_consume_token(NOT);
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      s = jj_consume_token(NOT);
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    n1 = condand();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_7;
      }
                                        Conditionlog n2=new Conditionlog();
      f = jj_consume_token(OR);
      n2 = condand();
                                                                                                  n2.setAo(f.image);b.addChild(n2);
    }
   if(t!=null)
  {
   n.getNot().put(0,t.image);
  }
  if(s!=null)
  {n.getNot().put(1,s.image);
  }
          n.addChild(n1);
          if(f!=null)
         {
            n.addChild(b);
            }
            else { n.addChild(null);}
          {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public Conditionlog condand() throws ParseException {
  Conditionlog n = new Conditionlog();
 BlockNode b=new BlockNode();
  AbstractTreeNode n1,n3;
  Token t=null,f=null,s=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    n1 = condition();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_8;
      }
                                    Conditionlog n2=new Conditionlog();
      f = jj_consume_token(AND);
      n3 = condition();
                                                                                                n2=(Conditionlog)n3;n2.setAo(f.image);b.addChild(n2);
    }
  if(t!=null)
  {
   n.getNot().put(0,t.image);
  }
  if(s!=null)
  {n.getNot().put(1,s.image);
  }
          n.addChild(n1);
          if(f!=null)
          n.addChild(b);
          {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public ConditionNode condition() throws ParseException {
  ConditionNode n = new ConditionNode();
  AbstractTreeNode n1,n2;
  Token t;
    n1 = E();
    t = jj_consume_token(CMP);
    n2 = E();
          n.addChild(n1);
          n.addChild(n2);
          n.setOperator(t.image);
          {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public AbstractTreeNode stmt() throws ParseException {
  AbstractTreeNode n = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      n = ifStmt();
      break;
    case WHILE:
      n = whileStmt();
      break;
    case FOR:
      n = forStmt();
      break;
    case ID:
      n = assignStmt();
      break;
    case RARROW:
      n = readStmt();
      break;
    case LARROW:
      n = writeStmt();
      break;
    case DEF:
      n = VarabailDef();
      break;
    case FUNC:
      FuncDef();
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  if (n == null)
        n = new BlockNode();
  {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public void FuncDef() throws ParseException {
  FunctionDef fd = new FunctionDef();
  Token name,t = null;
  BlockNode n = new BlockNode();
  AbstractTreeNode an;
    jj_consume_token(FUNC);
    name = jj_consume_token(ID);
    jj_consume_token(RARROW);
    jj_consume_token(LP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      t = jj_consume_token(ID);
                            fd.getParams().add(t.image);
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 33:
          ;
          break;
        default:
          jj_la1[20] = jj_gen;
          break label_9;
        }
        jj_consume_token(33);
        t = jj_consume_token(ID);
                         fd.getParams().add(t.image);
      }
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(RP);
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RARROW:
      case LARROW:
      case IF:
      case WHILE:
      case FOR:
      case FUNC:
      case DEF:
      case ID:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_10;
      }
      an = stmt();
                  n.addChild(an);
    }
    jj_consume_token(END);
          fd.setName(name.image);
          fd.setRoot(n);
          functions.put(fd.getName(),fd);
  }

  static final public DefVarabile VarabailDef() throws ParseException {
 DefVarabile node=new DefVarabile();
  Token t=null,n=null;
    jj_consume_token(DEF);
    t = jj_consume_token(ID);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FLOAT:
      n = jj_consume_token(FLOAT);
      break;
    case INT:
      n = jj_consume_token(INT);
      break;
    case CHAR:
      n = jj_consume_token(CHAR);
      break;
    case STRING:
      n = jj_consume_token(STRING);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(SEMI);
  node.setNametype(n.image);
  node.setNamevar(t.image);
  {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LP)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_11()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MyNewGrammarTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[24];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc0c98000,0x20,0x40,0x0,0x3001080,0x1080,0x3000000,0xc0c98000,0xc0c98000,0x100000,0xc0c98000,0x40000,0xc0c98000,0x20000000,0x20000000,0x10000000,0x20000000,0x20000000,0x8000000,0xc0c98000,0x0,0x0,0xc0c98000,0xf00,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1,0x0,0x0,0x2,0x1,0x0,0x1,0x1,0x1,0x0,0x1,0x0,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x2,0x1,0x1,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public MyNewGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyNewGrammar(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public MyNewGrammar(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public MyNewGrammar(MyNewGrammarTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MyNewGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 24; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[34];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 24; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 34; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
