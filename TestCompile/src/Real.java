/**
 * Created by cylee on 15/12/20.
 */
public class Real extends Token{
    float mValue;

    public Real(float mValue) {
        super(Tag.REAL);
        this.mValue = mValue;
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }
}
