package main.java.com.example.gpastudent.Testing.Student;

import main.java.com.example.gpastudent.constants.ExceptionConstants;
import main.java.com.example.gpastudent.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BranchCoverage_StudentTest {

    Exception exception;
    Student student;

    @BeforeEach
    void init() {
        student = new Student();
        exception = new Exception();

    }
    /************************Sum_Student_data****************************/
    @Test
    void Sum_student_data1() throws IllegalArgumentException {
        Student student7 = new Student(10, 10, 20, 57);
        student7.calculate_grade();
        assertEquals("A+", student7.getGrade(), "There is an error in the lower boundary of A+ grade");
        assertEquals(4, student7.getGpa(), "There is an error in the lower boundary of GPA 4");

    }

    @Test
    void Sum_student_data2() throws IllegalArgumentException {
        // Test upper boundaries of A
        Student student8 = new Student(10, 10, 20, 56);
        student8.calculate_grade();
        assertEquals("A", student8.getGrade(), "There is an error in the upper boundary of A grade");
        assertEquals(4, student8.getGpa(), "There is an error in the upper boundary of GPA 4");

    }

    @Test
    void Sum_student_data3() throws IllegalArgumentException {
        // Test upper boundaries of A-
        Student student10 = new Student(10, 10, 20, 52);
        student10.calculate_grade();
        assertEquals("A-", student10.getGrade(), "There is an error in the upper boundary of A- grade");
        assertEquals(3.7, student10.getGpa(), "There is an error in the upper boundary of GPA 3.7");
    }

    @Test
    void sum_student_data4() throws IllegalArgumentException {
        // Test upper boundaries of B+
        Student student12 = new Student(10, 10, 20, 48);
        student12.calculate_grade();
        assertEquals("B+", student12.getGrade(), "There is an error in the upper boundary of B+ grade");
        assertEquals(3.3, student12.getGpa(), "There is an error in the upper boundary of GPA 3.3");
    }

    @Test
    void Sum_student_data5() throws IllegalArgumentException {
        // Test upper boundaries of B
        Student student14 = new Student(10, 10, 20, 43);
        student14.calculate_grade();
        assertEquals("B", student14.getGrade(), "There is an error in the upper boundary of B grade");
        assertEquals(3, student14.getGpa(), "There is an error in the upper boundary of GPA 3");

    }

    @Test
    void Sum_student_data6() throws IllegalArgumentException {
        // Test upper boundaries of B-
        Student student16 = new Student(10, 10, 20, 39);
        student16.calculate_grade();
        assertEquals("B-", student16.getGrade(), "There is an error in the upper boundary of B- grade");
        assertEquals(2.7, student16.getGpa(), "There is an error in the upper boundary of GPA 2.7");

    }

    @Test
    void Sum_student_data7() throws IllegalArgumentException {
        // test upper boundaries of F
        Student student28 = new Student(10, 10, 20, 19);
        student28.calculate_grade();
        assertEquals("F", student28.getGrade(), "there is an error in upper boundary of F grade");
        assertEquals(0, student28.getGpa(), "there is an error in upper boundary of gpa 0");

    }

    @Test
    void Sum_student_data8() throws IllegalArgumentException {
        // Test upper boundaries of C+
        Student student18 = new Student(10, 10, 20, 35);
        student18.calculate_grade();
        assertEquals("C+", student18.getGrade(), "There is an error in the upper boundary of C+ grade");
        assertEquals(2.3, student18.getGpa(), "There is an error in the upper boundary of GPA 2.3");
    }

    @Test
    void Sum_student_data9() throws IllegalArgumentException {
        // Test upper boundaries of C
        Student student20 = new Student(10, 10, 20, 32);
        student20.calculate_grade();
        assertEquals("C", student20.getGrade(), "There is an error in the upper boundary of C grade");
        assertEquals(2, student20.getGpa(), "There is an error in the upper boundary of GPA 2");
    }

    @Test
    void Sum_student_data10() throws IllegalArgumentException {
        // Test upper boundaries of C-
        Student student22 = new Student(10, 10, 20, 29);
        student22.calculate_grade();
        assertEquals("C-", student22.getGrade(), "There is an error in the upper boundary of C- grade");
        assertEquals(1.7, student22.getGpa(), "There is an error in the upper boundary of GPA 1.7");
    }

    @Test
    void Sum_student_data11() throws IllegalArgumentException {
        // Test upper boundaries of D+
        Student student24 = new Student(10, 10, 20, 26);
        student24.calculate_grade();
        assertEquals("D+", student24.getGrade(), "There is an error in the upper boundary of D+ grade");
        assertEquals(1.3, student24.getGpa(), "There is an error in the upper boundary of GPA 1.3");
    }

    @Test
    void Sum_student_data12() throws IllegalArgumentException {
        // test upper boundaries of D
        Student student26 = new Student(10, 10, 20, 23);
        student26.calculate_grade();
        assertEquals("D", student26.getGrade(), "there is an error in upper boundary of D grade");
        assertEquals(1, student26.getGpa(), "there is an error in upper boundary of gpa 1");

    }

    @Test
    void Sum_student_data13() throws IllegalArgumentException {
        // test calculate grade with sum of negative marks
        Student student29 = new Student(-1, -1, -1, -1);
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> student29.calculate_grade());
        assertEquals(ExceptionConstants.student_Sum_grade, exception1.getMessage(),
                "there is an error at negative mark grade");
    }
    /*******************************Validate_Student_data*******************************/
    @Test
    void validate_student_data_invalidName() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("3BillGates", "1234567A", "8", "8", "18", "56");
        });
        assertEquals(ExceptionConstants.student_name_exception, exception.getMessage());
    }

    @Test
    void validate_student_data_InvalidCode() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "ABC123", "8", "8", "18", "56");
        });
        assertEquals(ExceptionConstants.student_code_exception, exception.getMessage());
    }

    @Test
    void validate_student_data_BlankActivitiesMark() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", " ", "8", "18", "56");
        });
        assertEquals(ExceptionConstants.student_activities_bounds_exception, exception.getMessage());
    }

    @Test
    void validate_student_data_BlankOralMark() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", " ", "18", "56");
        });
        assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception.getMessage());
    }

    @Test
    void validate_student_data_InvalidMidtermMark_String() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "8", "A", "56");
        });
        assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception.getMessage());
    }

    @Test
    void validate_student_data_InvalidFinalMark_String() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "8", "18", "BC");
        });
        assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception.getMessage());
    }

    @Test
    void validate_student_data_InvalidActivitiesMark() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "15", "9", "17", "56");
        });
        assertEquals(ExceptionConstants.student_activities_bounds_exception, exception.getMessage());
    }
    @Test
    void validate_student_data_InvalidOralMark() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "25", "17", "56");
        });
        assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception.getMessage());
    }
    @Test
    void validate_student_data_InvalidMidtermMark() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "8", "-9", "56");
        });
        assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception.getMessage());
    }
    @Test
    void validate_student_data_InvalidFinalMark() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "8", "15", "-60");
        });
        assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception.getMessage());
    }
    @Test
    void validate_student_data_Valid() throws IllegalArgumentException {
        // Test invalid name
        student.validate_student_data("Bill Gates", "1234567A", "8", "8", "15", "56");
        assertEquals("Bill Gates", student.getStudent_name());
        assertEquals("1234567A", student.getStudent_number());
        assertEquals(8, student.getStudent_activities_mark());
        assertEquals(8, student.getStudent_oralPractical_mark());
        assertEquals(15, student.getStudent_midtermExam_mark());
        assertEquals(56, student.getStudent_finalExam_mark());
    }
}