class Solution {
    public String generateTag(String caption) {
        int n = caption.length();
        StringBuilder sb = new StringBuilder();

        if(caption.charAt(0) != '#') sb.append('#');

        boolean isStart = false;
        boolean foundFirst = false;
        for(int i = 0; i < n; i++){
            char ch = caption.charAt(i);
            if(ch == ' ' && foundFirst) {
                isStart = true;
                continue;
            }else if(ch == ' ') continue;
            if(isStart){
                sb.append(Character.toUpperCase(ch));
                isStart = false;
            }else{
                foundFirst = true;
                sb.append(Character.toLowerCase(ch));
            }
        }
        if(sb.length() > 100)
            sb.setLength(100);
        return sb.toString();
    }
}