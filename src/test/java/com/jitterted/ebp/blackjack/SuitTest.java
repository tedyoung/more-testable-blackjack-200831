package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SuitTest {

  @Test
  public void suitColorsAreCorrectAsPerStandard() throws Exception {
    assertThat(Suit.DIAMOND.isRed())
        .isTrue();
    assertThat(Suit.HEART.isRed())
        .isTrue();
    assertThat(Suit.CLUB.isRed())
        .isFalse();
    assertThat(Suit.SPADE.isRed())
        .isFalse();
  }

}