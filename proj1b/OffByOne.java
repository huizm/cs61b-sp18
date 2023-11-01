public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int offset = (int) x - (int) y;
        return offset == 1 || offset == -1;
    }
}
