import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Map;
public class Day2 {
	
	private static final Map<String, Integer> score_part1 = Map.of(
			"A X", 3, "B Y", 3, "C Z", 3,
			"A Y", 6, "B Z", 6, "C X", 6,
			"A Z", 0, "B X", 0, "C Y", 0);
	
	private static final Map<String, Integer> score_part2 = Map.of(
		    "A X", 3, "A Y", 1, "A Z",2,
		    "B X", 1, "B Y", 2, "B Z",3,
		    "C X", 2, "C Y", 3, "C Z",1 );
	
	private static ArrayList<String> readFile(){
		ArrayList<String> input = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File ("input2.txt"))) {

		    while (scanner.hasNextLine()) {
		        input.add(scanner.nextLine());
		    }
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
		
		return input;
	}
	
	private static int part1(ArrayList<String> input) {
		int counter = 0;
		for(String i: input) 
		   switch (String.valueOf(i.charAt(2))) {
		      case "X": counter += score_part1.get(i) + 1; break;
		      case "Y": counter += score_part1.get(i) + 2; break;
		      case "Z": counter += score_part1.get(i) + 3;}
		return counter;
	}
	
	private static int part2(ArrayList<String> input) {
		int counter = 0;
		for(String i: input) 
			switch (String.valueOf(i.charAt(2))) {
			   case "X": counter += score_part2.get(i); break;
			   case "Y": counter += score_part2.get(i) + 3; break;
			   case "Z": counter += score_part2.get(i) + 6; break;}
		return counter;
	}
	
	public static void main(String[] args) {
		ArrayList<String> input = readFile();
		System.out.println("part 1: " + part1(input));
		System.out.println("part 2: " + part2(input));
	}
	

}
