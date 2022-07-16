package Events;

import fourteam.http.Exception.HttpException;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class CheckInCreado_Test {

    @Before
    public void setup() {

    }

    @Test
    public void HandleCheckInRegistrado_Ok() throws HttpException {
        UUID KeyCheckIn = UUID.randomUUID();
        String CodigoSeguridad = "sdfdsf";

        CheckInCreado personalRegistradoTest = new CheckInCreado(KeyCheckIn, CodigoSeguridad);

        personalRegistradoTest.CodigoSeguridad = CodigoSeguridad;
        String codigo = personalRegistradoTest.CodigoSeguridad;
    }
}
