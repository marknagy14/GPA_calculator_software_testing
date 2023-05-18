package main.java.com.example.gpastudent.file_handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputCourseFile {
    String fileName = "";// Set the filename
    File file; // Create a new file object
    FileWriter writer;

    public OutputCourseFile(String name) throws IOException {
        fileName = name;
        file = new File(name);
        writer = new FileWriter(file);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public void write_course_info_to_file(String subjectName, int fullMark) throws IOException {
        writer.write("Subject name: " + subjectName);
        writer.write("          "); //print 10 spaces
        writer.write("full mark: " + fullMark);

        writer.write("\n");
        writer.write("\n");
        //System.out.println("words written successfuly");
    }

    public void write_tuple_info_to_file() throws IOException {
        String headers = String.format("%-40s %-40s %-40s %-40s", "Name", "ID", "GPA", "grade");
        writer.write(headers + "\n");

    }

    public void write_student_info_to_file(String name, String id, double gpa, String grade) throws IOException {
        String line = String.format("%-40s %-40s %-40s %-40s", name, id, gpa, grade);
        writer.write(line + "\n");


    }

    public FileWriter getWriter() {
        return writer;
    }
}