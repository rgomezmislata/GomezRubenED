package ud4.practices;

import ud4.practices.data.BaseDeDades;
import ud4.practices.ui.MainMenu;

import java.util.Scanner;

/**
 * Programa de Gestió Musical.
 * Aquest programa permet consultar i afegir diferents
 * arttistes i grups a una base de dades en memòria.
 * <p>
 * El programa està dividit en 3 paquets:
 * - data: Classes encarregades de la "persistència" de dades.
 *         En aquest exemple les dades no es guarden a cap lloc.
 * - models: Classes que modelen els objectes que es tracten en el programa.
 * - ui: Classes que s'encarreguen de la interacció amb l'usuari.
 * <p>
 * Aquest exemple no segueix cap tipus de patró
 * de disseny i no s'ha de pendre com a exemple
 * per desenvolupar una aplicació real.
 *
 * TODO: Cal documentar les classes dels paquets models i ui
 *
 * @author Joan Puigcerver
 * @version 1.1 2022-12-14
 */
public class GestioMusical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseDeDades dades = new BaseDeDades();
        MainMenu mainMenu = new MainMenu(scanner, dades);
        mainMenu.menu();
    }
}
