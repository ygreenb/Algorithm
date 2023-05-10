# [Silver V] 배열 합치기 - 11728 

[문제 링크](https://www.acmicpc.net/problem/11728) 

### 성능 요약

메모리: 406372 KB, 시간: 1860 ms

### 분류

정렬, 두 포인터

### 문제 설명

<p>정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)</p>

<p>둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 10<sup>9</sup>보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.</p>

<hr>

###  설명
``` java
private static int[] parseInputArray(String input) {
    return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
}
```

`Arrays.stream(input.split(" "))`은 입력된 문자열 input을 공백을 기준으로 분할하여 문자열 배열로 만듭니다. 예를 들어, 입력된 문자열이 `"1 2 3 4 5"`라면, `split(" ")` 메서드에 의해 `"1", "2", "3", "4", "5"`와 같은 문자열로 분할됩니다.

`Arrays.stream`은 Stream 객체를 생성하여 배열 요소들을 처리할 수 있게 해줍니다. Stream은 Java 8에서 추가된 기능으로, 여러 가지 연산을 수행할 수 있는 데이터 처리 파이프라인을 구성할 수 있게 해줍니다.

`mapToInt(Integer::parseInt)`은 Stream의 각 요소에 대해 `Integer.parseInt`를 적용하여 문자열을 정수로 변환합니다. `Integer::parseInt`는 메서드 참조를 사용한 람다 표현식으로, 문자열을 정수로 변환하는 메서드입니다. 이를 통해 `"1", "2", "3", "4", "5"`와 같은 문자열이 정수형으로 변환됩니다.

`toArray()`는 Stream의 요소를 배열로 변환합니다. 정수로 변환된 요소들이 배열로 저장되며, 최종적으로 정수형 배열이 반환됩니다. 이를 통해 `"1 2 3 4 5"`와 같은 문자열이 `[1, 2, 3, 4, 5]`와 같은 정수형 배열로 변환됩니다.

따라서, `Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray()`는 공백을 기준으로 분할된 문자열을 정수로 변환하여 정수형 배열로 반환하는 코드입니다.


<br>

``` java
System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
```

`Arrays.toString(result)`는 배열 result의 요소들을 문자열로 변환하는데, 이 때 `[, ], ,`와 같은 문자들도 포함됩니다. `replaceAll("[\\[\\],]", "")`는 변환된 문자열에서 `[, ], ,`와 같은 문자들을 모두 제거하여 최종적으로 배열 요소들만 남겨둡니다.

예를 들어, result 배열이 `[1, 2, 3, 4, 5]`라면, `Arrays.toString(result)`는 `"[1, 2, 3, 4, 5]"` 문자열을 반환하고, `Arrays.toString(result).replaceAll("[\\[\\],]", "")`는 `"1 2 3 4 5"` 문자열을 반환합니다. 따라서 `System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""))`는 배열 요소를 공백으로 구분하여 출력하는 역할을 합니다.
