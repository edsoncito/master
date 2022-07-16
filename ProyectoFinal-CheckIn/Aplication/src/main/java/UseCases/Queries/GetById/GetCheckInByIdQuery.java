package UseCases.Queries.GetById;

import java.util.UUID;
import Dto.CheckInDto;
import fourteam.mediator.Request;

public class GetCheckInByIdQuery implements Request<CheckInDto> {

    public UUID Key;
    public GetCheckInByIdQuery(UUID key)
    {
        Key = key;
    }

}
