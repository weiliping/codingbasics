package com.algorithm.contest.weeklycontest296;

public class TextEditor {
    public static void main(String[] args) {
        // TextEditor textEditor = new TextEditor();
        // textEditor.addText("leetcode");
        // System.out.println(textEditor.deleteText(4));
        // textEditor.addText("practice");
        // System.out.println(textEditor.cursorRight(3));
        // System.out.println(textEditor.cursorLeft(8));
        // System.out.println(textEditor.deleteText(10));
        // System.out.println(textEditor.cursorLeft(2));
        // System.out.println(textEditor.cursorRight(6));
        TextEditor textEditor = new TextEditor();
        System.out.println(textEditor.deleteText(9));
        System.out.println(textEditor.cursorLeft(14));
        textEditor.addText("mjzxkemqyvfrg");
        System.out.println(textEditor.cursorLeft(5));

        textEditor.addText("svvyobqebssp");
        textEditor.addText("xkoznsq");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(15));
        textEditor.addText("irgkilfitjuysfgu");

        System.out.println(textEditor.cursorLeft(18));
        textEditor.addText("aanfokhwqqjf");
        System.out.println(textEditor.cursorLeft(18));
        System.out.println(textEditor.deleteText(7));
        textEditor.addText("kjekmkypfqvbsyigry");
        textEditor.addText("opkmggjoxng");
        System.out.println(textEditor.cursorRight(18));
    }

    int cursor;
    int len;
    int arrayLen;
    Character[] chrs;

    public TextEditor() {
        chrs = new Character[100];
        arrayLen = 100;
        len = 0;
        cursor = 0;
    }

    public void addText(String text) {
        if (text == null || text.length() == 0) {
            return;
        }
        int textLen = text.length();
        int newLen = len + textLen;
        char[] textChrs = text.toCharArray();
        if (newLen > arrayLen) {
            int nLen = arrayLen << 1;
            while (nLen < newLen) {
                nLen = nLen << 1;
            }
            Character[] temp = new Character[nLen];
            if (cursor != 0) {
                System.arraycopy(chrs, 0, temp, 0, cursor - 1);
            }
            int tmpInd = cursor;
            for (char c : textChrs) {
                temp[cursor++] = c;
            }
            int n = chrs.length, j = cursor;
            while (tmpInd < n) {
                temp[j++] = chrs[tmpInd++];
            }
            arrayLen = nLen;
            chrs = temp;
        } else {
            if (cursor < len) {
                for (int i = len; i >= cursor; i--) {
                    chrs[i + textLen] = chrs[i];
                }
            }
            for (char c : textChrs) {
                chrs[cursor++] = c;
            }
        }
        print();
        len = newLen;
    }

    public int deleteText(int k) {
        if (cursor >= k) {
            for (int i = cursor - k; i < cursor; i++) {
                if (i + k < len) {
                    chrs[i] = chrs[i + k];
                } else {
                    chrs[i] = null;
                }
            }
            len -= k;
            cursor -= k;
            return k;
        }

        for (int i = cursor; i < len; i++) {
            chrs[i - cursor] = chrs[i];
        }
        for (int i = len - cursor; i < len; i++) {
            chrs[i] = null;
        }
        len -= cursor;
        int res = cursor;
        cursor = 0;
        print();
        return res;
    }

    public String cursorLeft(int k) {
        if (cursor >= k) {
            cursor -= k;
        } else {
            cursor = 0;
        }

        if (cursor == 0) {
            print();
            return "";
        }
        int len = Math.min(10, cursor);
        StringBuilder sb = new StringBuilder();
        for (int i = cursor - len; i < cursor; i++) {
            sb.append(chrs[i]);
        }
        print();
        return sb.toString();
    }

    public String cursorRight(int k) {
        if (cursor + k >= len) {
            cursor = len;
        } else {
            cursor += k;
        }

        int len = Math.min(10, cursor);
        StringBuilder sb = new StringBuilder();
        for (int i = cursor - len; i < cursor; i++) {
            sb.append(chrs[i]);
        }
        print();
        return sb.toString();
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        for (Character c : chrs) {
            if (c != null) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
