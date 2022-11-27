import java.math.BigInteger;

public class BigIntegerApp {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("10000");
        BigInteger b = new BigInteger("20000");
        BigInteger c = a.add(b);

        System.out.println(a);
        System.out.println(c);
    }
}
