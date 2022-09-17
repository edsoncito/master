package UseCases.Command.CheckIn.Delete;

import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import factories.ICheckInFactory;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class DeleteCheckInHandler implements RequestHandler<DeleteCheckInCommand, UUID> {

  private ICheckInFactory _checkInFactory;
  private IcheckInRepository _icheckInRepository;
  private IUnitOfWork _unitOfWork;

  public DeleteCheckInHandler(
    ICheckInFactory checkInFactory,
    IcheckInRepository icheckInRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._checkInFactory = checkInFactory;
    this._icheckInRepository = icheckInRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(DeleteCheckInCommand request) throws Exception {
    CheckIn checkIn = _icheckInRepository.FindByKey(request.checkInDto.Key);
    if (checkIn == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "CheckIn no encontrado");
    }
    _icheckInRepository.Delete(checkIn);
    _unitOfWork.commit();
    return _icheckInRepository.Delete(checkIn).key;
  }
}
