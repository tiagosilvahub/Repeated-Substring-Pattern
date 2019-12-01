# Repeated-Substring-Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

https://leetcode.com/problems/repeated-substring-pattern/



Example 1:
```
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
```
Example 2:
```
Input: "aba"
Output: False
```
Example 3:
```
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
```

Solution 1, named BuildFromSubstring: for all possible substrings repeat the substring and then compare to the original string.

Possible substrings are sizes 1 to half the original string. In addition, we can skip all substring sizes that are not a divisor of the length of the original string (remainder == 0), because they will never satisfy the premise.

For example, for strings which the length is a prime number we only need to check for a substring of size 1, meaning a repeating first character like 'aaaaaaa'. 


Code
```
public boolean solve(String s) {
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
```

A simple optimization that becomes obvious, instead of building the entire string in a loop, compare substring by substring:



