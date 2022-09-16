package Modal;

import Events.CheckInCreado;
import core.AggregateRoot;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CheckIn extends AggregateRoot<UUID> {

  public String CodigoSeguridad;
  public Date HoraCheckIn;
  public Boolean EstadoPaciente;
  public String Descripcion;
  public int NumeroAsiento;
  public List<Equipaje> equipaje;
  public List<Asiento> asientos;
  public Pasajero pasajero;
  public Itinerario itinerario;
  public String keyVuelo;
  public String keyPasajero;

  public CheckIn() {}

  public CheckIn(
    String codigoSeguridad,
    Boolean estadoPaciente,
    String descripcion,
    int numeroAsiento
  ) {
    key = UUID.randomUUID();
    CodigoSeguridad = codigoSeguridad;
    EstadoPaciente = estadoPaciente;
    Descripcion = descripcion;
    NumeroAsiento = numeroAsiento;
    equipaje = new ArrayList<Equipaje>();
  }

  public void AgregarItem(Double PesoEquipaje, String NumeroEtiqueta, String descripcion) {
    // var detalleEquipaje = Equipaje.First(x => x.ProductoId == productoId);
    // Equipaje equipaje;
    // if (equipaje is null)
    // {
    // detallePedido = new DetallePedido(productoId, instrucciones, cantidad,
    // precio);
    // _detalle.Add(detallePedido);
    // }
    // else
    // {
    // detallePedido.ModificarPedido(cantidad, precio);
    // }

    Equipaje equipajes = new Equipaje(PesoEquipaje, NumeroEtiqueta, descripcion);
    equipaje.add(equipajes);
  }

  public void checkInCompletado() {
    var event = new CheckInCreado(key, CodigoSeguridad);
    addDomainEvent(event);
  }

  public List<Equipaje> getEquipaje() {
    return equipaje;
  }

  public void setEquipaje(List<Equipaje> equipaje1) {
    equipaje = equipaje1;
  }

  public String getCodigoSeguridad() {
    return this.CodigoSeguridad;
  }

  public void setCodigoSeguridad(String CodigoSeguridad) {
    this.CodigoSeguridad = CodigoSeguridad;
  }

  public Date getHoraCheckIn() {
    return this.HoraCheckIn;
  }

  public void setHoraCheckIn(Date HoraCheckIn) {
    this.HoraCheckIn = HoraCheckIn;
  }

  public Boolean getEstadoPaciente() {
    return this.EstadoPaciente;
  }

  public void setEstadoPaciente(Boolean EstadoPaciente) {
    this.EstadoPaciente = EstadoPaciente;
  }

  public String getDescripcion() {
    return this.Descripcion;
  }

  public void setDescripcion(String Descripcion) {
    this.Descripcion = Descripcion;
  }

  public int getAsiento() {
    return this.NumeroAsiento;
  }

  public void setAsiento(int Asiento) {
    this.NumeroAsiento = Asiento;
  }
}
