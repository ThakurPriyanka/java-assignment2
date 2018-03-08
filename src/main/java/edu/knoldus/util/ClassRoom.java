package edu.knoldus.util;

import java.util.List;
import java.util.Optional;

public class ClassRoom {
    String roomId;
    Optional<List<Student>> studentList;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setStudentList(Optional<List<Student>> studentList) {
        this.studentList = studentList;
    }

    public Optional<List<Student>> getStudentList() {
        return studentList;
    }

    public ClassRoom(String roomId, Optional<List<Student>> studentList) {

        this.roomId = roomId;
        this.studentList = studentList;
    }
}
