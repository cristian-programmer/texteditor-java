package com.cua.textprocess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerFiles {
	private File file;
	private String path;
	private FileReader fileReader;
	private FileWriter fileWrite;
	private boolean isSave = false; 
	
	public ManagerFiles(String namefile){
		
		file = new File(namefile);
		this.path = namefile;
	}
	
	public ManagerFiles() {}
	
	public void setIsSave(boolean isSave) {this.isSave = isSave;}
	
	public boolean getIsSave() {return isSave;}
	
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void prepareReadFile() {
		try {
			fileReader = new FileReader(this.path);
		} catch (FileNotFoundException e) {
			System.out.println("Error to initialize read file:  " + e.getMessage());
			
		}
	}
	
	public void prepareWriteFile() {
		try {
			fileWrite = new FileWriter(this.path);
		} catch (Exception e) {
			System.out.println("Error to initialize write file:  " + e.getMessage());
		}
	}
	
	public void createFile(){
		try {
			 file.createNewFile();
			 
			 
		} catch (IOException e) {
			System.out.println("Error to create file:  " + e.getMessage());
		}		 
	}
	
	public void writeText(String content) {
		try {
			this.fileWrite.write(content);
		} catch (IOException e) {
			
			System.out.println("Error to write in the file:  " + e.getMessage());
		}
	}
	
	public ArrayList<String> readText() {

		ArrayList<String> readContent = new ArrayList<String>();
		int count = 0;
		try {
			int data = fileReader.read();
			
			while (data != -1) {
			
				readContent.add(String.valueOf((char)data));
				count = count +1;
				data = fileReader.read();
			}
			closeReadFile();
		} catch (IOException e) {
			
			System.out.println("Error to read file:  " + e.getMessage());
		}
		
		return readContent;
	}
	
	public void deleteFile() {
		this.file.delete();
	}
	
	public boolean existFile() {
		return file.exists();
	}
	
	public void closeWriteFile() {
		try {
			this.fileWrite.close();
		} catch (IOException e) {
			System.out.println("Error to close  file (for write):  " + e.getMessage());
		}
	}
	
	public void closeReadFile() {
		try {
			this.fileReader.close();
		} catch (IOException e) {
			System.out.println("Error to close  file (for read):  " + e.getMessage());
		}
	}	
}



