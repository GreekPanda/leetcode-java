package com.github.greekpanda.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/11 08:06
 */
@Slf4j
public class ReversePolishNotation {
    private static final String OPS = "+-*/";

    public static void main(String[] args) {
        final String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        //log.info(String.valueOf(reversePolishNotation(tokens)));
        log.info(String.valueOf(evalRPNWithStack(tokens)));
    }

    public static int reversePolishNotation(final String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            throw new RuntimeException();
        }

        return evalRPN(tokens, tokens.length - 1);
    }

    private static boolean isOPS(final String op) {
        return op.length() == 1 || OPS.indexOf(op) != -1;
    }

    private static int evalRPN(final String[] tokens, int len) {
        if (len < 0)
            throw new RuntimeException();

        int x, y;
        final String token = tokens[len--];
        if (isOPS(token)) {
            y = evalRPN(tokens, len--);
            x = evalRPN(tokens, len--);

            switch (token.charAt(0)) {
                case '+':
                    x += y;
                    break;
                case '-':
                    x -= y;
                    break;
                case '*':
                    x *= y;
                    break;
                case '/':
                    x /= y;
                    break;
                default:
                    break;
            }
        } else {
            x = Integer.parseInt(token);
        }
        return x;
    }

    public static int reversePolishNotationWithStack(final String[] tokens) {
        if (tokens == null | tokens.length <= 0)
            throw new RuntimeException();

        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (isOPS(s)) {
                stack.push(s);
            } else {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());

                switch (s.charAt(0)) {
                    case '+':
                        x += y;
                        break;
                    case '-':
                        x -= y;
                        break;
                    case '*':
                        x *= y;
                        break;
                    case '/':
                        x /= y;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(x));
            }
        }
        return Integer.valueOf(stack.peek());
    }

    public static int evalRPNWithStack(String[] tokens) {
        Stack<String> s = new Stack<>();
        for (String token : tokens) {
            if (!isOPS(token)) {
                s.push(token);
            } else {
                if (!s.isEmpty()) {
                    int y = Integer.parseInt(s.pop());
                    int x = Integer.parseInt(s.pop());
                    switch (token.charAt(0)) {
                        case '+':
                            x += y;
                            break;
                        case '-':
                            x -= y;
                            break;
                        case '*':
                            x *= y;
                            break;
                        default:
                            x /= y;
                    }
                    s.push(String.valueOf(x));
                }
            }

        }
        if (!s.isEmpty())
            return Integer.parseInt(s.peek());
        else
            throw new RuntimeException();
    }
}
