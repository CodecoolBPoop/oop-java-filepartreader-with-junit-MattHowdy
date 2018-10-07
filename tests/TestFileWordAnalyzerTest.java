import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestFileWordAnalyzerTest {
    FilePartReader reader = new FilePartReader();
    FileWordAnalyzer analyzer =  new FileWordAnalyzer(reader);


    @Test
    public void returnsCorrectWordsByABC(){
        reader.setup("text.txt",1,4);
        List<String> expectedOutcome = Arrays.asList("abba", "gorog", "rever", "when");

        assertIterableEquals(expectedOutcome, analyzer.wordsByABC());
    }

    @Test
    public void returnsWordsWhenContainingSubString(){
        reader.setup("text.txt",1,4);
        List<String> expectedOutcome = Arrays.asList("abba", "rever");
        String stringInput = "abba rever";

        assertIterableEquals(expectedOutcome, analyzer.wordsContainingSubString(stringInput));
    }


    @Test
    public void returnPalindromeWords(){
        reader.setup("text.txt", 1,4);
        List<String> expectedOutcome = Arrays.asList("rever", "abba", "gorog");

        assertIterableEquals(expectedOutcome, analyzer.wordsArePalindrome());
    }
}