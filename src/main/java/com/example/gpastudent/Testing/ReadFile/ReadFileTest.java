package main.java.com.example.gpastudent.Testing.ReadFile;

import main.java.com.example.gpastudent.file_handlers.ReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;




class ReadFileTest {
    private ReadFile readFile;
    @BeforeEach

    public void setUp() throws Exception {
        readFile = new ReadFile();
    }

    @Test//(expected = FileNotFoundException.class)
    public void testFileNotFound() throws IOException {
        ActionEvent event = new ActionEvent(readFile.getButton(), ActionEvent.ACTION_PERFORMED, "Select XML File");
        readFile.actionPerformed(event);

        //Testing if file exists
        assertTrue(readFile.getFile().exists());

        //Test to check if read data of subject in first line like expected
        String actual_first_line =readFile.getArr().get(0);
        assertEquals("English Alevel,ESH100,100",actual_first_line);

        //Test to check if read data of student in second line like expected
        String actual_Second_line= readFile.getArr().get(1);
        assertEquals("Ahmed abd el megied,19007250,10,8,20,60",actual_Second_line );
    }
}