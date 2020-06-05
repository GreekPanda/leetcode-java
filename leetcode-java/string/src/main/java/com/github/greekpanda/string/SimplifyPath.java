package com.github.greekpanda.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * Simplify Path
 * 描述
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/" , => "/home"
 * path = "/a/./b/../../c/" , => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../" ?
 * In this case, you should return "/" .
 * Another corner case is the path might contain multiple slashes '/' together, such as
 * "/home//foo/" .
 * In this case, you should ignore redundant slashes and return "/home/foo" .
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/6/5 08:40
 */
@Slf4j
public class SimplifyPath {
    public static void main(String[] args) {

        log.info(simplifyPath("/home/"));
        log.info(simplifyPath("/a/./b/../../c/"));
    }

    public static String simplifyPath(String path) {
        if (path.isEmpty())
            return null;

        Stack<String> dirs = new Stack<>();
        for (int i = 0; i < path.length(); ) {
            ++i;
            int j = path.indexOf('/', i);
            if (j < 0) j = path.length();
            final String dir = path.substring(i, j);
            // 当有连续 '///'时，dir 为空
            if (!dir.isEmpty() && !dir.equals(".")) {
                if (dir.equals("..")) {
                    if (!dirs.isEmpty())
                        dirs.pop();
                } else {
                    dirs.push(dir);
                }
            }
            i = j;
        }
        StringBuilder result = new StringBuilder();
        if (dirs.isEmpty()) {
            result.append('/');
        } else {
            for (final String dir : dirs) {
                result.append('/').append(dir);
            }
        }
        return result.toString();
    }

}
