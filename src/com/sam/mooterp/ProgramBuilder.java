package com.sam.mooterp;

import com.sam.mooterp.parser.MooBaseListener;
import com.sam.mooterp.parser.MooParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.List;

public class ProgramBuilder extends MooBaseListener {

  private final ParseTreeProperty<MProgram.MOpCode> builtInstructions = new ParseTreeProperty<>();
  private MProgram builtProgram;

  public MProgram getProgram(ParserRuleContext ctx) {
    return builtProgram;
  }

  @Override
  public void exitProgram(MooParser.ProgramContext ctx) {
    List<MProgram.MOpCode> instructions = new ArrayList<>();
    for (MooParser.InstructionContext instruction : ctx.instruction()) {
      instructions.add(builtInstructions.get(instruction));
    }
    builtProgram = new MProgram(instructions);
  }

  @Override
  public void exitInstruction(MooParser.InstructionContext ctx) {
    builtInstructions.put(ctx, builtInstructions.get(ctx.getChild(0)));
  }

  @Override
  public void exitForwardInstruction(MooParser.ForwardInstructionContext ctx) {
    builtInstructions.put(ctx, MProgram.MOpCode.FORWARD);
  }
}
