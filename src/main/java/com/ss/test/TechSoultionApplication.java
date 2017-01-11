package com.ss.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ss.test.reader.ReadInputData;
import com.ss.test.solver.ProblemSolver;

@SpringBootApplication
public class TechSoultionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TechSoultionApplication.class, args);
	}

	@Autowired
	@Qualifier("dataReader")
	private ReadInputData dataReader;

	@Override
	public void run(String... arg0) throws Exception {
		try{
			int maxTime = dataReader.getMaxTime();
			final List<Integer> stsList = new ArrayList<>();
			final List<Integer> timeList = new ArrayList<>();
			dataReader.loadSatisfactionAndTimeArray(stsList, timeList);
			int size = stsList.size();
			// considering both list is having same size as per given data
			Integer[] sts = stsList.toArray(new Integer[size]);
			Integer[] time = timeList.toArray(new Integer[size]);
			int maxStatisfaction = ProblemSolver.findMaxStatisfaction(maxTime, time, sts, size);
			System.out.println("Maximum Satisfaction Value [ " + maxStatisfaction + " ] using provided data set");
		}catch (Exception e){
			System.err.println("Exeception while processing, Exception :: "+ e);
		}
	
	}
}
