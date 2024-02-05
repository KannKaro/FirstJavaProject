package pl.kantos.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@RestController
public class AddNumber {
    @GetMapping("/AddNumbers")
    public BigDecimal addNum(@RequestParam("number1") BigDecimal number1, @RequestParam("number2") BigDecimal number2) {
        return number1.add(number2);
    }

    @PostMapping("/AddNumbersPost")
    public BigDecimal addNumbers(@RequestBody NumbersPostMethod numbers) {
        BigDecimal number1 = numbers.createNumber1();
        BigDecimal number2 = numbers.createNumber2();
        return number1.add(number2);
    }
}
