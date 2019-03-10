package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        Solution solution = g.new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int leftCount = n;
            int rightCount = n;
            generateParenthesis(sb, leftCount, rightCount, result);
            return result;
        }

        public void generateParenthesis(StringBuilder s,
                                        int leftBrackets,
                                        int rightBrackets,
                                        List<String> result) {
            if(leftBrackets == 0) {
                if(rightBrackets == 0) {
                    result.add(s.toString());
                    return;
                } else {
                    s.append(")");
                    generateParenthesis(s, leftBrackets, rightBrackets - 1, result);
                    s.deleteCharAt(s.length() - 1);
                }
            } else {
                s.append("(");
                generateParenthesis(s, leftBrackets - 1, rightBrackets, result);
                s.deleteCharAt(s.length() - 1);

                if(rightBrackets > leftBrackets) {
                    s.append(")");
                    generateParenthesis(s, leftBrackets, rightBrackets - 1, result);
                    s.deleteCharAt(s.length() - 1);
                }
            }
        }
    }
}
