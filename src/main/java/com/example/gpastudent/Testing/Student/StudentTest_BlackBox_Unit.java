package main.java.com.example.gpastudent.Testing.Student;

import main.java.com.example.gpastudent.constants.ExceptionConstants;
import main.java.com.example.gpastudent.models.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest_BlackBox_Unit {
    Exception exception;
    Student student;

    @BeforeEach
    void init()
    {
        student= new Student();
    }

    @Test
    void validate_student_data_is_wrong() throws IllegalArgumentException {
        // Test invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("123", "1234567A", "10", "9", "18", "56");
        });
        assertEquals(ExceptionConstants.student_name_exception, exception.getMessage());

        // Test invalid ID
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234", "10", "9", "18", "56");
        });
        assertEquals(ExceptionConstants.student_code_exception, exception.getMessage());

        // Test invalid ID
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "123456AA", "10", "9", "18", "56");
        });
        assertEquals(ExceptionConstants.student_code_exception, exception.getMessage());

        // Test invalid ID
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "A123456A", "10", "9", "18", "56");
        });
        assertEquals( ExceptionConstants.student_code_exception, exception.getMessage());

        // Test invalid ID
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "123A456A", "10", "9", "18", "56");
        });
        assertEquals(ExceptionConstants.student_code_exception, exception.getMessage());
    }


    @Test
    void validate_student_data_is_negative() throws IllegalArgumentException {

        /*******************************equivalence class partition negative part (below 0)************************************************/


        // Test negative activities mark
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "-1", "9", "18", "56");
        });
        assertEquals(ExceptionConstants.student_activities_bounds_exception, exception.getMessage());

        // Test negative oral mark activities mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "1", "-9", "18", "56");
        });
        assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception.getMessage());


        // Test negative midterm exam mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates ", "1234567A", "10", "9", "-7", "56");
        });
        assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception.getMessage());

        // Test negative final exam mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "9", "7", "-56");
        });
        assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception.getMessage());
    }


    @Test
    void validate_student_data_is_maxed() throws IllegalArgumentException {
        /*********************equivalence class partition, partition more than accepted value with two digits value***********************/
        // Test invalid activities mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "12", "10", "18", "56");
        });
        assertEquals(ExceptionConstants.student_activities_bounds_exception, exception.getMessage());


        // Test invalid oral/practical mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "11", "18", "56");
        });
        assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception.getMessage());

        // Test invalid midterm mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "9", "28", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception.getMessage());


        // Test invalid final exam mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "9", "18", "61");
        });
        assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception.getMessage());


        /*********************equivalence class partition, partition more than accepted value with three digits value***********************/

        // Test invalid activities mark
        exception= assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "122", "10", "18", "56");
        });
        assertEquals(ExceptionConstants.student_activities_bounds_exception, exception.getMessage());

        // Test invalid oral/practical mark
        IllegalArgumentException exception6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "111", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception6.getMessage());

        // Test invalid midterm mark
        IllegalArgumentException exception7 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "9", "288", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception7.getMessage());

        // Test invalid final exam mark
        IllegalArgumentException exception8 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "9", "18", "611");
        });
        Assertions.assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception8.getMessage());

    }

    @Test
    void validate_student_data_boundries() throws IllegalArgumentException {
        /*************************************upper boundries testing***************************************/
        // Test full mark
        Assertions.assertDoesNotThrow(() -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "10", "18", "60");
        });


        // Test activities mark +1
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "11", "10", "20", "60");
        });
        Assertions.assertEquals(ExceptionConstants.student_activities_bounds_exception, exception2.getMessage());

        // Test activities mark +1
        IllegalArgumentException exception3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "11", "20", "60");
        });
        Assertions.assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception3.getMessage());

        // Test activities mark +1
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "10", "21", "60");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception.getMessage());

        // Test activities mark +1
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "10", "10", "20", "61");
        });
        Assertions.assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception.getMessage());

        // Test full mark -1
        Assertions.assertDoesNotThrow(() -> {
            student.validate_student_data("Bill Gates", "1234567A", "9", "9", "19", "59");
        });

        /*************************************lower boundries testing***************************************/

        // Test zero mark
        Assertions.assertDoesNotThrow(() -> {
            student.validate_student_data("Bill Gates", "1234567A", "0", "0", "0", "0");
        });

        // Test zero mark +1
        Assertions.assertDoesNotThrow(() -> {
            student.validate_student_data("Bill Gates", "1234567A", "1", "1", "1", "1");
        });

        // Test zero mark -1
        IllegalArgumentException exception6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "-1", "0", "0", "0");
        });
        Assertions.assertEquals(ExceptionConstants.student_activities_bounds_exception, exception6.getMessage());
        // Test zero mark -1
        IllegalArgumentException exception7 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "0", "-1", "0", "0");
        });
        Assertions.assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception7.getMessage());

        // Test zero mark -1
        IllegalArgumentException exception8 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "0", "0", "-1", "0");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception8.getMessage());

        // Test zero mark -1
        IllegalArgumentException exception9 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "0", "0", "0", "-1");
        });
        Assertions.assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception9.getMessage());


    }

    @Test
    void validate_student_contain_space() throws IllegalArgumentException {
        // Test space before name
        IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data(" Bill Gates", "1234567A", "2", "10", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_name_exception, exception1.getMessage());

        // Test space before id
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", " 1234567A", "1", "9", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_code_exception, exception2.getMessage());

        // Test space inside id
        IllegalArgumentException exception3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "123 4567A", "1", "9", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_code_exception, exception3.getMessage());

        // Test space inside activities mark
        Exception exception4 = Assertions.assertThrows(Exception.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "1 ", "9", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_activities_bounds_exception, exception4.getMessage());

        // Test space inside Oral/Practical mark
        IllegalArgumentException exception5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "1", "9 ", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception5.getMessage());

        // Test space inside Midterm mark
        IllegalArgumentException exception6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "1", "9", "1 8", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception6.getMessage());

        // Test space inside final mark
        IllegalArgumentException exception7 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "1", "9", "18", "5 6");
        });
        Assertions.assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception7.getMessage());

    }

    @Test
    void validate_student_data_is_empty() throws IllegalArgumentException {

        // Test empty name
        IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("", "1234567A", "12", "10", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_name_exception, exception1.getMessage());

        // Test empty id
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "", "8", "10", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_code_exception, exception2.getMessage());

        // Test empty Activities mark
        IllegalArgumentException exception3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "", "10", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_activities_bounds_exception, exception3.getMessage());

        // Test empty oral mark
        IllegalArgumentException exception4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception4.getMessage());

        // Test empty midterm mark
        IllegalArgumentException exception5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "10", "", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception5.getMessage());


        // Test empty final mark
        IllegalArgumentException exception6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "10", "18", "");
        });
        Assertions.assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception6.getMessage());
    }
    @Test
    void validate_student_data_is_float() throws IllegalArgumentException {

        // Test float Activities mark
        IllegalArgumentException exception1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8.3", "10", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_activities_bounds_exception, exception1.getMessage());

        // Test float oral mark
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "8.3", "18", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception2.getMessage());

        // Test float midterm mark
        IllegalArgumentException exception3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "10", "18.3", "56");
        });
        Assertions.assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception3.getMessage());


        // Test float final mark
        IllegalArgumentException exception4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.validate_student_data("Bill Gates", "1234567A", "8", "10", "18", "50.3");
        });
        Assertions.assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception4.getMessage());

    }

    @Test
    public void testValidInputs() {

        try {
            student.validate_student_data("Bill Gates", "12345678", "8", "7", "18", "55");

            assertEquals("Bill Gates", student.getStudent_name());
            assertEquals("12345678", student.getStudent_number());
            assertEquals(8, student.getStudent_activities_mark());
            assertEquals(7, student.getStudent_oralPractical_mark());
            assertEquals(18, student.getStudent_midtermExam_mark());
            assertEquals(55, student.getStudent_finalExam_mark());
        } catch (IllegalArgumentException e) {
            fail("An exception should not be thrown for valid input.");
        }
    }

    @Test
    void calculate_grade_test() {

        /***********************************boundaries testing******************************************/
        //test calculate grade with full mark(upper boundries)
        Student student1 = new Student(10,10,20,60);
        student1.calculate_grade();
        assertEquals(4, student1.getGpa(),"there is an error at full mark grade");
        assertEquals("A+", student1.getGrade(),"there is an error at full mark grade");

        //test calculate grade with full mark-1(upper boundries)
        Student student2 = new Student(10,10,20,59);
        student2.calculate_grade();
        assertEquals(4, student2.getGpa(),"there is an error at full mark grade");
        assertEquals("A+", student2.getGrade(),"there is an error at full mark grade");

        //test calculate grade with full mark+1(upper boundries)
        Student student3 = new Student(10,10,20,61);
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> student3.calculate_grade());
        assertEquals(ExceptionConstants.student_Sum_grade,exception3.getMessage(),"there is an error at upper bpundries mark grade");


        //test calculate grade with zero marks(lower boundries)
        Student student4 = new Student(0,0,0,0);
        student4.calculate_grade();
        assertEquals(0, student4.getGpa(),"there is an error at zero mark grade");
        assertEquals("F", student4.getGrade(),"there is an error at full mark grade");

        //test calculate grade with zero marks-1(lower boundries)
        Student student5 = new Student(0,0,0,-1);
        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> student5.calculate_grade());
        assertEquals(ExceptionConstants.student_Sum_grade,exception4.getMessage(),"there is an error at negative mark grade");

        //test calculate grade with zero marks+1(lower boundries)
        Student student6 = new Student(0,0,0,1);
        student6.calculate_grade();
        assertEquals(0, student6.getGpa(),"there is an error at zero mark grade");
        assertEquals("F", student6.getGrade(),"there is an error at full mark grade");


        // Test lower boundaries of A+
        Student student7 = new Student(10, 10, 20, 57);
        student7.calculate_grade();
        assertEquals("A+", student7.getGrade(), "There is an error in the lower boundary of A+ grade");
        assertEquals(4, student7.getGpa(), "There is an error in the lower boundary of GPA 4");

        // Test upper boundaries of A
        Student student8 = new Student(10, 10, 20, 56);
        student8.calculate_grade();
        assertEquals("A", student8.getGrade(), "There is an error in the upper boundary of A grade");
        assertEquals(4, student8.getGpa(), "There is an error in the upper boundary of GPA 4");

        // Test lower boundaries of A
        Student student9 = new Student(10, 10, 20, 53);
        student9.calculate_grade();
        assertEquals("A", student9.getGrade(), "There is an error in the lower boundary of A grade");
        assertEquals(4, student9.getGpa(), "There is an error in the lower boundary of GPA 4");

        // Test upper boundaries of A-
        Student student10 = new Student(10, 10, 20, 52);
        student10.calculate_grade();
        assertEquals("A-", student10.getGrade(), "There is an error in the upper boundary of A- grade");
        assertEquals(3.7, student10.getGpa(), "There is an error in the upper boundary of GPA 3.7");

        // Test lower boundaries of A-
        Student student11 = new Student(10, 10, 20, 49);
        student11.calculate_grade();
        assertEquals("A-", student11.getGrade(), "There is an error in the lower boundary of A- grade");
        assertEquals(3.7, student11.getGpa(), "There is an error in the lower boundary of GPA 3.7");

        // Test upper boundaries of B+
        Student student12 = new Student(10, 10, 20, 48);
        student12.calculate_grade();
        assertEquals("B+", student12.getGrade(), "There is an error in the upper boundary of B+ grade");
        assertEquals(3.3, student12.getGpa(), "There is an error in the upper boundary of GPA 3.3");

        // Test lower boundaries of B+
        Student student13 = new Student(10, 10, 20, 44);
        student13.calculate_grade();
        assertEquals("B+", student13.getGrade(), "There is an error in the lower boundary of B+ grade");
        assertEquals(3.3, student13.getGpa(), "There is an error in the lower boundary of GPA 3.3");

        // Test upper boundaries of B
        Student student14 = new Student(10, 10, 20, 43);
        student14.calculate_grade();
        assertEquals("B", student14.getGrade(), "There is an error in the upper boundary of B grade");
        assertEquals(3, student14.getGpa(), "There is an error in the upper boundary of GPA 3");

        // Test lower boundaries of B
        Student student15 = new Student(10, 10, 20, 40);
        student15.calculate_grade();
        assertEquals("B", student15.getGrade(), "There is an error in the lower boundary of B grade");
        assertEquals(3, student15.getGpa(), "There is an error in the lower boundary of GPA 3");


        // Test upper boundaries of B-
        Student student16 = new Student(10, 10, 20, 39);
        student16.calculate_grade();
        assertEquals("B-", student16.getGrade(), "There is an error in the upper boundary of B- grade");
        assertEquals(2.7, student16.getGpa(), "There is an error in the upper boundary of GPA 2.7");

        // Test lower boundaries of B-
        Student student17 = new Student(10, 10, 20, 36);
        student17.calculate_grade();
        assertEquals("B-", student17.getGrade(), "There is an error in the lower boundary of B- grade");
        assertEquals(2.7, student17.getGpa(), "There is an error in the lower boundary of GPA 2.7");

        // Test upper boundaries of C+
        Student student18 = new Student(10, 10, 20, 35);
        student18.calculate_grade();
        assertEquals("C+", student18.getGrade(), "There is an error in the upper boundary of C+ grade");
        assertEquals(2.3, student18.getGpa(), "There is an error in the upper boundary of GPA 2.3");

        // Test lower boundaries of C+
        Student student19 = new Student(10, 10, 20, 33);
        student19.calculate_grade();
        assertEquals("C+", student19.getGrade(), "There is an error in the lower boundary of C+ grade");
        assertEquals(2.3, student19.getGpa(), "There is an error in the lower boundary of GPA 2.3");

        // Test upper boundaries of C
        Student student20 = new Student(10, 10, 20, 32);
        student20.calculate_grade();
        assertEquals("C", student20.getGrade(), "There is an error in the upper boundary of C grade");
        assertEquals(2, student20.getGpa(), "There is an error in the upper boundary of GPA 2");

        //test lower boundaries of C
        Student student21 = new Student(10,10,20,30);
        student21.calculate_grade();
        assertEquals("C", student21.getGrade(), "there is an error in upper boundary of C grade");
        assertEquals(2, student21.getGpa(), "there is an error in upper boundary of gpa 2");

        // Test upper boundaries of C-
        Student student22 = new Student(10, 10, 20, 29);
        student22.calculate_grade();
        assertEquals("C-", student22.getGrade(), "There is an error in the upper boundary of C- grade");
        assertEquals(1.7, student22.getGpa(), "There is an error in the upper boundary of GPA 1.7");

        // Test lower boundaries of C-
        Student student23 = new Student(10, 10, 20, 27);
        student23.calculate_grade();
        assertEquals("C-", student23.getGrade(), "There is an error in the lower boundary of C- grade");
        assertEquals(1.7, student23.getGpa(), "There is an error in the lower boundary of GPA 1.7");

        // Test upper boundaries of D+
        Student student24 = new Student(10, 10, 20, 26);
        student24.calculate_grade();
        assertEquals("D+", student24.getGrade(), "There is an error in the upper boundary of D+ grade");
        assertEquals(1.3, student24.getGpa(), "There is an error in the upper boundary of GPA 1.3");

        // Test lower boundaries of D+
        Student student25 = new Student(10, 10, 20, 24);
        student25.calculate_grade();
        assertEquals("D+", student25.getGrade(), "There is an error in the lower boundary of D+ grade");
        assertEquals(1.3, student25.getGpa(), "There is an error in the lower boundary of GPA 1.3");

        //test upper boundaries of D
        Student student26 = new Student(10,10,20,23);
        student26.calculate_grade();
        assertEquals("D", student26.getGrade(), "there is an error in upper boundary of D grade");
        assertEquals(1, student26.getGpa(), "there is an error in upper boundary of gpa 1");

        //test lower boundaries of D
        Student student27 = new Student(10,10,20,20);
        student27.calculate_grade();
        assertEquals("D", student27.getGrade(), "there is an error in lower boundary of D grade");
        assertEquals(1, student27.getGpa(), "there is an error in lower boundary of gpa 1");

        //test upper boundaries of F
        Student student28 = new Student(10,10,20,19);
        student28.calculate_grade();
        assertEquals("F", student28.getGrade(), "there is an error in upper boundary of F grade");
        assertEquals(0, student28.getGpa(), "there is an error in upper boundary of gpa 0");

        /*********************equivalence class partition***********************/

        //test calculate grade with sum of negative marks
        Student student29 = new Student(-1,-1,-1,-1);
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> student29.calculate_grade());
        assertEquals(ExceptionConstants.student_Sum_grade,exception1.getMessage(),"there is an error at negative mark grade");


        //test grading is more than expected
        Student student30 = new Student(12,19,15,76);
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> student30.calculate_grade());
        assertEquals(ExceptionConstants.student_Sum_grade,exception2.getMessage(),"there is an error at more than 100 mark grade");

    }










    /******************************** white box testing: data flow testing*******************************/

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