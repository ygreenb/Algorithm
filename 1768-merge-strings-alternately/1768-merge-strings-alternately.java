class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();

        if(length1<length2){
            for(int i=0;i<length1;i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word2.substring(length1, length2));
        }else if(length1>length2){
            for(int i=0;i<length2;i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(length2, length1));
        }else{
            for(int i=0;i<length1;i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();        

    }
}