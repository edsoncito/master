package Application.UseCases.Command.CheckIn.Edit;

import Dto.CheckInDto;
import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import UseCases.Command.CheckIn.Edit.EditCheckInCommand;
import UseCases.Command.CheckIn.Edit.EditCheckInHandler;
import factories.ICheckInFactory;
import fourteam.http.Exception.HttpException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class EditCheckInHandler_Test {

    ICheckInFactory _checkInFactory = Mockito.mock(ICheckInFactory.class);
    IcheckInRepository _checkInRepository = Mockito.mock(IcheckInRepository.class);
    IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

    int Asiento = 33;
    Boolean EstadoPaciente = true;
    String Descripcion = "haskjhfaksjf";
    String CodigoSeguridad = "dsfds";

    @Before
    public void setUp() {
    }

    @Test
    public void HandleCorrectly() throws HttpException {

        CheckIn objCheckIn = new CheckIn(CodigoSeguridad, EstadoPaciente, Descripcion, Asiento);
        when(_checkInRepository.FindByKey(any())).thenReturn(objCheckIn);
        EditCheckInHandler handler = new EditCheckInHandler(_checkInFactory, _checkInRepository, _unitOfWork);

        CheckInDto checkInDto = new CheckInDto();
        checkInDto.setKey(objCheckIn.getKey());
        checkInDto.setCodigoSeguridad(CodigoSeguridad);
        checkInDto.setAsiento(Asiento);
        checkInDto.setEstadoPaciente(EstadoPaciente);
        checkInDto.setDescripcion(Descripcion);

        EditCheckInCommand command = new EditCheckInCommand(checkInDto.getKey());
        command.checkInDto.setCodigoSeguridad(CodigoSeguridad);
        CheckIn resp = handler.handle(command);
        Assert.assertEquals(CodigoSeguridad, resp.getCodigoSeguridad());
    }

    @Test
    public void HandleFailed() throws HttpException {

        when(_checkInRepository.FindByKey(any())).thenReturn(null);
        EditCheckInHandler handler = new EditCheckInHandler(_checkInFactory, _checkInRepository, _unitOfWork);
        CheckInDto checkInDto = new CheckInDto();
        checkInDto.setKey(UUID.randomUUID());
        checkInDto.setCodigoSeguridad(CodigoSeguridad);
        checkInDto.setAsiento(Asiento);
        checkInDto.setEstadoPaciente(EstadoPaciente);
        checkInDto.setDescripcion(Descripcion);
        EditCheckInCommand command = new EditCheckInCommand(checkInDto.getKey());
        try {
            CheckIn resp = handler.handle(command);
        } catch (HttpException e) {
            Assert.assertEquals(400, e.getCode());
        }
    }
}
