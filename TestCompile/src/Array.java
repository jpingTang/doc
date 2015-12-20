/**
 * Created by cylee on 15/12/20.
 */
public class Array extends Type {
    private int mLen;
    private Type mType;
    public Array(Type type, int len) {
        super(Tag.ARRAY, "[]", type.mWidth * len);
        mType = type;
        mLen = len;
    }

    @Override
    public String toString() {
        return mType + "[" + mLen+ "]";
    }
}
