package bitcamp.myapp3.study.array;

import java.util.Arrays;

public class ArrayMain2 {

  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 2;
    System.out.println(Arrays.toString(arr));

    System.out.println("배열의 첫번째 위치에 3추가 O(n)");
    int newValue = 3;
    addFirst(arr , newValue);
    System.out.println(Arrays.toString(arr));

    System.out.println("배열의 index(2) 위치에 4 추가O(n)");
    int newValue2 = 4;
    addSecond(arr, newValue2);
    System.out.println(Arrays.toString(arr));

   addLast(arr, 5);
    System.out.println(Arrays.toString(arr));
  }

  private static void addLast(int[] arr, int i) {
    arr[arr.length - 1] = 5;
  }

  private static void addSecond(int[] arr, int newValue2) {
    for (int i = arr.length - 1; i > 2; i--) {
      arr[i] = arr[i - 1];
    }
    arr[2] = newValue2;
  }

  private static void addFirst(int[] arr, int newValue) {
    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = newValue;
  }

}
