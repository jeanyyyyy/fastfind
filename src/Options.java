import java.util.ArrayList;
public class Options {
    public static ArrayList<String> options(String option, ArrayList<String> command, String dir, String name) {
        switch(option) {
            case "-i":
                command.add("find");
                command.add(dir);
                command.add("-iname");
                command.add(name);
                break;

            case "-img":
                command.add("find");
                command.add(dir);
                command.add("-type");
                command.add("f");
                command.add("(");
                command.add("-iname");
                command.add("*%s*.jpg".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.png".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.gif".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.webp".formatted(name));
                command.add(")");
                break;

            case "-vid":
                command.add("find");
                command.add(dir);
                command.add("-type");
                command.add("f");
                command.add("(");
                command.add("-iname");
                command.add("%s*.mp4".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.mkv".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.avi".formatted(name));
                command.add(")");
                break;

            case "-doc":
                command.add("find");
                command.add(dir);
                command.add("-type");
                command.add("f");
                command.add("(");
                command.add("-iname");
                command.add("*%s*.pdf".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.docx".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.txt".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.odt".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.pptx".formatted(name));
                command.add("-o");
                command.add("-iname");
                command.add("*%s*.odp".formatted(name));
                command.add(")");
                break;

            default:
                command.add("find");
                command.add(dir);
                command.add("-name");
                command.add(name);
                break;
        }
        return command;
    }
}
