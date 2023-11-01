import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Palindrome {
    
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<Character>();
        CharacterIterator ci = new StringCharacterIterator(word);

        for (; ci.current() != CharacterIterator.DONE; ci.next()) {
            deque.addLast(ci.current());
        }
        return deque;
    }

    /** use character comparator provided by user */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = this.wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

    /** use character comparator provided by user */
    private boolean isPalindromeHelper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }

        if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(d, cc);
        }
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = this.wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }

        if (d.removeFirst() != d.removeLast()) {
            return false;
        } else {
            return isPalindromeHelper(d);
        }
    }
}
