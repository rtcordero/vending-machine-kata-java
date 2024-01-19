package domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.entities.coins.Dime;
import domain.entities.coins.Nickel;
import domain.entities.coins.Pennie;
import domain.entities.coins.Quarters;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VendingMachineTest {

  @Nested
  class Coins {

    @Test
    void shouldGetCurrentAmountOfOneCoin() {
      VendingMachine vendingMachine = new VendingMachine();
      Nickel nickel = new Nickel();
      Amount expected = nickel.getValue();

      vendingMachine.insertCoin(nickel);

      assertEquals(expected, vendingMachine.getCurrentAmount());
    }

    @Test
    void shouldGetCurrentAmountOfSeveralSameCoins() {
      VendingMachine vendingMachine = new VendingMachine();
      Nickel nickel = new Nickel();
      Amount expected = new Amount(0.10F);

      vendingMachine.insertCoin(nickel);
      vendingMachine.insertCoin(nickel);

      assertEquals(expected, vendingMachine.getCurrentAmount());
    }

    @Test
    void shouldGetCurrentAmountOfSeveralDifferentCoins() {
      VendingMachine vendingMachine = new VendingMachine();
      Nickel nickel = new Nickel();
      Dime dime = new Dime();
      Quarters quarters = new Quarters();
      Amount expected = new Amount(0.40F);

      vendingMachine.insertCoin(nickel);
      vendingMachine.insertCoin(dime);
      vendingMachine.insertCoin(quarters);

      assertEquals(expected.getValue(), vendingMachine.getCurrentAmount().getValue());
    }

    @Test
    void shouldNotAllowInvalidCoins() {
      VendingMachine vendingMachine = new VendingMachine();
      Pennie pennie = new Pennie();
      Amount expected = new Amount(0.0F);

      vendingMachine.insertCoin(pennie);

      assertEquals(expected, vendingMachine.getCurrentAmount());
    }
  }

  @Nested
  class Display {

    @Test
    void shouldDisplayNoCoinsMessageWhenHasNotCoins() {
      VendingMachine vendingMachine = new VendingMachine();
      String expected = "INSERT COIN";

      vendingMachine.insertCoin(null);

      assertEquals(expected, vendingMachine.getDisplayMessage());
    }

    @Test
    void shouldDisplayCurrentAmountValueWhenHasCoins() {
      VendingMachine vendingMachine = new VendingMachine();
      Nickel nickel = new Nickel();
      Quarters quarters = new Quarters();
      Pennie pennie = new Pennie();
      String expected = "0,30 €";

      vendingMachine.insertCoin(nickel);
      vendingMachine.insertCoin(quarters);
      vendingMachine.insertCoin(pennie);

      assertEquals(expected, vendingMachine.getDisplayMessage());
    }
  }
}