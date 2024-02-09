package pl.kantos.first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/words")
public class WordController {
    @Value("${wordApi.address}")
    public String wordApiAddress;

    @GetMapping("/")
    public String wordFromSite(@RequestParam("amountOfWords") int amount) {
        RestTemplate restTemplate = new RestTemplate();
        String url = wordApiAddress + "/word?number=" + amount;
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/")
    public String wordFromSiteSecondOption(@RequestBody AmountOfWordsRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String url = wordApiAddress + "/word?number=" + request.amountOfWords();
        return restTemplate.getForObject(url, String.class);
    }
}
