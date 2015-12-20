/**
 * Created by cylee on 15/12/20.
 */
public class Num extends Token{
    int mValue;
    public Num(int value) {
        super(Tag.NUM);
        this.mValue = value;
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }
}
