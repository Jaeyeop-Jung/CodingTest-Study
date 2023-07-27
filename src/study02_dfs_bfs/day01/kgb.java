import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Picture {
	static int maxNum = 0;
	static int index = 0;
	static int a = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 세로
		int m = Integer.parseInt(st.nextToken()); // 가로

		int[][] arr = new int[n][m];
//		for (int i = 0; i < n; i++) { // 그림만들기
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < m; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//
//			}
//			
//		}

		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 500; j++) {
				arr[i][j] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0) {
					index++;
					int temp = maxNum;
					maxNum = 0;
					r(i, j, arr);

					if (maxNum < temp)
						maxNum = temp;

				}
			}
		}
		System.out.println(index);
		System.out.println(maxNum);

	}

	public static void r(int i, int j, int[][] arr) {

		if (arr[i][j] != 0) {
			maxNum += arr[i][j];
			arr[i][j] = 0;

		}
		int[] di = { 0, -1, 0, 1 };
		int[] dj = { -1, 0, 1, 0 };
		for (int k = 0; k < 4; k++) {
			int nexti = i + di[k];
			int nextj = j + dj[k];

			// System.out.println(a++);
			if (nexti >= 0 && nexti < arr.length && nextj >= 0 && nextj < arr[0].length)
				if (arr[nexti][nextj] != 0) {
					r(nexti, nextj, arr);
				}
		}

	}
}
