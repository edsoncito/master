package Modal;

import core.Entity;
import java.util.List;
import java.util.UUID;

public class Itinerario extends Entity<UUID> {

  private String keyVuelo;
  private String ciudadOrigen;
  private String ciudadDestino;
  private List<Asiento> asiento;

  public Itinerario() {}

  public Itinerario(
    String keyVuelo,
    String ciudadOrigen,
    String ciudadDestino,
    List<Asiento> asiento
  ) {
    this.keyVuelo = keyVuelo;
    this.ciudadOrigen = ciudadOrigen;
    this.ciudadDestino = ciudadDestino;
    this.asiento = asiento;
  }

  public String getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(String keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public String getCiudadOrigen() {
    return this.ciudadOrigen;
  }

  public void setCiudadOrigen(String ciudadOrigen) {
    this.ciudadOrigen = ciudadOrigen;
  }

  public String getCiudadDestino() {
    return this.ciudadDestino;
  }

  public void setCiudadDestino(String ciudadDestino) {
    this.ciudadDestino = ciudadDestino;
  }

  public List<Asiento> getAsiento() {
    return this.asiento;
  }

  public void setAsiento(List<Asiento> asiento) {
    this.asiento = asiento;
  }
}
