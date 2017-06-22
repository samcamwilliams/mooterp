package com.sam.mooterp;

import java.util.ArrayList;
import java.util.List;

public class MProgram {

  public enum MOpCode {
    FORWARD,
    BACKWARD,
    INCREMENT,
    DECREMENT
  }
  private final List<MOpCode> instructions;

  public MProgram(List<MOpCode> instructions) {
    this.instructions = new ArrayList<>(instructions);
  }
}
