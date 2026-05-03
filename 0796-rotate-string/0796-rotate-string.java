class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String mix = s + s;
        return mix.contains(goal);
    }
}