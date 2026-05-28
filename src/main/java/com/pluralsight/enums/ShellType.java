package com.pluralsight.enums;

public enum ShellType {
    CORN("Corn"), FLOUR("Flour"), HARD_SHELL("Hard Shell"), BOWL("Bowl");

    private final String shellType;

    ShellType(String shellType) {
        this.shellType = shellType;
    }

    public String getShellType() {
        return shellType;
    }
}
