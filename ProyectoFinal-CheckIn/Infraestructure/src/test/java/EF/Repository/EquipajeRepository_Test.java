package EF.Repository;

import static org.mockito.ArgumentMatchers.any;

import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDb.WriteDbContext;
import Modal.Equipaje;
import fourteam.db.DbSet;
import fourteam.http.Exception.HttpException;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EquipajeRepository_Test {

  @Before
  public void setup() {}

  IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
  DbSet<Equipaje> _baggage = Mockito.mock(DbSet.class);

  @Before
  public void setUp() {
    bdTest.equipaje = _baggage;
  }

  @Test
  public void HandleBaggageRegistrado_Ok() throws HttpException {
    Double PesoEquipaje = 23.3;
    String NumeroEtiqueta = "sdfd33f3";
    String Descripcion = "sdsfsfse";
    IWriteDbContext bdTest = new WriteDbContext();
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    Equipaje objBaggage = new Equipaje(PesoEquipaje, NumeroEtiqueta, Descripcion);
  }

  @Test
  public void GetAll_Test() {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.GetAll();
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Create_Test() {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.Create(any(Equipaje.class));
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Update_Test() {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.Update(new Equipaje());
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void Delete_Test() {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.Delete(new Equipaje());
    Assert.assertNotNull(baggageRepository);
  }

  @Test
  public void FindByKey_Test() {
    EquipajeRepository baggageRepository = new EquipajeRepository(bdTest);
    baggageRepository.FindByKey(UUID.randomUUID());
    Assert.assertNotNull(baggageRepository);
  }
}
