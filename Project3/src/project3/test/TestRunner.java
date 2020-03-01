package project3.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestFailure;
import junit.framework.TestSuite;

import java.util.Enumeration;

/**
 * This class runs the tests in the MyUnitTest class
 */
public class TestRunner {
	public static void main(String[] args) {
		runAllTests();
		// runSelectedTests();
	}

	private static void runAllTests() {
		Result result = JUnitCore.runClasses(MyUnitTest.class);

		if(result.wasSuccessful()) {
			printSuccess(result.getRunCount());
		}else{
			printFailures(result.getFailureCount(), result.getRunCount());
			for (Failure failure : result.getFailures()) {
				String failedTest = failure.getTestHeader();
				failedTest = failedTest.substring(0, failedTest.indexOf("("));
				System.out.println("Failed test: " + failedTest);
				System.out.println(failure.getMessage());
				System.out.println("");
			}
			System.out.println("===========================================\n");
		}
	}

	private static void runSelectedTests() {
		TestSuite suite= new TestSuite();
		suite.addTest(new MyUnitTest("testUniqueLicensePlates"));
		suite.addTest(new MyUnitTest("testMyTestTwo"));

		TestResult result = new TestResult();
		suite.run(result);

		if(result.wasSuccessful()) {
			printSuccess(result.runCount());
		}else{
			printFailures(result.failureCount(), result.runCount());
			Enumeration<TestFailure> e = result.failures();
			while (e.hasMoreElements()) {
				TestFailure failure = e.nextElement();
				String failedTest = failure.toString();
				failedTest = failedTest.substring(0, failedTest.indexOf("("));
				System.out.println("Failed test: " + failedTest);
				System.out.println(failure.exceptionMessage());
				System.out.println("");
			}
			System.out.println("===========================================\n");
		}
	}

	private static void printSuccess(int numTests){
		System.out.println("");
		System.out.println("===========================================");
		System.out.println("     All "+numTests+" test(s) passed successully!");
		System.out.println("===========================================");
	}

	private static void printFailures(int failures, int total){
		System.out.println("");
		System.out.println("===========================================");
		System.out.println("RESULT: " + failures + "/" + total + " test(s) failed");
		System.out.println("===========================================");
	}
}
