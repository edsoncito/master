package Modal;

import core.Entity;
import java.util.UUID;

public class Pasajero extends Entity<UUID> {

  private String nombre;
  private String apellido;
  private int dni;

  public Pasajero() {}

  public Pasajero(UUID keyVuelo, String nombre, String apellido, int dni) {
    this.key = keyVuelo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public String getnombre() {
    return nombre;
  }

  public void setnombre(String nombre) {
    this.nombre = nombre;
  }

  public String getapellido() {
    return apellido;
  }

  public void setapellido(String apellido) {
    this.apellido = apellido;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }
}
