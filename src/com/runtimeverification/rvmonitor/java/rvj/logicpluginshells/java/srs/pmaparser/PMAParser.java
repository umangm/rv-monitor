/* Generated By:JavaCC: Do not edit this line. PMAParser.java */
  package com.runtimeverification.rvmonitor.java.rvj.logicpluginshells.java.srs.pmaparser;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.HashSet;
  import java.io.*;

  public class PMAParser implements PMAParserConstants {
    public static PMAParser parse(InputStream input) {
      PMAParser srsParser = new PMAParser(input);
      try{
        srsParser.Start();
      }
      catch(Exception e){
        System.err.println(e.getMessage());
        System.exit(1);
      }
      return srsParser;
    }

    public static PMAParser parse(String input) {
      PMAParser srsParser = new PMAParser(new StringReader(input));
      try{
        srsParser.Start();
      }
      catch(Exception e){
        System.err.println(e.getMessage());
        System.exit(1);
      }
      return srsParser;
    }

    public static void main(String[] args) throws ParseException, TokenMgrError {
      PMAParser parser = new PMAParser(System.in);
      parser.Start();
      ShellPatternMatchAutomaton pma = parser.getPMA();
      System.out.println(pma);
      System.out.println(pma.toImplString());
    }

    private Symbol begin = Symbol.get("^");
    private Symbol end   = Symbol.get("$");
    private ShellPatternMatchAutomaton pma = new ShellPatternMatchAutomaton(new State(0,0, null));
    public ShellPatternMatchAutomaton getPMA(){
      return pma;
    }

  final public void Start() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
            pma.setBegin(true);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
            pma.setEnd(true);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Pma();
    jj_consume_token(0);
  }

  final public void Pma() throws ParseException {
  State state;
  HashMap<Symbol, ActionState> transition;
    label_1:
    while (true) {
      state = State();
      jj_consume_token(OPENB);
      transition = Transition();
      jj_consume_token(CLOSEB);
      pma.put(state, transition);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPENA:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
    }
  }

  final public State State() throws ParseException {
Token number;
Token depth;
Rule rule = null;
    jj_consume_token(OPENA);
    number = jj_consume_token(NUMBER);
    jj_consume_token(19);
    depth = jj_consume_token(NUMBER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MATCHES:
      jj_consume_token(MATCHES);
      rule = Rule();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(CLOSEA);
    {if (true) return new State(new Integer(number.image), new Integer(depth.image), rule);}
    throw new Error("Missing return statement in function");
  }

  final public HashMap<Symbol, ActionState> Transition() throws ParseException {
  Token symbol;
  Token action;
  State state;
  HashMap<Symbol, ActionState> transition = new HashMap<Symbol, ActionState>();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TERMINAL:
        symbol = jj_consume_token(TERMINAL);
        break;
      case BEGIN:
        symbol = jj_consume_token(BEGIN);
        break;
      case END:
        symbol = jj_consume_token(END);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(ARROW);
      jj_consume_token(OPENB);
      action = jj_consume_token(NUMBER);
      jj_consume_token(CLOSEB);
      state = State();
     transition.put(Symbol.get(symbol.image),
                    new ActionState(new Integer(action.image), state));
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BEGIN:
      case END:
      case TERMINAL:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
    }
     {if (true) return transition;}
    throw new Error("Missing return statement in function");
  }

  final public Rule Rule() throws ParseException {
  Sequence lhs;
  AbstractSequence rhs;
    lhs = LhsSequence();
    jj_consume_token(ARROW);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TERMINAL:
      rhs = Sequence();
      break;
    case EPSILON:
      rhs = Epsilon();
      break;
    case FAIL:
    case SUCCEED:
      rhs = SucceedOrFail();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return new Rule(lhs,rhs);}
    throw new Error("Missing return statement in function");
  }

  final public Sequence LhsSequence() throws ParseException {
  Sequence ret = new Sequence();
  Sequence seq;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BEGIN:
      jj_consume_token(BEGIN);
         ret.add(begin);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    seq = Sequence();
                      ret.addAll(seq);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case END:
      jj_consume_token(END);
         ret.add(end);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  final public Sequence Sequence() throws ParseException {
  Sequence ret = new Sequence();
  Symbol s;
  Token t;
    t = jj_consume_token(TERMINAL);
    ret.add(Symbol.get(t.image));
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TERMINAL:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
      t = jj_consume_token(TERMINAL);
      ret.add(Symbol.get(t.image));
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  final public AbstractSequence SucceedOrFail() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUCCEED:
      jj_consume_token(SUCCEED);
     {if (true) return Succeed.get();}
      break;
    case FAIL:
      jj_consume_token(FAIL);
     {if (true) return Fail.get();}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Sequence Epsilon() throws ParseException {
    jj_consume_token(EPSILON);
    {if (true) return new Sequence();}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public PMAParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x60,0x60,0x100,0x10,0x4c000,0x4c000,0x43004,0x4000,0x8000,0x40000,0x3000,};
   }

  /** Constructor with InputStream. */
  public PMAParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public PMAParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new PMAParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public PMAParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new PMAParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public PMAParser(PMAParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(PMAParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[20];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 20; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  }