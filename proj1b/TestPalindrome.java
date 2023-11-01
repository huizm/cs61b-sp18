import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } // Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindromeOne() {
        assertTrue(palindrome.isPalindrome("boob"));
    }

    @Test
    public void testIsPalindromeTwo() {
        assertFalse(palindrome.isPalindrome("false"));
    }

    @Test
    public void testIsPalindromeThree() {
        assertTrue(palindrome.isPalindrome("t"));
    }

    @Test
    public void testIsPalindromeFour() {
        assertTrue(palindrome.isPalindrome(""));
    }
}
