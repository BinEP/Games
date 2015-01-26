package utilityClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetFileContentList {

	private String folderPath = "InfoFiles/";
	private String fileName;
	private String filePath;
	private ArrayList<String> wordList = new ArrayList<String>();
	
	public static void main(String[] args) {
		GetFileContentList runIt = new GetFileContentList();
		runIt.runFromMain();
	}

	public void runFromMain() {

	}

	public GetFileContentList(String fileName) {
		// TODO Auto-generated constructor stub
		
		this.fileName = fileName;
		this.filePath = folderPath + fileName;
		setFileList();
		
		
	}
	
	public GetFileContentList() {
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
	
	public ArrayList<String> getFileList() {

	return wordList;
	}

}
