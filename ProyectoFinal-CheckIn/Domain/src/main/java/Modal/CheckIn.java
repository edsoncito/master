package Modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import Events.CheckInCreado;
import core.AggregateRoot;

public class CheckIn extends AggregateRoot<UUID> {

    public String CodigoSeguridad;
    public Date HoraCheckIn;
    public int Asiento;
    public Boolean EstadoPaciente;
    public String Descripcion;
    public List<Baggage> equipaje;
    //private List<Seat> Seats ;


    public CheckIn() {
    }

    public CheckIn(String codigoSeguridad,Boolean estadoPaciente,String descripcion, int asiento) {
        key = UUID.randomUUID();
        CodigoSeguridad = codigoSeguridad;
        EstadoPaciente = estadoPaciente;
        Descripcion = descripcion;
        Asiento = asiento;
        equipaje = new ArrayList<Baggage>();
    }

    public void AgregarItem(Double PesoEquipaje, String NumeroEtiqueta, String descripcion) {

        //var detalleEquipaje = Equipaje.First(x => x.ProductoId == productoId);
        //Equipaje equipaje;
//        if (equipaje is null)
//        {
//            detallePedido = new DetallePedido(productoId, instrucciones, cantidad, precio);
//            _detalle.Add(detallePedido);
//        }
//            else
//        {
//            detallePedido.ModificarPedido(cantidad, precio);
//        }

        Baggage equipajes = new Baggage(PesoEquipaje, NumeroEtiqueta, descripcion);
        equipaje.add(equipajes);
    }

    public void checkInCompletado() {
        var event = new CheckInCreado(key, CodigoSeguridad);
        addDomainEvent(event);
    }

    public List<Baggage> getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(List<Baggage> equipaje1) {
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
        return this.Asiento;
    }

    public void setAsiento(int Asiento) {
        this.Asiento = Asiento;
    }
}
