package cleanCode.Chapter3.primePrinter.refactored;

public class PrimePrinter {
    private static final int numberOfPrimes = 1000;
    private static final int linesPerPage = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimeGenerator primePrinterHelper = new PrimeGenerator();
        NumberPrinter numberPrinter = new NumberPrinter(linesPerPage,columns);

        int[] primes = primePrinterHelper.generatePrimes(numberOfPrimes);
        numberPrinter.print(primes, numberOfPrimes);
    }
}


