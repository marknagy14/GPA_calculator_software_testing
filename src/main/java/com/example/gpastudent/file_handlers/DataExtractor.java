package main.java.com.example.gpastudent.file_handlers;


import main.java.com.example.gpastudent.models.CourseModel;
import main.java.com.example.gpastudent.models.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtractor {
    private int count = 0;
    private String subjectName = "";
    private String subjectCode = "";
    private int fullmark = 0;
    private OutputCourseFile outputCourseFile;
    private String array[];
    Student s;

    /**
     * reads file line by line,The application input is a file. The application reads each line in this file as one string
     * where each of its fields are separated by comma “,”.
     * The first line of the file contains the subject name, subject-code and the full mark of that
     * subject where each of their fields are separated by comma “,”
     * Each of the following lines of that file (starting from line 2 to the end of file) should consists
     * of the following items Student name, Student number, Student Activities mark,
     * Oral/Practical mark, Midterm exam mark and Final exam mark
     *
     * @param line
     *
     * @return FileWriter -> output file with same name of course name
     * The output of this application is a file that contains in the first line of each page the
     * Following: “Subject Name:” subject-name “Max Mark:” full mark
     * The line after contains a head of the table which is:
     * Student name Student number GPA Grade
     * Each of the following lines contains the Student name, Student number, his GPA and
     * Grade separated by spaces.
     *
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public FileWriter extractData(String line) throws IOException,IllegalArgumentException {
        Pattern comma = Pattern.compile(",");
        Matcher matcher = comma.matcher(line);

        if (count == 0) { // check if this is the first line
            count++;
            int firstComma = line.indexOf(",");
            int secondComma = line.indexOf(",", firstComma + 1);
            subjectName = line.substring(0, firstComma);
            subjectCode = line.substring(firstComma + 1, secondComma);
            String full_mark_as_string= line.substring(secondComma + 1);
            //Extract the subject information
            new CourseModel().validate_subject_data(subjectName, subjectCode,full_mark_as_string);
            System.out.println("data for course entered is valid !");
            //create output file with same name of course name
            fullmark=Integer.parseInt(full_mark_as_string);
            outputCourseFile = new OutputCourseFile(subjectName);
            outputCourseFile.write_course_info_to_file(subjectName, fullmark);
            outputCourseFile.write_tuple_info_to_file();
        } else { //if not the first line
            int startIndex = 0; //index for commas found to extract data with matchers
            String StudentInfo = "";
            array = new String[6]; //first element is student name, second element is student code
            for (int i = 0; i < array.length - 1; i++) {
                if (matcher.find()) {
                    StudentInfo = line.substring(startIndex, matcher.start());
                    array[i] = StudentInfo;
                    startIndex = matcher.start() + 1;
                }
            }
            array[5] = line.substring(startIndex);
            s = new Student();
            s.validate_student_data(array[0], array[1], array[2], array[3], array[4], array[5]);
            System.out.println("data for student entered is valid !");
            s.calculate_grade();
            outputCourseFile.write_student_info_to_file(array[0], array[1], s.getGpa(), s.getGrade());
        }
        return outputCourseFile.writer;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getFullmark() {
        return fullmark;
    }

    public void setFullmark(int fullmark) {
        this.fullmark = fullmark;
    }

    public OutputCourseFile getOutputCourseFile() {
        return outputCourseFile;
    }

    public void setOutputCourseFile(OutputCourseFile outputCourseFile) {
        this.outputCourseFile = outputCourseFile;
    }

    public String getStudentName() {
        return array[0];
    }

    public String getStudentCode() {
        return array[1];
    }

    public String getStudentActivitiesMark() {
        return array[2];
    }

    public String getStudentOralMark() {
        return array[3];
    }

    public String getStudentMidtermMark() {
        return array[4];
    }

    public String getStudentFinalMark() {
        return array[5];
    }
}