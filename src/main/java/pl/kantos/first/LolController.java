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
    @Value("${lolAPISummonerInfo.host}")
    public String lolAPISummonerInfo;
    @Value("${lolChampionRotation.host}")
    public String lolRotation;
    @Value("${lolChampionMastery.host}")
    public String lolChampionMastery;

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

    @GetMapping("/summoner")
    public String accountSummonerInfo(@RequestParam String puuid) {
        return restTemplate.getForObject(LolSummonerInfoUrlGenerator.generateUrl(puuid, riotAPIKey, lolAPISummonerInfo), String.class);
    }

    @PostMapping("/summoner")
    public String accountSummonerInfoSecondOption(@RequestBody LolSummonerRequest request) {
        return restTemplate.getForObject(LolSummonerInfoUrlGenerator.generateUrl(request.puuid(), riotAPIKey, lolAPISummonerInfo), String.class);
    }

    @GetMapping("/rotation")
    public String lolChampionsRotation() {
        return restTemplate.getForObject(LolChampionRotationUrlGenerator.generateUrl(lolRotation, riotAPIKey), String.class);
    }

    @GetMapping("/mastery")
    public String lolChampionMasteryInfo(@RequestParam String puuid) {
        return restTemplate.getForObject(LolSummonerMasteryInfoGenerator.generateUrl(puuid, riotAPIKey, lolChampionMastery), String.class);
    }

}
