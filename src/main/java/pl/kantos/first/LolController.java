package pl.kantos.first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/lol")
public class LolController {
    private final RestTemplate restTemplate;
    @Value("${lolAPIAccountPuuid.host}")
    public String lolAPIPuuidHost;
    @Value("${riotAPIKey}")
    public String riotAPIKey;

    public LolController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/account")
    public String accountInfo(@RequestParam("accountName") String name, @RequestParam("tagLine") String tag) {
        return restTemplate.getForObject(LolApiAccountInfoUrlGenerator.generateUrl(name, tag, lolAPIPuuidHost, riotAPIKey), String.class);
    }

    @PostMapping("/account")
    public String accountInfoSecondOption(@RequestBody LolAccountRequest request) {
        return restTemplate.getForObject(LolApiAccountInfoUrlGenerator.generateUrl(request.accountName(), request.tagLine(), lolAPIPuuidHost, riotAPIKey), String.class);
    }
}
