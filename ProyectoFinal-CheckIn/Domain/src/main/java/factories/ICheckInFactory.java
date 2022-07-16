package factories;

import Modal.CheckIn;

public interface ICheckInFactory {
    
    CheckIn Create(String codigoSeguridad,Boolean estadoPaciente,String descripcion, int asiento);

}
