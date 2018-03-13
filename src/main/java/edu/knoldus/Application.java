package edu.knoldus;

import edu.knoldus.operation.CollegeOperation;
import edu.knoldus.operation.TwitterOperation;
import edu.knoldus.util.ConnectionTwitter;
import edu.knoldus.util.StudentClassData;
import twitter4j.Status;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class Application {

    public static void main(String[] args) {
        ConnectionTwitter connectionObject = new ConnectionTwitter();
        twitter4j.Twitter twitter = connectionObject.getConnectionTwitter();
        TwitterOperation twitterobject = new TwitterOperation(twitter);
        try {
            CompletableFuture<Stream<String>> resultTweet = twitterobject.getTweet();
            resultTweet.thenAccept(tweets -> tweets.forEach(System.out::println));
            CompletableFuture<Integer> resultOldNew = twitterobject.getTweetCount();
            resultOldNew.thenAccept(System.out::println);
            CompletableFuture<Double> resultRetweet = twitterobject.getTweetAvgerage();
            resultRetweet.thenAccept(System.out::println);

            CompletableFuture<Double> resultTotalLike = twitterobject.getTweetAvgerageLike();
            resultTotalLike.thenAccept(System.out::println);
            Thread.sleep(10000);


        StudentClassData objData = new StudentClassData();
        CollegeOperation collObj = new CollegeOperation();
        System.out.println(collObj
                .studentAssociateWithRoom(objData.getClassRoomData()));
        System.out.println(collObj.studentSubject(objData.getClassRoomData()));

        System.out.println(collObj.classStudentHello(objData.getClassRoomData()));
        Thread.sleep(10000);
        }
        catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
