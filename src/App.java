import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // inizializzo lo scanner
        // variabili
        int riga;
        int colonna;
        boolean again;
        again = false;

        String[][] tris = new String[3][3];

        for (int i = 0; i < tris.length; i++) {
            for (int j = 0; j < tris.length; j++) {
                tris[i][j] = "-";
                System.out.print(tris[i][j]);
            }
            System.out.println();
        }
        do {

            do {
                System.out.println("In che riga vuoi piazzare la X? (0-1-2)");
                riga = sc.nextInt();
                System.out.println("E in che colonna? (0-1-2)");
                colonna = sc.nextInt();
                sc.nextLine();

                if (riga < 0 || riga > 2 || colonna < 0 || colonna > 2 ||
                        tris[riga][colonna].equals("X") || tris[riga][colonna].equals("O")) {

                    System.out.println("Inserimento non valido. Riprova");
                }
            } while (riga < 0 || riga > 2 || colonna < 0 || colonna > 2 || tris[riga][colonna].equals("X") || tris[riga][colonna].equals("O"));
            tris[riga][colonna] = "X";
            for (int i = 0; i < tris.length; i++) {
                for (int j = 0; j < tris.length; j++) {
                    System.out.print(tris[i][j]);

                } System.out.println();
            }
            System.out.println("again?");
            again = sc.nextBoolean();
        } while (again == true);
        sc.close();
    }
}
