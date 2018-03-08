package edu.knoldus.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentClassData {
    static List<Student> studentList;
    static List<ClassRoom> classRoomList;

    static {
        studentList = new ArrayList<>();
        classRoomList = new ArrayList<>();
    }

    /**
     * @return classRoomList . return list of classsromm
     */
    public List<ClassRoom> getClassRoomData() {
        String name1 = "Priyanka2";
        String rollNumber1 = "123";
        Optional<List<String>> subjectOption1 = Optional.ofNullable(null);

        String name2 = "Priyank";
        String rollNumber2 = "124";
        List<String> subjectList2 = new ArrayList<>();
        subjectList2.add("maths1");
        subjectList2.add("english1");
        subjectList2.add("science1");

        String name3 = "Priya";
        String rollNumber3 = "125";
        List<String> subjectList3 = new ArrayList<>();
        subjectList3.add("maths");
        subjectList3.add("english");


        Optional<List<String>> subjectOption2 = Optional.of(subjectList2);

        Optional<List<String>> subjectOption3 = Optional.of(subjectList3);

        Student student1 = new Student(name1, rollNumber1, subjectOption1);
        Student student2 = new Student(name2, rollNumber2, subjectOption2);

        Student student3 = new Student(name3, rollNumber3, subjectOption3);


        String classRoomId1 = "A";
        Optional<List<Student>> studentOption1 = Optional.ofNullable(null);

        String classRoomId2 = "B";
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(student1);
        studentList1.add(student3);


        String classRoomId3 = "C";
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(student2);

        Optional<List<Student>> studentOption2 = Optional.of(studentList1);


        Optional<List<Student>> studentOption3 = Optional.of(studentList2);

        ClassRoom classRoom1 = new ClassRoom(classRoomId1, studentOption1);
        ClassRoom classRoom2 = new ClassRoom(classRoomId2, studentOption2);

        ClassRoom classRoom3 = new ClassRoom(classRoomId3, studentOption3);


        classRoomList.add(classRoom1);
        classRoomList.add(classRoom2);
        classRoomList.add(classRoom3);
        return classRoomList;
    }

}
