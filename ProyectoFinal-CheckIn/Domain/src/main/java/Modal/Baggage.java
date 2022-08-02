package Modal;

import core.Entity;
import java.util.UUID;

public class Baggage extends Entity<UUID> {

  private Double PesoEquipaje;
  private String NumeroEtiqueta;
  private String Descripcion;

  public Baggage() {}

  public Baggage(
    Double pesoEquipaje,
    String numeroEtiqueta,
    String descripcion
  ) {
    key = UUID.randomUUID();
    PesoEquipaje = pesoEquipaje;
    NumeroEtiqueta = numeroEtiqueta;
    Descripcion = descripcion;
  }

  public Double getPesoEquipaje() {
    return PesoEquipaje;
  }

  public void setPesoEquipaje(Double pesoEquipaje) {
    PesoEquipaje = pesoEquipaje;
  }

  public String getNumeroEtiquta() {
    return NumeroEtiqueta;
  }

  public void setNumeroEtiqueta(String numeroEtiquta) {
    NumeroEtiqueta = numeroEtiquta;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String descripcion) {
    Descripcion = descripcion;
  }
}
