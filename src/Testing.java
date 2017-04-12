import org.junit.jupiter.api.Test;

public class Testing {
    //zum testen der Algorithmen in der Konsole

    //Testmethoden:

    void printSpiral(int size) {//Ausgabe ab 100 unschön

        UlamSpiral u = new UlamSpiral(size);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (u.spiral[i][j] == null) System.out.print(0 + "  ");
                else if (u.spiral[i][j].value > 9) System.out.print(u.spiral[i][j] + " ");
                else System.out.print(u.spiral[i][j] + "  ");
            }
            System.out.println();
        }
    }

    void printStats(int range) {
        Statistics stats = new Statistics(range);
        System.out.println("range: " + range);
        System.out.println("number of primes: " + stats.numberOfPrimes);
        System.out.println("number of twin primes: " + stats.numberOfTwinPrimes);
        System.out.println("ratio: " + stats.ratio);
        System.out.println("pi(n): " + stats.pi);
        System.out.println("li(n): " + stats.li);
        System.out.println("epsilon: " + stats.epsilon);
    }

    @Test
    public void test() {

        printSpiral(99);

        printStats(99);

    }
}
