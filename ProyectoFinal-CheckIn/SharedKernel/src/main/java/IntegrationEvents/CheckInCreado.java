package IntegrationEvents;

import java.util.UUID;

public class CheckInCreado {

  public UUID keyVuelo;
  public int numeroAsiento;
  public int disponibilidad;

  public UUID getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(UUID keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public int getNumeroAsiento() {
    return this.numeroAsiento;
  }

  public void setNumeroAsiento(int numeroAsiento) {
    this.numeroAsiento = numeroAsiento;
  }

  public int getDisponibilidad() {
    return this.disponibilidad;
  }

  public void setDisponibilidad(int disponibilidad) {
    this.disponibilidad = disponibilidad;
  }
}
