import com.goodnight.background.entity.GoodNightUser;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class Test {
    @org.junit.Test
    public void asd() {

        List<GoodNightUser> list = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            GoodNightUser user = new GoodNightUser();
            user.setUid(String.valueOf(i));
            user.setPassword(String.valueOf(i));
            list.add(user);
        }
        for (GoodNightUser user1 : list) {
            System.out.println(user1.getUid()+user1.getPassword());
        }
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        temp_str=sdf.format(dt);
        if (temp_str.compareTo("12:00:00") >= 0){
            System.out.print(temp_str);
        }

    }


}
