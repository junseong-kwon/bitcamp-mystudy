package semiproject.jun;

public class ArrayExample {

  public static void main(String[] args) {
    int[][] mathScores = new int[2][3];

    for (int i = 0; i < mathScores.length; i++) {//반의 수만큼 반복
      for (int k = 0; k < mathScores[i].length; k++) { // 해당 반의 학생 수만큼 반복

        System.out.println("mathScores[" + i + "][" + k + "]: " + mathScores[i][k]);
      }
    }
    System.out.println();
  }
}

