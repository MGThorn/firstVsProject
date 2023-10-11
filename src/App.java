public class App {
    static int sum(int ... ret){
        int s =0;
        for (int i : ret) {
            s+=i;
        }
        return s;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(sum(7,6));
        int [] d = {7,5};
        System.out.println(sum(d));
        
    }
}
