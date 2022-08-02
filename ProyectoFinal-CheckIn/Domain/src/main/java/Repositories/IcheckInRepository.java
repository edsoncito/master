package Repositories;

import Modal.CheckIn;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IcheckInRepository extends IRepository<CheckIn, UUID> {
  // public void UpdateAsync(CheckIn obj);

  public List<CheckIn> GetAll();

  public CheckIn Delete(CheckIn checkIn);

  public CheckIn Update(CheckIn checkIn);
}
