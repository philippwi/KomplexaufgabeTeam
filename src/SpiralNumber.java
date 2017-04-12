public class SpiralNumber {
    //eine Zahl der Spirale
    //besitzt Zahlenwert und die Eigenschaft Primzahl bzw. Nicht-Primzahl

    public int value;

    public boolean isPrime;

    public boolean isTwinPrime;

    public SpiralNumber(int x){
        this.value=x;
        isPrime = primeTest(x);

        if(isPrime){
            if(primeTest(x-2)||primeTest(x+2)) isTwinPrime=true;
        }
        else isTwinPrime=false;
    }

    private boolean primeTest(int x){
        if(x<2) return false;

        else {
            for (int i = x - 1; i > 1; i--) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
