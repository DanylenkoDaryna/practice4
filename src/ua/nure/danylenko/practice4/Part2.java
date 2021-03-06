package ua.nure.danylenko.practice4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Part2 {

    public static void main(String[] args) throws IOException {
        StringBuilder input = new StringBuilder();
        input.append("input ==> ");
        File file = new File("part2.txt");
        if (!file.exists()) {
            boolean isCreated = file.createNewFile();
            if (!isCreated) {
                System.out.println("is not created");
            }
        }

        int[] arr = new int[10];
        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(file.getName()))) {
            for (int i = 0; i < 10; i++) {
                int rand = randomNums();
                out.write((Integer.toString(rand) + " ").getBytes());
                input.append(rand).append(" ");
                arr[i] = rand;
            }
        }
        System.out.println(input);

        try (BufferedWriter out2 = new BufferedWriter(new
                OutputStreamWriter(
                new FileOutputStream("part2_sorted.txt"), "Cp1251"))){
            String sortedNums=sort(arr);
            out2.write(sortedNums);
            StringBuilder sb = new StringBuilder();
            sb.append("output ==> ").append(sortedNums);
            System.out.println(sb);
        }
    }

    private static String sort(int[]arr){
        StringBuilder sb = new StringBuilder();

        for(int i=arr.length-1; i>=1; i--) {
            for (int k = 0; k < i; k++) {
                while (arr[k] > arr[k + 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
        for (int anArr : arr) {
            sb.append(anArr).append(" ");
        }
        return sb.toString();
    }

    private static int randomNums(){
        final int rightBound = 50;
        return new Random().nextInt(rightBound);
    }
}
