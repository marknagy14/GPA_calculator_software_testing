package main.java.com.example.gpastudent.models;

import main.java.com.example.gpastudent.constants.ExceptionConstants;

public class CourseModel {


    private String subjectName = "";
    private String subjectCode = "";
    private int fullmark = 0;



    /**
     * validates course data before storing in class variables
     * so if error exists we throw exception and do not store.
     *
     * @param subjectLabel
     * @param subjectId
     * @param fMark
     * @throws IllegalArgumentException
     */

    public void validate_subject_data(String subjectLabel, String subjectId, String fMark) throws IllegalArgumentException {

        /* checking that course name must be Alphabetic characters and Spaces. the name should not
        start with space*/
        if (!subjectLabel.matches("[a-zA-Z ]+") || subjectLabel.startsWith(" ") || !subjectLabel.contains(" ")) {
            throw new IllegalArgumentException(ExceptionConstants.subject_name_exception);
        } else {
            subjectName = subjectLabel;
        }

    /*  checking that course id must be 6-7 Alphanumeric characters. The first 3 are Alphabetic
    followed by 3 numeric characters. The sevens should be s if exists.
    */
        int course_id_len1 = 6;
        int course_id_len2 = 7;
        if (subjectId.length() == course_id_len1 &&
                subjectId.substring(0, 3).matches("[a-zA-Z]+") &&
                subjectId.substring(subjectId.length() - 3).matches("\\d+")) {
            subjectCode = subjectId;
        } else if (subjectId.length() == course_id_len2 &&
                subjectId.substring(0, 3).matches("[a-zA-Z]+") &&
                subjectId.substring(3, 6).matches("\\d+") &&
                subjectId.endsWith("s")) {
            subjectCode = subjectId;
        } else {
            throw new IllegalArgumentException(ExceptionConstants.subject_code_exception);
        }

        /* checking that full mark is a numeric number of the value: 100*/
        int required_full_mark = 100;
        if (!fMark.matches("^[+-]?\\d+$")) {
            throw new IllegalArgumentException(ExceptionConstants.subject_fullmark_exception);
        }
        if (Integer.parseInt(fMark) == required_full_mark) {
            fullmark = Integer.parseInt(fMark);
        } else {
            throw new IllegalArgumentException(ExceptionConstants.subject_fullmark_exception);
        }


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
}
