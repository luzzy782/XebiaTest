package com.mowitnow.tondeuse.enumeration;

public enum Orientation {

	GAUCHE("G"), DROIT("D"), AVANCER("A");

    private String value;

    private Orientation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
    /**
     * Methode wich return Orientation according to given instruction letter in parameter
     * @param instruction
     * @return Orientation
     * @throws Exception
     */
    public static Orientation toOrientation(String instruction) throws Exception {
    	if (instruction.equals("D")) {
			return Orientation.DROIT;
		}else if (instruction.equals("G")) {
			return Orientation.GAUCHE;
		}else if (instruction.equals("A")) {
			return Orientation.AVANCER;
		}else {
			throw new Exception("Unknown orientation letter");
		}
    }
    
}
