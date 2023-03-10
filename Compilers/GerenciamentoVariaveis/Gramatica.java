/* Gramatica.java */
/* Generated By:JavaCC: Do not edit this line. Gramatica.java */
import java.io.*;

class Gramatica implements GramaticaConstants {
  static Tabelas Tabela = new Tabelas (); // Para o gerenciamento de variáveis
  public static void main (String[] args) throws ParseException
  {
   try
   {
    Gramatica analisador = new Gramatica (System.in);
    analisador.Programa();
    System.out.println("Compilado....");
  }
  catch(TokenMgrError e) {
  System.err.println("Lexical Error:\u005cn" + e.getMessage());
 }
  catch(ParseException e) {
  System.err.println("Syntactic Error:\u005cn" + e.getMessage());
  }
  catch(Exception e) {
  System.err.println("Semantic error:\u005cn" + e.getMessage()  );
  e.printStackTrace();
  }
 }

//////////////////////////////////INICIO//////////////////////////////
  final public void Programa() throws ParseException {
    jj_consume_token(INICIO);
    Variaveis();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case REPEAT:
      case DO:
      case FOR:
      case IDENTIFICADOR:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Comandos(true);
    }
    jj_consume_token(FIM);
    jj_consume_token(0);
Tabela.imprime();
  }

//////////////////////////////////////////////////////////////////////
  final public void Variaveis() throws ParseException {Token var=null, tipo=null;
    label_2:
    while (true) {
      tipo = jj_consume_token(TIPO);
      var = jj_consume_token(IDENTIFICADOR);
if (tipo.image.equals("STRING"))
    Tabela.insere (var.image, "null",tipo.image) ;
  else if (tipo.image.equals("BOOL"))
    Tabela.insere (var.image, "false",tipo.image);
  else
    Tabela.insere (var.image, "0", tipo.image) ;
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIPO:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
    }
  }

//////////////////////////////////////////////////////////////////////
  final public void Comandos(boolean valida) throws ParseException {
    if (jj_2_1(3)) {
      Atribuicao(valida);
    } else {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFICADOR:{
        Ternario(valida);
        break;
        }
      case IF:{
        Condicional();
        break;
        }
      case WHILE:
      case REPEAT:
      case DO:
      case FOR:{
        Iterativo();
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//////////////////////////////////////////////////////////////////////
  final public 

void Iterativo() throws ParseException {Token t = null; boolean valida = true;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WHILE:{
      jj_consume_token(WHILE);
      jj_consume_token(AP);
      t = Expressao();
      jj_consume_token(FP);
      jj_consume_token(DO);
      jj_consume_token(AC);
      label_3:
      while (true) {
        Comandos(valida);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case REPEAT:
        case DO:
        case FOR:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          break label_3;
        }
      }
      jj_consume_token(FC);
      break;
      }
    case REPEAT:{
      jj_consume_token(REPEAT);
      jj_consume_token(AC);
      label_4:
      while (true) {
        Comandos(valida);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case REPEAT:
        case DO:
        case FOR:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_4;
        }
      }
      jj_consume_token(FC);
      jj_consume_token(UNTIL);
      jj_consume_token(AP);
      t = Expressao();
      jj_consume_token(FP);
      break;
      }
    case DO:{
      jj_consume_token(DO);
      jj_consume_token(AC);
      label_5:
      while (true) {
        Comandos(valida);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case REPEAT:
        case DO:
        case FOR:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          break label_5;
        }
      }
      jj_consume_token(FC);
      jj_consume_token(WHILE);
      jj_consume_token(AP);
      t = Expressao();
      jj_consume_token(FP);
      break;
      }
    case FOR:{
      jj_consume_token(FOR);
      jj_consume_token(AP);
      jj_consume_token(IDENTIFICADOR);
      jj_consume_token(ATRIB);
      jj_consume_token(DIGITO);
      jj_consume_token(PV);
      t = Expressao();
      jj_consume_token(PV);
      jj_consume_token(IDENTIFICADOR);
      jj_consume_token(SINAL);
      jj_consume_token(SINAL);
      jj_consume_token(FP);
      jj_consume_token(AC);
      label_6:
      while (true) {
        Comandos(valida);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case REPEAT:
        case DO:
        case FOR:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          break label_6;
        }
      }
      jj_consume_token(FC);
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//////////////////////////////////////////////////////////////////////
  final public 
void Condicional() throws ParseException {Token t=null; boolean valida=true;
    jj_consume_token(IF);
    jj_consume_token(AP);
    t = Expressao();
    jj_consume_token(FP);
    jj_consume_token(THEN);
    jj_consume_token(AC);
if(t.image.equals("true"))
      valida = true;
    else
      valida = false;
    label_7:
    while (true) {
      Comandos(valida);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case REPEAT:
      case DO:
      case FOR:
      case IDENTIFICADOR:{
        ;
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        break label_7;
      }
    }
    jj_consume_token(FC);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ELSE:{
      jj_consume_token(ELSE);
      jj_consume_token(AC);
      label_8:
      while (true) {
        Comandos(!valida);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case REPEAT:
        case DO:
        case FOR:
        case IDENTIFICADOR:{
          ;
          break;
          }
        default:
          jj_la1[9] = jj_gen;
          break label_8;
        }
      }
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    jj_consume_token(FC);
  }

//////////////////////////////////////////////////////////////////////
  final public 
Token Expressao() throws ParseException {Token tk=null, n=null, d=null; boolean a=false, b=true;
    //ANALISE SEMANTICA
      tk = termo_Alfa();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case BOOL_A:{
        ;
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        break label_9;
      }
      n = jj_consume_token(BOOL_A);
      d = termo_Alfa();
if(n!=null)
      {
        if(tk.image.equals("true"))
          a=true;
        else
          a=false;
        if(d.image.equals("true"))
          b=true;
        else
          b=false;

        a = a||b;
      }

      if(a)
        tk.image="true";
      else
        tk.image="false";
    }
{if ("" != null) return tk;}
    throw new Error("Missing return statement in function");
  }

