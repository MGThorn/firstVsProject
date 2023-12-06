import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("insert number of Bars:");
        Chart chart = new Chart(input.nextInt());

        System.out.println("");
        while (true) {
            System.out.println("waiting for input ...");
        }



    }
}
