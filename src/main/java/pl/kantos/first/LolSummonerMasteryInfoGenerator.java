package pl.kantos.first;

public class LolSummonerMasteryInfoGenerator {
    private LolSummonerMasteryInfoGenerator() {

    }

    public static String generateUrl(String puuid, String riotAPIKey, String lolAPIChampionMasteryInfo) {
        return lolAPIChampionMasteryInfo + puuid + "?api_key=" + riotAPIKey;
    }
}
