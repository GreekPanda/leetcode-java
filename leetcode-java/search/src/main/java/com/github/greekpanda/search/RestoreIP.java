package com.github.greekpanda.search;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses
 * 描述
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example: Given "25525511135" ,
 * return ["255.255.11.135", "255.255.111.35"] . (Order does not matter)
 *
 * @author GreekPanda
 * @version 1.0
 * @date 2020/8/29 15:08
 */
@Slf4j
public class RestoreIP {
    public static void main(String[] args) {
//        final String s = "1111";
        final String s = "25525511135";
        List<String> result = restoreIP(s);
        log.info(String.valueOf(result));
    }

    public static List<String> restoreIP(String s) {
        List<String> result = new ArrayList<>();
        List<String> ip = new ArrayList<>();
        dfs(s, ip, result, 0);

        return result;
    }

    private static void dfs(final String s, List<String> ip, List<String> result, int start) {
        if (ip.size() == 4 && start == s.length()) {
            result.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            return;
        }

        if (s.length() - start > (4 - ip.size()) * 3)
            return;
        if (s.length() - start < (4 - ip.size()))
            return;

        int num = 0;
        for (int i = start; i < start + 3 && i < s.length(); ++i) {
            num = num * 10 + (s.charAt(i) - '0');

            if (num < 0 || num > 255) {
                continue;
            }

            ip.add(s.substring(start, i + 1));
            dfs(s, ip, result, i + 1);
            ip.remove(ip.size() - 1);

            if (num == 0) {
                break;
            }
        }
    }

}
