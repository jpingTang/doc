/**
 * Created by cylee on 15/12/20.
 */
public class Token {
    int mTag;
    Token(int tag) {
        mTag = tag;
    }

    @Override
    public String toString() {
        return String.valueOf((char)mTag);
    }
}
