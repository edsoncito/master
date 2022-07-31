package EF.Repository;

import static org.mockito.ArgumentMatchers.any;

import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDb.WriteDbContext;
import Modal.Baggage;
import fourteam.db.DbSet;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BaggageRepository_Test {

  @Before
  public void setup() {}

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  DbSet<Baggage> _baggage = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.baggage = _baggage;
  }

  @Test
  public void HandleBaggageRegistrado_Ok() throws HttpException {
    Double PesoEquipaje = 23.3;
    String NumeroEtiqueta = "sdfd33f3";
    String Descripcion = "sdsfsfse";
    IWriteDbContext bdTest = new WriteDbContext();
    BaggageRepository baggageRepository = new BaggageRepository(bdTest);
    Baggage objBaggage = new Baggage(PesoEquipaje, NumeroEtiqueta, Descripcion);
  }

  @Test
  public void GetAll_Test() {
    BaggageRepository baggageRepository = new BaggageRepository(bdTest);
    baggageRepository.GetAll();
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Create_Test() {
    BaggageRepository baggageRepository = new BaggageRepository(bdTest);
    baggageRepository.Create(any(Baggage.class));
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Update_Test() {
    BaggageRepository baggageRepository = new BaggageRepository(bdTest);
    baggageRepository.Update(new Baggage());
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Delete_Test() {
    BaggageRepository baggageRepository = new BaggageRepository(bdTest);
    baggageRepository.Delete(new Baggage());
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void FindByKey_Test() {
    BaggageRepository baggageRepository = new BaggageRepository(bdTest);
    baggageRepository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(baggageRepository);
  }
}
