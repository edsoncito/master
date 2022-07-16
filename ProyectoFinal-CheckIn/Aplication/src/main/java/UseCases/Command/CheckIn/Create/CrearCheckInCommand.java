package UseCases.Command.CheckIn.Create;

import Dto.CheckInDto;
import Dto.BaggageDto;
import Modal.CheckIn;
import fourteam.mediator.Request;

import java.util.List;

public class CrearCheckInCommand implements Request<CheckIn> {

    public CheckInDto checkInDto;
    public List<BaggageDto> Equipaje;

    public CrearCheckInCommand(CheckInDto obj) {
        checkInDto = obj;
        Equipaje = obj.getEquipajeDto();
    }

}
