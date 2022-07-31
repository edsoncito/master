package Repositories;

import Modal.Baggage;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IbaggageRepository extends IRepository<Baggage, UUID> {
  public List<Baggage> GetAll();

  public Baggage Delete(Baggage baggage);

  public Baggage Update(Baggage baggage);
}
