package com.algorithm.contest.weeklycontest192;

import java.util.ArrayDeque;

class BrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1));//facebook.com 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));//google.com 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));//facebook.com // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));//              // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }

    private String currUrl;
    private ArrayDeque<String> backStack;
    private ArrayDeque<String> forwardStack;
    public BrowserHistory(String homepage) {
	currUrl = homepage;
        backStack = new ArrayDeque<String>(5000);
        forwardStack = new ArrayDeque<String>(5000);
        backStack.push(currUrl);
    }
    
    public void visit(String url) {
	currUrl = url;
        backStack.push(currUrl);
	if (!forwardStack.isEmpty()) {
	    forwardStack.clear();
	}
    }
    
    public String back(int steps) {
	String url = currUrl;
	while (steps > 0 && !backStack.isEmpty()) {
	     url = backStack.pop();
	     forwardStack.push(url);
	     steps--;
	}
        return url;
    }
    
    public String forward(int steps) {
	String url = currUrl;
        while (steps > 0 && !forwardStack.isEmpty()) {
             url = forwardStack.pop();
             backStack.push(url);
             steps--;
        }
        return url;
    }
}
