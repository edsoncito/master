package UseCases.Command.CheckIn.Edit;

import Dto.CheckInDto;
import Modal.CheckIn;
import fourteam.mediator.Request;
import java.util.UUID;

public class EditCheckInCommand implements Request<CheckIn> {

    public CheckInDto checkInDto;

    public EditCheckInCommand(UUID key) {
        this.checkInDto = new CheckInDto();
        this.checkInDto.Key = key;
    }
}
