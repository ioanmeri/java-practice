package com.practice.basics;

public class ManipulatingText {
    public static void main(String[] args) {

        String s1 = """
                 a \
                 b \t
                 c \s
                 """;

        // 10 2
        System.out.println(s1.length()+" "+s1.split("\\n").length);


    }
}

// Thus, s1 contains: "a b \t\nc \s\n" i.e. a total of 10 characters.


/*
You need to remember the following points:
1. The opening delimiter of a text block includes a new line while the closing delimiter does not. Therefore, the given String starts with "a" and ends with "c \s\n".
2. A single trailing backslash at the end of any line in a text block instructs the compiler to NOT insert a new line. Threfore, there is no new line between a and b.
3. It is ok to include special characters in a text block using escape sequences. So, \t and \s include a single character each (tab and space) in the string.
4. Normally, all trailing white space at the end of a line in a text block is removed and a single new line character (ASCII LF) is inserted at the end of that line immediately after the last non-blank character. However, if you want to include white space characters at the end of a line, you can do so by specifying their escape sequences. Therefore, in the given text block, the second line has four characters, namely, b, space, tab, and new line, while the third line has c, space, space, and a new line. Note that if the second line did not have \t, then the second line would only contain b and new line. The trailing space would have been removed. Similarly, the third line would only contain c if there was no \s at the end.

 */
