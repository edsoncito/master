package factories;

import Modal.CheckIn;

public class CheckInFactory implements ICheckInFactory{

    @Override
    public CheckIn Create(String codigoSeguridad,Boolean estadoPaciente,String descripcion, int asiento) {
        return new CheckIn(codigoSeguridad,estadoPaciente,descripcion,asiento);
    }

}
