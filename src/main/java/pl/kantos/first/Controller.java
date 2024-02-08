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
    @GetMapping("/addNumbers")
    public BigDecimal sumNumbersGETMethod(@RequestParam("number1") BigDecimal numberGET1, @RequestParam("number2") BigDecimal numberGET2) {
        return numberGET1.add(numberGET2);
    }

    @GetMapping("/randomWordsGET")
    public  String wordFromSiteGETMethod(@RequestParam("amountOfWordsGETMethod") int amountGET){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-word-api.herokuapp.com/word?number=" + amountGET;
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/addNumbersPOST")
    public BigDecimal sumNumbersPOSTMethod(@RequestBody NumbersForPOSTMethodClass request) {
        BigDecimal numberPOST1 = request.numberForPostMethod1();
        BigDecimal numberPOST2 = request.numberForPostMethod2();
        return numberPOST1.add(numberPOST2);
    }

    @PostMapping("/randomWordsPOST")
    public String wordFromSitePOSTMethod(@RequestBody AmountOfWordsClass request) {
        int amountOfWords = request.amountOfWordsPOSTMethod();
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-word-api.herokuapp.com/word?number=" + amountOfWords;
        return restTemplate.getForObject(url, String.class);
    }
}