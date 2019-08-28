package a1;

import javax.swing.plaf.synth.SynthUI;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("(\\s+|\\z)");
		int fnum = scan.nextInt();
		String[] fname = new String[fnum];
		String[] fprice = new String[fnum];
		int[] fcus = new int[fnum];
		int[] fsold = new int[fnum];

		for(int j = 0 ; j <fnum; j++){
			fname[j] = scan.next();
			fprice[j] = scan.next();
		}
		int cnum = scan.nextInt();

		for(int j = 0; j <cnum; j++){
			scan.next();
			scan.next();
			int cfnum = scan.nextInt();
			int[] cfindlist = new int[cfnum];
			Arrays.fill(cfindlist, -1);
			for(int k = 0; k < cfnum; k++){
				int cfbo = scan.nextInt();
				boolean check = true;
				String cfname = scan.next();
				int cfind = index(fname, cfname);
				for(int l = 0; l < cfnum; l++){
					if(cfind == cfindlist[l]){
						fsold[cfind] += cfbo;
						check = false;
						break;
					}
				}
				if(check) {
					fcus[cfind]++;
					fsold[cfind] += cfbo;
				}
				System.out.println(cfindlist[k]);
				cfindlist[k] = cfind;
				System.out.println(cfindlist[k]);
			}
		}
		for( int j = 0; j < fname.length; j++){
			if(fcus[j] < 1){
				System.out.println("No customers bought " + fname[j]);
			}
			else {
				System.out.println(fcus[j] + " customers bought " + fsold[j] + " " + fname[j]);
			}
		}
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
