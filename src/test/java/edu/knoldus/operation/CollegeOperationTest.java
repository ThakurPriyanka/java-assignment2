package edu.knoldus.operation;

import edu.knoldus.util.ClassRoom;
import edu.knoldus.util.StudentClassData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class CollegeOperationTest {
  StudentClassData dataObj;

  List<ClassRoom> classRoomList;
  CollegeOperation operationObj;
  @Before
  public void setUp() throws Exception {
    dataObj = new StudentClassData();
    operationObj = new CollegeOperation();
  classRoomList = dataObj.getClassRoomData();
    operationObj = new CollegeOperation();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void studentAssociateWithRoom() {
    List<String> studentList = operationObj.studentAssociateWithRoom(classRoomList);
   List<String> expectedOutput =  new ArrayList();
    expectedOutput.add("Priyanka2");
    assertEquals("Student associated with room does not match",expectedOutput,studentList);
  }

  @Test
  public void studentSubject() {
    List<String> subjectList = operationObj.studentSubject(classRoomList);
    List<String> expectedOutput =  new ArrayList();
    expectedOutput.add("maths");
    expectedOutput.add("english");
    expectedOutput.add("maths");
    expectedOutput.add("english");
    expectedOutput.add("maths");
    expectedOutput.add("english");
    assertEquals("Subject list of student associated to class is not working",expectedOutput,subjectList);
  }

  @Test
  public void classStudentHello() {
    List<String> greetList = operationObj.classStudentHello(classRoomList);
    List<String> expectedOutput =  new ArrayList();
    expectedOutput.add("hello Priyanka2");
    expectedOutput.add("hello Priya");
    expectedOutput.add("hello Priyank");
    expectedOutput.add("hello Priyanka2");
    expectedOutput.add("hello Priya");
    expectedOutput.add("hello Priyank");
    assertEquals("list of student with greeting of all class is not working",expectedOutput,greetList);

  }
}