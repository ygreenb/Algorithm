class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 두 문자열 길이의 최대공약수
        int endLen = gcd(str1.length(), str2.length());

        // 최대공약수 길이만큼 문자열잘라서 치환
        String gcdOfStr = str1.substring(0,endLen);

        if(str1.replace(gcdOfStr,"").equals("") && str2.replace(gcdOfStr,"").equals("")){
            return gcdOfStr;
        }

        return "";
    }

    // 유클리드 호제법
    public static int gcd(int p, int q){
        if(q==0) return p;
        else return gcd(q, p % q);
    }
}