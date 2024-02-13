package pl.kantos.first;

public class WordApiUrlGenerator {
    private WordApiUrlGenerator() {

    }

    public static String generateUrl(String wordApiHost, int amount) {
        return wordApiHost + "/word?number=" + amount;
    }
}
