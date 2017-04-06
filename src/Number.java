public class Number {
    //eine Zahl der Spirale
    //besitzt Zahlenwert und die Eigenschaft Primzahl bzw. Nicht-Primzahl

    public int value;

    public boolean isPrime=true;

    public Number(int x){
        this.value=x;

        if(x<2) isPrime=false;

        else {
            for (int i = x - 1; i > 1; i--) {
                if (x % i == 0) {
                    this.isPrime = false;
                    break;
                }
            }
        }

    }
    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
