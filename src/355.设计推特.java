/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 *
 * https://leetcode.cn/problems/design-twitter/description/
 *
 * algorithms
 * Medium (41.15%)
 * Likes:    375
 * Dislikes: 0
 * Total Accepted:    45.5K
 * Total Submissions: 110.6K
 * Testcase Example:  '["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]\n' +
  '[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]'
 *
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 * 
 * 实现 Twitter 类：
 * 
 * 
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId
 * 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID
 * 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为
 * followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为
 * followeeId 的用户。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet",
 * "getNewsFeed", "unfollow", "getNewsFeed"]
 * [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 * 输出
 * [null, null, [5], null, null, [6, 5], null, [5]]
 * 
 * 解释
 * Twitter twitter = new Twitter();
 * twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
 * twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
 * twitter.follow(1, 2);    // 用户 1 关注了用户 2
 * twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
 * twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文
 * id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
 * twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
 * twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1
 * 已经不再关注用户 2
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= userId, followerId, followeeId <= 500
 * 0 <= tweetId <= 10^4
 * 所有推特的 ID 都互不相同
 * postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 10^4 次
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;




class Twitter {
    private HashMap<Integer, Tweet> tweetMap;

    //消息的全局唯一id，自增长
    private static long timestamp = 0;

    /**
     * Twitter() 初始化简易版推特对象
     */
    public Twitter() {
        tweetMap = new HashMap<Integer, Tweet>();
    }

    /**
     * * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId
     * 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
     * 
     * @param userId
     * @param tweetId
     */
    public void postTweet(int userId, int tweetId) {
        //将推文加入自己的推文列表
        tweetMap.putIfAbsent(userId, new Tweet());
        System.out.println("add" + userId + "tweet" + tweetId);
        tweetMap.get(userId).myTweetList.put(++timestamp, tweetId);
    }

    /**
     * * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID
     * 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
     * 
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId) {
        //如果用户不存在，直接返回
        if(!tweetMap.containsKey(userId)){
            return new ArrayList<>();
        }

        //获取关注列表
        List<Integer> followList = tweetMap.get(userId).getMyFollowTweetList();
        //如果关注列表为空，直接返回自己的推文列表，按时间降序
        if(followList.isEmpty()){
            List<Map.Entry<Long,Integer>> tweetList = new ArrayList<>(tweetMap.get(userId).getMyTweetList().entrySet());
            Collections.sort(tweetList, new Comparator<Map.Entry<Long,Integer>>() {
                @Override
                public int compare(Map.Entry<Long,Integer> o1, Map.Entry<Long,Integer> o2) {
                    return o2.getKey().compareTo(o1.getKey());
                }
            });
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < tweetList.size() && i < 10; i++) {
                result.add(tweetList.get(i).getValue());
            }
            return result;
        }
        //获取自己的推文列表
        Map<Long,Integer> myTweetList = tweetMap.get(userId).getMyTweetList();
        //将自己的推文列表加入推文列表
        List<Map.Entry<Long,Integer>> tweetList = new ArrayList<>(myTweetList.entrySet());
        //遍历关注列表
        for (Integer followId : followList) {
            //如果关注用户不存在，跳过这个用户
            if(!tweetMap.containsKey(followId)){
                continue;
            }

            //获取关注用户的推文列表
            Map<Long,Integer> followTweetList = tweetMap.get(followId).getMyTweetList();
            //将关注用户的推文列表加入推文列表
            tweetList.addAll(followTweetList.entrySet());
        }
        //按照时间排序
        Collections.sort(tweetList, new Comparator<Map.Entry<Long,Integer>>() {
            @Override
            public int compare(Map.Entry<Long,Integer> o1, Map.Entry<Long,Integer> o2) {
                return o2.getKey().compareTo(o1.getKey());
            }
        });
        //获取前10条推文
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < tweetList.size() && i < 10; i++) {
            result.add(tweetList.get(i).getValue());
        }
        return result;
    }

    /**
     * * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为
     * followeeId 的用户。
     * 
     * @param followerId
     * @param followeeId
     */
    public void follow(int followerId, int followeeId) {
        //将关注的用户加入关注列表
        tweetMap.putIfAbsent(followerId, new Tweet());
        //如果followerId关注了followeeId，直接返回
        if(tweetMap.get(followerId).myFollowTweetList.contains(followeeId)){
            return;
        }
        tweetMap.get(followerId).getMyFollowTweetList().add(followeeId);
    }

    /**
     * * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为
     * followeeId 的用户。
     * 
     * @param followerId
     * @param followeeId
     */
    public void unfollow(int followerId, int followeeId) {
        //如果followerId不存在，直接返回
        if(!tweetMap.containsKey(followerId)){
            return;
        }
        //如果关注列表中没有followeeId，直接返回
        if(!tweetMap.get(followerId).myFollowTweetList.contains(followeeId)){
            return;
        }

        //将关注的用户从关注列表中移除
        tweetMap.get(followerId).myFollowTweetList.remove(Integer.valueOf(followeeId));
    }

    private class Tweet{
        public Map<Long,Integer> myTweetList ;

        //关注列表
        public List<Integer> myFollowTweetList ;
        
        Tweet(){
            myTweetList = new HashMap<>();
            myFollowTweetList = new ArrayList<>();
        }

        public List<Integer> getMyFollowTweetList() {
            return myFollowTweetList;
        }

        public Map<Long, Integer> getMyTweetList() {
            return myTweetList;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end
