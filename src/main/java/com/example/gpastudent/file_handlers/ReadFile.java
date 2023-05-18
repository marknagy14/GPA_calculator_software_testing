package main.java.com.example.gpastudent.file_handlers;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;



public class ReadFile extends JFrame implements ActionListener {
	FileWriter fileWriter;
	JButton button;
	DataExtractor student;
	File file;

	private ArrayList<String> list = new ArrayList<String>();
	public ReadFile() {
		this.setDefaultCloseOperation(3);
		this.setLayout(new FlowLayout());
		this.setBounds(900, 400, 450, 300);
		this.button = new JButton("Select file");
		this.getButton().addActionListener(this);
		this.add(this.getButton());
		this.pack();
		this.setVisible(true);
		this.student = new DataExtractor();
	}

	public ArrayList<String> getArr() {
		return list;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getButton()) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int response = fileChooser.showOpenDialog((Component)null);
			file = fileChooser.getSelectedFile();
			BufferedReader br = null;
			if (response == 0) {
				try {
					br = new BufferedReader(new FileReader(getFile()));
				} catch (FileNotFoundException var8) {
					var8.printStackTrace();
				}

				try {
					String st;
					while((st = br.readLine()) != null) {
						fileWriter=student.extractData(st);
						list.add(st);
					}
					fileWriter.close();

				} catch (IOException var9) {
					var9.printStackTrace();
				}
			}
		}

	}

	public JButton getButton() {
		return button;
	}

	public File getFile() {
		return file;
	}

}