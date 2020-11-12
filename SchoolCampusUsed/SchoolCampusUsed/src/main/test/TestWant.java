import com.dao.UserDao;
import com.dao.WantBuyDao;
import com.domain.User;
import com.domain.WantBuy;
import com.service.UserService;
import com.service.WantBuyService;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.PrintStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestWant {
    @Autowired
    private WantBuyService wantBuyService;
    private UserServiceImpl userServiceImpl;
    private GoodsServiceImpl goodsService;

    @Test
    public void test1(){
        List<WantBuy> all = wantBuyService.findAll();
        System.out.println(all);
    }

    @Test
    public void test2(){
        wantBuyService.deleteMessageById(3);
    }

    @Test
    public void test3(){
        String username = "xuanyu45645";
        String message = "asdada";
        WantBuy wantBuy = new WantBuy();
        wantBuy.setUsername(username);
        wantBuy.setMessage(message);
        int i = wantBuyService.addMessage(wantBuy);
        System.out.println("结果是"+i);
    }

    @Test
    public void test4(){

    }
}
