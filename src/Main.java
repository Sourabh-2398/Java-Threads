import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Long> inputNumbers = Arrays.asList(1000000L,343L,3455L,2324L,4656L,23L,5564L);
        List<FactorialThread> threads = new ArrayList<>();

        for(long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

         for (Thread thread : threads) {
             thread.start();
         }

         for (Thread thread : threads) {
             thread.join(2000);
         }

         for(int i=0;i<inputNumbers.size();i++) {
             FactorialThread thread = threads.get(i);
             if(thread.isFinished()){
                 System.out.println("Factorial of "+inputNumbers.get(i)+" is " +thread.getResult());
             }
             else{
                 System.out.println("The calculation of "+inputNumbers.get(i)+" is still in progress" );
             }
         }

    }

    private static class FactorialThread extends Thread {
        private final long inputNumber;
        private BigInteger result=BigInteger.ZERO;
        private boolean isFinished=false;
        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result=factorial(inputNumber);
            this.isFinished=true;
        }

        public BigInteger factorial(long n) {
            BigInteger tempResult=BigInteger.ONE;
            for(long i=2; i<=n; i++) {
                tempResult=tempResult.multiply(BigInteger.valueOf(i));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return this.isFinished;
        }

        public BigInteger getResult() {
            return this.result;
        }
    }
}