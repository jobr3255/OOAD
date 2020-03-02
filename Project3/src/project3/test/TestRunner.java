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
