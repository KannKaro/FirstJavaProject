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
    public BigDecimal sumNumbersGETMethod(@RequestParam("number1") BigDecimal number1, @RequestParam("number2") BigDecimal number2) {
        return number1.add(number2);
    }

    @PostMapping("/addNumbersPOST")
    public BigDecimal sumOfNumbersPOSTMethod(@RequestBody NumbersPOSTMethod numbersPOSTMethod) {
        BigDecimal number1 = numbersPOSTMethod.getNumber1();
        BigDecimal number2 = numbersPOSTMethod.getNumber2();
        return number1.add(number2);
    }
}
