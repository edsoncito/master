package Model;

import Modal.CheckIn;
import org.junit.Assert;
import org.junit.Test;

public class CheckIn_Test {


    @Test
    public void Correctly() {

        String CodigoSeguridad = "dsfds";
        int Asiento = 33;
        Boolean EstadoPaciente = true;
        String Descripcion = "haskjhfaksjf";

        CheckIn objCheckIn = new CheckIn(CodigoSeguridad, EstadoPaciente, Descripcion, Asiento);
        objCheckIn.AgregarItem(3.2, "Sdfds", "asdasfasa");

        CheckIn checkIn = new CheckIn();

        checkIn.setEquipaje(objCheckIn.getEquipaje());
        checkIn.setCodigoSeguridad(objCheckIn.getCodigoSeguridad());
        checkIn.setDescripcion(objCheckIn.getDescripcion());
        checkIn.setEstadoPaciente(objCheckIn.getEstadoPaciente());
        checkIn.setAsiento(objCheckIn.getAsiento());

        Assert.assertEquals(CodigoSeguridad, checkIn.getCodigoSeguridad());
        Assert.assertEquals(Asiento, checkIn.getAsiento());
        Assert.assertEquals(EstadoPaciente, checkIn.getEstadoPaciente());
        Assert.assertEquals(Descripcion, checkIn.getDescripcion());

        checkIn.checkInCompletado();
    }
}


