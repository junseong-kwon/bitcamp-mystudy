package bitcamp.array;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] students = new int[] {90, 80, 70, 60, 50};

        int total = 0;
        for (int i = 0; i < students.length; i++){
             total += students[i];
        }
        double avg = (double) total / 5;

        System.out.println(total);
        System.out.println(avg);


    }
}
