package com.algorithm.contest.weeklycontest230;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-items-matching-a-rule/
 * #1773. 统计匹配检索规则的物品数量
 *
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 *
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 *
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 *
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 *
 * 示例 1：
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 *
 * 示例 2：
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 */
public class CountMatches {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> item1 = new ArrayList<>();
        item1.add("phone");
        item1.add("blue");
        item1.add("pixel");
        items.add(item1);
        item1 = new ArrayList<>();
        item1.add("computer");
        item1.add("silver");
        item1.add("lenovo");
        items.add(item1);
        item1 = new ArrayList<>();
        item1.add("phone");
        item1.add("gold");
        item1.add("iphone");
        items.add(item1);
        String ruleKey = "color", ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey, ruleValue));

        List<List<String>> items1 = new ArrayList<>();
        List<String> item11 = new ArrayList<>();
        item11.add("phone");
        item11.add("blue");
        item11.add("pixel");
        items1.add(item11);
        item11 = new ArrayList<>();
        item11.add("computer");
        item11.add("silver");
        item11.add("phone");
        items1.add(item11);
        item11 = new ArrayList<>();
        item11.add("phone");
        item11.add("gold");
        item11.add("iphone");
        items1.add(item11);
        String ruleKey1 = "type", ruleValue1 = "phone";
        System.out.println(countMatches(items1, ruleKey1, ruleValue1));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int i = getIndex(ruleKey);
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(i))) {
                res++;
            }
        }
        return res;
    }

    static int getIndex(String ruleKey) {
        if ("type".equals(ruleKey)) {
            return 0;
        }
        if ("color".equals(ruleKey)) {
            return 1;
        }
        return 2;
    }
}
