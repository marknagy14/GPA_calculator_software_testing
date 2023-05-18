package main.java.com.example.gpastudent.Testing.CourseModel;

import main.java.com.example.gpastudent.constants.ExceptionConstants;
import main.java.com.example.gpastudent.models.CourseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseModelTest {
    private CourseModel model;
    private Exception exception;

    @BeforeEach
    void init(){
        model = new CourseModel();
        exception =  new Exception();
    }

    @Test
    public void path_test() {
        //path  1 2 4 5 8 10 11 13
        model.validate_subject_data("Software Testing", "CSE337", "100");
        assertEquals("Software Testing", model.getSubjectName());
        assertEquals("CSE337", model.getSubjectCode());
        assertEquals(100, model.getFullmark());

        //path  1 2 4 6 5 8 10 11 13
        model.validate_subject_data("Software Testing", "CSE337s", "100");
        assertEquals("Software Testing", model.getSubjectName());
        assertEquals("CSE337s", model.getSubjectCode());
        assertEquals(100, model.getFullmark());

        // Test path 1 3 13
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("12English Alevel", "CSE337s", "100"));
        assertEquals(ExceptionConstants.subject_name_exception, exception.getMessage());

        // Test path 1 2 4 7 13
        exception = assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("Software Testing", "CSE 337", "100"));
        assertEquals(ExceptionConstants.subject_code_exception, exception.getMessage());

        // Test path  1 2 4 5 8 9 13
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("Software Testing", "CSE337", "sss"));
        assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());

        // Test path 1 2 4 5 8 10 12 9 13
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> model.validate_subject_data("Software Testing", "CSE337", "80"));
        assertEquals(ExceptionConstants.subject_fullmark_exception, exception.getMessage());
    }

}