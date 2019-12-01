package src.solutions;

public class BuildFromSubstring implements Solution {
    @Override
    public boolean solve(String s) {
        int halfLength = s.length()/2 + 1;
        int length = s.length();
        for (int i = 1; i < halfLength; i++) {
            if( length % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < length / i; j++) {
                    sb.append(substring);
                }
                if(sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean solveUsingRepeat(String s) {
        int halfLength = s.length()/2 + 1;
        int length = s.length();
        for (int i = 1; i < halfLength; i++) {
            if( length % i == 0) {
                if(s.substring(0, i).repeat(length / i).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
