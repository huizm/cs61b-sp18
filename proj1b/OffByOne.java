public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int offset = (int)x - (int)y;
        if (offset == 1 || offset == -1) {
            return true;
        } else {
            return false;
        }
    }
}
