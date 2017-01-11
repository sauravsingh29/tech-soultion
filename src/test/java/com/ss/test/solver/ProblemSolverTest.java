package com.ss.test.solver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author saurav
 *
 */
public class ProblemSolverTest {

	Integer[] sts = null;
	Integer[] time = null;

	@Before
	public void setUp() {
		sts = new Integer[] { 10, 20, 30 };
		time = new Integer[] { 1, 2, 3 };
	}

	@Test
	public void test_findMaxStatisfaction_success() {
		int maxTime = 5;
		int size = time.length;
		assertEquals(50, ProblemSolver.findMaxStatisfaction(maxTime, time, sts, size));
	}

	@Test
	public void test_findMaxStatisfaction_fail() {
		int maxTime = 2;
		int size = time.length;
		assertNotEquals(50, ProblemSolver.findMaxStatisfaction(maxTime, time, sts, size));
	}

	@Test(expected = NullPointerException.class)
	public void test_findMaxStatisfaction_exception() {
		int maxTime = 2;
		int size = time.length;
		assertNotEquals(50, ProblemSolver.findMaxStatisfaction(maxTime, null, sts, size));
	}
}
