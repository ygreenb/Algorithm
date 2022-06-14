package greedy;
/*
 * bj1931.java
 * 백준 1931번 : 회의실배정
 * version 1.0
 * data 2022.06.15
 */

import java.util.Arrays;
import java.util.Scanner;

public class bj1931 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // 회의의 수
		
		int[][] meetingtime  = new int[n][2]; // 회의 시작, 종료시간
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++)
				meetingtime[i][j] = s.nextInt();
		}
		
		Arrays.sort(meetingtime, (o1, o2) -> {
			if(o1[1]==o2[1]) {
//				return Integer.compare(o1[1],o2[1]);
				return o1[0]-o2[0];
			}else
				return o1[1]-o2[1];
		});
		
		// 정렬 확인
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<2;j++) {
//				System.out.print(meetingtime[i][j]+" ");	
//			}
//			System.out.println();
//		}
		
		int count = 1, current = meetingtime[0][1]; // 첫번쨰 회의 선택
		for(int i=1;i<n;i++) { // 2번쨰 회의부터 현재시간과 시작시간 비교
			// 현재시간과 같거나 이상인 회의를 선택
			if(current <= meetingtime[i][0]) {
				current = meetingtime[i][1]; // 종료시간 넣어줌
				count++;
//				System.out.println("("+meetingtime[i][0]+", " +meetingtime[i][1]+")");
			}
		}
		
		System.out.println(count);
		s.close();
	}

}
