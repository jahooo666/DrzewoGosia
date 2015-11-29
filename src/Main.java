import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner odczyt = new Scanner(new File("input.txt"));

            //wczytywanie korzenia głównego - dla ułatwienia jest to pierwszy element
            String rootLine = odczyt.nextLine();
            String[] rootPodzielone = rootLine.split(" ");
            char rootLabel = rootPodzielone[0].charAt(0);
            Node root = new Node(rootLabel);

            while (odczyt.hasNextLine()) {
                String line = odczyt.nextLine();
                String[] podzielone = line.split(" ");
                char label = podzielone[0].charAt(0);
                String path = podzielone[1];
                root.insert(label,path);
            }
            root.printFormated(0);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
