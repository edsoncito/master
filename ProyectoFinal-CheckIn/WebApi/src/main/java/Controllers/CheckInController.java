package Controllers;

import Dto.CheckInDto;
import Modal.CheckIn;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import UseCases.Command.CheckIn.Delete.DeleteCheckInCommand;
import UseCases.Command.CheckIn.Edit.EditCheckInCommand;
import UseCases.Queries.GetAll.GetCheckInAllQuery;
import UseCases.Queries.GetById.GetCheckInByIdQuery;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.*;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

    private Mediator _mediator;

    public CheckInController(Mediator mediator) {
        this._mediator = mediator;
    }

    @GetMapping("/{key}")
    public Response<CheckInDto> getByKey(@PathVariable GetCheckInByIdQuery request) throws HttpException {
        return _mediator.send(request);
    }

    @PostMapping("/registro")
    public Response<CheckIn> register(@RequestBody CrearCheckInCommand checkInCommand) throws HttpException {
        Response<CheckIn> obj = _mediator.send(checkInCommand);
        return obj;
    }

    @GetMapping("/")
    public Response<List<CheckIn>> getAll() throws HttpException {
        return _mediator.send(new GetCheckInAllQuery());
    }

    @PutMapping("/{key}")
    public Response<CheckIn> edit(@RequestBody CheckIn checkIn, @PathVariable EditCheckInCommand request)
            throws HttpException {
        request.checkInDto.CodigoSeguridad = checkIn.CodigoSeguridad;
        return _mediator.send(request);
    }

    @DeleteMapping("/{key}")
    public Response<CheckIn> delete(@PathVariable DeleteCheckInCommand request) throws HttpException {
        return _mediator.send(request);
    }
    
}
