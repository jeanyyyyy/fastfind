import java.util.Scanner;

public class Utils {
    public void usage(int which) {
        switch (which) {
            case 1:
                System.out.println("fastfind [filter] [directory] [query]" +
                        "\nLeave filename blank, if you wish to filter every file containing selected file extension" +
                        "\n" +
                        "\nFor an overview of the available filters, type 'fastfind -h'");
                break;
            case 2:
                System.out.println("""
                            Available filters:
                            -i      insensitive (ignore capital letters)
                            -img    images (.jpg, .png, .gif, .webp)
                            -vid    videos (.mp4, .mkv, .avi)
                            -doc    documents (.pdf, .docx, .txt, .odt, .pptx, .odp)
                            -comp   compressed files (.zip, .rar, .7z)
                            -inst   installer (.exe, .tar.gz, .msi, .AppImage, .dmg)
                        """);
                break;
        }
    }
}
