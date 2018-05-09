package unitarias.model;

import static org.junit.Assert.*;

import org.junit.Test;

import dataBuilder.VehicleTestDataBuilder;
import model.Vehicle;

public class VehicleTest {
	
	private static final String TYPE = "BIKE";
	private static final String PLATE = "ELR01D";
	private static final int CC = 150;

	@Test
	public void createVehicleTypeTest() {
		
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().usingType(TYPE);
		
		//act
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		//assert
		assertEquals(TYPE, vehicle.getType());
	}
	
	@Test
	public void createVehiclePlateTest() {
		
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().usingPlate(PLATE);
		
		//act
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		//assert
		assertEquals(PLATE, vehicle.getPlate());
	}
	
	@Test
	public void createVehicleCCTest() {
		
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().usingCC(CC);
		
		//act
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		//assert
		assertEquals(CC, vehicle.getCc());
	}
	
	@Test
	public void createVehicleFailTest() {
		
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		//act
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		//assert
		assertNotEquals(CC, vehicle.getCc());
	}

}
