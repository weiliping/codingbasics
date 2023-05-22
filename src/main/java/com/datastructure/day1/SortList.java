package com.datastructure.day1;

public class SortList {

    public static void main(String[] args) {
        SortList list = new SortList();
        list.add("bc");
        list.add("ab");
        list.add("de");
        list.add("cd");
        list.add("ef");
        list.add("fg");
        list.add("gh");
        list.add("hi");
        list.add("ij");
        list.add("jk");
        list.add("kl");
        list.add("lm");
        list.add("mn");
        list.add("no");
        list.add("op");
        list.add("pq");
        list.add("qr");
        list.add("rs");
        list.add("st");
        list.add("tu");
        list.add("uv");
        list.add("vw");
        list.add("wx");
        System.out.println("2");
        list.delete(2);
        System.out.println("1");
    }

    private static int size;
    private String[] objects;

    public SortList(int capacity){
        objects =  new String[capacity];
        size = 0;
    }

    public SortList() {
        this(16);
    }

    public void add(String obj) {
        if (size >= objects.length) {
            return;
        }

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = obj;
                break;
            } else {
                if (objects[i].hashCode() > obj.hashCode()) {
                    String tmp = objects[i];
                    objects[i] = obj;
                    int j = i + 1;
                    while (j < objects.length) {
                        if (objects[j] == null) {
                            objects[j] = tmp;
                            break;
                        } else {
                            if (objects[j].hashCode() > tmp.hashCode()) {
                                String maxObj = objects[j];
                                objects[j] = tmp;
                                tmp = maxObj;
                            }
                            j++;
                        }
                    }
                    break;
                }
            }
        }
        size++;
    }


    public boolean delete(int index) {
        if (index < 0 || index >= objects.length) {
            return false;
        }
        for (int j = index; j < objects.length - 1; j++) {
            if (objects[j] == null) {
                break;
            }
            objects[j] = objects[j + 1];
            if (j + 2 == objects.length) {
                objects[j + 1] = null;
            }
        }
        return true;
    }
}
