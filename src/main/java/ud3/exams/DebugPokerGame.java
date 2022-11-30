import java.util.Scanner;
import java.util.Locale;

public class DebugPokerGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);

        boolean escala = true;
        int comptadorCartesIguals = 0;
        int anterior = -1;

        for (int i = 0; i < 3; i++) {
            int carta = in.nextInt();

            if(anterior == carta)
                comptadorCartesIguals++;
            else if(anterior != carta + 1)
                escala = false;

            anterior = carta;
        }

        if(comptadorCartesIguals == 2)
            System.out.println("Trio");
        else if (comptadorCartesIguals == 1)
            System.out.println("Parella");
        else if (escala==false)
            System.out.println("Escala");
        else
            System.out.println("Carta alta");

    }
}
