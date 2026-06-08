import java.io.IOException;
import java.util.ArrayList;

public class Fastfind {
    Utils utilities;
    private ArrayList<String> command;
    private String[] commands;
    private boolean isCommand;

    public Fastfind() {
        utilities = new Utils();
        commands = new String[] {"-i", "-img", "-doc", "-vid", "-comp", "-inst"};
        isCommand = false;
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

        for (int i = 0; i < commands.length; i++) { // check if option is valid
            if (args[0].equals(commands[i])) {
                isCommand = true;
                break;
            }
        }

        if (!isCommand) {
            System.out.println("Invalid parameter: '" + args[0] + "'. For an overview of all commands, type fastfind -h.");
            return;
        }

        if (args.length < 2) {
            utilities.usage(1);
            return;
        }

        command = new ArrayList<String>();
        String option = args[0];
        String dir = args[1].replace("~", System.getProperty("user.home")); // search in home directory
        String name;

        if (args.length < 3 || args[2].isEmpty()) { // in case insufficient arguments are provided
            name = "*";                               // or name is empty
        } else {
            name = args[2];
        }

        ArrayList<String> end = Options.options(option, command, dir, name);
        ProcessBuilder pb = new ProcessBuilder(end);
        pb.inheritIO();

        try {
            pb.start().waitFor();
        } catch (InterruptedException | IOException e) {
            System.out.println("Error; " + e.getMessage());
        }
    }
}