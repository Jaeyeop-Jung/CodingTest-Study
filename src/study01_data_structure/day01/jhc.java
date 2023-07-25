package study01_data_structure.day01;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class jhc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean ans = true;
        int idx = 1;
        int cnt = 0;
        Stack<Integer> line = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (!line.isEmpty() && st.hasMoreTokens()) {
            int tmp = 0;
            if (cnt < n) {
                tmp = Integer.parseInt(st.nextToken());
                cnt++;
            }
            if (!line.isEmpty() && line.peek() == idx) {
                idx++;
            }
            else if (tmp == idx) {
                idx++;
            }
            else if (tmp > idx) {
                if (!line.isEmpty() && line.peek() < tmp) {
                    System.out.println("Sad");
                    ans = false;
                    break;
                }
                else line.push(tmp);
            }
//            else if (line.isEmpty()) {
//                line.push(tmp);
//            }
//            else {
//                System.out.println("Sad");
//                ans = false;
//                break;
//            }
        }
        if (ans) {
            System.out.println("Nice");
        }
    }
}
