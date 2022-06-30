package backtracking;
/*
 * bj1759.java
 * ���� 1759�� : ��ȣ�����
 * version 1.0
 * data 2022.06.23
 */

import java.util.Arrays;
import java.util.Scanner;

public class bj1759 {
	
	public static int L,C; // ��ȣ����, ���� ��
	public static char 
	alphabet[], code[]; // ���ɼ��ִ� ��ȣ
	
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
	
	// GETNEXT() ��������� ����
	public static void makeCode(int start, int idx) {
		if(idx==L) {
			if(BOUND()) { // ���� 1 ���� 2�� �̻��̸� ���
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

	// ��ȣ�� ���� 1 ���� 2�� �̻����� �˻��ϴ� �Լ�
	public static boolean BOUND() {
		int vowel = 0; //����
		int consonant = 0; // ����

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
