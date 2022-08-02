package Model;

import Modal.CheckIn;
import Modal.Passenger;
import org.junit.Assert;
import org.junit.Test;

public class Passenger_Test {

  @Test
  public void Correctly() {
    String Name = "edson";
    String LastName = "Mamani Veizga";
    int Dni = 7576586;

    Passenger objPassenger = new Passenger(Name, LastName, Dni);

    Passenger passenger = new Passenger();

    passenger.setName(objPassenger.getName());
    passenger.setLastName(objPassenger.getLastName());
    passenger.setDni(objPassenger.getDni());

    Assert.assertEquals(Name, passenger.getName());
    Assert.assertEquals(LastName, passenger.getLastName());
    Assert.assertEquals(Dni, passenger.getDni());
  }
}
