class Solution{
    public String sortVowels(String s){
        int n = s.length();

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> startIdx = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            startIdx.putIfAbsent(ch, i);
            if(isVowel(ch)) list.add(ch);
        }
        list.sort((a, b) ->{
            if(!freq.get(a).equals(freq.get(b))){
                return freq.get(b) - freq.get(a);
            }
            return startIdx.get(a) - startIdx.get(b);
        });
        int j = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                sb.setCharAt(i, list.get(j++));
            }
        }
        return sb.toString();
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}
// class Tuple{
//     char ch;
//     int freq, idx;
//     Tuple(char c, int f, int i){
//         ch = c;
//         freq = f;
//         idx = i;
//     }    
// }
// class Solution {
//     public String sortVowels(String s) {
//         int n = s.length();
//         int[] freq = new int[26];
//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < n; i++){
//             char ch = s.charAt(i);
//             if("aeiou".indexOf(ch) != -1){
//                 if(!map.containsKey(ch)) map.put(ch, i);
//                 freq[ch - 'a']++;
//             }
//         }
//         PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> {
//             if(a.freq != b.freq) return b.freq - a.freq;
//             return a.idx - b.idx;           
//         });
//         for(int i = 0; i < 26; i++){
//             if(freq[i] != 0){
//                 char ch = (char)(i + 'a');
//                 pq.offer(new Tuple(ch, freq[i], map.get(ch)));
//             }
//         }
//         StringBuilder helper = new StringBuilder();
//         while(!pq.isEmpty()){
//             char c = pq.peek().ch;
//             int fq = pq.peek().freq;
//             pq.poll();
//             for(int i = 0; i < fq; i++){
//                 helper.append(c);
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         int idx = 0;
//         for(int i = 0; i < n; i++){
//             char ch = s.charAt(i);
//             if("aeiou".indexOf(ch) != -1){ // is a vowel
//                 sb.append(helper.charAt(idx++));
//             }else{
//                 sb.append(ch);
//             }
//         }
//         return sb.toString();
//     }
// }