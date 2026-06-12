import java.util.Scanner;

public class Utils {
    public void usage(int which) {
        switch (which) {
            case 1:
                System.out.println("Usage: 'fastfind [size flag] [flag(s)] [directory] [query]'" +
                        "\nLeave query blank to filter every file containing selected flag(s)." +
                        "\nLeave size blank to not filter by size." +
                        "\nFor an overview of all available flags, type 'fastfind -h'");
                break;
            case 2:
                System.out.println("""
                            Available flags:
                            -img    images      (.jpg, .png, .gif, .webp)
                            -vid    videos      (.mp4, .mkv, .avi)
                            -doc    documents   (.pdf, .docx, .txt, .odt, .pptx, .odp)
                            -comp   compressed  (.zip, .rar, .7z)
                            -exec   executable  (.exe, .tar.gz, .msi, .AppImage, .dmg, .app)
                            -aud    audio       (.mp3, .wav, .ogg)
                            -a      general     (search all files by name)
                            
                            Available size flags:
                            -small              (<10MB)
                            -big                (>100MB)
                            -large              (>1GB)
                            
                            Please note that only one size flag is possible simultaneously.""");
                break;
        }
    }
}
