package streamline.receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static InputStream testInput;
    static OutputStream testOutput;

    public static void setSystemInput(String inputStr){
        testInput = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    public static void setSystemOutput(){
        testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));
    }

    @After
    public void restoreDefaults(){
        System.setIn(System.in);
        System.setOut(System.out);
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void AppLevelTest() throws IOException {

        String inputStr = new String(Files.readAllBytes(Paths.get("src/test/testCase1_INPUT.txt")), StandardCharsets.UTF_8);
        String outputStr = new String(Files.readAllBytes(Paths.get("src/test/testCase1_OUTPUT.txt")), StandardCharsets.UTF_8);

        setSystemInput(inputStr);
        setSystemOutput();
        App.readStreamInput();
        assertEquals( outputStr.trim(), testOutput.toString().trim() );
    }
}
