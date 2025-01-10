class Twitter {
    Map<Integer, User> users;
    LinkedList<Post> posts;
    public class User{
        int userId;
        List<Integer> follow;
        public User(int userId){
            this. userId = userId;
            this.follow = new LinkedList<>();
            this.follow.add(userId);
        }
    }
    public class Post{
        int tweetId;
        int userId;
        public Post(int tweetId, int userId){
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        this.users = new HashMap<>();
        this.posts = new LinkedList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Post post = new Post(tweetId, userId);
        posts.addFirst(post);
        addUser(userId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        User user = this.users.get(userId);
        if(user == null) return res;
        List<Integer> follow = user.follow;
        int count = 0;
        ListIterator<Post> it = posts.listIterator(0);
        while(it.hasNext()){
            Post post = it.next();
            if(follow.contains(post.userId)){
                res.add(post.tweetId);
                if(++count == 10)
                return res;
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = addUser(followerId);
        addUser(followeeId);
        if(!follower.follow.contains(followeeId))
            follower.follow.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User user = addUser(followerId);
        List<Integer> f = user.follow;
        for(int i = 0; i < f.size(); i++)
            if(f.get(i) == followeeId && followerId != followeeId)
                f.remove(i);
    }
    private User addUser(int userId){
        if(!this.users.containsKey(userId)){
            this.users.put(userId, new User(userId));
        }
        return this.users.get(userId);
    }
}