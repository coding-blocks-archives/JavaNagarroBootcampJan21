package L72_NagarroTest;

import java.util.ArrayList;

public class NeedForSpeed {

	public static void main(String[] args) {

		int cities = 7;
		int noPaths = 8;
		int[][] path = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 6 }, { 4, 5 }, { 5, 6 } };

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < cities; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < noPaths; i++) {
			list.get(path[i][0]).add(path[i][1]);
		}

		String[] power = { "None", "Cop", "Sand", "None", "Nitro", "None", "None" };
		nfs(power, list, 0, 0.0, "0", false , false);

	}

	public static void nfs(String[] power, ArrayList<ArrayList<Integer>> list, int city, double time, String ans,
			boolean ne, boolean se) {

		if (city == list.size() - 1) {
			System.out.println(ans + " -> " + time);
			return;
		}

		for (int nbr : list.get(city)) {

			if (power[city].equals("Nitro")) {

				double pCityTime = 1 * 0.5 * (se ? 2 : 1);
				nfs(power, list, nbr, time + pCityTime, ans + nbr, true, false);

			} else if (power[city].equals("Sand")) {

				double pCityTime = 1 * 2 * (ne ? 0.5 : 1);
				nfs(power, list, nbr, time + pCityTime, ans + nbr, false, true);

			} else if (power[city].equals("Cop")) {

				return;

			} else {

				double pCityTime = 1 * (ne ? 0.5 : 1) * (se ? 2 : 1);
				nfs(power, list, nbr, time + pCityTime, ans + nbr, false, false);

			}

		}

	}

}
