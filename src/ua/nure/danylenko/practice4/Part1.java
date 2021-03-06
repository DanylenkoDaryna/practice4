package ua.nure.danylenko.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static final String CHARSET = "Cp1251";
    public static void main(String[] args) throws IOException {
       StringBuilder input = new StringBuilder();
        try (BufferedReader in1 = new BufferedReader(new
                InputStreamReader(
                new FileInputStream("part1.txt"),CHARSET))) {

            String line;
            while ((line = in1.readLine()) != null) {
                input.append(line).append(System.lineSeparator());
            }
        }
        System.out.println(convert(input.toString()));

    }

    private static String convert(String input) throws UnsupportedEncodingException {
        StringBuffer result = new StringBuffer();

        String regexp= new String("[A-Za-zа-яА-ЯъйіїєёЙІЇЄЁ]{4,}".getBytes(CHARSET),CHARSET);
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(input);
        while(m.find()){

            m.appendReplacement(result, changeCase(m.group()));
        }
        m.appendTail(result);
         return result.toString();
    }

    private static String changeCase(String str){
        StringBuilder sb = new StringBuilder();
        char[] letters=str.toCharArray();
        for(char ch: letters){
            if(Character.isLowerCase(ch)){
                sb.append(Character.toUpperCase(ch));
            }else if(Character.isUpperCase(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
