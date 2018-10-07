import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWordAnalyzer {
    private FilePartReader reader;


    public FileWordAnalyzer(FilePartReader reader){
        this.reader = reader;
    }


    private ArrayList<String> convertToArrayList() {
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLines().split("\\s")));
        return myList;
    }



    public ArrayList<String> wordsByABC (){
        ArrayList<String> file = convertToArrayList();
        Collections.sort(file);

        return file;
    }


    public ArrayList<String> wordsContainingSubString (String subString ) {
        ArrayList<String> file = convertToArrayList();
        ArrayList<String> listToReturn = new ArrayList<>();
        ArrayList<String> subStringToList = new ArrayList<>(Arrays.asList(subString.split("\\s+")));

        for(String word :subStringToList){
            if(file.contains(word)){
                listToReturn.add(word);
            }
        }
        return listToReturn;
    }


    public ArrayList<String> wordsArePalindrome (){
        ArrayList<String> file = convertToArrayList();
        ArrayList<String> allPalindrome = new ArrayList<>();

        for (String word : file) {
            char[] wordChar = word.toCharArray();
            if(istPalindrom(wordChar)){
                allPalindrome.add(word);
            }
        }
        return allPalindrome;
    }


    public static boolean istPalindrom(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;

        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }





}
