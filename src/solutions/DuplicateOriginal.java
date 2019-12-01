package src.solutions;

public class DuplicateOriginal implements Solution {
    @Override
    public boolean solve(String s) {
        return (s+s).substring(1, 2 * s.length() - 1 ).contains(s);
    }
}
