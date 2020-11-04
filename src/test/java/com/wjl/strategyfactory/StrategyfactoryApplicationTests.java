package com.wjl.strategyfactory;

import com.wjl.strategyfactory.factory.NumFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StrategyfactoryApplicationTests {

	@Autowired
	NumFactory factory;
	@Test
	void contextLoads() {
		/**
		 * 去除if else
		 */
//		if("1".equals("1")){
//
//		}else if("2".equals("2")){
//
//		}
		String num = factory.getLicRetInfo("1").getNum();
		System.out.println(num);
	}

}
