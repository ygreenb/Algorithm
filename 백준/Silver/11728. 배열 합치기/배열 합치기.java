import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = parseInputArray(br.readLine());
    int a = input[0];
    int b = input[1];

    int[] arrA = parseInputArray(br.readLine());
    int[] arrB = parseInputArray(br.readLine());

    int result[] = mergeArrays(a, b, arrA, arrB);
    System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
  }

  // 입력을 한 줄에 받아 정수 배열로 변환하는 작업을 수행하는 메소드
  private static int[] parseInputArray(String input) {
    return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  private static int[] mergeArrays(int a, int b, int[] arrA, int[] arrB) {
    int[] result = new int[a + b];

    int i = 0, j = 0, k = 0;

    while (i < a && j < b) {
      if (arrA[i] < arrB[j]) {
        result[k++] = arrA[i++];
      } else {
        result[k++] = arrB[j++];
      }
    }

    while (i < a) {
      result[k++] = arrA[i++];
    }

    while (j < b) {
      result[k++] = arrB[j++];
    }

    return result;
  }
}
