import java.io.*;
import java.util.Arrays;
import java.util.List;


public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader(){}


    public String getFilePath() {
        return filePath;
    }


    public void setup (String filePath, Integer fromLine, Integer toLine){
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if (toLine < fromLine) throw new IllegalArgumentException("The starting index cannot be lower than the end index.");
        if(fromLine < 1) throw new IllegalArgumentException("The starting index should be higher than 0.");
    }


    public String read () throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(getFilePath());
        StringBuilder resultStringBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            resultStringBuilder.append(line).append("\n");
        }

        return resultStringBuilder.toString();
    }



    public String readLines(){
        String file = null;

        try {
            file = read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> fileToList = Arrays.asList(file.split("\\s"));
        List<String> subArr = fileToList.subList(fromLine-1, toLine);
        return String.join(" ",subArr);

    }

}
