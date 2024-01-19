package domain.entities;

import java.util.ArrayList;

import domain.entities.coins.Coin;

public class VendingMachine {

  private final ArrayList<Coin> coins = new ArrayList<>();

  private static final String NO_COINS_MESSAGE = "INSERT COIN";

  public void insertCoin(Coin coin) {
    if (coin != null) {
      this.coins.add(coin);
    }
  }

  public Amount getCurrentAmount() {
    Amount currentAmount = new Amount();
    coins.forEach(
        coin -> currentAmount.sumAmount(coin.getValue())
    );
    return currentAmount;
  }

  public String getDisplayMessage() {
    if (getCurrentAmount().isGreaterThanZero()) {
      return getAmountFormattedToDisplay(getCurrentAmount());
    }
    return NO_COINS_MESSAGE;
  }

  private String getAmountFormattedToDisplay(Amount amount) {
    return String.format("%.02f", amount.getValue()) + " €";
  }
}

