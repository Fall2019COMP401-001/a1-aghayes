package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("(\\s+|\\z)");

		double low = 0;
		String lowname = null;
		double high = 0;
		String highname = null;
		double avgtotal = 0;

		int fnum = scan.nextInt();
		String[] fname = new String[fnum];
		double[] fprice = new double[fnum];
		for(int j = 0 ; j <fnum; j++){
			fname[j] = scan.next();
			fprice[j] = scan.nextDouble();
		}

		int cnum = scan.nextInt();
		for(int j = 0; j<cnum; j++){
			String cname = scan.next() + " " + scan.next();
			int cfnum = scan.nextInt();
			double ctotal = 0;
			for(int k = 0; k< cfnum; k++) {
				int finum = scan.nextInt();
				int find = index(fname, scan.next());
				ctotal += finum*fprice[find];
			}
			if(j==0) {
				low = ctotal;
				lowname = cname;
			}
			if(ctotal < low){
				low = ctotal;
				lowname = cname;
			}
			if(ctotal > high){
				high = ctotal;
				highname = cname;
			}
			avgtotal += ctotal;
		}
		System.out.println("Biggest: "+highname+" ("+String.format("%.2f", high)+")");
		System.out.println("Smallest: "+lowname+" ("+String.format("%.2f", low)+")");
		System.out.println("Average: "+String.format("%.2f", (avgtotal/cnum)));
	}

	public static int index(String[] array, String value){
		value.replaceAll("[a-zA-Z0-9]", "");
		for( int l = 0; l<array.length; l++){
			if(array[l].contentEquals(value)){
				return l;
			}
		}
		return -1;
	}
}
