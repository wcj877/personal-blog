package com.example.personalblog;

import com.example.personalblog.utils.DataTimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataTest {

    @Test
    public void t1(){
        String dataTime = DataTimeUtil.getDataTime();
        System.out.println(dataTime);
    }

}
