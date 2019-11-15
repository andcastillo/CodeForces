import java.io.*;
import java.util.*;

public class P1257D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int i, j, n, m, lastMonster = 0, nDays = -1;
		int[] monsters = new int[200001];
		int[][] heroes = new int[200001][2]; 
		int[] endurance = new int[200001];
		//int power = new int[200001];
		for (i = 0; i < t; i++) {
			n = in.nextInt();
			for (j = 0; j < n; j++) {
				monsters[j] = in.nextInt();
				endurance[j] = 0;
			}
			endurance[n] = 0;
			m = in.nextInt();
			for (j = 0; j < m; j++) {
				heroes[j][0] = in.nextInt();
				heroes[j][1] = in.nextInt();
				endurance[heroes[j][1]] = 1;
			}

			lastMonster = 0;
			nDays = -1;

			
		}
		
	}
}
