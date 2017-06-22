package com.sam.mooterp;

import com.sam.mooterp.parser.MooLexer;
import com.sam.mooterp.parser.MooParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Machine {

  public Machine(String program) {
    MooParser parser = getParser(program);
    if (parser.getNumberOfSyntaxErrors() > 0) {
      throw new IllegalArgumentException("malformed program");
    }
    ProgramBuilder builder = new ProgramBuilder();
    ParseTreeWalker.DEFAULT.walk(builder, parser.program());
    MProgram prog = builder.getProgram(parser.program());
  }



  private MooParser getParser(String program) {
    CodePointCharStream input = CharStreams.fromString(program);
    MooLexer lexer = new MooLexer(input);
    TokenStream tokens = new CommonTokenStream(lexer);
    MooParser parser = new MooParser(tokens);
    //parser.removeErrorListeners();
    //parser.addErrorListener(errorManager);
    return parser;
  }
}
