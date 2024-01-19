package domain.entities;

import java.util.Objects;

public class Amount {

  private float value;

  public Amount() {
    this.value = 0.0F;
  }

  public Amount(float value) {
    this.value = value;
  }

  public float getValue() {
    return this.value;
  }

  public boolean isGreaterThanZero() {
    return this.value > 0.0F;
  }

  public void sumAmount(Amount amount) {
    this.value += amount.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return Float.compare(value, amount.value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
