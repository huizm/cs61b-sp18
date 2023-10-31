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
}
