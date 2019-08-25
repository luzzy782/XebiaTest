package com.mowitnow.tondeuse.model;

import java.util.HashSet;
import java.util.LinkedHashSet;

import com.mowitnow.tondeuse.enumeration.Cardinal;

import lombok.Getter;
import lombok.Setter;

public class Field {

	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Getter
	@Setter
	private int x;
	
	@Getter
	@Setter
	private int y;
	
	@Getter
	private HashSet<Tondeuse> tondeuses = new HashSet<Tondeuse>();
	
	public void addTondeuse(Tondeuse tondeuse) {
		tondeuses.add(tondeuse);
	}

}
