class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] splitedWord1 = word1.toCharArray();
        char[] splitedWord2 = word2.toCharArray();
        char[] result = new char[word1.length()+word2.length()];
        
        int idx=0;
        for(int i=0; i<word1.length() || i<word2.length(); i++){
            if(i<word1.length()){
                result[idx++] = splitedWord1[i];
            }
            if(i<word2.length()){
                result[idx++] = splitedWord2[i];
            }
        }
        
        return new String(result);
    }
}