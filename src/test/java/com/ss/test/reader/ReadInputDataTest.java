/**
 * 
 */
package com.ss.test.reader;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author saurav
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadInputDataTest {
	
	@Autowired
	@Qualifier("dataReader")
	private ReadInputData dataReader;


	@Test
	public void test_maxTime_success() throws IOException {
		assertEquals(10000, dataReader.getMaxTime());
	}
	
	@Test
	public void test_loadSatisfactionAndTimeArray_success() throws IOException {
		final List<Integer> stsList = new ArrayList<>();
		final List<Integer> timeList = new ArrayList<>();
		dataReader.loadSatisfactionAndTimeArray(stsList, timeList);
		assertEquals(stsList.size(), timeList.size());
	}

}
