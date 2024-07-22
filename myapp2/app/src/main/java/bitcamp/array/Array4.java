package bitcamp.array;

import java.util.Scanner;

public class Array4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력받을 숫자의 개수를 입력하세요: ");
        int text = scanner.nextInt();
        int[] arr = new int[text];
        int total = 0;


        System.out.print(text + "개의 정수를 입력하세요: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];

        }

        double avg = (double) total / text;
        System.out.println("입력한 정수의 합계: " + total);
        System.out.println("입력한 정수의 평균: " + avg);


    }
}
