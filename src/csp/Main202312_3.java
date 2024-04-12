package csp;

import java.util.*;

/**
 * @author 冯钰卓
 * @version 1.0
 * @data 2024/3/1 19:29
 * @email fengyuzhuo666@gmail.com
 */
public class Main202312_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] weights = new int[N];
        int sumW = 0;
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            sumW += weights[i];
        }
        Map<Integer, Node> orignalMap = new HashMap<>();
        Node root;
        if (M >= 1) {
            root = new Node(weights[0], 0);
            orignalMap.put(2, root);
        }
        for (int i = 1; i < M; i++) {
            int pId = sc.nextInt();
            Node pNode = orignalMap.get(pId);
            pNode.all_weight += weights[i];
            pNode.children.add(new Node(weights[i], i));
        }

        for (int i = 0; i < M; i++) {
            //正确答案
            int ans = sc.nextInt();
            Map<Integer,Node> map = new HashMap<>(orignalMap);
            while (!map.isEmpty()) {
                int minWeight = Integer.MAX_VALUE;
                int minNodeId = Integer.MAX_VALUE;
                //计算所有的 绝对权重
                for (int j = 0; j < M; j++) {
                    Set<Map.Entry<Integer, Node>> entries = map.entrySet();
                    for (Map.Entry<Integer, Node> entry : entries) {
                        int temp = Math.abs(entry.getValue().all_weight - (sumW - entry.getValue().all_weight));
                        if (temp < minWeight) {
                            minNodeId = entry.getKey();
                            minWeight = temp;
                        }
                        if (temp == minWeight) {
                            if (entry.getKey() < minNodeId) {
                                minNodeId = entry.getKey();
                            }
                        }
                    }
                }
                //验证
                if (minNodeId == ans) {
                    break;
                } else {
                    System.out.println(minNodeId);
                    //总权重减去该节点的所有权重
                    sumW -= map.get(minNodeId).all_weight;
                    //去除该节点及其后代
                    removeChildren(map, minNodeId);
                }
            }
        }
    }

    private static void removeChildren(Map<Integer, Node> map, int minNodeId) {
        if (map.containsKey(minNodeId)) {
            Node node = map.get(minNodeId);
            for (Node child : node.children) {
                removeChildren(map, child.id);
            }
            map.remove(minNodeId);
        }
    }


    static class Node {
        int id;
        int weight;
        int all_weight;
        List<Node> children;

        public Node(int weight, int id) {
            this.weight = weight;
            all_weight = weight;
            this.children = new ArrayList<>();
            this.id = id;
        }
    }
}
