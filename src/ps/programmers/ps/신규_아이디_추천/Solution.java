package ps.programmers.ps.신규_아이디_추천;

import java.util.List;
import java.util.regex.Pattern;

class Solution {

    private final List<String> available = List.of("-", "_", ".");

    public String solution(String new_id) {
        new_id = step1(new_id);
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);
        return new_id;
    }

    private String step1(String word) {
        return word.toLowerCase();
    }

    public String step2(String word) {
        char[] charArray = word.toCharArray();

        for (int index = 0; index < charArray.length; index++) {
            String eachWord = String.valueOf(charArray[index]);
            if (!isAlphaOrAvailableWord(eachWord)) {
                charArray[index] = 'X';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (!(c == 'X')) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isAlphaOrAvailableWord(String alpha) {
        return Pattern.matches("^[0-9a-z]", alpha) || available.contains(alpha);
    }

    private String step3(String word) {
        String before = word;
        while (true) {
            word = before.replace("..", ".");
            if (word.equals(before)) {
                break;
            }
            before = word;
        }
        return word;
    }

    private String step4(String word) {
        if (word.startsWith(".")) {
            word = word.substring(1);
        }
        if (word.length() == 0) {
            return "";
        }
        if (word.length() == 1) {
            if (word.startsWith(".")) {
                return "";
            }
            if (word.isBlank()) {
                return "";
            }
            return word;
        }
        if (word.charAt(word.length() - 1) == '.') {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }

    private String step5(String word) {
        if (word.isEmpty()) {
            return word + "a";
        }
        return word;
    }

    private String step6(String word) {
        if (word.length() >= 16) {
            word = word.substring(0, 15);
            if (word.charAt(word.length() - 1) == '.') {
                word = word.substring(0, word.length() - 1);
                return word;
            }
            return word;
        }
        return word;
    }

    private String step7(String word) {
        if (word.length() <= 2) {
            while (word.length() <= 2) {
                String last = String.valueOf(word.charAt(word.length() - 1));
                word += last;
            }
            return word;
        }
        return word;
    }

    public static void main(String[] args) throws Exception {
        String word = "...!@BaT#*..y.abcdefghijklm";
        String word2 = "z-+.^.";
        String word3 = "=.+";
        String word4 = "123_.def";
        String word5 = "abcdefghijklmn.p";
        Solution solution = new Solution();
        System.out.println(solution.solution(word5));
    }
}
