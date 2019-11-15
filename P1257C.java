import java.io.*;
import java.util.*;

public class P1257C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] occ = new int[200001];
		int[][] rep = new int[200001][2]; 
		int val = 0, prev, i, j, n = 0;
		int minSubArray = -1;
		int t = in.nextInt();
		for (i = 0; i < t; i++) {
			n = in.nextInt();
			for ( j = 0; j <= n; j++) {
				occ[j] = 0;
				rep[j][0] = -1;
				rep[j][1] = n + 1;
			}
			for ( j = 0; j < n; j++) {
				val = in.nextInt();
				prev = rep[val][0];
				rep[val][0] =  j;
				if (prev != -1) {
					rep[val][1] =  j - prev + 1;
					occ[j - prev - 1] = 1;
				}
			}
			val = -1;
			for ( j = 0; j <= n; j++) {
				if (occ[j] == 1) {
					val = j + 2;
					break;							
				}
			}
			System.out.println(val);
		}
		
	}
}
