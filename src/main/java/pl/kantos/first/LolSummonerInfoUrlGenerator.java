package pl.kantos.first;

public class LolSummonerInfoUrlGenerator {
    private LolSummonerInfoUrlGenerator() {

    }

    public static String generateUrl(String puuid, String riotAPIKey, String lolAPISummonerInfo) {
        return lolAPISummonerInfo + puuid + "?api_key=" + riotAPIKey;
    }
}
