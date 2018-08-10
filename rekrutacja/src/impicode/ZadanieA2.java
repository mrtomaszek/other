package impicode;

import java.util.ArrayList;

public class ZadanieA2 {

	public static void main(String[] args) {

		ArrayList<Float> listOfNumbers = new ArrayList<Float>();
		Float sum = 0f;
		
		for(int i = 0; i < args.length; i++) {
			listOfNumbers.add((float) Integer.parseInt(args[i]));
		}
		
		for (int i = 0; i < listOfNumbers.size(); i++) {
			sum += listOfNumbers.get(i);
		}
		Float qrt = sum / 4;
		
		Float first = Math.abs(listOfNumbers.get(0) - qrt);
		Float second;
		int index = 0;

		for (int i = 1; i < listOfNumbers.size(); i++) {
			second = Math.abs(listOfNumbers.get(i) - qrt);
			if (second < first) {
				index = i;
				first = second;
			}
		}
		System.out.println(listOfNumbers.get(index));
	}
}
