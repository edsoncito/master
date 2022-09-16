package EF.Contexts;

import Modal.CheckIn;
import Modal.Equipaje;
import fourteam.db.DbContext;
import fourteam.db.DbSet;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) {
    super(dbContextClass);
  }

  public DbSet<CheckIn> checkIn;
  public DbSet<Equipaje> equipaje;
}
