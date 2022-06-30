package backtracking;
/*
 * bj1759.java
 * 백준 1759번 : 암호만들기
 * version 1.0
 * data 2022.06.23
 */

import java.util.Arrays;
import java.util.Scanner;

public class bj1759 {
	
	public static int L,C; // 암호길이, 문자 수
	public static char 
	alphabet[], code[]; // 가능성있는 암호
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		code = new char[L];
		alphabet = new char[C];
		for(int i=0;i<C;i++) {
			alphabet[i] = sc.next().charAt(0);
		}
		Arrays.sort(alphabet);
		
		makeCode(0,0);

		sc.close();
	}
	
	// GETNEXT() 재귀적으로 구현
	public static void makeCode(int start, int idx) {
		if(idx==L) {
			if(BOUND()) { // 모음 1 자음 2개 이상이면 출력
				System.out.println(code);
			}
			return;
		}
		for(int i=start;i<C;i++) {
			code[idx] = alphabet[i];
//			System.out.println(i+","+idx);
			makeCode(i+1, idx+1);
		}
	}

	// 암호가 모음 1 자음 2개 이상인지 검사하는 함수
	public static boolean BOUND() {
		int vowel = 0; //모음
		int consonant = 0; // 자음

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
            	vowel++;
            } else {
            	consonant++;
            }
        }
        
        if(vowel>=1&& consonant >=2) {
        	return true;
        }
        return false;
	}

}
