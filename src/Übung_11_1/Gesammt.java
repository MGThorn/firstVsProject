package Übung_11_1;

public class Gesammt {
    int temp;
    boolean isGerade(int i){
        return i%2 == 0 ? true : false;
    }

    int quersumme(int i){
        if (i < 10) {
            return temp+i;
        }else{
            temp +=i%10;
            return quersumme(i/10);
        }
    }

    int max(int [] arr){
        int currMax =0;
        for (int i : arr) {
            if(currMax<i){
                currMax =i;
            }
        }
        return currMax;
    }
    int average(int [] arr){
        int total= 0;
        for (int i : arr) {
            total +=i;
        }
        return total/arr.length;

    }
    int [] reverse(int [] arr){
        int temp = 0;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[arr.length-(i+1)];
            arr[arr.length-(i+1)] = arr[i];
            arr[i]=temp;
        }
        return arr;
    }

}
