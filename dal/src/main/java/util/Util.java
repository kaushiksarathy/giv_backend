package util;

import java.util.Random;

public class Util {
    private static final String AZ = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();
    public static String randomID(int numChars) {
        StringBuilder sb = new StringBuilder(numChars);
        for( int i = 0; i < numChars; i++ )
            sb.append( AZ.charAt( rnd.nextInt(AZ.length()) ) );
        return sb.toString();
    }
}
