package pl.kantos.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@RestController
public class AddNumber {
    @GetMapping("/addNumbers")
    public BigDecimal sumNumbersGetMethod(@RequestParam("number1") BigDecimal number1, @RequestParam("number2") BigDecimal number2) {
        return number1.add(number2);
    }

    @PostMapping("/addNumbersPost")
    public BigDecimal sumOfNumbersPostMethod(@RequestBody NumbersPostMethod numbersPostMethod) {
        BigDecimal number1 = numbersPostMethod.createNumber1();
        BigDecimal number2 = numbersPostMethod.createNumber2();
        return number1.add(number2);
    }
}
