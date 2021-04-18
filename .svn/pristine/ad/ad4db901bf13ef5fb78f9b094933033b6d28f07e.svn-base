package ua.nure.danylenko.practice4;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    public static void main(String[]args){
        Scanner s = new Scanner(System.in,"Cp1251");
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if("stop".equals(line)) {
                break;
            }else{
                System.out.println(defineLocale(line));
            }
        }
    }

    private static String defineLocale(String line){

        String word="";
        Matcher m = Pattern.compile("^(\\w+)\\s(\\b[a-z]{2}\\b)$").matcher(line);
        String lang = "";
        if(m.find()){
            word=m.group(1);
            lang=m.group(2);
        }
        Locale locale=new Locale(lang);
        ResourceBundle rb = ResourceBundle.getBundle("resources",locale);
        String result;
        try{
            result = rb.getString(word);
        }catch (MissingResourceException e){
            result = "No such values";
        }

        return result;
    }


}
