package ar.com.kriche;

/**
 *
 * Given an expression containing '(' or ')' determine if it is balanced.
 *
 * @author Kriche 2022
 *
 */
public class BalancedExpression {

    public static void main(String[] args) {

        String[] balancedExpressions = {
                                            null,
                                            "",
                                            "()",
                                            "()(())",
                                            "(())()",
                                            "((()))",
                                            "((()()(())))",
        };

        String[] unbalancedExpressions = {
                                            "(",
                                            ")",
                                            "()(()",
                                            "((())))",
                                            "(((()()(())))(",
        };

        for (String expression : balancedExpressions) {
            System.out.printf("\"%s\" is %sbalanced.\n", expression, isBalanced(expression) ? "" : "not ");
        }        
        System.out.println("--------------------------------------------------------------------");
        
        for (String expression : unbalancedExpressions) {
            System.out.printf("\"%s\" is %sbalanced.\n", expression, isBalanced(expression) ? "" : "not ");
        }
        System.out.println("--------------------------------------------------------------------");
        
    }

    private static boolean isBalanced(String expression) {

        if (expression == null) {
            return true;
        }

        int balance = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }

}
