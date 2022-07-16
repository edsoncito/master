package Modal;

import core.Entity;
import java.util.UUID;

public class Passenger extends Entity<UUID> {

    private String Name;
    private String LastName;
    private int Dni;

    public Passenger() {
    }

    public Passenger(String name, String lastName, int dni) {
        key = UUID.randomUUID();
        Name = name;
        LastName = lastName;
        Dni = dni;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int dni) {
        Dni = dni;
    }
}
