package src;

import src.solutions.Solution;
import src.solutions.BuildFromSubstring;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] solutions =
                new Solution[]{
                        new BuildFromSubstring(),
                };

        // add test cases
        var input = new String[]{
                "abab", "abcabcabcabc", "aa","aaaaaaa","a", "baaaaa", "aaaaab","aba"
        };
        // add test case results
        var output = new boolean[]{
            true, true, true, true, false, false, false, false
        };

        // add the type of result here and in src.SolutionStrategy.java
        boolean result;

        int errors = 0;
        int nTestCases = input.length;
        for (Solution s : solutions) {
            for (int i = 0; i < nTestCases; i++) {
                // put input arguments into solution
                result = s.solve(input[i]);
                // implement equals if needed
                if( output[i] != result) {
                    System.out.println("Solution " + s.getClass().getName() + " wrong for input " + input[i]);
                    System.out.println("Expected: " + output[i] + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(nTestCases - errors + " tests passed.");
        }
        System.out.println(errors + " tests failed.");
        System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
    }
}

