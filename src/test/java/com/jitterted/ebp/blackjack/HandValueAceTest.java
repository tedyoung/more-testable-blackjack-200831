package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DUMMY_SUIT = Suit.HEART;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHandWithRanksOf("A", "5");

    assertThat(hand.value())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceRestOfCardsEqualTo10ThenAceIsValueAt11() throws Exception {
    Hand hand = createHandWithRanksOf("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHandWithRanksOf("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo12IsValuedAt1() throws Exception {
    Hand hand = createHandWithRanksOf("7", "5", "A");

    assertThat(hand.value())
        .isEqualTo(7 + 5 + 1);
  }

  private Hand createHandWithRanksOf(String... ranks) {
    Hand hand = new Hand();
    for (String rank : ranks) {
      hand.add(new Card(DUMMY_SUIT, rank));
    }
    return hand;
  }

}
