import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcurrencyAssignment extends Thread {

private static List<Integer> randNum = new ArrayList<Integer>();
public static int arraySize = 200000000;

	public static List<Integer> randomNumbers(){
		Random rand = new Random();		
		randNum.clear();
		for (int i = 0; i < arraySize; ++i) {
			randNum.add(rand.nextInt(10) + 1);
			}
		return randNum;
	}
	public static int singleSum() {
		randomNumbers();
		int results = ConcurrencyAssignment.sum(arraySize, 1);
		System.out.println(results);
		return results;
	}
	public static int parallelSum() {
		int threads = 4;
		int size = arraySize / threads;
		int[] partial = {0,1,2,3};
		randomNumbers();
		
		Thread first = new Thread(() -> partial[0] = ConcurrencyAssignment.sum(size, 1));
		Thread second = new Thread(() -> partial[1] = ConcurrencyAssignment.sum(size, 2));
		Thread third = new Thread(() -> partial[2] = ConcurrencyAssignment.sum(size, 3));
		Thread fourth = new Thread(() -> partial[3] = ConcurrencyAssignment.sum(size, 4));
		
		first.start();
		second.start();
		third.start();
		fourth.start();
		
		try {
			first.join();
			second.join();
			third.join();
			fourth.join();
		} catch (InterruptedException e) {
		}
		
		int results = (partial[0] + partial[1] + partial[2] + partial[3]);
		System.out.println(results);
		return results;
		}
	
	public static int sum(int size, int thread) {
		int low,high;
		low = (size * thread) - size;
		high = (size * thread);
		
		int sum = randNum.get(low);
		for (int i = low; i < high; ++i) {
			sum = sum + randNum.get(i);
			}
		return sum;
		}
	
	public static void main(String[] args) {
		long runTime = System.currentTimeMillis();
		singleSum();
		System.out.println("The run time for Single is: " + (System.currentTimeMillis() - runTime) + " milliseconds.");
		
		runTime = System.currentTimeMillis();
		parallelSum();
		System.out.println("The run time for Parallel is: " + (System.currentTimeMillis() - runTime) + " milliseconds.");

	}

}

