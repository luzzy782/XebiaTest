package com.mowitnow.tondeuse.enumeration;

public enum Cardinal {

	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

    private String value;

    private Cardinal(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
}
