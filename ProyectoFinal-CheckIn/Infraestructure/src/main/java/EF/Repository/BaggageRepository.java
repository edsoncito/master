package EF.Repository;

import EF.Contexts.IWriteDbContext;
import Modal.Baggage;
import Repositories.IbaggageRepository;
import fourteam.db.DbSet;

import java.util.List;
import java.util.UUID;

public class BaggageRepository implements IbaggageRepository {

    private DbSet<Baggage> _baggage;

    public BaggageRepository(IWriteDbContext database) {
        _baggage = database.baggage;
    }

    @Override
    public Baggage FindByKey(UUID key) {
        return _baggage.Single(obj -> obj.key.equals(key));
    }

    @Override
    public void Create(Baggage obj) {
        _baggage.Add(obj);
    }

    @Override
    public List<Baggage> GetAll() {
        return _baggage.All();
    }

    @Override
    public Baggage Delete(Baggage obj) {
        _baggage.Delete((it -> it.key.equals(obj.key)));
        return obj;
    }

    @Override
    public Baggage Update(Baggage obj) {
        _baggage.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;
    }
}
