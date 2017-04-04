package tasks.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {

    }
    private static final int MAX_TWEETS = 10;

    private static int time = 0;

    private static class Tweet implements Comparable<Tweet> {
        int id;
        int tweetedTime;
        Tweet(int id) {
            this.id = id;
            this.tweetedTime = time++;
        }

        @Override
        public int compareTo(Tweet o) {
            return o.tweetedTime - tweetedTime;
        }
    }

    private static class User {
        List<Tweet> tweets = new LinkedList<Tweet>() {
            public boolean add(Tweet t) {
                if (size() == MAX_TWEETS) {
                    removeFirst();
                }
                return super.add(t);
            }
        };
        Set<User> following = new HashSet<>();

        public void tweet(Tweet t) {
            tweets.add(t);
        }

        public void follow(User user) {
            following.add(user);
        }

        public void unfollow(User user) {
            following.remove(user);
        }

        public List<Integer> getTweets() {
            return Stream.concat(following.stream(), Stream.of(this)).
                    flatMap(u -> u.tweets.stream()).sorted().limit(MAX_TWEETS).map(t -> t.id).
                    collect(Collectors.toList());
        }
    }

    private Map<Integer, User> users = new HashMap<>();
    private final User defaultUser = new User();

    public void postTweet(int userId, int tweetId) {
        users.compute(userId, (k,v) -> {
            if (v == null) v = new User();
            v.tweet(new Tweet(tweetId));
            return v;
        });
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return users.getOrDefault(userId, defaultUser).getTweets();
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        User u = users.computeIfAbsent(followeeId, v -> new User());
        users.compute(followerId, (k,v) -> {
            if (v == null) v = new User();
            v.follow(u);
            return v;
        });
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User u = users.get(followeeId);
        if (u == null) return;
        users.computeIfPresent(followerId, (k,v) -> {
            v.unfollow(u);
            return v;
        });
    }
}
