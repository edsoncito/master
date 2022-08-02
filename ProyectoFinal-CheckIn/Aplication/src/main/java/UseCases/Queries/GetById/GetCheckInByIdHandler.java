package UseCases.Queries.GetById;

import Dto.BaggageDto;
import Dto.CheckInDto;
import Modal.CheckIn;
import Repositories.IcheckInRepository;
import fourteam.mediator.RequestHandler;
import java.util.ArrayList;
import java.util.List;

public class GetCheckInByIdHandler implements RequestHandler<GetCheckInByIdQuery, CheckInDto> {

  private IcheckInRepository _IcheckInRepository;

  public GetCheckInByIdHandler(IcheckInRepository icheckInRepository) {
    this._IcheckInRepository = icheckInRepository;
  }

  @Override
  public CheckInDto handle(GetCheckInByIdQuery request) {
    CheckInDto checkInDto = new CheckInDto();
    try {
      CheckIn checkIn = _IcheckInRepository.FindByKey(request.Key);
      if (checkIn == null) {
        return null;
      }
      checkInDto.setEstadoPaciente(checkIn.getEstadoPaciente());
      checkInDto.setDescripcion(checkIn.getDescripcion());
      checkInDto.setAsiento(checkIn.getAsiento());
      List<BaggageDto> lista = new ArrayList<>();
      for (var item : checkIn.getEquipaje()) {
        BaggageDto equipajeDto = new BaggageDto();
        equipajeDto.setPesoEquipaje(item.getPesoEquipaje());
        equipajeDto.setNumeroEtiqueta(item.getNumeroEtiquta());
        equipajeDto.setDescripcion(item.getDescripcion());
        lista.add(equipajeDto);
      }
      checkInDto.setEquipajeDto(lista);
      checkInDto.setCodigoSeguridad(checkIn.getCodigoSeguridad());
    } catch (Exception e) {
      System.out.println(e);
    }
    return checkInDto;
  }
}
