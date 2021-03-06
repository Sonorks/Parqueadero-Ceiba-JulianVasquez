package co.ceibauniversity.parkinglot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.ceibauniversity.parkinglot.model.Ticket;

@Service
public interface ITicketDAO {	
	
	String getVehicleType(String plate);
	boolean addTicket(Ticket ticket);
	boolean removeVehicle(String plate, int totalHours, int totalPrice, Date date);
	List<Ticket> getTickets();
	Ticket getTicket(String plate);
	
}
