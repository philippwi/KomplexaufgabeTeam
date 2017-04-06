import java.util.ArrayList;

public class Statistics {
    public int numberOfPrimes,numberOfTwinPrimes,pi,li;
    public double ratio,epsilon;
    private ArrayList<Integer> primes;
    private ArrayList<Integer> twinPrimes;

    public Statistics(int range) {
        primes = new ArrayList<>();
        twinPrimes = new ArrayList<>();
        getNumberOfPrimes(range);
        getNumberOfTwinPrimes();
        calcLi();
        getRatios();
    }

    public boolean isPrime(int number) { //testet ob number = primzahl

        if (number < 2) return false;

        else {
            for (int i = 2; i < number; i++)
                if (number % i == 0) return false;
        }
        return true;
    }

    private void getNumberOfPrimes(int range) {

        int overRange = 0;

        for (int i = 0; i <= range + 2; i++) {
            if (isPrime(i)) {
                primes.add(i);
                if (i > range) overRange++;
            }
        }
        this.numberOfPrimes = primes.size() - overRange;
    }

    private void getNumberOfTwinPrimes() { //Anzahl der Primzahlen, die Twin Prime-Paare bilden

        for (int i = 0; i < primes.size()-1; i++) {

                int prime1 = primes.get(i);
                int prime2 = primes.get(i + 1);
                if (prime2 - prime1 == 2) {
                    if (!twinPrimes.contains(prime1)) {
                        twinPrimes.add(prime1);
                        if (i < numberOfPrimes-1) twinPrimes.add(prime2);
                    }
                    else if (i < numberOfPrimes-1) twinPrimes.add(prime2);
                }
        }
        this.numberOfTwinPrimes = twinPrimes.size();
        this.pi = this.numberOfTwinPrimes;
    }

    private void calcLi(){
        //sehr komplizierte mathematische Berechnung
        //daher konkrete Umsetzung ausgelassen

      /*  int expInt=0;

        for(int i=1; i<1000; i++){
            expInt += ...
        }

        li = (int)(0.57721566490153286060
                + Math.log(Math.abs(Math.log(numberOfPrimes)))
                + expInt);*/
      li=(int)(pi*1.1);
    }

    private void getRatios(){
        this.ratio = (double)numberOfTwinPrimes/numberOfPrimes;
        this.epsilon = (double)pi/li;
    }
}
