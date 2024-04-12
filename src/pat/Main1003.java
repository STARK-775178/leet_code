package pat;
import java.util.*;
/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/2/14 14:21
 * @email fengyuzhuo666@gmail.com
 */
public class Main1003 {
    /**
     * N (≤500) - the number of cities (and the cities are numbered from 0 to N−1)
     * M - the number of roads, C1 and C2 - the cities that you are currently in and that you must save, respectively.
     * 5 6 0 2
     * 1 2 1 5 3
     * 0 1 1
     * 0 2 2
     * 0 3 1
     * 1 2 1
     * 2 4 1
     * 3 4 1
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int C1 = in.nextInt();
        int C2 = in.nextInt();
        int[] teams = new int[N];
        for (int i = 0; i < N; i++) {
            teams[i] = in.nextInt();
        }
        int[][] roads = new int[N][N];
        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            roads[a][b] = c;
            roads[b][a] = c;
        }
        int[] dist = new int[N];
        int[] teamsNum = new int[N];
        boolean[] collected = new boolean[N];
        int[] pathNum = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[C1] = 0;
        teamsNum[C1] = teams[C1];
        pathNum[C1] = 1;
        while (true) {
            int v = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (!collected[i] && dist[i] < minDist) {
                    v = i;
                    minDist = dist[i];
                }
            }
            if (v == -1) {
                break;
            }
            collected[v] = true;
            for (int i = 0; i < N; i++) {
                if (!collected[i] && roads[v][i] > 0) {
                    if (dist[v] + roads[v][i] < dist[i]) {
                        dist[i] = dist[v] + roads[v][i];
                        teamsNum[i] = teamsNum[v] + teams[i];
                        pathNum[i] = pathNum[v];
                    } else if (dist[v] + roads[v][i] == dist[i]) {
                        pathNum[i] += pathNum[v];
                        if (teamsNum[v] + teams[i] > teamsNum[i]) {
                            teamsNum[i] = teamsNum[v] + teams[i];
                        }
                    }
                }
            }
        }
        System.out.println(pathNum[C2] + " " + teamsNum[C2]);
    }
}
