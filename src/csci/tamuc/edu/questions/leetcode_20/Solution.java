package csci.tamuc.edu.questions.leetcode_20;

import java.util.Stack;

/**
 * @author ruby_
 * @create 2020-10-14-1:36 PM
 */

public class Solution {

    public boolean isValid(String s) {

        if(s == null || s.length() < 2) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
           if(c == '(' || c == '[' || c == '{') stack.push(c);
           else {
               if(stack.isEmpty()) return false;
               char p = stack.pop();

               if(c == ')' && p != '(') return false;
               if(c == ']' && p != '[') return false;
               if(c == '}' && p != '{') return false;
           }
        }

        return stack.isEmpty(); //" (){"
    }
}
