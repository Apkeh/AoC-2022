import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;
public class Day1 {
	
	private static ArrayList<String> readFile(){
		ArrayList<String> input = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File ("input1.txt"))) {

		    while (scanner.hasNextLine()) {
		        input.add(scanner.nextLine());
		    }
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
		
		return input;
	}
	private static int part1(ArrayList<String> input) {
		int max = 0;
		int counter = 0;
		for (String item: input ) {
			if (item.equals("") && counter > max) {
				max = counter;
				counter =0;
				}
			else if(item.equals("")){counter = 0;}
			else { counter += Integer.parseInt(item);}
			
		}
		return max;
	}
	private static int part2(ArrayList<String> input) {
		ArrayList<Integer> top3= new ArrayList<Integer>(Collections.nCopies(3, 0));
		int counter = 0;
		for (String item: input) {
			if (item.equals("") && counter > top3.get(0)) {
				top3.remove(0);
			    top3.add(counter);
				Collections.sort(top3);
				counter = 0;}
			else if(item.equals("")) {counter = 0;}
			else {counter += Integer.parseInt(item);}}
		return top3.stream().mapToInt(i -> i).sum();
	}
	
	public static void main(String[] args) {
		ArrayList<String> input= readFile();
		System.out.println("part 1: " + part1(input));
		System.out.println("part 2: " + part2(input));
		
	}

}