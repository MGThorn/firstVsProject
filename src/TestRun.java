import Praktikum_11_08.Gesammt;

public class TestRun {
    public static void main(String [] args){
        Gesammt prime = new Gesammt();
        for (int i : prime.primesFast(7)) {
            System.out.print(" "+i);
        }
    }
    
}
