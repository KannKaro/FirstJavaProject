package pl.kantos.first;

import java.math.BigDecimal;

public record NumbersPOSTMethod(BigDecimal number1, BigDecimal number2) {

    // Getters and setters
    public BigDecimal getNumber1() {
        return number1;
    }

    public BigDecimal getNumber2() {
        return number2;
    }

}