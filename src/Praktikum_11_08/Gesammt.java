package Praktikum_11_08;

public class Gesammt {
    boolean isPrime(int z){
        for(int i=2; i < z; i++){
            if(z%i==0){
                return false;
            }
        }
        return true;
    }

    
    boolean isPrimeTest(int [] primes){
        for (int i : primes) {
            if (!isPrime(i)) {
                return false;
            }
        }    
        return true;
    }

    int[] primes(int n){
        int primeCounter = 0;
        int currentNumber = 0;
        int [] primeList = new int[n];

        while(primeCounter<n){
            if (isPrime(currentNumber)) {
                primeList[primeCounter++] = currentNumber;
            }
            currentNumber++;
        }
        return primeList;
    }
    boolean isPrimeFast(int[] primes, int n, int number){
        for (int i = 1; i < n; i++) {
            if (!(number%primes[i]==0)) {
                return true;
            }
        }
        return false;
    }
    int[] primesFast1(int n, int [] primes){
        int primeCounter = 0;
        int currentNumber = 1;
        int [] primeList = new int[n];

        while(primeCounter<n){
            if (isPrimeFast(primes , primeCounter-1 ,currentNumber)) {
                primeList[primeCounter++] = currentNumber;
            }
            currentNumber+=2;
        }
        return primeList;
    }
    int[] primesFast(int n){
        //Warnings not working!!
        int primeCounter = 1;
        int currentNumber = 1;
        int [] primeList = new int[n];
        primeList[0] = 2;

        while(primeCounter<n){
            if (isPrimeFast(primeList , primeCounter-1 ,currentNumber)) {
                primeList[primeCounter++] = currentNumber;
            }
            currentNumber+=2;
        }
        return primeList;
    }

    long run(int n, int [] primes) {
        final long timeStart = System.currentTimeMillis();
        primesFast1(n, primes);
        final long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
     }
}


