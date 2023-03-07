package ru.job4j.lombok;

public class PermissionUsage {
    public static void main(String[] args) {
        var rule = Permission.of()
                .id(1)
                .name("UserRule")
                .rules("rule1")
                .rules("rule2")
                .rules("rule3")
                .build();
        System.out.println(rule);
    }
}
