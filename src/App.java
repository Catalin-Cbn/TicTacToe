import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // inizializzo lo scanner
        Random rnd = new Random(); // il Random

        // variabili
        int riga = 0, colonna = 0;
        boolean again = true; // Permette di continuare il gioco
        boolean vittoria = false, vittoriaPC = false;
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
                    tris[riga][colonna] = "X";
                    // controllo righe
                    for (int i = 0; i < 3; i++) {
                        if (tris[i][0].equals(tris[i][1]) && tris[i][1].equals(tris[i][2])
                                && tris[i][0].equalsIgnoreCase("X")) {
                            System.out.println("Hai vinto!");
                            vittoria = true;
                        }
                    }

                    // controllo colonne
                    for (int j = 0; j < 3; j++) {
                        if (tris[0][j].equals(tris[1][j]) && tris[1][j].equals(tris[2][j])
                                && tris[0][j].equalsIgnoreCase("X")) {
                            System.out.println("Hai vinto!");
                            vittoria = true;
                        }
                    }
                    // controllo diagonali
                    if (tris[0][0].equals(tris[1][1]) && tris[1][1].equals(tris[2][2])
                            && tris[0][0].equalsIgnoreCase("X")) {
                        System.out.println("Hai vinto!");
                        vittoria = true;
                    }
                    if (tris[0][2].equals(tris[1][1]) && tris[1][1].equals(tris[2][0])
                            && tris[0][2].equalsIgnoreCase("X")) {
                        System.out.println("Hai vinto!");
                        vittoria = true;
                    }

                } else { // Turno computer
                    if (caselle < 9 && vittoria == false) {
                        do {
                            riga = rnd.nextInt(3);
                            colonna = rnd.nextInt(3);
                        } while (!tris[riga][colonna].equals("-")); // Ripete finché la casella non è libera
                        caselle++;
                        tris[riga][colonna] = "O";
                        System.out.println("Il computer ha giocato in posizione: " + riga + ", " + colonna);
                        // controllo righe
                    for (int i = 0; i < 3; i++) {
                        if (tris[i][0].equals(tris[i][1]) && tris[i][1].equals(tris[i][2])
                                && tris[i][0].equalsIgnoreCase("O")) {
                            System.out.println("Hai vinto!");
                            vittoriaPC = true;
                        }
                    }

                    // controllo colonne
                    for (int j = 0; j < 3; j++) {
                        if (tris[0][j].equals(tris[1][j]) && tris[1][j].equals(tris[2][j])
                                && tris[0][j].equalsIgnoreCase("O")) {
                            System.out.println("Hai vinto!");
                            vittoriaPC = true;
                        }
                    }
                    // controllo diagonali
                    if (tris[0][0].equals(tris[1][1]) && tris[1][1].equals(tris[2][2])
                            && tris[0][0].equalsIgnoreCase("O")) {
                        System.out.println("Hai vinto!");
                        vittoriaPC = true;
                    }
                    if (tris[0][2].equals(tris[1][1]) && tris[1][1].equals(tris[2][0])
                            && tris[0][2].equalsIgnoreCase("O")) {
                        System.out.println("Hai vinto!");
                        vittoriaPC = true;
                    }
                    }

                }

            } // Stampo il tabellone
            for (int i = 0; i < tris.length; i++) {
                for (int j = 0; j < tris[i].length; j++) {
                    System.out.print(tris[i][j] + " ");
                }
                System.out.println();
            }

            if (caselle == 9) {
                System.out.println("Pareggio!");
                again = false;
            } else {
                if (vittoriaPC == false && vittoria == false) {
                    // Chiedo se continuare
                System.out.println("Vuoi continuare? (true/false)");
                again = sc.nextBoolean();
                }
                
            }

        } while (again && !vittoria && !vittoriaPC);

        sc.close();
    }

}
