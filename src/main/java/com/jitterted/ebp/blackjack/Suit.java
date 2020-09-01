package com.jitterted.ebp.blackjack;

public enum Suit {
  HEART("♥", true),
  CLUB("♣", false),
  DIAMOND("♦", true),
  SPADE("♠", false);

  private final String symbol;
  private final boolean isRed;

  Suit(String symbol, boolean isRed) {
    this.symbol = symbol;
    this.isRed = isRed;
  }

  public String symbol() {
    return symbol;
  }

  public boolean isRed() {
    return isRed;
  }
}
