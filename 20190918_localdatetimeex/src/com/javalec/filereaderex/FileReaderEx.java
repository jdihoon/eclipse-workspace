package com.javalec.filereaderex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	// D. main에서 throws 사용하여 예외처리
	public static void main(String[] args) throws IOException, FileNotFoundException {

		// A. BufferedReader와 FileReader 사용
		BufferedReader in = new BufferedReader(new FileReader("C:\\yesterday.txt"));
		
		// B. 실제 파일 포멧과 동일하게 출력
		String line;
		while( (line = in.readLine()) != null) {			
			// C. System.out 사용
			System.out.println(line);
		}		
		in.close();
	}
}
