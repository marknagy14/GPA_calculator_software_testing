package main.java.com.example.gpastudent.Testing.Student;

import main.java.com.example.gpastudent.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest_DataFlow {
    Student student;

    @BeforeEach
    void init()
    {
        student= new Student();
    }
    @Test
    void calculate_grade_path1(){
        student.setStudent_activities_mark(10);
        student.setStudent_oralPractical_mark(10);
        student.setStudent_midtermExam_mark(20);
        student.setStudent_finalExam_mark(60);
        student.calculate_grade();
        assertEquals("A+",student.getGrade());
        assertEquals(4,student.getGpa());
    }

    @Test
    void calculate_grade_path2(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(9);
        student.setStudent_midtermExam_mark(18);
        student.setStudent_finalExam_mark(58);
        student.calculate_grade();
        assertEquals("A",student.getGrade());
        assertEquals(4,student.getGpa());
    }

    @Test
    void calculate_grade_path3(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(9);
        student.setStudent_midtermExam_mark(18);
        student.setStudent_finalExam_mark(55);
        student.calculate_grade();
        assertEquals("A-",student.getGrade());
        assertEquals(3.7,student.getGpa());
    }
    @Test
    void calculate_grade_path4(){
        student.setStudent_activities_mark(7);
        student.setStudent_oralPractical_mark(9);
        student.setStudent_midtermExam_mark(15);
        student.setStudent_finalExam_mark(55);
        student.calculate_grade();
        assertEquals("B+",student.getGrade());
        assertEquals(3.3,student.getGpa());
    }
    @Test
    void calculate_grade_path5(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(9);
        student.setStudent_midtermExam_mark(15);
        student.setStudent_finalExam_mark(50);
        student.calculate_grade();
        assertEquals("B",student.getGrade());
        assertEquals(3,student.getGpa());
    }
    @Test
    void calculate_grade_path6(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(10);
        student.setStudent_midtermExam_mark(15);
        student.setStudent_finalExam_mark(45);
        student.calculate_grade();
        assertEquals("B-",student.getGrade());
        assertEquals(2.7,student.getGpa());
    }
    @Test
    void calculate_grade_path7(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(10);
        student.setStudent_midtermExam_mark(11);
        student.setStudent_finalExam_mark(45);
        student.calculate_grade();
        assertEquals("C+",student.getGrade());
        assertEquals(2.3,student.getGpa());
    }
    @Test
    void calculate_grade_path8(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(10);
        student.setStudent_midtermExam_mark(13);
        student.setStudent_finalExam_mark(39);
        student.calculate_grade();
        assertEquals("C",student.getGrade());
        assertEquals(2,student.getGpa());
    }
    @Test
    void calculate_grade_path9(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(8);
        student.setStudent_midtermExam_mark(11);
        student.setStudent_finalExam_mark(39);
        student.calculate_grade();
        assertEquals("C-",student.getGrade());
        assertEquals(1.7,student.getGpa());
    }
    @Test
    void calculate_grade_path10(){
        student.setStudent_activities_mark(5);
        student.setStudent_oralPractical_mark(5);
        student.setStudent_midtermExam_mark(11);
        student.setStudent_finalExam_mark(45);
        student.calculate_grade();
        assertEquals("D+",student.getGrade());
        assertEquals(1.3,student.getGpa());
    }
    @Test
    void calculate_grade_path11(){
        student.setStudent_activities_mark(8);
        student.setStudent_oralPractical_mark(10);
        student.setStudent_midtermExam_mark(14);
        student.setStudent_finalExam_mark(30);
        student.calculate_grade();
        assertEquals("D",student.getGrade());
        assertEquals(1,student.getGpa());
    }
    @Test
    void calculate_grade_path12(){
        student.setStudent_activities_mark(9);
        student.setStudent_oralPractical_mark(5);
        student.setStudent_midtermExam_mark(10);
        student.setStudent_finalExam_mark(30);
        student.calculate_grade();
        assertEquals("F",student.getGrade());
        assertEquals(0,student.getGpa());
    }

}