//////////////////////////////////////////////////////////////////////
  final public 
Token termo_Alfa() throws ParseException {Token tk=null, m=null, d=null, r=null; boolean a=true, b=true; double num_a=0.00, num_b=0.00;
    tk = termo_Beta();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case BOOL_B:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_10;
      }
      m = jj_consume_token(BOOL_B);
      d = termo_Beta();
if(m!=null)
    {
      if(tk.image.equals("true"))
        a=true;
      else
        a=false;

      if(d.image.equals("true"))
        b=true;
      else
        b=false;

      a=a&&b;
    }

    if(a)
      tk.image = "true";
    else
      tk.image = "false";
    }
{if ("" != null) return tk;}
    throw new Error("Missing return statement in function");
  }

//////////////////////////////////////////////////////////////////////
  final public 

Token termo_Beta() throws ParseException {Token tk=null, d=null, r=null; boolean a=true; double num_a=0.00, num_b=0.00; String bal="a", bel="a";
    tk = fator();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case RELACIONAIS:{
        ;
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        break label_11;
      }
      r = jj_consume_token(RELACIONAIS);
      d = fator();
if(r!=null)
      {
        boolean isNumeric = tk.image.matches("[+-]?\u005c\u005cd*(\u005c\u005c.\u005c\u005cd+)?"); //Comando que verifica se eh numero
        if(isNumeric)
        {
          num_a = Double.parseDouble(tk.image);
          num_b = Double.parseDouble(d.image);

          if(r.image.equals(">=") || r.image.equals(">")){
           a = num_a>=num_b;
          }

         else if(r.image.equals("<=") || r.image.equals("<")){
           a = num_a<=num_b;
          }

          else if(r.image.equals("==")){
            a = num_a==num_b;
          }

          else if(r.image.equals("!=")){
            a = num_a!=num_b;
          }
        }

        else if(r.image.equals("=="))
          a = tk.image.equals(d.image);

        else if(r.image.equals("!="))
          a = !tk.image.equals(d.image);
      }
  if(a)
    tk.image = "true";
  else
    tk.image = "false";
    }
{if ("" != null) return tk;}
    throw new Error("Missing return statement in function");
  }

//////////////////////////////////////////////////////////////////////
  final public 
Token fator() throws ParseException {Token num=null, bool=null, n1=null, flutuante = null, string = null, var=null; String valor, tipo;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NEGACAO:
    case IDENTIFICADOR:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NEGACAO:{
        n1 = jj_consume_token(NEGACAO);
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        ;
      }
      var = jj_consume_token(IDENTIFICADOR);
valor = Tabela.searchValue(var.image);

    if(n1!=null)
    {
      tipo = Tabela.searchTipe(var.image);
      if(tipo.equals("BOOL"))
        if(valor.equals("true"))
          var.image="false";
        else
          var.image="true";
    }
    else if(valor!="")
      var.image=valor;

    {if ("" != null) return var;}
      break;
      }
    case DIGITO:{
      num = jj_consume_token(DIGITO);
{if ("" != null) return num;}
      break;
      }
    case NUM:{
      flutuante = jj_consume_token(NUM);
{if ("" != null) return flutuante;}
      break;
      }
    case SENTENCA_BOOLEANA:{
      bool = jj_consume_token(SENTENCA_BOOLEANA);
{if ("" != null) return bool;}
      break;
      }
    case PALAVRA:{
      string = jj_consume_token(PALAVRA);
{if ("" != null) return string;}
      break;
      }
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

