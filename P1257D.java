import java.io.*;
import java.util.*;

public class P1257D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int i, j, k, n, m, power, endur, lastMonster = 0, prevMonster = 0, nDays = -1;
		Hero hero;
		int max;
		int[] monsters = new int[200001];
		for (i = 0; i < t; i++) {
			n = in.nextInt();
			max = Integer.MIN_VALUE;
			for (j = 0; j < n; j++) {
				monsters[j] = in.nextInt();
				if (monsters[j] > max)
					max = monsters[j];
			}
			m = in.nextInt();
			int[] heroesList = new int[n + 1];
			for (j = 0; j < m; j++) {
				power = in.nextInt();
				endur = in.nextInt();

				power = power > max ? max : power;
				endur = endur > n ? n : endur;
				heroesList[endur] = Math.max(heroesList[endur], power);
				//System.out.println(heroesList.size());
				/*for (k = heroesList.size() - 1; k >= 0; k--) {
					hero = heroesList.get(k);
					if (power > hero.power && endur >= hero.endurance
							|| power >= hero.power && endur > hero.endurance) {
						heroesList.remove(k);
					}
					if ((power < hero.power && endur <= hero.endurance)
							|| (power <= hero.power && endur < hero.endurance)
							|| (power == hero.power && endur == hero.endurance)) {
						power = -1;
						endur = -1;
						break;
					}

				}

				if (power != -1 && endur != -1) {
					heroesList.add(new Hero(power, endur));
				} */
			}
			
			nDays = -1;
			// BFS
			ArrayList<State> states = new ArrayList<State>();
			State currentState;
			states.add(new State(0, 0));
			while (states.size() > 0) {
				currentState = states.remove(0);
				prevMonster = currentState.state;

				if (prevMonster >= n) {
					nDays = currentState.level;
					break;
				} else {
					int bestMove = prevMonster;
					for (k = heroesList.size() - 1; k >= 0; k--) {
						lastMonster = prevMonster;
						hero = heroesList.get(k);
						int endurance = 1;
						while (monsters[lastMonster] <= hero.power && hero.endurance >= endurance && lastMonster < n) {
							endurance++;
							lastMonster++;
						}
						if (lastMonster > bestMove) {
							bestMove = lastMonster;
						}
					}
					if (bestMove > prevMonster) {
						states.add(new State(bestMove, currentState.level + 1));
					}
				}
			}
			System.out.println(nDays);
		}
	}

	static class State {
		int level;
		int state;

		public State(int state, int level) {
			this.level = level;
			this.state = state;
		}
	}

	static class Hero {
		int power;
		int endurance;

		public Hero(int power, int endurance) {
			this.power = power;
			this.endurance = endurance;
		}
	}
}
