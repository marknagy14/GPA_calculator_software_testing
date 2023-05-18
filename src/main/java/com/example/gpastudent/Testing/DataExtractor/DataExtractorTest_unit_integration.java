package main.java.com.example.gpastudent.Testing.DataExtractor;

import main.java.com.example.gpastudent.constants.ExceptionConstants;
import main.java.com.example.gpastudent.file_handlers.DataExtractor;
import main.java.com.example.gpastudent.models.CourseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;




public class DataExtractorTest_unit_integration {
    private DataExtractor dataExtractor;
    private CourseModel model;

    @BeforeEach
    public void init() {
        dataExtractor = new DataExtractor();
        model = new CourseModel();
    }

    @Test //Test to check if extracted data of subject in first line like expected
    public void  testExtractDataOfSubject() throws IOException {
        dataExtractor.extractData("English Alevel,ESH100,100");
        String actual_Subject_name = dataExtractor.getSubjectName();
        String actual_Subject_code = dataExtractor.getSubjectCode();
        int actual_Subject_mark = dataExtractor.getFullmark();

        assertEquals("English Alevel",actual_Subject_name);
        assertEquals("ESH100",actual_Subject_code);
        assertEquals(100,actual_Subject_mark);
    }


    @Test //Test to check if extracted data of student in second line like expected
    public void  testExtractDataOfStudent() throws IOException {
        dataExtractor.extractData("English Alevel,ESH100,100");
        dataExtractor.extractData("Ahmed abd el megied,1900725A,10,8,20,60");
        String actual_Student_name = dataExtractor.getStudentName();
        String actual_Student_code = dataExtractor.getStudentCode();
        int actual_Student_Activities_mark = Integer.parseInt(dataExtractor.getStudentActivitiesMark());
        int actual_Student_OralPractical_mark = Integer.parseInt(dataExtractor.getStudentOralMark());
        int actual_Student_Midterm_exam_mark =Integer.parseInt(dataExtractor.getStudentMidtermMark());
        int actual_Student_Final_exam_mark = Integer.parseInt(dataExtractor.getStudentFinalMark());

        assertEquals("Ahmed abd el megied",actual_Student_name);
        assertEquals("1900725A",actual_Student_code);
        assertEquals(10,actual_Student_Activities_mark );
        assertEquals(8,actual_Student_OralPractical_mark );
        assertEquals(20,actual_Student_Midterm_exam_mark );
        assertEquals(60,actual_Student_Final_exam_mark );
    }

    /*
     * Function DataExtractor() extract data and return filewriter contains data extracted
     *Test to check that the extracted data is written to the output file and that the file is not null
     */
    @Test
    public void testExtractData() throws IOException {
        dataExtractor = new DataExtractor();
        String courseInfo = "Discrete Math,PHM202,100";
        String studentInfo1 = "John Kamel,1234567A,10,10,20,60";
        String studentInfo2 = "Jane white,1134567B,10,10,20,60";
        FileWriter fileWriter = dataExtractor.extractData(courseInfo);
        fileWriter = dataExtractor.extractData(studentInfo1);
        fileWriter = dataExtractor.extractData(studentInfo2);
        fileWriter.close();
        assertNotNull(fileWriter);
    }


    /*********************************Integration testing**********************************************/
    @Test
    public void testExtractRightSubject() throws IllegalArgumentException, IOException {/*extract validate setup */
        String courseInfo ="Electrical EngineeringA,EGE102,100";
        FileWriter fileWriter =dataExtractor.extractData(courseInfo);
        fileWriter.close();
        File file =new File (dataExtractor.getSubjectName());
        assertTrue(file.exists());
        // check if the content of the file is correct
        String expected = "Subject name: " + dataExtractor.getSubjectName() + "          " + "full mark: " +dataExtractor.getFullmark() + "\n\n" +
                String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA","grade") + "\n";
        StringBuilder actual = readFileToString(dataExtractor.getSubjectName());
        assertEquals(expected, actual.toString());

        /*Check that course info is valid and stored in file right */

    }

