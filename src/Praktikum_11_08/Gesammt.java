package Praktikum_11_08;

public class Gesammt {
    public boolean isPrime(int z){
        for(int i=2; i < z; i++){
            if(z%i==0){
                return false;
            }
        }
        return true;
    }

    
    public boolean isPrimeTest(int [] primes){

        for (int i : primes) {
            if (!isPrime(i)) {
                return false;
            }
        }    
        return true;
    }

    public int[] primes(int n){
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
    public boolean isPrimeFast(int[] primes, int n, int number){
        //TODO test assert (number < primes[n-1] * primes[n-1]);

        for (int i = 1; i < n; i++) {
            if (number%primes[i]==0) {
                return false;
            }
        }
        return true;
    }
    public int[] primesFast1(int n, int [] primes){
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
    public int[] primesFast(int n){
        int primeCounter = 1;
        int currentNumber = 3;
        int [] primes = new int[n];
        primes[0] = 2;

        while(primeCounter<n){
            if (isPrimeFast(primes , primeCounter-1 ,currentNumber)) {
                primes[primeCounter++] = currentNumber;
            }
            currentNumber+=2;
        }
        return primes;
    }

    public long run(int n, int [] primes) {
        final long timeStart = System.currentTimeMillis();
        primesFast1(n, primes);
        final long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
     }
}


