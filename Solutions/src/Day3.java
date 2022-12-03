import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Map;

public class Day3 {
	private static ArrayList<String> readFile(){
		ArrayList<String> input = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File ("input3.txt"))) {
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
		for (String i: input) {
			for(int j = 0; j < i.length()/2; j++) {
				if (i.substring(i.length()/2).contains(String.valueOf(i.charAt(j)))) {
					if(Character.isLowerCase(i.charAt(j))){
						counter += i.charAt(j) - 'a' + 1;
					} else { counter += Character.toLowerCase(i.charAt(j)) - 'a' + 27;}
					break;
				}
			}
		}
		return counter;
	}
	
	private static int part2(ArrayList<String> input) {
		int counter = 0;
		for (int i = 0; i < input.size()-2; i+= 3) {
			for (int j = 0; j < input.get(i).length(); j++) {
				if (input.get(i+1).contains(String.valueOf(input.get(i).charAt(j))) 
						&& input.get(i+2).contains(String.valueOf(input.get(i).charAt(j)))) {
					if(Character.isLowerCase(input.get(i).charAt(j))){
						counter += input.get(i).charAt(j) - 'a' + 1;
					} else { counter += Character.toLowerCase(input.get(i).charAt(j)) - 'a' + 27;}
					break;
				}
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println("part 1: " + part1(readFile()));
		System.out.println("part 2: " + part2(readFile()));
	}

} 
