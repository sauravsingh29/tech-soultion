/**
 * 
 */
package com.ss.test.reader;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * This class will load the input data from given test file
 * @author saurav
 *
 */
@Component("dataReader")
public class ReadInputData {

	@Autowired
	private ApplicationContext applicationContext;
	
	/**
	 * Find out max time given as per requirement from give data.txt file
	 * @return
	 * @throws IOException
	 */
	public int getMaxTime() throws IOException{
		Scanner scanner = new Scanner(applicationContext.getResource("classpath:data.txt").getFile());
		
		int maxTime = 0;
		try{
			while (scanner.hasNext()) {
				String inp = (String) scanner.next();
				String[] split = inp.split("\\s+");
				//considering first line and first column is given max time in which need to find out max satisfaction.No null value provided in data file
				maxTime = Integer.valueOf(split[0]);
				break;
			}
		}finally {
			scanner.close();
		}
		return maxTime;
	}
	
	public void loadSatisfactionAndTimeArray(final List<Integer> stsList, final List<Integer> timeList) throws IOException {
		Scanner scanner = new Scanner(applicationContext.getResource("classpath:data.txt").getFile());
		boolean isHeader = true;
		try {
			while (scanner.hasNext()) {
				// skipping first line
				if (isHeader == true) {
					scanner.nextLine();
					isHeader = false;
					continue;
				}
				String inp = (String) scanner.nextLine();
				String[] split = inp.split("\\s+");
				// considering from second line onwards and first column of each is given satisfaction with time.No null value provided in data file
				stsList.add(Integer.valueOf(split[0]));
				timeList.add(Integer.valueOf(split[1]));
			}
		} finally {
			scanner.close();
		}
	}
}
