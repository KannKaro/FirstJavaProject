package pl.kantos.first;

public class UrlGeneratorWordApi {
    public static String generateUrl(String wordApiHost, int amount) {
        return wordApiHost + "/word?number=" + amount;
    }
}
