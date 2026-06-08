import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Fastfind fastfind = new Fastfind();
        fastfind.runFastfind(args);
    }
}

// To-Do:
// * Mehr Optionen
// * Syntax Fehlermeldungen verbessern
// * Windows support (bool is Windows)