class Twitter {

    Map<Integer, List<int[]>> tweetsMap;
    Map<Integer, Set<Integer>> followerMap;
    
    int counter;

    public Twitter() {
        this.tweetsMap = new HashMap<>();
        this.followerMap = new HashMap<>();
        counter = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsMap.putIfAbsent(userId, new ArrayList<>());
        tweetsMap.get(userId).add(new int[] {counter++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followees = followerMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for (int id : followees) {
            priorityQueue.addAll(tweetsMap.getOrDefault(id, new ArrayList<>()));
        }
        while (!priorityQueue.isEmpty() && feed.size() < 10) feed.add(priorityQueue.poll()[1]);
        return feed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerMap.containsKey(followerId)) followerMap.get(followerId).remove(followeeId);
    }
}
