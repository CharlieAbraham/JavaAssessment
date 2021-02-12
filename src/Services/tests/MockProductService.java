package Services.tests;

import Interfaces.ProductPricingService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
 public class MockProductService{

    @Mock
    ProductPricingService proserv;

    @org.junit.Test
    public void price(){
        when(proserv.price ("High","good")).thenReturn(1000.5);
        Assert.assertEquals(proserv.price("High","good"),1000.5,0);
        when(proserv.price ("High","good",4,2020)).thenReturn(2000.5);
        Assert.assertEquals(proserv.price("High","good",4,2020),2000.5,0);

    }

}









