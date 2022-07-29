package UseCases.Command.CheckIn.Create;

import Dto.BaggageDto;
import Dto.CheckInDto;
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
