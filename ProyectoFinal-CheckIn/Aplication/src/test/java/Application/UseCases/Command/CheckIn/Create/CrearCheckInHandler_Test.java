package Application.UseCases.Command.CheckIn.Create;

import static org.mockito.Mockito.*;

import Dto.BaggageDto;
import Dto.CheckInDto;
import Events.CheckInCreado;
import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import Services.CheckInServices;
import UseCases.Command.CheckIn.Create.CrearCheckInCommand;
import UseCases.Command.CheckIn.Create.CrearCheckInHandler;
import factories.CheckInFactory;
import factories.ICheckInFactory;
import fourteam.http.Exception.HttpException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearCheckInHandler_Test {

  ICheckInFactory checkInFactory = Mockito.mock(ICheckInFactory.class);
  IcheckInRepository checkInRepository = Mockito.mock(IcheckInRepository.class);
  IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);
  CheckInServices checkInServices = Mockito.mock(CheckInServices.class);

  @Test
  public void HandleCorrectly() throws HttpException {
    String CodigoSeguridad = "dsfds";
    int Asiento = 33;
    Boolean EstadoPaciente = true;
    String Descripcion = "haskjhfaksjf";
    List<BaggageDto> Equipaje = getBaggage();

    when(checkInServices.GenerarNroPedidoAsync()).thenReturn(CodigoSeguridad);
    CheckIn objCheckIn = new CheckInFactory()
      .Create(CodigoSeguridad, EstadoPaciente, Descripcion, Asiento);
    when(checkInFactory.Create(anyString(), anyBoolean(), anyString(), anyInt()))
      .thenReturn(objCheckIn);

    CrearCheckInHandler handler = new CrearCheckInHandler(
      checkInRepository,
      checkInFactory,
      _unitOfWork,
      checkInServices
    );

    CheckInDto checkInDto = new CheckInDto();
    checkInDto.setCodigoSeguridad(CodigoSeguridad);
    checkInDto.setAsiento(Asiento);
    checkInDto.setEstadoPaciente(EstadoPaciente);
    checkInDto.setDescripcion(Descripcion);
    checkInDto.setEquipajeDto(Equipaje);

    var objRequest = new CrearCheckInCommand(checkInDto);
    var resp = handler.handle(objRequest);

    verify(checkInRepository).Create(resp);
    verify(_unitOfWork).commit();
    verify(checkInServices).GenerarNroPedidoAsync();

    Assert.assertEquals(CheckInCreado.class, objCheckIn.domainEvents.get(0).getClass());
    Assert.assertEquals(CodigoSeguridad, resp.CodigoSeguridad);
    Assert.assertEquals(EstadoPaciente, resp.EstadoPaciente);
    Assert.assertEquals(Descripcion, resp.Descripcion);
    Assert.assertEquals(Asiento, resp.Asiento);
  }

  private List<BaggageDto> getBaggage() {
    List<BaggageDto> list = new ArrayList();
    BaggageDto baggageDto = new BaggageDto();
    baggageDto.setNumeroEtiqueta("dsdfsdf");
    baggageDto.setDescripcion("dsfdsf");
    baggageDto.setPesoEquipaje(23.3);
    list.add(baggageDto);
    return list;
  }
}
