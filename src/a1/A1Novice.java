package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("(\\s+|\\z)");

		int cnum = scan.nextInt();
		for(int i = 0; i<cnum; i++){
			System.out.print(scan.next().charAt(0)+". "+scan.next()+": ");
			int fnum = scan.nextInt();
			double total = 0;
			for(int j = 0; j<fnum; j++){
				int num = scan.nextInt();
				scan.next();
				double price = scan.nextDouble();
				total += num*price;
			}
			System.out.println(String.format("%.2f", total));
		}


		
	}
}
