package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {

  private final List<Card> cards = new ArrayList<>();

  public void add(Card card) {
    cards.add(card);
  }

  public void displayHand() {
    System.out.println(cards.stream()
                            .map(Card::display)
                            .collect(Collectors.joining(
                                ansi().cursorUp(6).cursorRight(1).toString())));
  }

  public int value() {
    int handValue = cards
        .stream()
        .mapToInt(Card::rankValue)
        .sum();

    // if the total hand value <= 11, then count the Ace as 11 by adding 10
    if (hasAce() && handValue <= 11) {
      handValue += 10;
    }

    return handValue;
  }

  private boolean hasAce() {
    return cards
        .stream()
        .anyMatch(card -> card.rankValue() == 1);
  }

  public String displayFirstCard() {
    return cards.get(0).display();
  }
}
