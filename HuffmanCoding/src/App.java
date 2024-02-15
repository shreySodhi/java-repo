import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());
        StringTokenizer st = new StringTokenizer(r.readLine());

        // ArrayList<Long> a = new ArrayList<>();
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long ans = 0;
        long contribution = 0;
        long cnt_ops = 0;
        for (int i = 0; i < n; i++) {
            contribution += cnt_ops;
            arr[i]+=contribution;
            long cur_ops = -arr[i];
            ans += Math.abs(cur_ops);
            cnt_ops += cur_ops;
            contribution += cur_ops;
        }
        System.out.println(ans);
    }
}

