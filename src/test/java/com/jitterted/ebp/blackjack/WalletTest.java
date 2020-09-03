package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  // Given - When - Then
  @Test
  public void addMoneyToNewWalletIsNotEmpty() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(10);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletIsZeroBalance() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void add7DollarsToNewWalletIs7DollarBalance() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(7);

    assertThat(wallet.balance())
        .isEqualTo(7);
  }

  @Test
  public void add8DollarsAnd12DollarsIs20DollarBalance() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(8);
    wallet.addMoney(12);

    assertThat(wallet.balance())
        .isEqualTo(8 + 12);
  }

  @Test
  public void walletWith20BalanceWhenBet5DollarsIs15DollarBalance() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(20);

    wallet.bet(5);

    assertThat(wallet.balance())
        .isEqualTo(20 - 5);
  }

  @Test
  public void walletWith11BalanceWhenBet3AndBet5Is3DollarBalance() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(11);

    wallet.bet(3);
    wallet.bet(5);

    assertThat(wallet.balance())
        .isEqualTo(11 - 3 - 5);
  }

}
