package com.javalec.localdatetimeex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		// A. 날짜와 시간 설정		
		LocalDateTime basedatetime = LocalDateTime.of(2018, 8, 15, 9, 30);		
		//     날짜와 시간 출력
		System.out.println("A 답 : " + basedatetime);
		
		// B. A에 2개월 3일 추가
		LocalDateTime afterbasedatetime = basedatetime.plusMonths(2).plusDays(3); 
		//    추가된 날짜와 시간 출력
		System.out.println("B 답 : " + afterbasedatetime);
		
		// C. 날짜와 시간 포멧 설정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
		
		String formatDatetime = afterbasedatetime.format(formatter);
		//    포멧된 날짜와 시간 출력
		System.out.println("C 답 : " + formatDatetime);
		
	}
	
}
