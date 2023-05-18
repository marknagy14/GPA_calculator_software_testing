package main.java.com.example.gpastudent.Testing.CourseModel;

import main.java.com.example.gpastudent.constants.ExceptionConstants;
import main.java.com.example.gpastudent.models.CourseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class CourseModelTest_Unit {
    private CourseModel model;
    private Exception exception;

    @BeforeEach
    public void BeforeEachTest() {
        model = new CourseModel();
        exception = new Exception();
    }

    @Test
    public void testValidSubjectData() {
        // Test to validate subject data with valid input
        model.validate_subject_data("Software Testing", "CSE337s", "100");
        assertEquals("Software Testing", model.getSubjectName());
        assertEquals("CSE337s", model.getSubjectCode());
        assertEquals(100, model.getFullmark());
    }

    @Test
    public void testValidSubjectData1() {
        // Test to validate subject data with valid input
        model.validate_subject_data("Software Testing", "cse337s", "100");
        assertEquals("Software Testing", model.getSubjectName());
        assertEquals("cse337s", model.getSubjectCode());
        assertEquals(100, model.getFullmark());
    }

    @Test
    public void testInvalidSubjectName() {
        // Test to validate subject data with invalid subject name (numbers)
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("12English Alevel", "ENG101", "100"));
        Assertions.assertEquals(ExceptionConstants.subject_name_exception, exception.getMessage());

        // Test to validate subject data with invalid subject name starts with space
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data(" English Alevel", "ENG101", "100"));
        Assertions.assertEquals(ExceptionConstants.subject_name_exception, exception.getMessage());

        // Test to validate subject data with invalid subject name that has a special character
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("Eng#lish Alevel", "ENG101", "100"));
        assertEquals(ExceptionConstants.subject_name_exception, exception.getMessage());

        // Test to validate subject data with invalid subject name (not present)
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("", "ENG101", "100"));
        assertEquals(ExceptionConstants.subject_name_exception, exception.getMessage());

        // Test to validate subject data with invalid subject name that has only 1 name no spaces
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English", "ENG101", "100"));
        assertEquals(ExceptionConstants.subject_name_exception, exception.getMessage());
    }

    @Test
    public void testInvalidSubjectCode() {
        // Test to validate subject data with invalid subject code has a space in it
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG 123", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code less than 6 Alphanumeric characters
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "EN1", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code first 3 numeric characters followed by 3 Alphabetic characters
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "123ENG", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code more than 7 Alphanumeric characters
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENGD123s", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code with special character
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG12!", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code capital S instead of small s
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123S", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code all numeric characters
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "123123", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code all alphabetic characters
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENGENG", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code with 3 numeric characters and 3 alphabetic characters scattered
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "E1N2G3", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test to validate subject data with invalid subject code (not present)
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());
    }


    @Test
    public void testInvalidFullMark() {
        // Test to validate subject data with invalid full mark less than 100
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "50"));
        assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark negative mark
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "-100"));
        assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark more than 100
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "105"));
        Assertions.assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark with space
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "10 0"));
        Assertions.assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark (not present)
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", ""));
        Assertions.assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark (alphabetic characters)
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "ABC"));
        Assertions.assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark (100+alphabetic characters)
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "100A"));
        Assertions.assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test to validate subject data with invalid full mark (special characters)
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("English Alevel", "ENG123", "100#"));
        Assertions.assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());
    }

}