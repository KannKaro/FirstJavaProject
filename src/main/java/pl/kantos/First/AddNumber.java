package pl.kantos.First;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RestController
public class AddNumber {
    @GetMapping("/AddNumbers")
    public BigDecimal addNum(@RequestParam("number1") BigDecimal number1, @RequestParam("number2") BigDecimal number2) {
        return number1.add(number2);
    }
}
