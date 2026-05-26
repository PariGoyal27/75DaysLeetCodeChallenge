class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n == 1) return true;

        // capital can only be at first or all letters
        boolean capital = false, small = false;
        // first two letter will decide it's nature
        if(Character.isLowerCase(word.charAt(0)) || Character.isLowerCase(word.charAt(1))) 
            small = true;
        else
            capital = true;

        for(int i = 1; i < word.length(); i++){
            char ch = word.charAt(i);
            if(small && Character.isUpperCase(ch))
                return false;
            
            if(capital && Character.isLowerCase(ch))
                return false;
        }
        return true;
    }
}