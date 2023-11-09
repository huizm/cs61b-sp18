package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    @Test
    public void arrayRingBufferTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(5);
        arb.enqueue(0);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        
        int testPeek = arb.peek(); // 0 1 2 3 4
        assertEquals(0L, testPeek);
        int testDequeue = arb.dequeue(); // n 1 2 3 4
        assertEquals(0L, testDequeue);
        int testDequeueSuccess = arb.peek(); // n 1 2 3 4
        assertEquals(1L, testDequeueSuccess);
        arb.enqueue(5); // 5 1 2 3 4
        int testDequeueTwo = arb.dequeue(); // 5 n 2 3 4
        assertEquals(1L, testDequeueTwo);
    }

    @Test
    public void iteratorTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(5);
        arb.enqueue(0);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);

        int i = 0;
        for (int x : arb) {
            assertEquals(i++, x);
        }
    }
} 
