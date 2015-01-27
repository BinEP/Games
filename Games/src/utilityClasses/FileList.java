package utilityClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileList {

	private String folderPath = "InfoFiles/";
	private String fileName;
	private String filePath;
	private ArrayList<String> wordList = new ArrayList<String>();
	
	public static void main(String[] args) {
		FileList runIt = new FileList();
		runIt.runFromMain();
	}

	public void runFromMain() {

	}

	public FileList(String fileName) {
		// TODO Auto-generated constructor stub
		
		if (fileName.indexOf('.') == -1) {
			
			fileName = fileName.concat(".txt");
		}
		
		this.fileName = fileName;
		this.filePath = folderPath + fileName;
		setFileList();
		
		
	}
	
	public FileList() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	
	public ArrayList<String> setFileList() {

		Scanner input;
		try {
			input = new Scanner(new File(filePath));
			while (input.hasNext()) {
				wordList.add(input.next());
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wordList;

	}
	
	public String[] get() {

	return getArray();
	}
	
	public String[] getArray() {

		
		String[] list = new String[wordList.size()];
		wordList.toArray(list);
		
		return list;
		}
	
	public ArrayList<String> getFileList() {

		return wordList;
		}

}
