package greedy;
/*
 * bj1744.java
 * 백준 1744번 : 수 묶기
 * version 1.0
 * data 2022.06.16
 */

import java.util.Arrays;
import java.util.Scanner;

public class bj1744 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        long ans = 0;

        for (int i = 0; i < n ; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        ans = 0;
        // 0, 음수일 경우 처리
        for (; left < right ; left+=2) {
            if(arr[left] < 1 && arr[left+1] < 1){
               ans += arr[left] * arr[left+1];
            }else{
                break;
            }
        }

        // 양수일 경우 처리
        for (; right > 0; right-=2) {
            // 1과는 곱하지 않게 조건문 추가.
            if(arr[right] > 1 && arr[right-1] > 1){
                ans += arr[right] * arr[right-1];
            }else{
                break;
            }
        }
        
        System.out.println("left"+left+"right"+right);
        // 남은 값들은 더해주기
        for (; right >= left; right--) {
            ans += arr[right];
        }
        System.out.println(ans);
    }
}