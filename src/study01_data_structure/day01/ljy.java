package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class ljy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			q.addLast(Integer.parseInt(st.nextToken()));
		}
		Stack<Integer> stack = new Stack<>();
		int pre = 0;
		Boolean isOk = true;
		int people = 0;
		// �����
		while(!q.isEmpty()) {
			if (!stack.isEmpty()) {
				people = stack.peek();
				if (people == pre+1) {
					pre = stack.pop();
					continue;
				}
			}
			people = q.pollFirst();
			if (pre+1 == people) {
				pre = people;
				continue;
			}
			stack.add(people);
		}
		// ���� ���ο� �����ִٸ�
		while(!stack.isEmpty()) {
			int re = stack.pop();
			if (re != pre+1) {
				isOk = false;
				break;
			}
			pre = re;
		}
		//System.out.println(stack);
		if (isOk) {
			System.out.println("Nice");
		}
		else {
			System.out.println("Sad");
		}
		
	}

}
