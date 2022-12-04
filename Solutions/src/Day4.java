import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
	
	private static ArrayList<String> readFile(){
		ArrayList<String> input = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File ("input4.txt"))) {

		    while (scanner.hasNextLine()) {
		        input.add(scanner.nextLine());
		    }
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
		
		return input;}
	
	private static int part1(ArrayList<String> input ) {
		int counter = 0;
		for(String i: input) {
			String[] arrOfStr = i.split("[-,-]");
			int[] arrOfInt = Arrays.stream(arrOfStr).mapToInt(Integer::parseInt).toArray();
			if((arrOfInt[0] >= arrOfInt[2] && arrOfInt[3] >= arrOfInt[1]) 
					|| (arrOfInt[2] >= arrOfInt[0] && arrOfInt[1] >= arrOfInt[3])) {counter++;}	
		}
		return counter;	
	}
	
	private static int part2(ArrayList<String> input) {
		int counter = 0;
		for(String i: input) {
			String[] arrOfStr = i.split("[-,-]");
			int[] arrOfInt = Arrays.stream(arrOfStr).mapToInt(Integer::parseInt).toArray();
			if((arrOfInt[1] >= arrOfInt[2] && arrOfInt[1] <= arrOfInt[3]) 
					|| (arrOfInt[3] >= arrOfInt[0] && arrOfInt[3] <= arrOfInt[1])) {counter++;}	
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println("part 1: " + part1(readFile()));
		System.out.println("part 2: " + part2(readFile()));
	}
	

}