    @Test
    public void testExtractInvalidSubjectName() throws IllegalArgumentException, IOException {/*extract validate_course_inavlid setup */
        String courseInfo ="ElectricalEngineering,EGE102,100";

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class,
                () ->dataExtractor.extractData(courseInfo));
        assertEquals(ExceptionConstants.subject_name_exception, exception4.getMessage());
        assertNull(dataExtractor.getOutputCourseFile());

    }

    @Test
    public void testExtractInvalidSubjectCode() throws IllegalArgumentException, IOException {/*extract validate_course_inavlid setup */
        String courseInfo ="Computer Science,EGE10,100";

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class,
                () ->dataExtractor.extractData(courseInfo));
        assertEquals(ExceptionConstants.subject_code_exception, exception4.getMessage());
        assertNull(dataExtractor.getOutputCourseFile());

    }

    @Test
    public void testExtractInvalidSubjectFullMark() throws IllegalArgumentException, IOException {/*extract validate_course_inavlid setup */
        String courseInfo ="Control Engineering,EGE102,116";

        IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class,
                () ->dataExtractor.extractData(courseInfo));
        assertEquals(ExceptionConstants.subject_fullmark_exception, exception4.getMessage());
        assertNull(dataExtractor.getOutputCourseFile());

    }

    @Test
    public void testExtractValidSubjectandStudent() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_right calculate_garde setup/
            String st ="Electrical EngineeringC,EGE102,100";
        String st1 = "John Kamel,1234567A,10,10,20,60";
        FileWriter fileWriter =dataExtractor.extractData(st);
        fileWriter =dataExtractor.extractData(st1);
        fileWriter.close();
        File file =new File (dataExtractor.getSubjectName());
        assertTrue(file.exists());
        // check if the content of the file is correct
        String expected = "Subject name: " + dataExtractor.getSubjectName() + "          " + "full mark: " +dataExtractor.getFullmark() + "\n\n" +
                String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA","grade") + "\n"+String.format("%-40s %-40s %-40s %-40s", dataExtractor.getStudentName(), dataExtractor.getStudentCode() , dataExtractor.getS().getGpa(), dataExtractor.getS().getGrade()) + "\n";
        StringBuilder actual = readFileToString(dataExtractor.getSubjectName());
        assertEquals(expected, actual.toString());

    }

    @Test
    public void testExtractValidSubject_InvalidStudentFinalMark() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_invalid setup/
        String courseInfo ="Electrical EngineeringD,EGE102,100";
        String st1 = "John Kamel,12345678,10,10,20,62";

        // Test invalid final exam mark
        IllegalArgumentException exception6 =assertThrows(IllegalArgumentException.class, () -> {
            dataExtractor.extractData(courseInfo);
            dataExtractor.extractData(st1);
        });
        assertEquals(ExceptionConstants.student_final_exam_bounds_exception, exception6.getMessage());
        assertTrue(dataExtractor.getOutputCourseFile().getFile().length()==0);

    }

    @Test
    public void testExtractValidSubject_InvalidStudentName() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_invalid setup
        String courseInfo ="Electrical EngineeringD,EGE102,100";
        String st1 = "John3 Kamel,12345678,10,10,20,60";

        // Test invalid final exam mark
        IllegalArgumentException exception6 =assertThrows(IllegalArgumentException.class, () -> {
            dataExtractor.extractData(courseInfo);
            dataExtractor.extractData(st1);
        });
        assertEquals(ExceptionConstants.student_name_exception, exception6.getMessage());
        assertTrue(dataExtractor.getOutputCourseFile().getFile().length()==0);

    }


    @Test
    public void testExtractValidSubject_InvalidStudentCode() throws IllegalArgumentException, IOException { //extract validate_course_right validate_student_invalid setup/
        String courseInfo ="Electrical EngineeringD,EGE102,100";
        String st1 = "John Kamel,123456,10,10,20,60";

        // Test invalid final exam mark
        IllegalArgumentException exception6 =assertThrows(IllegalArgumentException.class, () -> {
            dataExtractor.extractData(courseInfo);
            dataExtractor.extractData(st1);
        });
        assertEquals(ExceptionConstants.student_code_exception, exception6.getMessage());
        assertTrue(dataExtractor.getOutputCourseFile().getFile().length()==0);

    }

    @Test
    public void testExtractValidSubject_InvalidStudentActivitiesMark() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_invalid setup/
        String courseInfo ="Electrical EngineeringD,EGE102,100";
        String st1 = "John Kamel,12345678,15,10,20,60";

        // Test invalid final exam mark
        IllegalArgumentException exception6 =assertThrows(IllegalArgumentException.class, () -> {
            dataExtractor.extractData(courseInfo);
            dataExtractor.extractData(st1);
        });
        assertEquals(ExceptionConstants.student_activities_bounds_exception, exception6.getMessage());
        assertTrue(dataExtractor.getOutputCourseFile().getFile().length()==0);

    }

    @Test
    public void testExtractValidSubject_InvalidStudentOralMark() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_invalid setup/
        String courseInfo ="Electrical EngineeringD,EGE102,100";
        String st1 = "John Kamel,12345678,10,10.5,20,60";

        // Test invalid final exam mark
        IllegalArgumentException exception6 =assertThrows(IllegalArgumentException.class, () -> {
            dataExtractor.extractData(courseInfo);
            dataExtractor.extractData(st1);
        });
        assertEquals(ExceptionConstants.student_oral_exam_bounds_exception, exception6.getMessage());
        assertTrue(dataExtractor.getOutputCourseFile().getFile().length()==0);

    }

    @Test
    public void testExtractValidSubject_InvalidStudentMidtermMark() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_invalid setup/
        String courseInfo ="Electrical EngineeringD,EGE102,100";
        String st1 = "John Kamel,12345678,10,10,-20,60";

        // Test invalid final exam mark
        IllegalArgumentException exception6 =assertThrows(IllegalArgumentException.class, () -> {
            dataExtractor.extractData(courseInfo);
            dataExtractor.extractData(st1);
        });
        assertEquals(ExceptionConstants.student_midterm_exam_bounds_exception, exception6.getMessage());
        assertTrue(dataExtractor.getOutputCourseFile().getFile().length()==0);

    }

    @Test
    public void testExtract_calculateGrade1() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_right calculate_garde setup/
            String st ="Electrical EngineeringC,EGE102,100";
        String st1 = "John Kamel,1234567A,10,10,20,60";
        FileWriter fileWriter =dataExtractor.extractData(st);
        fileWriter =dataExtractor.extractData(st1);
        fileWriter.close();
        File file =new File (dataExtractor.getSubjectName());
        assertTrue(file.exists());

        // check if the content of the file is correct
        String expected = "Subject name: " + dataExtractor.getSubjectName() + "          " + "full mark: " +dataExtractor.getFullmark() + "\n\n" +
                String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA","grade") + "\n"+String.format("%-40s %-40s %-40s %-40s", dataExtractor.getStudentName(), dataExtractor.getStudentCode() , dataExtractor.getS().getGpa(), dataExtractor.getS().getGrade()) + "\n";
        StringBuilder actual = readFileToString(dataExtractor.getSubjectName());
        assertEquals(expected, actual.toString());

        assertEquals(4, dataExtractor.getS().getGpa());
        assertEquals("A+",dataExtractor.getS().getGrade());
    }



    @Test
    public void testExtract_calculateGrade2() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_right calculate_garde setup/
            String st ="Electrical EngineeringC,EGE102,100";
        String st1 = "John Kamel,1234567A,9,7,16,55";
        FileWriter fileWriter =dataExtractor.extractData(st);
        fileWriter =dataExtractor.extractData(st1);
        fileWriter.close();
        File file =new File (dataExtractor.getSubjectName());
        assertTrue(file.exists());

        // check if the content of the file is correct
        String expected = "Subject name: " + dataExtractor.getSubjectName() + "          " + "full mark: " +dataExtractor.getFullmark() + "\n\n" +
                String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA","grade") + "\n"+String.format("%-40s %-40s %-40s %-40s", dataExtractor.getStudentName(), dataExtractor.getStudentCode() , dataExtractor.getS().getGpa(), dataExtractor.getS().getGrade()) + "\n";
        StringBuilder actual = readFileToString(dataExtractor.getSubjectName());
        assertEquals(expected, actual.toString());

        assertEquals(3.3, dataExtractor.getS().getGpa());
        assertEquals("B+",dataExtractor.getS().getGrade());
    }

    @Test
    public void testExtract_calculateGrade3() throws IllegalArgumentException, IOException {//extract validate_course_right validate_student_right calculate_garde setup/
            String st ="Electrical EngineeringC,EGE102,100";
        String st1 = "John Kamel,1234567A,6,8,13,47";
        FileWriter fileWriter =dataExtractor.extractData(st);
        fileWriter =dataExtractor.extractData(st1);
        fileWriter.close();
        File file =new File (dataExtractor.getSubjectName());
        assertTrue(file.exists());

        // check if the content of the file is correct
        String expected = "Subject name: " + dataExtractor.getSubjectName() + "          " + "full mark: " +dataExtractor.getFullmark() + "\n\n" +
                String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA","grade") + "\n"+String.format("%-40s %-40s %-40s %-40s", dataExtractor.getStudentName(), dataExtractor.getStudentCode() , dataExtractor.getS().getGpa(), dataExtractor.getS().getGrade()) + "\n";
        StringBuilder actual = readFileToString(dataExtractor.getSubjectName());
        assertEquals(expected, actual.toString());

        assertEquals(2.3, dataExtractor.getS().getGpa());
        assertEquals("C+",dataExtractor.getS().getGrade());
    }



    public static StringBuilder readFileToString(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        reader.close();
        return builder;
    }
}