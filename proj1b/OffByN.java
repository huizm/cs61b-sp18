public class OffByN implements CharacterComparator {
    
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int offset = (int)x - (int)y;
        if (offset == N || offset == -N) {
            return true;
        } else {
            return false;
        }
    }
}
