package com.mowitnow.tondeuse.service;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.junit.Before;
import org.junit.Test;

import com.mowitnow.tondeuse.enumeration.Cardinal;
import com.mowitnow.tondeuse.model.Field;
import com.mowitnow.tondeuse.model.Tondeuse;
import com.mowitnow.tondeuse.service.impl.TondeuseServiceImpl;

public class TondeuseServiceTest {

	protected ITondeuseService tondeuseService;
	
	@Before
	public void init() {
		tondeuseService = new TondeuseServiceImpl();
	}
	@Test
	public void testTondeuse() throws Exception {
		Field field = null;
		
		try {
			//Getting file
            File f = new File("src/main/resources/tondeuse.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = b.readLine();
            String[] splitted = readLine.split(" ");
            //Setting Field Size
            int xField = Integer.parseInt(splitted[0]);
            int yField = Integer.parseInt(splitted[1]);

            field = new Field(xField, yField);
            
            //loop through all tondeuses
            while ((readLine = b.readLine()) != null) {
            	splitted = readLine.split(" ");
            	//Getting Tondeuse Position
            	int xTond = Integer.parseInt(splitted[0]);
            	int yTond = Integer.parseInt(splitted[1]);
            	
            	//Getting Tondeuse Cardinality (orientation)
            	Cardinal cardinal = null;
            	if (splitted[2].equals("N")) {					
            		cardinal = Cardinal.NORTH;
				}else if (splitted[2].equals("S")) {
					cardinal = Cardinal.SOUTH;
				}else if (splitted[2].equals("E")) {
					cardinal = Cardinal.EAST;
				}else if (splitted[2].equals("W")) {
					cardinal = Cardinal.WEST;
				}

            	String instructions = b.readLine();
            	
            	//Creating Tondeuse
            	Tondeuse tondeuse = new Tondeuse(xTond, yTond, cardinal, instructions);
            	
            	//Adding tondeuse to field
            	field.addTondeuse(tondeuse);
            	
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//Starting moving tondeuse present in the field
		tondeuseService.moveTondeuse(field); 

		Iterator<Tondeuse> iter = field.getTondeuses().iterator();

		Tondeuse first = iter.next();
		Tondeuse second = iter.next();
		
		//checking tondeuse are in good position X,Y and Orientation
		assertTrue("Wrong X position", first.getX() == 1);
		assertTrue("Wrong Y position", first.getY() == 3);
		assertTrue("Wrong Cardinal, expected to be North", first.getCardinal().equals(Cardinal.NORTH));
		assertTrue("Wrong X position", second.getX() == 5);
		assertTrue("Wrong Y position", second.getY() == 1);
		assertTrue("Wrong Cardinal, expected to be East", second.getCardinal().equals(Cardinal.EAST));
		
	}

}
