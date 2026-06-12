import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
    int amountFlags;
    boolean sizeSelected;
    boolean allFlag;
    public Filter() {
        amountFlags = 0;
        sizeSelected = false;
        allFlag = false;
    }
    public ArrayList<String> Flag(String[] args, String dir, String name, ArrayList<String> command) {
        command.addAll(List.of(
                "find",
                dir,
                "-type",
                "f",
                "("
        ));

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (allFlag) {
                    break;
                }
                if (amountFlags > 0) {
                    command.add("-o");
                }
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
                        amountFlags++;
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
                        amountFlags++;
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
                        amountFlags++;
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
                        amountFlags++;
                        break;

                    case "-exec":
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
                                "*%s*.dmg".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.app".formatted(name)
                        ));
                        amountFlags++;
                        break;

                    case "-aud":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*.mp3".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.wav".formatted(name),
                                "-o",
                                "-iname",
                                "*%s*.ogg".formatted(name)
                        ));
                        amountFlags++;
                        break;

                    case "-a":
                        command.addAll(List.of(
                                "-iname",
                                "*%s*".formatted(name)
                        ));
                        allFlag = true;
                        break;

                    case "-small":
                        // handled after
                        break;

                    case "-big":
                        // handled after
                        break;

                    case "-large":
                        // handled after
                        break;

                    default:
                        System.out.println("Invalid flag: '" + args[i] + "'. Check valid flags with 'fastfind -h'");
                }
            }
        }

        boolean hasFlag = Arrays.stream(args).anyMatch(a ->
                List.of("-img", "-vid", "-doc", "-comp", "-exec", "-aud", "-small", "-big", "-large", "-a").contains(a));
        if (!hasFlag) {
            System.out.println("Invalid structure. Usage: 'fastfind [flag(s)] [directory] [query]'");
            return null;
        }

        command.add(")");

        for (String arg : args) {
            if (sizeSelected) {
                break;
            }
            switch(arg) {
                case "-small":
                    command.addAll(List.of(
                            "-size",
                            "-10M"
                    ));
                    sizeSelected = true;
                    break;

                case "-big":
                    command.addAll(List.of(
                            "-size",
                            "+100M"
                    ));
                    sizeSelected = true;
                    break;

                case "-large":
                    command.addAll(List.of(
                            "-size",
                            "+1G"
                    ));
                    sizeSelected = true;
                    break;
            }
        }
        return command;
    }
}