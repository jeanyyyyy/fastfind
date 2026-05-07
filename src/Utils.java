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
                System.out.println("Available Commands:\n-i insensitive\n-img images (.jpg, .png, .gif, .webp)");
                break;
        }
    }
}
