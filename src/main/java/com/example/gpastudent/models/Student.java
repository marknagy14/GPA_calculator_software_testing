package main.java.com.example.gpastudent.models;


import main.java.com.example.gpastudent.constants.ExceptionConstants;

public class Student {

    private String student_name = "";
    private String student_number = "";
    private int student_activities_mark = 0;
    private int student_oralPractical_mark = 0;
    private int student_midtermExam_mark = 0;
    private int student_finalExam_mark = 0;
    private String grade = "";
    private double gpa = 0;

    public Student() {
    }

    public Student(int student_activities_mark, int student_oralPractical_mark, int student_midtermExam_mark, int student_finalExam_mark) {
        this.student_activities_mark = student_activities_mark;
        this.student_oralPractical_mark = student_oralPractical_mark;
        this.student_midtermExam_mark = student_midtermExam_mark;
        this.student_finalExam_mark = student_finalExam_mark;
    }

    /**
     * validates student data before storing in class variables
     * so if error exists we throw exception and do not store.
     * @param name
     * @param id
     * @param activities_mrk
     * @param oral_mrk
     * @param mid_mrk
     * @param final_mrk
     * @throws IllegalArgumentException
     */
    public void validate_student_data(String name, String id, String activities_mrk, String oral_mrk, String mid_mrk, String final_mrk) throws IllegalArgumentException {

        /* checking if student name is alphabetic containing spaces and does not start with space */
        if (!name.matches("[a-zA-Z ]+") || name.startsWith(" ") || !name.contains(" ")) {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_name_exception);
        } else {
            student_name = name;
        }

        /* checking if ID is alphanumeric of 8 chars according to requirements */
        int min_student_id_len=8;
        if (id.length() == min_student_id_len &&
                id.substring(0, id.length() - 1).matches("\\d+") &&
                (id.substring(id.length() - 1).matches("\\d+") || Character.isLetter(id.charAt(id.length() - 1)))) {
            student_number = id;
        } else {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_code_exception);
        }

        /* checking if each mark is an integer and not blank using regex */
        if (!activities_mrk.matches("^[+-]?\\d+$")) {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_activities_bounds_exception);
        }
        if (!oral_mrk.matches("^[+-]?\\d+$")) {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_oral_exam_bounds_exception);
        }
        if ( !mid_mrk.matches("^[+-]?\\d+$")) {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_midterm_exam_bounds_exception);
        }
        if (!final_mrk.matches("^[+-]?\\d+$")) {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_final_exam_bounds_exception);
        }

        /* if check is ok, then assign them to variables */
        int activities_mrk_parsed = Integer.parseInt(activities_mrk);
        int oral_mrk_parsed = Integer.parseInt(oral_mrk);
        int mid_mrk_parsed = Integer.parseInt(mid_mrk);
        int final_mrk_parsed = Integer.parseInt(final_mrk);

        /* checking boundaries of marks */
        int max_activities_mark=10;
        int max_oral_mark=10;
        int max_mid_mark=20;
        int max_final_mark=60;

        if (activities_mrk_parsed >= 0 && activities_mrk_parsed <= max_activities_mark) {
            student_activities_mark = activities_mrk_parsed;

        } else {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_activities_bounds_exception);
        }


        if (oral_mrk_parsed >= 0 && oral_mrk_parsed <= max_oral_mark) {
            student_oralPractical_mark = oral_mrk_parsed;
        } else {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_oral_exam_bounds_exception);
        }

        if (mid_mrk_parsed >= 0 && mid_mrk_parsed <= max_mid_mark) {
            student_midtermExam_mark = mid_mrk_parsed;
        } else {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_midterm_exam_bounds_exception);
        }
        if (final_mrk_parsed >= 0 && final_mrk_parsed <= max_final_mark) {
            student_finalExam_mark = final_mrk_parsed;
        } else {
            System.out.println("error at student with name : "+name);
            throw new IllegalArgumentException(ExceptionConstants.student_final_exam_bounds_exception);
        }


    }

    /**
     * calculates student grade in letters according to total marks of the checked marks in
     * validate_student_data in same class and if mark does not fall within boundaries it throws exception
     * @throws IllegalArgumentException
     */
    public void calculate_grade() throws IllegalArgumentException{
        int sum = getSum();
        if (sum >= 97 && sum <= 100) {
            grade = "A+";
            gpa = 4;
        } else if (sum >= 93 && sum < 97) {
            grade = "A";
            gpa = 4;
        } else if (sum >= 89 && sum < 93) {
            grade = "A-";
            gpa = 3.7;
        } else if (sum >= 84 && sum < 89) {
            grade = "B+";
            gpa = 3.3;
        } else if (sum >= 80 && sum < 84) {
            grade = "B";
            gpa = 3;
        } else if (sum >= 76 && sum < 80) {
            grade = "B-";
            gpa = 2.7;
        } else if (sum >= 73 && sum < 76) {
            grade = "C+";
            gpa = 2.3;
        } else if (sum >= 70 && sum < 73) {
            grade = "C";
            gpa = 2;
        } else if (sum >= 67 && sum < 70) {
            grade = "C-";
            gpa = 1.7;
        } else if (sum >= 64 && sum < 67) {
            grade = "D+";
            gpa = 1.3;
        } else if (sum >= 60 && sum < 64) {
            grade = "D";
            gpa = 1;
        } else if(sum<60 && sum>=0){
            grade = "F";
            gpa = 0;
        }
        else{
            throw new IllegalArgumentException(ExceptionConstants.student_Sum_grade);
        }

    }

    private int getSum(){
        return student_activities_mark + student_oralPractical_mark + student_midtermExam_mark + student_finalExam_mark;
    }


    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getStudent_activities_mark() {
        return student_activities_mark;
    }

    public void setStudent_activities_mark(int student_activities_mark) {
        this.student_activities_mark = student_activities_mark;
    }

    public int getStudent_oralPractical_mark() {
        return student_oralPractical_mark;
    }

    public void setStudent_oralPractical_mark(int student_oralPractical_mark) {
        this.student_oralPractical_mark = student_oralPractical_mark;
    }

    public int getStudent_midtermExam_mark() {
        return student_midtermExam_mark;
    }

    public void setStudent_midtermExam_mark(int student_midtermExam_mark) {
        this.student_midtermExam_mark = student_midtermExam_mark;
    }

    public int getStudent_finalExam_mark() {
        return student_finalExam_mark;
    }

    public void setStudent_finalExam_mark(int student_finalExam_mark) {
        this.student_finalExam_mark = student_finalExam_mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}