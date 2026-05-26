package com.pluralsight.enums;

public enum ShellType {
    CORN(1), FLOUR(2), HARD_SHELL(3), BOWL(4);

    private final int shellType;

    ShellType(int shellType) {
        this.shellType = shellType;
    }

    public int getShellType() {
        return shellType;
    }
}
