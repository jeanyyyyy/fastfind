import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
    public static ArrayList<String> Flag(String args[], String dir, String name, ArrayList<String> command) {
        Utils utilities = new Utils();
        command.addAll(List.of(
                "find",
                dir,
                "-type",
                "f",
                "("
        ));

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                switch (args[i]) {
                    case "-img":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*.jpg".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.png".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.gif".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.webp".formatted(name)
                        ));
                        break;

                    case "-vid":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*.mp4".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.mkv".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.avi".formatted(name)
                        ));
                        break;

                    case "-doc":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*.pdf".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.docx".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.odt".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.txt".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.pptx".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.odp".formatted(name)
                        ));
                        break;

                    case "-comp":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*.zip".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.rar".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.7z".formatted(name)
                        ));
                        break;

                    case "-inst":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*.exe".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.tar.gz".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.msi".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.AppImage".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.dmg".formatted(name)
                        ));
                        break;

                    default:
                        System.out.println("Invalid flag: '" + args[i] + "'. Check valid flags with 'fastfind -h'");
                }
            }
        }

        boolean hasFlag = Arrays.stream(args).anyMatch(a ->
                List.of("-img", "-vid", "-doc", "-comp", "-inst").contains(a));
        if (!hasFlag) {
            System.out.println("Invalid structure. Usage: 'fastfind [flag(s)] [directory] [query]'");
            return null;
        }

        command.add(")");

        return command;
    }
}