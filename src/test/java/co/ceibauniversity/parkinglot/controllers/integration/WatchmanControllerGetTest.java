package co.ceibauniversity.parkinglot.controllers.integration;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceibauniversity.parkinglot.databuilder.VehicleTestDataBuilder;
import co.ceibauniversity.parkinglot.dao.TicketDAO;
import co.ceibauniversity.parkinglot.model.Ticket;
import co.ceibauniversity.parkinglot.model.Vehicle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WatchmanControllerGetTest {
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@LocalServerPort
    int randomServerPort;
	
	@Autowired
	TicketDAO ticketDAO;
	
	@Before
	public void addVehicleToDB() {
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().usingPlate("PRUEBAGET");
		Vehicle vehicle = vehicleTestDataBuilder.build();
		Ticket ticket = new Ticket(vehicle.getType(),vehicle.getPlate(),vehicle.getCc(), new Date());
		ticket.setExitDate(new Date());
		ticket.setTotalHours(1);
		ticketDAO.addTicket(ticket);
	}
	
	@After
	public void removeVehicleFromDB() {
		ticketDAO.deleteVehicle("PRUEBAGET");
	}
	
	@Test
	public void getVehicleByPlateTest() {
		ResponseEntity<Ticket> responseEntity = 
				restTemplate.getForEntity("http://localhost:"+randomServerPort+"/parking/ticket/PRUEBAGET", Ticket.class);
		Ticket respuesta = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("PRUEBAGET",respuesta.getPlate());
	}
	

}
