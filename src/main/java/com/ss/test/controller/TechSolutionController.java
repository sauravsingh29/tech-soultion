/**
 * 
 */
package com.ss.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.test.reader.ReadInputData;
import com.ss.test.solver.ProblemSolver;

/**
 * @author saurav
 *
 */
@RestController
public class TechSolutionController {

	@Autowired
	@Qualifier("dataReader")
	private ReadInputData dataReader;

	@GetMapping(value = "/maxstat")
	public String process() {
		int maxStatisfaction = 0;
		try {
			int maxTime = dataReader.getMaxTime();
			final List<Integer> stsList = new ArrayList<>();
			final List<Integer> timeList = new ArrayList<>();
			dataReader.loadSatisfactionAndTimeArray(stsList, timeList);
			int size = stsList.size();
			// considering both list is having same size as per given data
			Integer[] sts = stsList.toArray(new Integer[size]);
			Integer[] time = timeList.toArray(new Integer[size]);
			maxStatisfaction = ProblemSolver.findMaxStatisfaction(maxTime, time, sts, size);
			System.out.println("Maximum Satisfaction Value [ " + maxStatisfaction
					+ " ] using provided data set");
		}
		catch (Exception e) {
			System.err.println("Exeception while processing, Exception :: " + e);
		}
		return String.valueOf(maxStatisfaction);

	}

}
