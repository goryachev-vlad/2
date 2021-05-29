package com.company;

public enum Item {
    EMPTY,
    X,
    O;

    @Override
    public String toString() {
        switch (this) {
            case EMPTY: return "-";
            case O: return "O";
            case X: return "X";
        }
        return null;
    }
}
