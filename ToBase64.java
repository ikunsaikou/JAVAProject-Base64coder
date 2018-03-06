package mypackage;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.lang.String;

public class ToBase64 {
    public static void main(String[] args) throws UnsupportedEncodingException {   //若JDK不支持的字符集则引发异常
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "ikunsaikou!";
        String binStr = "";
        for (int i = 0; i <text.length() ; i++) {
            binStr += Integer.toBinaryString((text.charAt(i)))+ " ";

        }
        final byte[] textByte = text.getBytes("UTF-8");
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(binStr);
        System.out.println(encodedText);
        System.out.println(new String(decoder.decode(encodedText),"UTF-8"));
    }
}
