package edu.knoldus.util;

import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private String rollNumber;
    private Optional<List<String>> subject;

    @Override
    public final String toString() {
        return this.name;
    }

    /**
     * @param nameUser . name of student
     * @param rollNumberUser . roll number of student
     * @param subjectUser . subject List of student
     */
    public Student(String nameUser, String rollNumberUser,
                   Optional<List<String>> subjectUser) {
        this.name = nameUser;
        this.rollNumber = rollNumberUser;
        this.subject = subjectUser;
    }

    /**
     * @return name . name of student
     */
    public final String getName() {
        return name;
    }

    /**
     * @param nameUser . name of student
     */
    public final void setName(String nameUser) {
        this.name = nameUser;
    }

    /**
     * @param rollNumberUser . student rollnumber
     */
    public final void setRollNumber(String rollNumberUser) {
        this.rollNumber = rollNumberUser;
    }

    /**
     * @param subjectUser . subject list of student
     */
    public final void setSubject(Optional<List<String>> subjectUser) {
        this.subject = subjectUser;
    }

    /**
     * @return rollNumber . roll number of student
     */
    public final String getRollNumber() {
        return rollNumber;

    }

    /**
     * @return subject . list of subject of student
     */

    public final Optional<List<String>> getSubject() {
        return subject;
    }
}
