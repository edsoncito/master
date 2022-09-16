package Modal;

import core.AggregateRoot;
import java.util.List;
import java.util.UUID;

public class Itinerario extends AggregateRoot<UUID> {

  private String ciudadOrigen;
  private String ciudadDestino;
  private List<Asiento> asiento;

  public Itinerario() {}

  public Itinerario(
    UUID keyVuelo,
    String ciudadOrigen,
    String ciudadDestino,
    List<Asiento> asiento
  ) {
    this.key = keyVuelo;
    this.ciudadOrigen = ciudadOrigen;
    this.ciudadDestino = ciudadDestino;
    this.asiento = asiento;
  }

  public UUID getKeyVuelo() {
    return this.key;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.key = keyVuelo;
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
