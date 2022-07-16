package Model;

import Modal.Baggage;
import Modal.CheckIn;
import org.junit.Assert;
import org.junit.Test;

public class Baggage_Test {

    @Test
    public void Correctly() {

        Double PesoEquipaje = 23.3;
        String NumeroEtiqueta = "sdfd33f3";
        String Descripcion = "sdsfsfse";

        Baggage objBaggage = new Baggage(PesoEquipaje, NumeroEtiqueta, Descripcion);

        Baggage baggage = new Baggage();

        baggage.setPesoEquipaje(objBaggage.getPesoEquipaje());
        baggage.setNumeroEtiqueta(objBaggage.getNumeroEtiquta());
        baggage.setDescripcion(objBaggage.getDescripcion());

        Assert.assertEquals(PesoEquipaje, baggage.getPesoEquipaje());
        Assert.assertEquals(NumeroEtiqueta, baggage.getNumeroEtiquta());
        Assert.assertEquals(Descripcion, baggage.getDescripcion());
    }
}