//////////////////////////////////////////////////////////////////////
  final public 

void Ternario(boolean valida) throws ParseException {Token var=null, exp=null;
    var = jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ATRIBTERNARIO);
    exp = Expressao();
    jj_consume_token(PERGTERNARIO);
if(exp.image.equals("true"))
      valida=true;
    else
      valida=false;
    Aux(valida, var);
    jj_consume_token(DP);
    Aux(!valida, var);
  }

//////////////////////////////////////////////////////////////////////
  final public 

void Atribuicao(boolean valida) throws ParseException {Token var=null;
    var = jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ATRIB);
    Aux(valida, var);
  }

//////////////////////////////////////////////////////////////////////
  final public void Aux(boolean valida, Token var) throws ParseException {Token valor=null, flutuante = null, bool=null, ident=null, nome=null; String result=null, result2=null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DIGITO:{
      valor = jj_consume_token(DIGITO);
result = Tabela.searchTipe(var.image);
        if(result.equals("INT") && valida)
          Tabela.insere(var.image, valor.image, "INT");
        else if (valida)
        {
          int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
          System.err.println("Semantic error: " + currentLine + ": " + var.image + " nao eh um inteiro");
          System.exit(1);
        }
      break;
      }
    case NUM:{
      flutuante = jj_consume_token(NUM);
result = Tabela.searchTipe(var.image);
        if (result.equals("FLOAT") && valida){
          Tabela.insere (var.image,flutuante.image,"FLOAT");
        }
        else if(valida){
          int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
          System.err.println("Semantic error: " + currentLine + ": " + var.image + " nao eh um float");
          System.exit(1);
        }
      break;
      }
    case SENTENCA_BOOLEANA:{
      bool = jj_consume_token(SENTENCA_BOOLEANA);
result = Tabela.searchTipe(var.image);

        if(result.equals("BOOL") && valida){
          Tabela.insere (var.image,bool.image,"BOOL");
        }
        else if(valida){
          int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
          System.err.println("Semantic error: " + currentLine + ": " + var.image + " nao eh um booleano");
          System.exit(1);
        }
      break;
      }
    case PALAVRA:{
      nome = jj_consume_token(PALAVRA);
result = Tabela.searchTipe(var.image);
        if(result.equals("STRING") && valida){
          Tabela.insere (var.image,nome.image,"STRING");
        }
        else if(valida){
          int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
          System.err.println("Semantic error: " + currentLine + ": " + var.image + " nao eh uma string");
          System.exit(1);
        }
      break;
      }
    case IDENTIFICADOR:{
      ident = jj_consume_token(IDENTIFICADOR);
result = Tabela.searchTipe(ident.image);
        result2 = Tabela.searchTipe(var.image);
        if(result.equals(result2) && valida){
          Tabela.insere (var.image, Tabela.searchValue(ident.image), result);
        }
        else if(valida){
          int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
          System.err.println("Semantic error: " + currentLine + ": " + var.image + " nao eh do mesmo tipo que " + ident.image);
          System.exit(1);
        }
      break;
      }
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_18()
 {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_scan_token(DIGITO)) return true;
    return false;
  }

  private boolean jj_3R_13()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_14()) {
    jj_scanpos = xsp;
    if (jj_3R_15()) {
    jj_scanpos = xsp;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) {
    jj_scanpos = xsp;
    if (jj_3R_18()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_3R_12()) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    if (jj_scan_token(PALAVRA)) return true;
    return false;
  }

  private boolean jj_3R_16()
 {
    if (jj_scan_token(SENTENCA_BOOLEANA)) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    if (jj_scan_token(NUM)) return true;
    return false;
  }

  private boolean jj_3R_12()
 {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    if (jj_scan_token(ATRIB)) return true;
    if (jj_3R_13()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public GramaticaTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[17];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x21e40,0x10000,0x21e40,0x21e40,0x21e40,0x21e40,0x21e40,0x1e00,0x21e40,0x21e40,0x100,0x4,0x10,0x2,0x8,0x360028,0x360020,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Gramatica(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Gramatica(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GramaticaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Gramatica(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GramaticaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Gramatica(GramaticaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(GramaticaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
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

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
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

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
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
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[36];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 17; i++) {
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
    for (int i = 0; i < 36; i++) {
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
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
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

  private void jj_save(int index, int xla) {
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
