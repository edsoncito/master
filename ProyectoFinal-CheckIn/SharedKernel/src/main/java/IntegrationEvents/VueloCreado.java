package IntegrationEvents;

import core.IntegrationEvent;
import java.util.List;

public class VueloCreado extends IntegrationEvent {

  private String keyVuelo;
  private String ciudadOrigen;
  private String ciudadDestino;
  private List<Asiento> asiento;

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

  public class Asiento {

    private String numero;
    private int disponibilidad;

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
}
