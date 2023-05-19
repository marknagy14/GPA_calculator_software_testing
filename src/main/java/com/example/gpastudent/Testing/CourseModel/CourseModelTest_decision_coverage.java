package main.java.com.example.gpastudent.Testing.CourseModel;

import main.java.com.example.gpastudent.models.CourseModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class CourseModelTest_decision_coverage {

    @Test
    void testValidData1() {
        //Test Valid data with subjectID of 6 chracters
        CourseModel coursemodel = new CourseModel();
        coursemodel.validate_subject_data("English Al","ENG100","100");
        assertEquals("English Al", coursemodel.getSubjectName());
        assertEquals("ENG100", coursemodel.getSubjectCode());
        assertEquals(100, coursemodel.getFullmark());
    }

    @Test
    void testInvalidID() {
        CourseModel coursemodel = new CourseModel();
        assertThrows(IllegalArgumentException.class, () -> coursemodel.validate_subject_data("English","ABCDEFGH","100"));
    }

    @Test
    void testInvalidLabel() {
        CourseModel coursemodel = new CourseModel();
        assertThrows(IllegalArgumentException.class, () -> coursemodel.validate_subject_data("1234","ENG100","100"));
    }
    @Test
    void testInvalidMark() {
        CourseModel coursemodel = new CourseModel();
        assertThrows(IllegalArgumentException.class, () -> coursemodel.validate_subject_data("1234","ENG100","120"));
    }
    @Test
    void testValidData2() {
        //Test Valid data with subjectID of 7 chracters
        CourseModel coursemodel = new CourseModel();
        coursemodel.validate_subject_data("English Al","ENG100s","100");
        assertEquals("English Al", coursemodel.getSubjectName());
        assertEquals("ENG100s", coursemodel.getSubjectCode());
        assertEquals(100, coursemodel.getFullmark());
    }

}
