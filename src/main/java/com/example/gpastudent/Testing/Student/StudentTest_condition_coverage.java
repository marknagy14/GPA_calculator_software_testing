package main.java.com.example.gpastudent.Testing.Student;

import main.java.com.example.gpastudent.models.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest_condition_coverage {
    @Test
    void NameCoverageTest() {
        //We assume that all the student data except the name are always correct
        Student student = new Student();

        //test name with space and numbers
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data(" 2234","12345678","10","10","20","60"));

        //test name with numbers
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("2234","12345678","10","10","20","60"));

        //test name with space
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data(" Ahmed","12345678","10","10","20","60"));

        //test valid name
        student.validate_student_data("Ahmed hany","12345678","10","10","20","60");
        assertEquals("Ahmed hany",student.getStudent_name());
    }

    @Test
    void IDCoverageTest() {
        //We assume that all the student data except the ID are always correct
        Student student = new Student();

        //test id with less than 8 characters,special characters,and letters
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","ab#","10","10","20","60"));

        //test id with less than 8 characters and letters
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","abc","10","10","20","60"));

        //test id with less than 8 characters and letters with 1 number at the end
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","ab1","10","10","20","60"));

        //test id with less than 8 characters and  with 1 special Character at the end
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","123#","10","10","20","60"));

        //test id with less than 8 characters and  with 1 Letter at the end
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","123a","10","10","20","60"));

        //test id with less than 8 characters and numbers only
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","1234","10","10","20","60"));

        //test id with  8 characters with letters and a special character at the end
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","abcdefg#","10","10","20","60"));

        //test id with  8 characters with letters
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","abcdefgh","10","10","20","60"));

        //test id with  8 characters with letters and a number at the end
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","abcdefg6","10","10","20","60"));

        //test id with  8 characters with numbers and a special character at the end
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","1234567#","10","10","20","60"));

        //test id with  8 characters with numbers and an "s" at the end
        student.validate_student_data("Ahmed hany","1234567s","10","10","20","60");
        assertEquals("1234567s",student.getStudent_number());

        //test id with  8 characters with just numbers
        student.validate_student_data("Ahmed hany","12345678","10","10","20","60");
        assertEquals("12345678",student.getStudent_number());

    }

    @Test
    void activityCoverageTest() {
        //We assume that all the student data except the activity marks are always correct
        Student student = new Student();

        //test with negative marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","-2","10","20","60"));

        //test with above boundary marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","20","10","20","60"));

        //test name with valid marks
        student.validate_student_data("Ahmed hany","12345678","10","10","20","60");
        assertEquals(10,student.getStudent_activities_mark());

    }

    @Test
    void oralCoverageTest() {
        //We assume that all the student data except the oral marks are always correct
        Student student = new Student();

        //test with negative marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","10","-2","20","60"));

        //test with above boundary marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","10","20","20","60"));

        //test name with valid marks
        student.validate_student_data("Ahmed hany","12345678","10","10","20","60");
        assertEquals(10,student.getStudent_oralPractical_mark());

    }

    @Test
    void midCoverageTest() {
        //We assume that all the student data except the midterm marks are always correct
        Student student = new Student();

        //test with negative marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","10","10","-2","60"));

        //test with above boundary marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","10","10","30","60"));

        //test name with valid marks
        student.validate_student_data("Ahmed hany" ,"12345678","10","10","20","60");
        assertEquals(20,student.getStudent_midtermExam_mark());

    }

    @Test
    void finalCoverageTest() {
        //We assume that all the student data except the midterm marks are always correct
        Student student = new Student();

        //test with negative marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","10","10","20","-2"));

        //test with above boundary marks
        assertThrows(IllegalArgumentException.class, () -> student.validate_student_data("Ahmed","12345678","10","10","20","70"));

        //test name with valid marks
        student.validate_student_data("Ahmed hany","12345678","10","10","20","60");
        assertEquals(60,student.getStudent_finalExam_mark());

    }
}