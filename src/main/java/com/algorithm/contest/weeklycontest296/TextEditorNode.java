package com.algorithm.contest.weeklycontest296;

public class TextEditorNode {
    public static void main(String[] args) {
        TextEditorNode textEditor = new TextEditorNode();
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

    Node root, cur;

    public TextEditorNode() {
        root = cur = new Node();
        root.prev = root;
        root.next = root;
    }

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++)
            cur = cur.insert(new Node(text.charAt(i)));
    }

    public int deleteText(int k) {
        int k0 = k;
        for (; k > 0 && cur != root; --k) {
            cur = cur.prev;
            cur.next.remove();
        }
        return k0 - k;
    }

    String text() {
        StringBuilder s = new StringBuilder();
        Node cur = this.cur;
        for (int k = 10; k > 0 && cur != root; --k) {
            s.append(cur.ch);
            cur = cur.prev;
        }
        return s.reverse().toString();
    }

    public String cursorLeft(int k) {
        for (; k > 0 && cur != root; --k)
            cur = cur.prev;
        return text();
    }

    public String cursorRight(int k) {
        for (; k > 0 && cur.next != root; --k)
            cur = cur.next;
        return text();
    }
}

class Node {
    Node prev, next;
    char ch;

    Node() {
    }

    Node(char ch) {
        this.ch = ch;
    }

    Node insert(Node node) {
        node.prev = this;
        node.next = this.next;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }

    void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}