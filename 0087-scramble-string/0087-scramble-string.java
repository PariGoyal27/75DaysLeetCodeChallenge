class Solution {
    HashMap<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals("") && s2.equals(""))
            return true;
        if (s1.equals(s2))
            return true;
        String temp = s1 + s2;
        if (map.containsKey(temp))
            return map.get(temp);
        int n = s1.length();
        boolean flag = false;
        for (int i = 1; i <= n - 1; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(n - i, n)) && isScramble(s1.substring(i, n), s2.substring(0, n - i))
                    || isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, n), s2.substring(i, n))) {
                flag = true;
                break;
            }
        }
        map.put(temp, flag);
        return flag;
    }
}