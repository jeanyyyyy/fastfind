import java.io.IOException;
import java.util.ArrayList;

public class Fastfind {
    Utils utilities;
    private ArrayList<String> command;

    public Fastfind() {
        utilities = new Utils();
    }

    public void runFastfind() {
        while (true) {
            String input = utilities.Scanner();
            String[] split = input.split(" ");
            ProcessBuilder pb;

            if (!split[0].equals("fastfind")) {
                utilities.usage(1);
                continue;
            }

            if (split.length < 2) {
                utilities.usage(1);
                continue;
            }

            if (split[1].equals("-h")) {
                utilities.usage(2);
                continue;
            }

            if (split.length < 3) {
                utilities.usage(1);
                continue;
            }

            command = new ArrayList<String>();
            String option = split[1];
            String dir = split[2].replace("~", System.getProperty("user.home")); // search in home directory
            String name;

            if (split.length < 4 || split[3].isEmpty()) { // in case insufficient arguments are provided
                name = "*";                               // or name is empty
            } else {
                name = split[3];
            }

            ArrayList<String> end = Options.options(option, command, dir, name);
            if (end.isEmpty()) {
                continue;
            }

            pb = new ProcessBuilder(end);
            pb.inheritIO();
            try {
                pb.start().waitFor();
            } catch (InterruptedException |IOException e){
                System.out.println("Error; " + e.getMessage());
            }
        }
    }
}