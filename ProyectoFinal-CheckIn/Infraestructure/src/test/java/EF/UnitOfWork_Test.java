package EF;

import EF.Contexts.IWriteDbContext;
import EF.UnitOfWork;
import core.DomainEvent;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class UnitOfWork_Test {

    private IWriteDbContext _context = Mockito.mock(IWriteDbContext.class);
    private Mediator _mediator = Mockito.mock(Mediator.class);

    @Test
    public void constructorVoid_accept() {
        UnitOfWork unitOfWork = new UnitOfWork(_context, _mediator);
        Assert.assertNotNull(unitOfWork);

    }

    @Test
    public void commit_accept() {
        UnitOfWork unitOfWork = new UnitOfWork(_context, _mediator);
        List<Object> list = new ArrayList<>();
        list.add(new DomainEvent());
        when(_context.getDomainEvents()).thenReturn(list);
        try {
            unitOfWork.commit();
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void commit_denied() {
        UnitOfWork unitOfWork = new UnitOfWork(_context, _mediator);
        try {
            unitOfWork.commit();
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
