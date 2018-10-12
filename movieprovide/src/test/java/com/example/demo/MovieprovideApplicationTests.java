package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.DemoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieprovideApplicationTests {

	@Autowired
	private DemoDao demoDao;
	@Test
	public void contextLoads() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long lo = System.currentTimeMillis();

		String d = simpleDateFormat.format(lo);

		Date date = null;
		try {
			date = simpleDateFormat.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		Date date = new Date(System.currentTimeMillis());

//		date = new Date(simpleDateFormat.format(date));
		demoDao.sava(date);

	}

	@Test
	public void test() {
		UserInfo userInfo = new UserInfo();
		userInfo.setCode(200);
		userInfo.setMsg("Successful");
		Map<String,Object> data = new HashMap<>();
		data.put("iconUrl","https://www.abc.com/123.png");
		data.put("nickname","gameboy");
		Map<String,Object> gen = new HashMap<>();
		gen.put("selectedKey","1");
		data.put("gender",gen);
		userInfo.setData(data);
		String json = JSON.toJSONString(userInfo);
		System.out.println(json);

	}
}
