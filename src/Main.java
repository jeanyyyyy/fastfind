import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Fastfind fastfind = new Fastfind();
        fastfind.runFastfind(args);
    }
}

// To-Do:
// * Wenn keine Datei, dann Fehlermeldung
// * Mehr Optionen
// * Nicht pfad zurückgeben, sondern Content