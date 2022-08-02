package UseCases.Command.CheckIn.Delete;

import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import factories.ICheckInFactory;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class DeleteCheckInHandler implements RequestHandler<DeleteCheckInCommand, CheckIn> {

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
  public CheckIn handle(DeleteCheckInCommand request) throws HttpException {
    CheckIn checkIn = _icheckInRepository.FindByKey(request.checkInDto.Key);
    if (checkIn == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "CheckIn no encontrado");
    }
    return _icheckInRepository.Delete(checkIn);
  }
}
