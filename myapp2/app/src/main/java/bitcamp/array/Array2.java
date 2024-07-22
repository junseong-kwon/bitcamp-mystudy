package bitcamp.array;

import java.util.Scanner;
public class Array2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[5];


        System.out.print("5개의 정수를 입력하세요: ");
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("출력");
      for (int i = 4; i >= 0; i--) {
          System.out.print(arr[i]);
          if (i  > 0)
              System.out.print(", ");
      }

    }
}
