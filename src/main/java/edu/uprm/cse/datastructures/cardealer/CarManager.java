package edu.uprm.cse.datastructures.cardealer;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.util.CircularSortedDoublyLinkedList;


@Path("/cars")
public class CarManager {

	private static CircularSortedDoublyLinkedList<Car> carList = MockCarList.getInstance();  
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Car[] getAllCars() {
		Car[] cars = new Car[carList.size()];
		for(int i = 0; i < carList.size(); i++) cars[i] = carList.get(i);
		return cars;
	}
	
	@GET
	  @Path("{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Car getCar(@PathParam("id") long id){
		
		return null;
	  }
	
	@POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCar(Car car){
      carList.add(car);
      return Response.status(201).build();
    }
	
	@PUT
    @Path("{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCar(Car car){
//      int matchIdx = 0;
//      Optional<Car> match = carList.stream()
//          .filter(c -> c.getCarId() == car.getCarId())
//          .findFirst();
//      if (match.isPresent()) {
//        matchIdx = carList.indexOf(match.get());
//        carList.set(matchIdx, car);
//        return Response.status(Response.Status.OK).build();
//      } else {
//        return Response.status(Response.Status.NOT_FOUND).build();      
//      }
		return null;
    }
	
	@DELETE
    @Path("/remove/{id}")
    public void deleteCustomer(@PathParam("id") long id){
//      Predicate <Car> customer = c -> c.getCarId() == id;
//      if (!carList.removeIf(customer)) {
//       throw new NotFoundException(new JsonError("Error", "Customer " + id + " not found"));
//      }
    }  
	
}
