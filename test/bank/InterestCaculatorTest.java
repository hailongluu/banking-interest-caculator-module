/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import common.DateTimeFomater;
import connection.DBconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import excel.InterestTestDataCollector;
import junit.framework.TestListener;
import junit.framework.TestResult;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author hailongluu
 */
public class InterestCaculatorTest {
    SavingAccountDAO savingAccountDAO;
    InterestCaculator interestCaculator;
    DateTimeFomater dateTimeFomater;
    InterestTestDataCollector interestTestDataCollector;
    TestResult testResult;

    public InterestCaculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        Connection connection = new DBconnection().getConnect();
        savingAccountDAO = new SavingAccountDAO(connection);
        interestCaculator = new InterestCaculator();
        dateTimeFomater = new DateTimeFomater();
        interestTestDataCollector = new InterestTestDataCollector();
        testResult = new TestResult();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of caculateInterest method, of class InterestCaculator.
     */
    @Test
    public void testCaculateInterest1() {

        for (int i = 1; i <= 75; i++) {
            int rowNum = i;
            Map<Integer, String> testData;
            testData = interestTestDataCollector.getData(rowNum);
//            SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber(testData.get(InterestTestDataCollector.DATA_ACCOUNTNUMBER));
            InterestCaculator instance = new InterestCaculator();

            String accountnumber = testData.get(InterestTestDataCollector.DATA_ACCOUNTNUMBER);
            double cash = Double.parseDouble(testData.get(InterestTestDataCollector.DATA_CASH));
            double interest = Double.parseDouble(testData.get(InterestTestDataCollector.DATA_INTERESTRATE));
            int term = Integer.parseInt(testData.get(InterestTestDataCollector.DATA_TERM));
            Date startDate = dateTimeFomater.convertStringToDate(testData.get(InterestTestDataCollector.DATA_STARTDATE));
            Date endDate = dateTimeFomater.convertStringToDate(testData.get(InterestTestDataCollector.DATA_ENDATE));
            double expResult = Double.parseDouble(testData.get(InterestTestDataCollector.DATA_EXPRESULT));
            SavingAccount savingAccount = new SavingAccount(accountnumber,cash,interest,term,startDate);
            double result = (long) instance.caculateInterest(savingAccount, endDate);
            String testNote = testData.get(InterestTestDataCollector.DATA_NOTE);
            System.out.println(testNote);
            if (result == expResult) {
                interestTestDataCollector.addResult(rowNum, result, "yes");
            } else interestTestDataCollector.addResult(rowNum, result, "no");

//            assertEquals(expResult, result, 0.0);
        }
    }


}
