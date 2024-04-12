package pat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
    int i;
    int j;
    int value;

    public Node(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

public class Main1007 {
    public static void main(String[] args) throws IOException {
        /**
         * Sample Input:
         * 10
         * -10 1 2 3 4 -5 -23 3 7 -21
         * Sample Output:
         * 10 1 4
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        List<Node> dp = new ArrayList<>(N);
        dp.add(0, new Node(0, 0, nums[0]));
        for (int i = 1; i < N; i++) {
            if (nums[i] + dp.get(i - 1).value > nums[i]) {
                dp.add(i, new Node(dp.get(i - 1).i, i, nums[i] + dp.get(i - 1).value));
            } else {
                dp.add(i, new Node(i, i, nums[i]));
            }
        }
        Node max = dp.get(0);
        for (int i = 1; i < N; i++) {
            if (dp.get(i).value > max.value) {
                max = dp.get(i);
            }
        }

        if (max.value < 0) {
            System.out.println("0 " + nums[0] + " " + nums[N - 1]);
        } else {
            System.out.println(max.value + " " + nums[max.i] + " " + nums[max.j]);
        }
    }
}