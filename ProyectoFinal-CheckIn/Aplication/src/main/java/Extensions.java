import UseCases.Command.CheckIn.Create.CrearCheckInHandler;
import UseCases.Command.CheckIn.Delete.DeleteCheckInHandler;
import UseCases.Command.CheckIn.Edit.EditCheckInHandler;
import UseCases.DomainEventHandler.PublishIntegrationEventWhenCheckInCreadoHandler;
import UseCases.Queries.GetAll.GetCheckInAllHandler;
import UseCases.Queries.GetById.GetCheckInByIdHandler;
import factories.CheckInFactory;
import factories.ICheckInFactory;
import fourteam.extensions.IServiceCollection;
import fourteam.mediator.IMediator;

public class Extensions {

  public static void AddApplication() {
    IMediator.registerHandler(GetCheckInByIdHandler.class);
    IMediator.registerHandler(EditCheckInHandler.class);
    IMediator.registerHandler(DeleteCheckInHandler.class);
    IMediator.registerHandler(CrearCheckInHandler.class);
    IMediator.registerHandler(GetCheckInAllHandler.class);
    IMediator.registerHandler(PublishIntegrationEventWhenCheckInCreadoHandler.class);
    IServiceCollection.AddTransient(ICheckInFactory.class, CheckInFactory.class);
    Domain.addDomain();
  }
}
