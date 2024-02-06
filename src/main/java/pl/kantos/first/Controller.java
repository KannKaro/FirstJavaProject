package pl.kantos.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@RestController
public class Controller {
    @GetMapping("/addNumbers")
    public BigDecimal sumNumbersGETMethod(@RequestParam("number1") BigDecimal numberGET1, @RequestParam("number2") BigDecimal numberGET2) {
        return numberGET1.add(numberGET2);
    }

    @PostMapping("/addNumbersPOST")
    public BigDecimal sumNumbersPOSTMethod(@RequestBody NumbersForPOSTMethod requestForNumbersPOSTMethod) {
        BigDecimal numberPOST1 = requestForNumbersPOSTMethod.numberForPostMethod1();
        BigDecimal numberPOST2 = requestForNumbersPOSTMethod.numberForPostMethod2();
        return numberPOST1.add(numberPOST2);
    }
}
