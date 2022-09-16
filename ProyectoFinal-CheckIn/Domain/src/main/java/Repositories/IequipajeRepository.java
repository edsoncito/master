package Repositories;

import Modal.Equipaje;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IequipajeRepository extends IRepository<Equipaje, UUID> {
  public List<Equipaje> GetAll();

  public Equipaje Delete(Equipaje equipaje);

  public Equipaje Update(Equipaje equipaje);
}
