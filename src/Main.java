import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Scanner odczyt = new Scanner(new File("input.txt"));
          //   Scanner odczyt = new Scanner(new File("przyklad1"));
          // Scanner odczyt = new Scanner(new File("przyklad2"));
             Scanner odczyt = new Scanner(new File("przyklad3"));

            //wczytywanie korzenia głównego - dla ułatwienia jest to pierwszy element
            Node root = new Node('-');

            while (odczyt.hasNextLine()) {
                String line = odczyt.nextLine();
                String[] podzielone = line.split(" ");
                char label = podzielone[0].charAt(0);
                if (podzielone.length > 1) {
                    String path = podzielone[1];
                    root.insert(label, path);
                } else
                    root.setLabel(label);

            }
            root.printFormated(0);
            System.out.println("Wyszukuje najstarsze słowo");
            //System.out.println(root.findOldest());
            root.findOldestPath(root,"");
            System.out.println(root.getOldestPath());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
