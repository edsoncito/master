import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDb.WriteDbContext;
import EF.Repository.CheckInRepository;
import EF.UnitOfWork;
import Repositories.IUnitOfWork;
import Repositories.IcheckInRepository;
import fourteam.extensions.IServiceCollection;

public class ExtensionsInfrastructure {

  public static void AddInfraestructure() {
    Extensions.AddApplication();
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(IWriteDbContext.class, WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(
      IcheckInRepository.class,
      CheckInRepository.class
    );
  }
}
