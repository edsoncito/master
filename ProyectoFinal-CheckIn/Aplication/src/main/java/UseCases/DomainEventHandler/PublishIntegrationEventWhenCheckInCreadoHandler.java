package UseCases.DomainEventHandler;

import Events.CheckInCreado;
import core.ConfirmedDomainEvent;
import fourteam.massTransit.IPublishEndpoint;
import fourteam.mediator.Notification;
import fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenCheckInCreadoHandler
  implements NotificationHandler<ConfirmedDomainEvent<CheckInCreado>> {

  private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenCheckInCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    CheckInCreado checkInCreado = (CheckInCreado) event.DomainEvent;
    IntegrationEvents.AeronaveCreado evento = new IntegrationEvents.AeronaveCreado();
    evento.setKeyAeronave(checkInCreado.getKey());
    this.publishEndpoint.Publish(event);
  }
}
