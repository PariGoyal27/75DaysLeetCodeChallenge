class Pair{
    String word;
    int steps;
    Pair(String w, int s){
        word = w;
        steps = s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();
            if(word.equals(endWord)) return steps;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replaced = word.toCharArray();
                    replaced[i] = ch;
                    String rpWord = new String(replaced);
                    if(set.contains(rpWord)){
                        set.remove(rpWord);
                        q.offer(new Pair(rpWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}