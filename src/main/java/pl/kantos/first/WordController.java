package pl.kantos.first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/words")
public class WordController {
    private final RestTemplate restTemplate;
    @Value("${wordApi.host}")
    public String wordApiHost;

    public WordController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String wordFromSite(@RequestParam("amountOfWords") int amount) {
        return restTemplate.getForObject(UrlGeneratorWordApi.generateUrl(wordApiHost, amount), String.class);
    }

    @PostMapping("/")
    public String wordFromSiteSecondOption(@RequestBody AmountOfWordsRequest request) {
        return restTemplate.getForObject(UrlGeneratorWordApi.generateUrl(wordApiHost, request.amountOfWords()), String.class);
    }
}
