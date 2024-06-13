package study.lang.variavle;

public class Test03 {
  public static void main(String[] args) {
    //  static String[][] subMenus = new String[][]{
    //  {"등록", "목록", "조회", "변경", "삭제"},
    //{"등록", "목록", "조회", "변경", "삭제"},
    // {"등록", "목록", "조회", "변경", "삭제"},
    // {"등록", "목록", "조회", "변경", "삭제"}
    //};

    int[][] arr2 = new int[3][4];
    arr2[0] = new int[] {11, 12};
    arr2[1] = new int[] {21, 22, 23};
    arr2[2] = new int[] {32, 32, 33, 34};

    System.out.println(arr2.length);
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr2[i].length; j++) {
        System.out.print(arr2[i][j] + ",");
      }
      System.out.println();
    }

    int[][] arr3 = new int[3][4];
    arr3[0] = new int[] {11, 12};
    arr3[1] = new int[] {21, 22, 23};
    arr3[2] = new int[] {32, 32, 33, 34};

    System.out.println(arr3.length);
    for (int i = 0; i < arr3.length; i++) {
      for (int j = 0; j < arr3[i].length; j++) {
        System.out.print(arr3[i][j] + ",");
      }
      System.out.println();

    }
  }
}


