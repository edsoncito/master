package UseCases.Command.CheckIn.Edit;

import Modal.CheckIn;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import factories.ICheckInFactory;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditCheckInHandler
	implements RequestHandler<EditCheckInCommand, CheckIn> {

	private ICheckInFactory _checkInFactory;
	private IcheckInRepository _icheckInRepository;
	private IUnitOfWork _unitOfWork;

	public EditCheckInHandler(
		ICheckInFactory checkInFactory,
		IcheckInRepository icheckInRepository,
		IUnitOfWork _unitOfWork
	) {
		this._checkInFactory = checkInFactory;
		this._icheckInRepository = icheckInRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public CheckIn handle(EditCheckInCommand request) throws HttpException {
		CheckIn checkIn = _icheckInRepository.FindByKey(
			request.checkInDto.getKey()
		);
		if (checkIn == null) {
			throw new HttpException(HttpStatus.BAD_REQUEST, "CheckIn no encontrada");
		}
		checkIn.CodigoSeguridad = request.checkInDto.getCodigoSeguridad();
		_icheckInRepository.Update(checkIn);
		return checkIn;
	}
}
