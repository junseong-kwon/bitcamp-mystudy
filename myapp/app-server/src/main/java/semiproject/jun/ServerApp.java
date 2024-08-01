package semiproject.jun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerApp {

  private static final int PORT = 8888;
  private static final int SIZE = 4;
  private static final int MAX_NUM = 25;
  private int[][] board1 = new int[SIZE][SIZE];
  private int[][] board2 = new int[SIZE][SIZE];

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= MAX_NUM; i++) {
      numbers.add(i);
    }
    Collections.shuffle(numbers);

    int counter = 0;
    int[][] board = new int[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = numbers.get(counter++);
      }
    }
    System.out.println(board);
  }
}
