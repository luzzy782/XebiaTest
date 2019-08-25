package com.mowitnow.tondeuse.model;

import com.mowitnow.tondeuse.enumeration.Cardinal;

import lombok.Getter;
import lombok.Setter;

public class Tondeuse {

	public Tondeuse(int x, int y, Cardinal cardinal, String instructions) {
		this.x = x;
		this.y = y;
		this.cardinal = cardinal;
		this.instructions = instructions;
		this.hasMoved = false;
	}
	
	@Getter
	@Setter
	private int x;
	
	@Getter
	@Setter
	private int y;
	
	@Getter
	@Setter
	private Cardinal cardinal;
	
	@Getter
	@Setter
	private boolean hasMoved;
	
	@Getter
	@Setter
	private String instructions;

	
	public String returnPosition() {
		return this.x + " " + this.y + " " + this.cardinal.getValue();
	}

}
