import java.util.ArrayList;
public class Options {
    public static ArrayList<String> options(String option, ArrayList<String> command, String dir, String name) {
        switch(option) {
            case "-i":
                command.addAll(List.of(
                        "find",
                        dir,
                        "-iname",
                        name
                ));
                break;

            case "-img":
                command.addAll(List.of(
                        "find",
                        dir,
                        "-type",
                        "f",
                        "(",
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
                        "*%s*.webp".formatted(name),
                        ")"
                ));
                break;

            case "-vid":
                command.addAll(List.of(
                        "find",
                        dir,
                        "-type",
                        "f",
                        "(",
                        "-iname",
                        "*%s*.mp4".formatted(name),
                        "-o",
                        "-iname",
                        "*%s*.mkv".formatted(name),
                        "-o",
                        "-iname",
                        "*%s*.avi".formatted(name),
                        ")"
                ));
                break;

            case "-doc":
                command.addAll(List.of(
                        "find",
                        dir,
                        "-type",
                        "f",
                        "(",
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
                        "*%s*.odp".formatted(name),
                        ")"
                ));
                break;

            default:
                command.addAll(List.of(
                        "find",
                        dir,
                        "-name",
                        name
                ));
                break;
        }
        return command;
    }
}
