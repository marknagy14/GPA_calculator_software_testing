package main.java.com.example.gpastudent.Testing.OutputCourseFile;

import main.java.com.example.gpastudent.file_handlers.OutputCourseFile;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class OutputCourseFileTest_unit {

    /*
     * Test to check that the data written to the output file like the expected to be written
     */

    @Test
    public void testWriteCourseInfoToFile() throws IOException {
        OutputCourseFile outputCourseFile = new OutputCourseFile("Test Course Info");

        String subjectName = "English Alevel";
        int fullMark = 100;

        // write the course information to file
        outputCourseFile.write_course_info_to_file(subjectName, fullMark);
        outputCourseFile.getWriter().flush();

        // check if the file has been created
        File file = new File("Test Course Info");
        assertTrue(file.exists());


        // check if the content of the file is correct
        String expected = "Subject name: " + subjectName + "          " + "full mark: " + fullMark + "\n\n";
        StringBuilder actual = readFileToString("Test Course Info");
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testWriteTupleInfoToFile() throws IOException {
        OutputCourseFile outputCourseFile = new OutputCourseFile("Test Tuple Info");

        // write the tuple information to file
        outputCourseFile.write_tuple_info_to_file();
        outputCourseFile.getWriter().flush();

        // check if the file has been created
        File file = new File("Test Tuple Info");
        assertTrue(file.exists());

        // check if the content of the file is correct
        String expected = String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA","grade") + "\n";
        StringBuilder actual = readFileToString("Test Tuple Info");
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testWriteStudentInfoToFile() throws IOException {
        OutputCourseFile outputCourseFile = new OutputCourseFile("Test Student Info");

        String Student_Name = "Mohamed ahmad shaker";
        String Student_Number = "1900722";
        double GPA = 4.0;
        String Grade = "A+";

        // write the student information to file
        outputCourseFile.write_student_info_to_file(Student_Name, Student_Number , GPA, Grade);
        outputCourseFile.getWriter().flush();

        // check if the file has been created
        File file = new File("Test Student Info");
        assertTrue(file.exists());

        // check if the content of the file is correct
        String expected = String.format("%-40s %-40s %-40s %-40s", Student_Name, Student_Number , GPA, Grade) + "\n";
        StringBuilder actual = readFileToString("Test Student Info");
        assertEquals(expected, actual.toString());
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