package mypackage;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.lang.String;
import java.util.Scanner;

public class ToBase64 {
    public static void main(String[] args) throws UnsupportedEncodingException {   //若JDK不支持的字符集则引发异常
        Scanner input = new Scanner(System.in);
        System.out.print("输入字符：");
        String text = input.next();
        Base64Coder base64Coder = new Base64Coder(text);
        base64Coder.ToBase64();
        base64Coder.ToBinary();
        base64Coder.ToUTF8();
    }
}
class Base64Coder{

    private String str;

    private Base64.Decoder decoder = Base64.getDecoder();
    private Base64.Encoder encoder = Base64.getEncoder();
    private byte[] textByte;
    private String encodedText;

    Base64Coder(String str) throws UnsupportedEncodingException {
        this.str=str;
        textByte = str.getBytes("UTF-8");

    }

    public void ToBase64() {

        encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
    }

    public void ToBinary(){
        StringBuilder binStr = new StringBuilder();  //单线程下对字符缓冲区操作
        for (int i = 0; i < str.length(); i++) {
            binStr.append(Integer.toBinaryString((str.charAt(i)))).append(" ");

        }
        System.out.println(binStr);
    }

    public void ToUTF8() throws UnsupportedEncodingException {
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }
}