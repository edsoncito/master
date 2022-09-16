package Modal;

import core.Entity;
import java.util.UUID;

public class Asiento extends Entity<UUID> {

  private String numero;
  private int disponibilidad;

  public Asiento() {}

  public Asiento(UUID key, String numero, int disponibilidad) {
    this.key = key;
    this.numero = numero;
    this.disponibilidad = disponibilidad;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getNumero() {
    return numero;
  }

  public void setDisponibilidad(int disponibilidad) {
    this.disponibilidad = disponibilidad;
  }

  public int getDisponibilidad() {
    return disponibilidad;
  }
}
