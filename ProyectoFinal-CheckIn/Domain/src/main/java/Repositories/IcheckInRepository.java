package Repositories;

import java.util.List;
import java.util.UUID;

import Modal.CheckIn;
import core.IRepository;

public interface IcheckInRepository extends IRepository<CheckIn, UUID> {

    //public void UpdateAsync(CheckIn obj);

    public List<CheckIn> GetAll();

    public CheckIn Delete(CheckIn checkIn);

    public CheckIn Update(CheckIn checkIn);

}
