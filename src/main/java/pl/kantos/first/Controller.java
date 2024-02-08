package pl.kantos.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;

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
        BigDecimal firstNumberForSecondOption = request.firstNumber();
        BigDecimal secondNumberForSecondOption = request.secondNumber();
        return firstNumberForSecondOption.add(secondNumberForSecondOption);
    }

    @PostMapping("/words")
    public String wordFromSiteSecondOption(@RequestBody AmountOfWordsRequest request) {
        int amountOfWords = request.amountOfWords();
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-word-api.herokuapp.com/word?number=" + amountOfWords;
        return restTemplate.getForObject(url, String.class);
    }
}