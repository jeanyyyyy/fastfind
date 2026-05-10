import java.util.Scanner;

public class Utils {
    public String Scanner() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
    public void usage(int which) {
        switch(which) {
            case 1:
                System.out.println("Usage: fastfind (option) (path) (filename)");
                break;
            case 2:
                System.out.println("""
                        Available Commands:
                        -i      insensitive (ignore capital letters)
                        -img    images (.jpg, .png, .gif, .webp)
                        -vid    videos (.mp4, .mkv, .avi)
                        -doc    documents (.pdf, .docx, .txt, .odt, .pptx, .odp)
                    """);
                break;
        }
    }
}
