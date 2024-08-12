package bitcamp.myapp3.study.array;

import java.util.Arrays;

public class ArrayMain1 {

  public static void main(String[] args) {
    int[] arr = new int[5];

    System.out.println("==index 입력: 0(1)==");
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;

    System.out.println(Arrays.toString(arr) );

    System.out.println("==index 조회: 0(1)==");
  }
}
