package pl.kantos.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/words")
public class WordController {
    public final RestTemplate restTemplate;
    @Value("${wordApi.host}")
    public String wordApiHost;

    @Autowired
    public WordController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String wordFromSite(@RequestParam("amountOfWords") int amount) {
        String url = wordApiHost + "/word?number=" + amount;
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/")
    public String wordFromSiteSecondOption(@RequestBody AmountOfWordsRequest request) {
        String url = wordApiHost + "/word?number=" + request.amountOfWords();
        return restTemplate.getForObject(url, String.class);
    }
}
