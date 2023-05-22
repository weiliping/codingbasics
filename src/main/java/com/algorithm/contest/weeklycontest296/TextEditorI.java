package com.algorithm.contest.weeklycontest296;

public class TextEditorI {
    public static void main(String[] args) {
        TextEditorI textEditor = new TextEditorI();
        textEditor.addText("leetcode");
        System.out.println(textEditor.deleteText(4));
        textEditor.addText("practice");
        System.out.println(textEditor.cursorRight(3));
        System.out.println(textEditor.cursorLeft(8));
        System.out.println(textEditor.deleteText(10));
        System.out.println(textEditor.cursorLeft(2));
        System.out.println(textEditor.cursorRight(6));
    }

    LinkedNode cursor;

    public TextEditorI() {
        cursor = new LinkedNode('|');
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            cursor.add(c);
        }
    }

    public int deleteText(int k) {
        int i = k;
        for (; i > 0 && cursor.prev != null; i--) {
            cursor.prev.remove();
        }
        return k - i;
    }

    public String cursorLeft(int k) {
        for (; k > 0 && cursor.prev != null; k--) {
            cursor = cursor.prev;
        }
        return text();
    }

    public String cursorRight(int k) {
        for (; k > 0 && cursor.next != null; k--) {
            cursor = cursor.next;
        }
        return text();
    }

    public String text() {
        LinkedNode node = cursor;
        StringBuilder sb = new StringBuilder();
        for (int i = 10; i > 0 && node.prev != null; i--) {
            sb.append(node.prev.c);
            node = node.prev;
        }
        return sb.reverse().toString();
    }

    class LinkedNode {
        char c;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(char ch) {
            this.c = ch;
        }

        public void add(char c) {
            LinkedNode node = new LinkedNode(c);
            if (this.prev != null) {
                this.prev.next = node;
            }
            node.next = this;
            node.prev = this.prev;
            this.prev = node;
        }

        public void remove() {
            if (this.prev != null) {
                this.prev.next = this.next;
            }
            if (this.next != null) {
                this.next.prev = this.prev;
            }
        }
    }
}
