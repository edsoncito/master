package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Modal.Equipaje;
import Repositories.IequipajeRepository;
import fourteam.db.DbSet;
import java.util.List;
import java.util.UUID;

public class EquipajeRepository implements IequipajeRepository {

  private DbSet<Equipaje> _equipaje;

  public EquipajeRepository(IWriteDbContext database) {
    _equipaje = database.equipaje;
  }

  @Override
  public Equipaje FindByKey(UUID key) {
    return _equipaje.Single(obj -> obj.key.equals(key));
  }

  @Override
  public void Create(Equipaje obj) {
    _equipaje.Add(obj);
  }

  @Override
  public List<Equipaje> GetAll() {
    return _equipaje.All();
  }

  @Override
  public Equipaje Delete(Equipaje obj) {
    _equipaje.Delete((it -> it.key.equals(obj.key)));
    return obj;
  }

  @Override
  public Equipaje Update(Equipaje obj) {
    _equipaje.Update(obj, (it -> it.key.equals(obj.key)));
    return obj;
  }
}
