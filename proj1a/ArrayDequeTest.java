import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    
    @Test
    public void addFirstTest() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.addFirst("1");
        ad.addFirst("2");
        ad.addFirst("3");
        assertEquals("1", ad.get(2));
    }

    @Test
    public void removeLastTest() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.addFirst("1");
        ad.addFirst("2");
        ad.addFirst("3");
        assertEquals("1", ad.removeLast());
    }
}
