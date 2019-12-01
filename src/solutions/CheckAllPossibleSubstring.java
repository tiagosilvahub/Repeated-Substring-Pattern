package src.solutions;

public class CheckAllPossibleSubstring implements Solution {
    @Override
    public boolean solve(String s) {
        int halfLength = s.length()/2 + 1;
        int length = s.length();
        for (int i = 1; i < halfLength; i++) {
            if( length % i == 0) {
                String substring1 = s.substring(0, i);
                int j = i;
                for (; j < length; j+=i ) {
                    String substring2 = s.substring(j, j+i);
                    if(!substring1.equals(substring2)) {
                        break;
                    }
                }
                if(j == length) {
                    return true;
                }
            }
        }
        return false;
    }
}
