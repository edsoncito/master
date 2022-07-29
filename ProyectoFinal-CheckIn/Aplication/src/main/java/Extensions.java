import UseCases.Command.CheckIn.Create.CrearCheckInHandler;
import UseCases.Command.CheckIn.Delete.DeleteCheckInHandler;
import UseCases.Command.CheckIn.Edit.EditCheckInHandler;
import UseCases.Queries.GetAll.GetCheckInAllHandler;
import UseCases.Queries.GetAll.GetCheckInAllQuery;
import UseCases.Queries.GetById.GetCheckInByIdHandler;
import factories.CheckInFactory;
import factories.ICheckInFactory;
import fourteam.extensions.IServiceCollection;
import fourteam.mediator.IMediator;

public class Extensions {

	// public static void main(String[] args) {
	// IServiceCollection services = new IServiceCollection();
	// IMediator.registerHandler(CrearCheckInHandler.class);
	// services.AddTransient(ICheckInFactory.class, CheckInFactory.class);
	// services.AddTransient(IcheckInRepository.class, IcheckInRepository.class);
	// }

	public static void AddApplication() {
		// INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
		IMediator.registerHandler(GetCheckInByIdHandler.class);
		IMediator.registerHandler(EditCheckInHandler.class);
		IMediator.registerHandler(DeleteCheckInHandler.class);
		IMediator.registerHandler(CrearCheckInHandler.class);
		IMediator.registerHandler(GetCheckInAllHandler.class);
		IServiceCollection.AddTransient(
			ICheckInFactory.class,
			CheckInFactory.class
		);
	}
}
