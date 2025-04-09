package com.pattern.proxy;

public class UserService {
    public void addUser(String username) {
        System.out.println("Add user: " + username);
    }

    public void deleteUser(String username) {
        System.out.println("Delete user: " + username);
    }

    public int updateUser(String username) {
        if (username == null || username.isEmpty()) {
            return 0;
        }
        System.out.println("Update user: " + username);
        return 1;
    }
}
