package IntegrationEvents;

import core.IntegrationEvent;
import java.util.UUID;

public class TripulacionCreado extends IntegrationEvent {

  public UUID keyTripulacion;
  public String descripcion;

  public UUID getKeyTripulacion() {
    return this.keyTripulacion;
  }

  public void setKeyTripulacion(UUID keyTripulacion) {
    this.keyTripulacion = keyTripulacion;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
