package Praktikum_12_06;

public class Bar {
    int size;
    final int MAX_SIZE = 40;

    Bar(int size){
        if ((size<=MAX_SIZE)&&(size>=0)) {
            this.size = size;
        }else{
            throw new IllegalArgumentException("required: 0 <= size <= "+MAX_SIZE);
        }
        
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < this.size; i++)  ret += "#";
        return ret+" "+this.size;
    }




}
