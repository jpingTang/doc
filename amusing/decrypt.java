import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by cylee on 16/1/24.
 */
public class Test_01 {

    private static  Cipher b;
    private static  Cipher c;
    private static Key b(byte[] paramArrayOfByte)
    {
        byte[] arrayOfByte = new byte[8];
        int i = 0;
        while (true)
        {
            if ((i >= paramArrayOfByte.length) || (i >= arrayOfByte.length))
                return new SecretKeySpec(arrayOfByte, "DES");
            arrayOfByte[i] = paramArrayOfByte[i];
            i += 1;
        }
    }
    public static void main(String[] args) throws Exception{
        System.out.println(decrypt("9f9955a8d43897e6ac7bbc6b6e0b57e0"));
        System.out.println(decrypt("9f9955a8d43897e6726f1b25014c7cdcf72927203283a7fe"));
        System.out.println(decrypt("77c79f04c3b34e35f5e0d7a3f744d27beda7f36474f02f3d"));
        System.out.println(decrypt("9f9955a8d43897e6726f1b25014c7cdcf72927203283a7fe"));
        System.out.println(decrypt("df4366b1b9d7d95937c5ac6563122d275acb86f0d9ee4a45"));
        System.out.println(decrypt("9f9955a8d43897e6ac7bbc6b6e0b57e0"));
        System.out.println(decrypt("fb286b8bfcf28cae6a57e68bd6554603eda7f36474f02f3d"));
    }

    public static String decrypt(String raw) throws Exception{
        if (b == null) {
            byte[] key = "h~mx".getBytes();
            b = Cipher.getInstance("DES");
            b.init(1, b(key));
            c = Cipher.getInstance("DES");
            c.init(2,b(key));
        }
        return new String(c.doFinal(a(raw)));
    }

    public static byte[] a(String str_raw)
    {
        byte[] paramString = str_raw.getBytes();
        int j = paramString.length;
        byte[] arrayOfByte = new byte[j / 2];
        int i = 0;
        while (true)
        {
            if (i >= j)
                return arrayOfByte;
            String str = new String(paramString, i, 2);
            arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(str, 16));
            i += 2;
        }
    }
}
