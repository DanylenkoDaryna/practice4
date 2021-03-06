package ua.nure.danylenko.practice4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final String CHARSET = "Cp1251";

    public static void main(String[] args) throws IOException {
        StringBuilder input = new StringBuilder();
        try (BufferedReader in3 = new BufferedReader(new
                InputStreamReader(
         new FileInputStream("part3.txt"),CHARSET))){
            String line;
            while((line=in3.readLine())!=null){
                input.append(line).append(System.lineSeparator());
            }
        }

        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if("stop".equals(line)) {
                break;
            }else{
                System.out.print(defineDataType(line,input));
                System.out.println();
            }
        }
    }

    private static String defineDataType(String line, StringBuilder input) throws UnsupportedEncodingException {
        Matcher m;
        StringBuilder result = new StringBuilder();
        switch (line){
            case "String":
                String regexp= new String("\\b[a-zа-яъйіїєё]{2,}\\b".getBytes(CHARSET),CHARSET);
                m = Pattern.compile(regexp).matcher(input);
                while(m.find()){
                    result.append(m.group()).append(" ");
                }
                defineDataType(result);
                break;
            case "char":
                regexp= new String("(?iu)\\b[a-zа-яъйіїєё]\\b".getBytes(CHARSET),CHARSET);
                m = Pattern.compile(regexp).matcher(input);
                while(m.find()){
                    result.append(m.group()).append(" ");
                }
                defineDataType(result);
                break;
            case "int":
                regexp = "\\s\\b(\\d+)\\b\\s";
                m = Pattern.compile(regexp).matcher(input);
                while(m.find()){
                    result.append(m.group(1)).append(" ");
                }
                defineDataType(result);
                break;
            case "double":
                regexp = "\\d*\\.\\d*";
                m = Pattern.compile(regexp).matcher(input);
                while(m.find()){
                    result.append(m.group()).append(" ");
                }
                defineDataType(result);
                break;
            default:result.append("Incorrect input");
        }
        return result.toString();
    }

    private static void defineDataType(StringBuilder input) {
        if (input.length() == 0) {
            input.append("No such values");
        }
    }
}
