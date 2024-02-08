package pl.kantos.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;

//Kolejny challenge, z restTemplate zrob @bean i uzywająć DI (dependency injection) wstrzyknij w kontruktorze controllera a potem dopiero uzyj
//kolejny challenge. Chcialbym zeby ten adres byl konfigurowalny w application.properties a potem tutaj pobierany chodzi mi bardziej o adres hosta czyli "https://random-word-api.herokuapp.com"
@RestController
public class Controller {
    @GetMapping("/calculator/add")
    public BigDecimal sumNumbers(@RequestParam("number1") BigDecimal firstNumber, @RequestParam("number2") BigDecimal secondNumber) {
        return firstNumber.add(secondNumber);
    }

    @GetMapping("/words")
    public  String wordFromSite(@RequestParam("amountOfWords") int amount){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-word-api.herokuapp.com/word?number=" + amount;
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/calculator/add")
    public BigDecimal sumNumbersSecondOption(@RequestBody CalculatorAddOperationRequest request) {
        return request.firstNumber().add(request.secondNumber());
    }

    @PostMapping("/words")
    public String wordFromSiteSecondOption(@RequestBody AmountOfWordsRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-word-api.herokuapp.com/word?number=" + request.amountOfWords();
        return restTemplate.getForObject(url, String.class);
    }
}

