package com.immigration.employee;

import com.immigration.employee.shared.DateUtils;
import com.immigration.employee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlertMeApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserRepository userRepository;

    @Test
    public void getUser() {
        System.out.println(userRepository.findAll());
    }

    @Test
    public void testDateofExpiry() throws ParseException {
        Date tomorrow = new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-22");
        System.out.println(tomorrow);
        System.out.println( DateUtils.isWithinDaysFuture(tomorrow, 60));
    }

}
