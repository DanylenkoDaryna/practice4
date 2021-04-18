package ua.nure.danylenko.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String>{

    private StringBuilder result;
    private static final String CHARSET = "Cp1251";

    @Override
    public Iterator<String> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<String> {

       private String regex;
       private String foundNext;
       private Matcher m;

       IteratorImpl() {
           try {
               regex=new String("(?sm)\\p{javaUpperCase}[A-Za-zа-яА-ЯъйіїєёЙІЇЄЁ\\s,-]+\\.".
                               getBytes(CHARSET),CHARSET);
           } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
           }
           m = Pattern.compile(regex).matcher(result);
        }

        @Override
        public boolean hasNext() {
                if(m.find()) {
                    foundNext = m.group();
                    }else {
                    return false;
                }
            return foundNext!=null;
        }

        @Override
        public String next() {
            if(foundNext==null){
                throw new NoSuchElementException();
            }else {
                return foundNext;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static String findSentences(Part4 part4) {
        StringBuilder sb=new StringBuilder();

        for (Object aPart4 : part4) {
            sb.append(aPart4).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args)throws IOException {
        Part4 part4=new Part4();
        part4.result=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        try (BufferedReader in4 = new BufferedReader(new
                InputStreamReader(
                new FileInputStream("part4.txt"), CHARSET))) {
            String line;
            while ((line = in4.readLine()) != null) {
                temp.append(line).append(" ");
            }
        }
        part4.result.append(temp.toString().replaceAll("\\p{javaWhitespace}{2,}", " "));
        System.out.println(findSentences(part4));

    }
}
