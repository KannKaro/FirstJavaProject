package pl.kantos.first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Value("${wordApi.host}")
    public String wordApiAddress;

    @GetMapping("/add")
    public BigDecimal sumNumbers(@RequestParam("firstNumber") BigDecimal firstNumber, @RequestParam("secondNumber") BigDecimal secondNumber) {
        return firstNumber.add(secondNumber);
    }

    @PostMapping("/add")
    public BigDecimal sumNumbersSecondOption(@RequestBody CalculatorAddOperationRequest request) {
        return request.firstNumber().add(request.secondNumber());
    }

}

