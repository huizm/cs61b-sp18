import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    // Uncomment this class once you've created your CharacterComparator
    // interface and OffByOne class.
    @Test
    public void testEqualCharsOne() {
        assertTrue(offByOne.equalChars('x', 'y'));
    }

    @Test
    public void testEqualCharsTwo() {
        assertTrue(offByOne.equalChars('d', 'c'));
    }

    @Test
    public void testEqualCharsThree() {
        assertFalse(offByOne.equalChars('x', 'x'));
    }

    @Test
    public void testEqualCharsFour() {
        assertFalse(offByOne.equalChars('x', 'X'));
    }

    @Test
    public void testEqualCharsFive() {
        assertTrue(offByOne.equalChars('&', '%'));
    }
}
