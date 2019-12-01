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

First thoughts:

The substring cannot be bigger than half the original string.

The substring divides the original string in equal parts, meaning that it's length must be divisor of the length of the original.


Solution 1, named BuildFromSubstring: for all possible substrings repeat the substring and then compare to the original string.

Possible substrings are sizes 1 to half the original string. In addition, we can skip all substring sizes that are not a divisor of the length of the original string (remainder == 0), because they will never satisfy the premise.

For example, for strings which the length is a prime number we only need to check for a substring of size 1, meaning a repeating first character like 'aaaaaaa'. 

Implementation: 

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

If you cannot use String.repeat (because Leetcode uses java version 8) then use a loop of StringBuilder append :

```
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
```

A simple optimization that becomes obvious, instead of building the entire string in a loop we could stop earlier. 

Iterate over the original string comparing with the substring, if all positions match then we found an answer, but if just one doesn't match we can break and save time over the previous solution:

```
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
```

This answer saves a few milliseconds for a better result on Leetcode.

This one line solution is quite interesting, although it is neither faster not uses less space:
```
public boolean solve(String s) {
    return (s+s).substring(1, 2 * s.length() - 1 ).contains(s);
}
```

If you have a string that can be built by repeating a substring from it and you duplicate it, then you will be able to find the original string inside it:

Example:
```
Original: "abab"
Duplicated: "ab**abab**ab"
```

Explanation: Consider the original string S. If it has a substring s which repeated generates S, then we can say that S is:
```
S = ss
or 
S = sss
or 
S = ssss
...
```

For simplicity, let's only consider the case where the substring is half the length of the original: S = ss 

Then if we duplicate S we surely get: 
```
SS = ssss = sSs
```

And this holds true for any size of s:

```
S = ssss
SS = ssssssss = ssSss
```

If S is not a repeat substring then there are at least 2 different patterns in it, a and b (a!=b) and we can express S as:
```
S = ab
SS = abab 
```

