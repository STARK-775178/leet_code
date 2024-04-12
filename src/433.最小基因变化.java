/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 *
 * https://leetcode.cn/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (54.60%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    61.2K
 * Total Submissions: 112.1K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * 
 * 
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 
 * 
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end
 * 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank =
 * ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank =
 * ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 * 
 * 
 */

// @lc code=start

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        List<String> visited = new ArrayList<>();
        queue.offer(startGene);
        visited.add(startGene);
        char[] geneChars = new char[] { 'A', 'C', 'G', 'T' };
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 对gene进行基因变化
                String gene = queue.poll();
                char[] geneCharArray = gene.toCharArray();

                for (int j = 0; j < gene.length(); j++) {
                    char oldChar = gene.charAt(j);
                    // 将这里的oldChar进行变化
                    for (int k = 0; k < geneChars.length; k++) {
                        geneCharArray[j] = geneChars[k];
                        String newString = new String(geneCharArray);
                        if (bankSet.contains(newString) && !visited.contains(newString)) {
                            if (newString.equals(endGene)) {
                                return step+1;
                            }
                            visited.add(newString);
                            queue.offer(newString);
                        }
                        geneCharArray[j] = oldChar;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end
