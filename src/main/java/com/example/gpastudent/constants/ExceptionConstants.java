package main.java.com.example.gpastudent.constants;

public class ExceptionConstants {
    // for courses
    public final static String subject_name_exception="subject name must be alphabetic characters and spaces.The name should not start with space";
    public final static String subject_code_exception="subject code must be 6-7 alphanumeric characters. The first 3 are alphabetic followed by 3 numeric characters. The sevens should be s if exists";
    public final static String subject_fullmark_exception="full mark is a numeric number of the value 100";

    //for student
    public final static String student_name_exception="student name must be alphabetic characters and Spaces. the name should not start with space";
    public final static String student_code_exception="the length of this field must be alphanumeric characters of exact length of 8 characters. it should start with numbers and might end with only one alphabetic character";
    public final static String student_activities_bounds_exception="student activities mark is an integer of a value from 0 up to 10 of the full mark";
    public final static String student_oral_exam_bounds_exception="oral/practical mark is an integer of a value from 0 up to 10 of the full mark";
    public final static String student_midterm_exam_bounds_exception="midterm exam mark is an integer of a value from 0 up to 20 of the full mark";
    public final static String student_final_exam_bounds_exception="final exam mark is an integer of a value from 0 up to 60 of the full mark";

    public final static String student_Sum_grade="sum of marks must be positive integer greater than or equal to 0 and less than or equal 100";

    //number format exception
    final static String mark_format_exception="enter a valid number format for marks";
}
