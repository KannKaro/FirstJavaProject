package pl.kantos.first;

public class LolApiAccountInfoUrlGenerator {
    private LolApiAccountInfoUrlGenerator(){

    }
    public static String generateUrl(String accountName, String tag, String lolAPIAccount, String riotAPIKey) {
        return lolAPIAccount + accountName + "/" + tag + "?api_key=" + riotAPIKey;
    }
}
