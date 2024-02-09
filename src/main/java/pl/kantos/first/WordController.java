package pl.kantos.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/words")
public class WordController {
    public RestTemplate restTemplate;
    @Value("${wordApi.address}")
    public String wordApiAddress;
    @Autowired
    public WordController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String wordFromSite(@RequestParam("amountOfWords") int amount) {
        String url = wordApiAddress + "/word?number=" + amount;
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/")
    public String wordFromSiteSecondOption(@RequestBody AmountOfWordsRequest request) {
        String url = wordApiAddress + "/word?number=" + request.amountOfWords();
        return restTemplate.getForObject(url, String.class);
    }
}
