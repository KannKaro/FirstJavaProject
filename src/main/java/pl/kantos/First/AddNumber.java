package pl.kantos.First;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RestController
public class AddNumber {
    @GetMapping("/test")
    public BigDecimal AddNum(@RequestParam("number1") String number1, @RequestParam("number2") String number2) {
        BigDecimal BigDecimalNumber1 = new BigDecimal(number1);
        BigDecimal BigDecimalNumber2 = new BigDecimal(number2);
        return BigDecimalNumber1.add(BigDecimalNumber2);
    }
}
