import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // inizializzo lo scanner
        Random rnd = new Random(); // il Random

        // variabili
        int riga = 0, colonna = 0;
        boolean again = true; // Permette di continuare il gioco
        int caselle = 0;
        String[][] tris = new String[3][3];
        int[] turno = new int[2]; // Indica i turni, 0: utente, 1: computer

        // Inizializzazione del tabellone
        for (int i = 0; i < tris.length; i++) {
            for (int j = 0; j < tris[i].length; j++) {
                tris[i][j] = "-";
            }
        }

        // Ciclo del gioco
        do {
            for (int t = 0; t < turno.length; t++) {
                if (t == 0) { // Turno utente
                    do {
                        System.out.println("In che riga vuoi piazzare la X? (0-1-2)");
                        riga = sc.nextInt();
                        System.out.println("E in che colonna? (0-1-2)");
                        colonna = sc.nextInt();
                        sc.nextLine(); // Consuma l'input rimanente

                        if (riga < 0 || riga > 2 || colonna < 0 || colonna > 2 ||
                                tris[riga][colonna].equals("X") || tris[riga][colonna].equals("O")) {
                            System.out.println("Inserimento non valido. Riprova");
                        }
                    } while (riga < 0 || riga > 2 || colonna < 0 || colonna > 2 ||
                            tris[riga][colonna].equals("X") || tris[riga][colonna].equals("O"));
                    caselle++;
                } else { // Turno computer
                    if (caselle < 9) {
                        do {
                            riga = rnd.nextInt(3);
                            colonna = rnd.nextInt(3);
                        } while (!tris[riga][colonna].equals("-")); // Ripete finché la casella non è libera
                        caselle++;
                    }

                }

                // Aggiorno il tabellone
                if (t == 0) {
                    tris[riga][colonna] = "X";
                } else {
                    tris[riga][colonna] = "O";
                    System.out.println("Il computer ha giocato in posizione: " + riga + ", " + colonna);
                }

            }
            for (int i = 0; i < tris.length; i++) {
                for (int j = 0; j < tris[i].length; j++) {
                    System.out.print(tris[i][j] + " ");
                }
                System.out.println();
            }
            // Stampo il tabellone
            if (caselle == 9) {
                System.out.println("Pareggio!");
                again = false;
            } else {
                // Chiedo se continuare
                System.out.println("Vuoi continuare? (true/false)");
                again = sc.nextBoolean();
            }

        } while (again);

        sc.close();
    }

}
