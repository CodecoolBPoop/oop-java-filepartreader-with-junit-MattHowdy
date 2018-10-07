import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader file = new FilePartReader();
        file.setup("text.txt",1,10);

        FileWordAnalyzer analyzer = new FileWordAnalyzer(file);
    }
}
