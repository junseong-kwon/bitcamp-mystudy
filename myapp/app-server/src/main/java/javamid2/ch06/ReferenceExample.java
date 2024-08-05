package javamid2.ch06;

import java.util.Arrays;

public class ReferenceExample {

  public static void main(String[] args) {
    int[] arr1;
    int[] arr2;
    int[] arr3;

    arr1 = new int[]{1, 2, 3};
    arr2 = new int[]{1, 2, 3};
    arr3 = arr2;

    System.out.println(Arrays.equals(arr1, arr2));
  }

}
