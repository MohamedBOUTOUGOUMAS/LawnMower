package unitTests;

import parsing.ParseFile;
import model.Direction;
import model.MowerConfig;
import model.MowerSystem;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MowerTests {
    MowerSystem mowerSystem;
    MowerConfig mowerConfig1;
    MowerConfig mowerConfig2;

    @Before
    public void setUp() {
        mowerSystem = ParseFile.parseFile("src/main/resources/test.txt");
        mowerConfig1 = mowerSystem.getMowers().get(0);
        mowerConfig2 = mowerSystem.getMowers().get(1);
    }

    @Test
    public void parsingMowerSystemTest() {
        assertEquals(mowerSystem.getLawn().getWidth(), 5);
        assertEquals(mowerSystem.getLawn().getHeight(), 5);
        assertEquals(mowerSystem.getMowers().size(), 2);
    }

    @Test
    public void parsingMowerTest() {
        assertEquals(mowerConfig1.getMower().getDirection(), Direction.N);
        assertEquals(mowerConfig1.getMower().getX(), 1);
        assertEquals(mowerConfig1.getMower().getY(), 2);

        assertEquals(mowerConfig2.getMower().getDirection(), Direction.E);
        assertEquals(mowerConfig2.getMower().getX(), 3);
        assertEquals(mowerConfig2.getMower().getY(), 3);
    }

    @Test
    public void parsingCommandTest() {
        assertEquals(mowerConfig1.getCommand().getCmd(), "GAGAGAGAA");
        assertEquals(mowerConfig2.getCommand().getCmd(), "AADAADADDA");
    }

    @Test
    public void processingTest() {
        mowerSystem.startAll();
        assertEquals(mowerConfig1.getMower().getDirection(), Direction.N);
        assertEquals(mowerConfig1.getMower().getX(), 1);
        assertEquals(mowerConfig1.getMower().getY(), 3);

        assertEquals(mowerConfig2.getMower().getDirection(), Direction.E);
        assertEquals(mowerConfig2.getMower().getX(), 5);
        assertEquals(mowerConfig2.getMower().getY(), 1);
    }
}
