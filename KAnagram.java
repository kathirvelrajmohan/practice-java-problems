/*Input              
    S1: grammar
    S2: anagram
    K = 3
Output
    True
*/

class KAnagram{
    public static void main(String args[]){
        // String s1 = "grammar";
        // String s2 = "anagram";
        // int k = 3;
        String s1 = "leetcode";
        String s2 = "practice";
        int k = 5;
        System.out.println(isAnagramWithK(s1, s2, k));
        
    }
    static boolean isAnagramWithK(String s1, String s2, int k){
        if(s1.length() != s2.length()) return false;
        int count = 0;
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            count += Math.abs(s1Freq[i] - s2Freq[i]);
        }

        if(count/2 <= k) return true;
        return false;
    }
}