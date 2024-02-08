package pl.kantos.first;

import java.math.BigDecimal;

public record CalculatorAddOperationRequest(BigDecimal firstNumber, BigDecimal secondNumber) {

}