package EF.Repository;

import java.util.List;
import java.util.UUID;
import EF.Contexts.IWriteDbContext;
import Modal.CheckIn;
import Repositories.IcheckInRepository;
import fourteam.db.DbSet;

public class CheckInRepository implements IcheckInRepository {

    private DbSet<CheckIn> _checkIn;

    public CheckInRepository(IWriteDbContext database) {
        _checkIn = database.checkIn;
    }

    @Override
    public CheckIn FindByKey(UUID key) {
        return _checkIn.Single(obj -> obj.key.equals(key));
    }

    @Override
    public void Create(CheckIn obj) {
        _checkIn.Add(obj);
    }

    @Override
    public List<CheckIn> GetAll() {
        return _checkIn.All();
    }

    @Override
    public CheckIn Delete(CheckIn obj) {
        _checkIn.Delete((it -> it.key.equals(obj.key)));
        return obj;
    }

    @Override
    public CheckIn Update(CheckIn obj) {
        _checkIn.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;
    }
}