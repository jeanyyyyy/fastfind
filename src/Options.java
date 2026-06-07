import java.util.ArrayList;
import java.util.List;

public class Options {
    public static ArrayList<String> options(String option, ArrayList<String> command, String dir, String name) {
        Boolean isMac = System.getProperty("os.name").trim().toLowerCase().contains("mac");
        String leftParenthesis;
        String rightParenthesis;
        if (isMac) {
            leftParenthesis = "\\(";
            rightParenthesis = "\\)";
        } else {
            leftParenthesis = "(";
            rightParenthesis = ")";
        }

        switch (option) {
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
                        leftParenthesis,
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
                        rightParenthesis
                ));
                break;

            case "-vid":
                command.addAll(List.of(
                        "find",
                        dir,
                        "-type",
                        "f",
                        leftParenthesis,
                        "-iname",
                        "*%s*.mp4".formatted(name),
                        "-o",
                        "-iname",
                        "*%s*.mkv".formatted(name),
                        "-o",
                        "-iname",
                        "*%s*.avi".formatted(name),
                        rightParenthesis
                ));
                break;

            case "-doc":
                command.addAll(List.of(
                        "find",
                        dir,
                        "-type",
                        "f",
                        leftParenthesis,
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
                        rightParenthesis
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
