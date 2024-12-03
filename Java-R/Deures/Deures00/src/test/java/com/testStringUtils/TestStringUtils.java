package com.testStringUtils;

public class TestStringUtils {

    /**
     * Compare two strings and find the first position where they differ, displaying only the line of the difference.
     * @param str1 First string to compare.
     * @param str2 Second string to compare.
     * @return A string showing the lines with a marker at the first different character.
     */
    public static String findFirstDifference(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return getDifference(str1, str2, i);
            }
        }
        if (str1.length() != str2.length()) {
            return "Strings differ in length. Extra content in " + 
                   (str1.length() > str2.length() ? "received string at position " + length + "\n" : "expected string at position " + length + "\n");
        }
        
        return "identical";
    }

    private static String getDifference(String strReceived, String strExpected, int index) {
        int beginReceived = findBegin(strReceived, index);
        String previous = "";

        String lineReceived = strReceived.substring(findBegin(strReceived, index), findEndCut(strReceived, index));
        String lineExpected = strExpected.substring(findBegin(strExpected, index), findEndLine(strExpected, index));

        if (beginReceived > 0) {
            int previousLimit = 500;
            if (beginReceived > previousLimit) {
                int beginCut = findBegin(strReceived, beginReceived - (previousLimit - 1));
                previous += "Matching text:\n...\n";
                previous += strReceived.substring(beginCut, beginReceived) + "\n";
            } else {
                previous += "Matching text:\n";
                previous += strReceived.substring(0, beginReceived) + "\n";
            }
        }

        if (index < strReceived.length() && strReceived.charAt(index) == '\n') {
            lineReceived = lineReceived.replace("\n", "\\n");
        }

        if (index < strReceived.length() && strExpected.charAt(index) == '\n') {
            lineExpected = lineExpected.replace("\n", "\\n");
        }

        return  previous + 
                "First difference at position " + index + ".\n" +
                "Received: " + lineReceived + "<difference>\n" +
                "Expected: " + lineExpected + "\n";
    }

    private static int findBegin(String str, int index) {
        int begin = index;
        while (begin > 0 && str.charAt(begin - 1) != '\n') {
            begin--;
        }
        return begin;
    }

    private static int findEndCut(String str, int index) {
        int end = index + 1;
        if (end > str.length()) {
            end = str.length(); 
        }
        return end;
    }

    private static int findEndLine(String str, int index) {
        int end = index;
        while (end < str.length() && str.charAt(end) != '\n') {
            end++;
        }
        return end;
    }
}


