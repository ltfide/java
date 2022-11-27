import java.util.ArrayList;
import java.util.List;

public class hello {
    public static void main(String[] args) {

        System.out.println(lineNumbering(List.of("a", "b", "c")));
        System.out.println(lineNumbering(List.of("", "", "")));

    }

    public static List<String> lineNumbering(List<String> value) {
        List<String> a = new ArrayList<>();
        for (int i = 1; i <= value.size() ; i++) {
            a.add(i + ": " + value.get(i - 1));
        }

        return a;
    }
}
