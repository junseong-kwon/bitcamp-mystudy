package bitcamp.array;

import java.util.Scanner;
public class Array3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        int total = 0;

        System.out.print("5개의 정수를 입력하세요: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        double avg = (double) total / 5;
        System.out.println("입력한 정수의 합계: " + total);
        System.out.println("입력한 정수의 평균: " + avg);


    }
}
