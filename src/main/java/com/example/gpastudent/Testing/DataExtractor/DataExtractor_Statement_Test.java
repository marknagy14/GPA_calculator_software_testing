package main.java.com.example.gpastudent.Testing.DataExtractor;

import main.java.com.example.gpastudent.file_handlers.DataExtractor;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataExtractor_Statement_Test {
/***************** white box testing: statement coveraget*****************/
    @Test
    void extractData_statement_coverage1() throws IOException {
        DataExtractor dataExtractor = new DataExtractor();
        dataExtractor.setCount(0);
        dataExtractor.extractData("Electrical EngineeringD,EGE102,100");
        assertEquals("Electrical EngineeringD",dataExtractor.getSubjectName());
        assertEquals("EGE102",dataExtractor.getSubjectCode());
    }

    @Test
    void extractData_statement_coverage2() throws IOException {
        DataExtractor dataExtractor = new DataExtractor();
        String st ="Electrical EngineeringC,EGE102,100";
        dataExtractor.extractData(st);
        dataExtractor.setCount(1);
        dataExtractor.extractData("Ahmed abdo,19007250,10,10,20,60");
        assertEquals("Ahmed abdo",dataExtractor.getStudentName());
        assertEquals("19007250",dataExtractor.getStudentCode());
        assertEquals("10",dataExtractor.getStudentActivitiesMark());
        assertEquals("10",dataExtractor.getStudentOralMark());
        assertEquals("20",dataExtractor.getStudentMidtermMark());
        assertEquals("60",dataExtractor.getStudentFinalMark());
    }
}