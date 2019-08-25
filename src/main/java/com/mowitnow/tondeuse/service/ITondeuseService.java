package com.mowitnow.tondeuse.service;

import com.mowitnow.tondeuse.enumeration.Cardinal;
import com.mowitnow.tondeuse.enumeration.Orientation;
import com.mowitnow.tondeuse.model.Field;
import com.mowitnow.tondeuse.model.Tondeuse;

public interface ITondeuseService {
		
	/**
	 * Main method wich manage moving tondeuses calling changeCardinal and moveForward methods
	 * @param field
	 */
	public void moveTondeuse(Field field) throws Exception;
	
	/**
	 * Method wich change tondeuse's caridinal position acording to orientation param
	 * @param tondeuse
	 * @param field
	 * @param ori
	 * 
	 */
	public void changeCardinal(Tondeuse tondeuse,Field field, Orientation ori);
	
	/**
	 * method used to move tondeuse forward
	 * @param tondeuse
	 * @param field
	 *
	 */
	public void moveForward(Tondeuse tondeuse, Field field);
	

}
