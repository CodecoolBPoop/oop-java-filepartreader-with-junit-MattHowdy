import org.junit.Assert;
import org.junit.jupiter.api.Test;


import static org.junit.internal.matchers.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private FilePartReader file = new FilePartReader();

    @Test
    public void setupToLineLessThanFromLine(){
        assertThrows(IllegalArgumentException.class, ()-> { file.setup("valami", 2,1);});
    }

    @Test
    public void setupFromLineLessThan1(){
        assertThrows(IllegalArgumentException.class, ()-> { file.setup("valami", -1,1);});
    }


    @Test
    public void readlinesReturnsCorrectLines() {
        String expectedData = "abba gorog when";
        file.setup("text.txt",1,3);
        String data = file.readLines();

        Assert.assertThat(data, containsString(expectedData));
    }

    @Test
    public void readThrowsErrorWhenFileNotFound(){
        assertThrows(NullPointerException.class, ()-> {file.read();});
    }
}