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

Possible substrings are sizes 1 to half the original string, but only if the size of the substring is a divider of the length of the original string. For strings which the length is a prime number, the answer is always false unless they are always the same caracter.

for example:
```
Input: "abcabca"
Output: false
Explanation: Because the length of original string is a prime number, 7, there is no divider except 1, the only possible substring would be 'aaaaaaa'. 
```

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

