package pl.kantos.first;

public class LolChampionRotationUrlGenerator {
    private LolChampionRotationUrlGenerator() {

    }

    public static String generateUrl(String championRotationAPI, String riotAPIKey) {
        return championRotationAPI + "?api_key=" + riotAPIKey;
    }
}
