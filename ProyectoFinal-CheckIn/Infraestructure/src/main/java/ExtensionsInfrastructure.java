import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDb.WriteDbContext;
import EF.Repository.CheckInRepository;
import EF.UnitOfWork;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import UseCases.Consumers.VueloCreadoConsumer;
import fourteam.extensions.IServiceCollection;

public class ExtensionsInfrastructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(IcheckInRepository.class, CheckInRepository.class);
    Extensions.AddApplication();
    AddRabbitMq();
  }

  private static void AddRabbitMq() {
    IServiceCollection.AddMassTransit(config -> {
      // config.AddConsumer(CheckInCreadoConsumer.class).Endpoint(endpoint -> {
      // endpoint.Name = CheckInCreadoConsumer.QueueName;
      // });
      config.AddConsumer(VueloCreadoConsumer.class);

      config.UsingRabbitMq((context, cfg) -> {
        cfg.Host = "192.168.3.2";
        cfg.User = "admin";
        cfg.Password = "admin";
        // cfg.ReceiveEndpoint(CheckInCreadoConsumer.QueueName, endpoint -> {
        //   endpoint.ConfigureConsumer(CheckInCreadoConsumer.class);
        // });
      });
    });
  }
}
