package cleanCode.Chapter3.primePrinter.notRefactored;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;


import static org.junit.Assert.assertEquals;
public class PrimePrinterTest {


    private PrintStream out;

    @Before
    public void setUp() throws FileNotFoundException {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("lead")));
    }

    @Test
    public void makeSureOutputMatchesGold() throws Exception{
        PrimePrinter.main(new String[0]);
        BufferedReader lead = new BufferedReader(new FileReader("lead"));
        BufferedReader gold = new BufferedReader(new FileReader("gold"));

        String line;
        while ((line = gold.readLine()) != null){
            assertEquals(line,lead.readLine());
        }

        assertEquals(null,lead.readLine());
    }


    @After
    public void tearDown(){
        System.setOut(out);
        new File("lead").delete();
    }



}
