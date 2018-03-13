package edu.knoldus.operation;



import twitter4j.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class TwitterOperation {
    private Twitter twitter;


    public TwitterOperation(Twitter twitter) {
        this.twitter = twitter;
    }

    /**
     * @return tweetList . List of tweet is return
     */
    public CompletableFuture<Stream<String>> getTweet() {

        return CompletableFuture.supplyAsync(() -> {
            Stream<String> tweetData = null;
            try {
                Query query = new Query("modi");
                QueryResult result;
                do {
                    result = twitter.search(query);
                    List<Status> tweets = result.getTweets();
                    tweetData = tweets.stream().map(tweet -> tweet.getText());
                    System.out.println(tweetData);
                    return tweetData;
                }while ((query = result.nextQuery()) != null);
            } catch (TwitterException te) {
                System.out.println(te.getMessage());
            }
            return tweetData;
        });
    }

    /**
     * @return count . return tweet count
     */
    public CompletableFuture<Integer> getTweetCount() {
        return CompletableFuture.supplyAsync(() -> {
            Integer totalTweet = 0;
            try {
                Integer count = 100;
                Query query = new Query("annual");
                query.setCount(count);

                QueryResult result;
                do {
                    result = twitter.search(query);
                    totalTweet = result.getTweets().size();
                }while ((query = result.nextQuery()) != null);
            } catch (TwitterException te) {
                te.printStackTrace();
                System.out.println("Failed to search tweets: " + te.getMessage());
                System.exit(-1);
            }
            return totalTweet;
        });
    }

    /**
     * @return average . average tweets
     */
    public CompletableFuture<Double> getTweetAvgerage() {
        return CompletableFuture.supplyAsync(() -> {
            Integer count = 100;
            Double averageDate = 0.0;
            try {
                Query query = new Query("modi");
                query.setCount(count);
                query.setSince(java.time.LocalDate.now().minusDays(10).toString());
                query.setUntil(java.time.LocalDate.now().toString());

                QueryResult result = twitter.search(query);
                Integer total = result.getTweets().size();
                System.out.println("\n\nTotal" + total + "\n\n");
                averageDate = total * 1.0 / 10;
            } catch (TwitterException te) {
                te.printStackTrace();
                System.out.println("Failed to search tweets: " + te.getMessage());
                System.exit(-1);
            }
            return averageDate;
        });
    }

    /**
     * @return averageTweetLike . average tweets like
     */
    public CompletableFuture<Double> getTweetAvgerageLike() {
        CompletableFuture<Double> averageTweetLike = CompletableFuture.supplyAsync(() -> {
            Integer count = 100, sum = 0, total = 0;
            Long userId = 254136345L;
            try {
                Query query = new Query("annual");
                query.setCount(count);
                QueryResult result;
                result = twitter.search(query);
                total = result.getTweets().size();
                sum = twitter.getFavorites(userId).size();
            } catch (TwitterException te) {
                te.printStackTrace();
                System.out.println("Failed to search tweets: " + te.getMessage());
                System.exit(-1);
            }
            Double average = sum * 1.0 / total;
            return average;
        });
        return averageTweetLike;
    }
}
