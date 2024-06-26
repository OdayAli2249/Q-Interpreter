package compiler;
import java.io.*;
import nodes.*;
import java.util.HashMap;

/** Token Manager. */
public class MyNewGrammarTokenManager implements MyNewGrammarConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x8000L) != 0L)
         {
            jjmatchedKind = 5;
            return -1;
         }
         if ((active0 & 0x40000L) != 0L)
            return 8;
         if ((active0 & 0xc0000f00L) != 0L)
         {
            jjmatchedKind = 32;
            return 16;
         }
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 26;
            return 18;
         }
         return -1;
      case 1:
         if ((active0 & 0x8000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0xc0000f00L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 1;
            return 16;
         }
         return -1;
      case 2:
         if ((active0 & 0x40000d00L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 2;
            return 16;
         }
         if ((active0 & 0x80000200L) != 0L)
            return 16;
         return -1;
      case 3:
         if ((active0 & 0x40000800L) != 0L)
            return 16;
         if ((active0 & 0x500L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 3;
            return 16;
         }
         return -1;
      case 4:
         if ((active0 & 0x100L) != 0L)
            return 16;
         if ((active0 & 0x400L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 4;
            return 16;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjStopAtPos(0, 21);
      case 34:
         return jjStopAtPos(0, 24);
      case 36:
         return jjStopAtPos(0, 27);
      case 38:
         return jjStopAtPos(0, 23);
      case 39:
         return jjStopAtPos(0, 25);
      case 40:
         return jjStopAtPos(0, 12);
      case 41:
         return jjStopAtPos(0, 13);
      case 44:
         return jjStopAtPos(0, 33);
      case 45:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 58:
         return jjStartNfaWithStates_0(0, 18, 8);
      case 59:
         return jjStopAtPos(0, 17);
      case 60:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 63:
         jjmatchedKind = 19;
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 64:
         return jjStopAtPos(0, 22);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x40000100L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 124:
         return jjStopAtPos(0, 28);
      case 126:
         return jjStopAtPos(0, 29);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 45:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(1, 16);
         break;
      case 62:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(1, 15);
         break;
      case 63:
         if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(1, 20);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L);
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x100L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 102:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(2, 31, 16);
         break;
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x100L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 116:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(2, 9, 16);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 99:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(3, 30, 16);
         break;
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 114:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 16);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      case 116:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(4, 8, 16);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 103:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(5, 10, 16);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 19;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 7)
                        kind = 7;
                     jjCheckNAddStates(0, 2);
                  }
                  else if ((0x7000000000000000L & l) != 0L)
                  {
                     if (kind > 26)
                        kind = 26;
                  }
                  else if ((0x840000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                  }
                  else if ((0x280000000000L & l) != 0L)
                  {
                     if (kind > 5)
                        kind = 5;
                  }
                  else if (curChar == 58)
                     jjCheckNAdd(8);
                  if (curChar == 60)
                     jjCheckNAddTwoStates(13, 18);
                  else if (curChar == 62)
                     jjCheckNAdd(13);
                  else if (curChar == 42)
                     jjCheckNAdd(8);
                  else if (curChar == 43)
                     jjCheckNAdd(8);
                  break;
               case 18:
                  if (curChar == 62)
                  {
                     if (kind > 26)
                        kind = 26;
                  }
                  else if (curChar == 61)
                  {
                     if (kind > 26)
                        kind = 26;
                  }
                  break;
               case 1:
                  if ((0x840000000000L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAddStates(0, 2);
                  break;
               case 3:
                  if (curChar == 46)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAddTwoStates(4, 5);
                  break;
               case 6:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAdd(7);
                  break;
               case 8:
                  if (curChar == 61 && kind > 14)
                     kind = 14;
                  break;
               case 9:
                  if (curChar == 58)
                     jjCheckNAdd(8);
                  break;
               case 10:
                  if (curChar == 43)
                     jjCheckNAdd(8);
                  break;
               case 11:
                  if (curChar == 42)
                     jjCheckNAdd(8);
                  break;
               case 12:
                  if ((0x7000000000000000L & l) != 0L && kind > 26)
                     kind = 26;
                  break;
               case 13:
                  if (curChar == 61 && kind > 26)
                     kind = 26;
                  break;
               case 14:
                  if (curChar == 62)
                     jjCheckNAdd(13);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 17:
                  if (curChar == 60)
                     jjCheckNAddTwoStates(13, 18);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 16:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  jjCheckNAdd(16);
                  break;
               case 5:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(3, 4);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 19 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   2, 3, 5, 6, 7, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\146\154\157\141\164", 
"\151\156\164", "\123\164\162\151\156\147", "\143\150\141\162", "\50", "\51", null, "\55\76", 
"\74\55", "\73", "\72", "\77", "\77\77", "\41", "\100", "\46", "\42", "\47", null, 
"\44", "\174", "\176", "\146\165\156\143", "\144\145\146", null, "\54", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3ffffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[19];
static private final int[] jjstateSet = new int[38];
static protected char curChar;
/** Constructor. */
public MyNewGrammarTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public MyNewGrammarTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 19; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
