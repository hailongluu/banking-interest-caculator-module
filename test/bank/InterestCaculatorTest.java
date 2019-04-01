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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author hailongluu
 */
public class InterestCaculatorTest {
    SavingAccountDAO savingAccountDAO;
    InterestCaculator interestCaculator;
    DateTimeFomater dateTimeFomater;

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of caculateInterest method, of class InterestCaculator.
     */
    @Test
    public void testCaculateInterest() { // in term có ngày dư
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000001");
        Date endDate = dateTimeFomater.convertStringToDate("2019-04-01");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 8036000;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateInterest1() { // in term không có ngày dư
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000001");
        Date endDate = dateTimeFomater.convertStringToDate("2019-03-20");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 8000000;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateInterest2() { // in term = 0
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000002");
        Date endDate = dateTimeFomater.convertStringToDate("2019-04-01");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 1033333;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateInterest3() { // in term > 0 chưa đủ kì hạn
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000003");
        Date endDate = dateTimeFomater.convertStringToDate("2019-04-01");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 1033333;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateInterest4() { // in term > 0 đạt kì hạn >=2 lần không có ngày dư
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000004");
        Date endDate = dateTimeFomater.convertStringToDate("2019-03-20");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 7744400;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateInterest5() { // in term > 0 đạt kì hạn >=2 lần có ngày dư
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000004");
        Date endDate = dateTimeFomater.convertStringToDate("2019-04-01");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 7780315;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateInterest6() { // test vừa lập vừa rút luôn
        System.out.println("caculateInterest");
        SavingAccount savingAccount = savingAccountDAO.getSavingAccountByAccountNumber("HN000001");
        Date endDate = dateTimeFomater.convertStringToDate("2018-03-25");
        InterestCaculator instance = new InterestCaculator();
        double expResult = 0;
        double result = (long) instance.caculateInterest(savingAccount, endDate);
        assertEquals(expResult, result, 0.0);
    }
}
