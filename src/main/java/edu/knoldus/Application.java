package edu.knoldus;

import edu.knoldus.operation.CollegeOperation;
import edu.knoldus.operation.TwitterOperation;
import edu.knoldus.util.ConnectionTwitter;
import edu.knoldus.util.StudentClassData;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class Application {

    public static void main(String[] args) {
        ConnectionTwitter connectionObject = new ConnectionTwitter();
        twitter4j.Twitter twitter = connectionObject.getConnectionTwitter();
        TwitterOperation twitterobject = new TwitterOperation(twitter);
//
        StudentClassData objData = new StudentClassData();
        CollegeOperation collObj = new CollegeOperation();
        System.out.println(collObj
                .studentAssociateWithRoom(objData.getClassRoomData()));
        System.out.println(collObj.studentSubject(objData.getClassRoomData()));

        System.out.println(collObj.classStudentHello(objData.getClassRoomData()));
    }
}
