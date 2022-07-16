package EF.Repository;

import EF.Contexts.IWriteDbContext;
import EF.Contexts.MongoDb.WriteDbContext;
import Modal.CheckIn;
import fourteam.db.DbSet;
import fourteam.http.Exception.HttpException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.UUID;
import static org.mockito.ArgumentMatchers.any;

public class CheckInRepository_Test {

    @Before
    public void setup() {
    }

    IWriteDbContext bdTest = Mockito.mock(IWriteDbContext.class);
    DbSet<CheckIn> _CheckIn = Mockito.mock(DbSet.class);

    @Before
    public void setUp() {
        bdTest.checkIn = _CheckIn;
    }

    @Test
    public void HandleCheckInRegistrado_Ok() throws HttpException {

        String CodigoSeguridad = "dsfds";
        int Asiento = 33;
        Boolean EstadoPaciente = true;
        String Descripcion = "haskjhfaksjf";

        IWriteDbContext bdTest = new WriteDbContext();
        CheckInRepository checkInRepository = new CheckInRepository(bdTest);
        CheckIn objCheckIn = new CheckIn(CodigoSeguridad, EstadoPaciente, Descripcion, Asiento);
        objCheckIn.AgregarItem(3.2, "Sdfds", "asdasfasa");
    }

    @Test
    public void GetAll_Test() {
        CheckInRepository checkInRepository = new CheckInRepository(bdTest);
        checkInRepository.GetAll();
        Assert.assertNotNull(checkInRepository);
    }

    @Test
    public void Create_Test(){
        CheckInRepository checkInRepository = new CheckInRepository(bdTest);
        checkInRepository.Create(any(CheckIn.class));
        Assert.assertNotNull(checkInRepository);
    }

    @Test
    public void Update_Test(){
        CheckInRepository checkInRepository = new CheckInRepository(bdTest);
        checkInRepository.Update(new CheckIn());
        Assert.assertNotNull(checkInRepository);
    }

    @Test
    public void Delete_Test(){
        CheckInRepository checkInRepository = new CheckInRepository(bdTest);
        checkInRepository.Delete(new CheckIn());
        Assert.assertNotNull(checkInRepository);
    }

    @Test
    public void FindByKey_Test(){
        CheckInRepository checkInRepository = new CheckInRepository(bdTest);
        checkInRepository.FindByKey(UUID.randomUUID());
        Assert.assertNotNull(checkInRepository);
    }

}
