package org.example;
import java.security.MessageDigest;
import org.example.Block;
public class StringUtil {
    Block block = new Block();
    public static String applySha256(String input){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for(int i=0; i< hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);

            }
            return hexString.toString();
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }// takes a string and applies the SHA-256 function to it

}
