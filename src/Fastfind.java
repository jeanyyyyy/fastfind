import java.io.IOException;
import java.util.ArrayList;

public class Fastfind {
    Utils utilities;
    Filter filter;
    private ArrayList<String> command;

    public Fastfind() {
        utilities = new Utils();
        command = new ArrayList<>();
        filter = new Filter();
    }

    public void runFastfind(String[] args) {
        if (args.length == 0) {
            utilities.usage(1);
            return;
        }

        if (args[0].equals("-h")) {
            utilities.usage(2);
            return;
        }

        if (args.length < 2) {
            utilities.usage(1);
            return;
        }

        String dir;
        String name;

        if (args[args.length - 2].startsWith("-")) {
            dir = args[args.length - 1];
            name = "*";
        } else {
            dir = args[args.length - 2];
            name = args[args.length - 1];
        }

        if (name.isEmpty()) {
            name = "*";
        }

        command = filter.Flag(args, dir, name, command);
        if (command == null) {
            return;
        }

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.inheritIO();

        try {
            pb.start().waitFor();
        } catch (InterruptedException | IOException e) {
            System.out.println("Error; " + e.getMessage());
        }
    }
}