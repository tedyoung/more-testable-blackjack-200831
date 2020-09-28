package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingTest {

  @Test
  public void playerWith100Bets10AndWinsThenHas110() throws Exception {
    Game game = new Game();
    game.playerBets(10);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 10 + 10 * 2);
  }

  @Test
  public void playerWith100Bets10AndPushesThenHas100() throws Exception {
    Game game = new Game();
    game.playerBets(10);

    game.playerPushes();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 10 + 10);
  }

  @Test
  public void playerWith100Bets10AndLosesThenHas90() throws Exception {
    Game game = new Game();
    game.playerBets(10);

    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 10);
  }

  @Test
  public void playerWith100Bets20WinsBlackjackThenHas130() throws Exception {
    Game game = new Game();
    game.playerBets(20);

    game.playerWinsBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 20 + ((int) (20 * 2.5)));
  }


  @Test
  public void playerStartsWith100Balance() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void playerWith100Bets9DollarsHas91Dollars() throws Exception {
    Game game = new Game();

    game.playerBets(9);

    assertThat(game.playerBalance())
        .isEqualTo(100 - 9);
  }

}