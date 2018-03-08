package edu.knoldus.operation;

import edu.knoldus.util.ClassRoom;

import java.util.List;
import java.util.stream.Collectors;

public class CollegeOperation {

    /**
     * @param classroomList . list of classroom
     * @return listName . list of student name
     */
    public List<String> studentAssociateWithRoom(List<ClassRoom> classroomList) {
        return classroomList.stream().filter(classRoom -> classRoom.getStudentList().isPresent())
                .flatMap(classRoom -> classRoom.getStudentList().get().stream())
                .filter(student -> !student.getSubject().isPresent())
                .map(x -> x.getName()).collect(Collectors.toList());
    }

    /**
     * @param classRoomList . list of classroom
     * @return listName . list of student name
     */
    public List<String> studentSubject(List<ClassRoom> classRoomList) {
        return classRoomList.stream().filter(classRoom -> classRoom.getRoomId().compareTo("B") == 0 && classRoom.getStudentList().isPresent())
                .flatMap(classRoom -> classRoom.getStudentList().get().stream())
                .filter(student -> student.getSubject().isPresent())
                .flatMap(student -> student.getSubject().get().stream()).collect(Collectors.toList());
    }

    /**
     * @param classroomList . list of classroom
     * @return listname . list of student name with greeting
     */
    public List<String> classStudentHello(List<ClassRoom> classroomList) {
        return classroomList.stream().filter(classRoom -> classRoom.getStudentList().isPresent())
                .flatMap(classRoom -> classRoom.getStudentList().get().stream())
                .map(greet -> "hello " + greet).collect(Collectors.toList());
    }
}
