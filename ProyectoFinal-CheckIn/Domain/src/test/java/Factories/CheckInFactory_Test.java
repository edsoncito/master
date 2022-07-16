package Factories;

import Modal.CheckIn;
import factories.CheckInFactory;
import fourteam.http.Exception.HttpException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.UUID;

public class CheckInFactory_Test {

    @Before
    public void setup() {
    }

    @Test
    public void HandleCheckFactory_Ok() throws HttpException {

        String CodigoSeguridad = "dsfds";
        int Asiento = 33;
        Boolean EstadoPaciente = true;
        String Descripcion = "haskjhfaksjf";
        CheckIn objCheckIn = new CheckIn(CodigoSeguridad, EstadoPaciente, Descripcion, Asiento);

        CheckInFactory checkInFactory = new CheckInFactory();
        CheckIn checkIn = checkInFactory.Create(anyString(),anyBoolean(),anyString(), anyInt());

    }
}
