package ud3.exams;

import java.util.Scanner;
import java.util.Locale;

public class GitConflicts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = in.nextInt();
        
        if(n % 2 == 0) {
            System.out.printf("%d is even.", n);
        } else {
<<<<<<< HEAD
            System.out.printf("%d is not even.", n);
=======
            System.out.printf("%d is odd.", n);
>>>>>>> odd_number
        }
    }
}