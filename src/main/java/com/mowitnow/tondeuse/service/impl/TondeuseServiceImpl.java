package com.mowitnow.tondeuse.service.impl;

import com.mowitnow.tondeuse.enumeration.Cardinal;
import com.mowitnow.tondeuse.enumeration.Orientation;
import com.mowitnow.tondeuse.model.Field;
import com.mowitnow.tondeuse.model.Tondeuse;
import com.mowitnow.tondeuse.service.ITondeuseService;

public class TondeuseServiceImpl implements ITondeuseService {

	public TondeuseServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void moveTondeuse(Field field) throws Exception {
		//Looping on each tondeuse
		for (Tondeuse tondeuse : field.getTondeuses()) {
			String[] splittedInstructions = tondeuse.getInstructions().split("(?!^)");
			//Operating each instruction one by one
			for (String instruction : splittedInstructions) {
					changeCardinal(tondeuse,field, Orientation.toOrientation(instruction));
			}
			System.out.println(tondeuse.returnPosition());
		}
	}

	
	public void changeCardinal(Tondeuse tondeuse, Field field, Orientation ori) {
		switch (ori) {
			case DROIT:
				switch (tondeuse.getCardinal()) {
					case NORTH:
						tondeuse.setCardinal(Cardinal.EAST);
						break;
					case EAST:
						tondeuse.setCardinal(Cardinal.SOUTH);
						break;
					case SOUTH:
						tondeuse.setCardinal(Cardinal.WEST);
						break;
					case WEST:
						tondeuse.setCardinal(Cardinal.NORTH);
						break;
		
					default:
						break;
				}
			break;
				
			case GAUCHE:
				switch (tondeuse.getCardinal()) {
					case NORTH:
						tondeuse.setCardinal(Cardinal.WEST);
						break;
					case WEST:
						tondeuse.setCardinal(Cardinal.SOUTH);
						break;
					case SOUTH:
						tondeuse.setCardinal(Cardinal.EAST);
						break;
					case EAST:
						tondeuse.setCardinal(Cardinal.NORTH);
						break;
	
					default:
						break;
				}
				break;
				
			case AVANCER:
				moveForward(tondeuse, field);
				break;
	
			default:
				break;
		}
	}

	
	public void moveForward(Tondeuse tondeuse, Field field) {
		// TODO Auto-generated method stub
		switch (tondeuse.getCardinal()) {
			case NORTH:
				if (tondeuse.getY()+1 <= field.getY()) {
					tondeuse.setY(tondeuse.getY()+1);
				}
				break;
			case WEST:
				if (tondeuse.getX()-1 >= 0) {
					tondeuse.setX(tondeuse.getX()-1);
				}
				break;
			case SOUTH:
				if (tondeuse.getY()-1 >= 0) {
					tondeuse.setY(tondeuse.getY()-1);
				}
				break;
			case EAST:
				if (tondeuse.getX()+1 <= field.getX()) {
					tondeuse.setX(tondeuse.getX()+1);
				}
				break;
	
			default:
				break;
		}
	}
}
