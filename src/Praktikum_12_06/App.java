package Praktikum_12_06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("insert number of Bars:");
        String inp = input.next();
        Chart chart = new Chart(0);
        while (!isNumeric(inp)) {
            chart = new Chart(Integer.parseInt(inp));
        }
        

        help(input);
        
        while (true) {
            System.err.println("waiting for input ...");

            String in = input.next();

            if (in.equals("help")) {
                help(input);
            }else if (in.equals("up")) {
                chart.down();
            }else if (in.equals("down")) {
                chart.down();
            }else if (in.equals("exit")){
                break;
            }else if (isNumeric(in)) {
                try {
                    chart.setBar(new Bar(Integer.parseInt(in)));
                } catch (Exception e) {
                    System.out.println("try again, "+e.getMessage());
                }
            }else{
                System.out.println("please enter a valid command");
                help(input);
            }

            System.out.println(chart.toString());
        }




    }

    private static void help(Scanner input) {
        System.out.println("to enter this menue type help");
        System.out.println("to go select the next or previous Bar slot in the Chart either type up or down ");
        System.out.println("to Create/Overwrite a new Bar in the selected slot with the length of [Number] type a valid number");
        System.out.println("to exit type exit");
        System.out.println("to continue type any text");
        input.next();
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
