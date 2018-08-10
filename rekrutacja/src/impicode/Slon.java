package impicode;

import java.util.*;

public class Slon {
	
	public static void main(String[] args) {
	
	String[] listsc = new String[4];
	
	try(Scanner scanner = new Scanner(System.in)){
		int i = 0;
		while(i < 4){
		listsc[i] = scanner.nextLine();
		i++;
		}			
	}
	
	int numberOfElephants = Integer.parseInt(listsc[0]);
	int[] weightOfElephants = new int[numberOfElephants];
	int[] currentOrder = new int[numberOfElephants];
	int[] targetOrder = new int[numberOfElephants];
	
	for(int i = 1; i < 4; i++) {
		if (i == 1) {
			String [] temp = listsc[i].split(" ");
			for(int j =0; j < weightOfElephants.length; j++) {
				weightOfElephants[j] = Integer.parseInt(temp[j]);
				}
			}
		if (i == 2) {
			String [] temp = listsc[i].split(" ");
			for(int j =0; j < currentOrder.length; j++) {
				currentOrder[j] = Integer.parseInt(temp[j])-1;
				}
			}
		if (i == 3) {
			String [] temp = listsc[i].split(" ");
			for(int j =0; j < targetOrder.length; j++) {
				targetOrder[j] = Integer.parseInt(temp[j])-1;
				}
			}
		}
		
	boolean [] helper = new boolean[numberOfElephants];
	for(int i = 0; i < numberOfElephants; i++) {
		if(currentOrder[i] == targetOrder[i]) {
			helper[i] = true;
		}
		else {
			helper[i] = false;
		}
	}
	
	int operationsWeight = 0;
	int min = Integer.MAX_VALUE;
	
	for(int i = 0; i < numberOfElephants; i++) {
		if(!helper[i]) {
		min = Integer.min(min, weightOfElephants[i]);
		}
	}
		
	for (int i = 0; i < numberOfElephants; i++) {
		if(!helper[i]) {
			int cycleSum = 0;
			int cycleMin = Integer.MAX_VALUE;
			int numberOfCycles = 0;
			
			int x = i;
			while (!helper[i]) {
				cycleSum += weightOfElephants[x];
				cycleMin = Integer.min(cycleMin,weightOfElephants[x]);	
				x = targetOrder[x];
				numberOfCycles += 1;
				helper[x] = true;
				
				}
			int method1 = cycleSum +((numberOfCycles-2)*cycleMin);
			int method2 = cycleSum + cycleMin + ((numberOfCycles+1)*min);
			
			operationsWeight += Integer.min(method1, method2);
			}
		}			
		
	System.out.println(operationsWeight);
	
	}
	
}
