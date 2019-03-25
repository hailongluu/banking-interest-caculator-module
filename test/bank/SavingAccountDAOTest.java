/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import bank.SavingAccount;
import bank.SavingAccountDAO;
import common.BankAccountGenID;
import common.DateTimeFomater;
import connection.DBconnection;
import customer.Customer;
import customer.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.runner.RunWith;
/**
 *
 * @author phamhoanganh
 */

public class SavingAccountDAOTest {
    private Connection connection;
    private int idStart;
    
    public SavingAccountDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            DBconnection dbConnection = new DBconnection();
            this.connection = dbConnection.getConnect();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @After
    public void tearDown() {
        String deleteSavingAccount = "DELETE FROM savingaccount WHERE id > ?;";
        try {
            System.out.println(idStart);
            PreparedStatement pre = connection.prepareStatement(deleteSavingAccount);
            pre.setString(1, Integer.toString(idStart));
            pre.executeUpdate();
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Test of addSavingAccount method, of class SavingAccountDAO.
     */

    @Test
    public void testAddSavingAccount() {
        System.out.println("addSavingAccount");
        
        SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
        BankAccountGenID bag = new BankAccountGenID();
        this.idStart = bag.lastSavingAccount;
        Customer customer = new Customer(1,null, "abc","abc","11111","11111");
        SavingAccount sa = new SavingAccount(bag.getNewSavingAccountId(),10000,8.7,2,"Deposite", customer,new Date());
        savingAccountDAO.addSavingAccount(sa);
        int idNew = sa.getId();

        String getSavingAccount = "SELECT * FROM savingaccount WHERE id = ?;";
        try {
            DateTimeFomater dtf = new DateTimeFomater();
            PreparedStatement pre = connection.prepareStatement(getSavingAccount);
            pre.setString(1, Integer.toString(idNew));
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                assertEquals(rs.getInt(1), idNew);
                assertEquals(rs.getDouble(3), 10000, 0.001);
                assertEquals(rs.getDouble(4), 8.7, 0.001);
                assertEquals(rs.getInt(5), 2);
                assertEquals(rs.getInt(6), 1);
                assertEquals(rs.getString(7), "Deposite");
            }
            
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex) {
            fail("Got exception");
        }
        
    }

    /**
     * Test of getSavingAccountByIdCard method, of class SavingAccountDAO.
     */
//    @Test
//    public void testGetSavingAccountByIdCard() {
//        System.out.println("getSavingAccountByIdCard");
//        String idCard = "";
//        SavingAccountDAO instance = new SavingAccountDAO();
//        List<SavingAccount> expResult = null;
//        List<SavingAccount> result = instance.getSavingAccountByIdCard(idCard);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSavingAccountByAccountNumber method, of class SavingAccountDAO.
//     */
//    @Test
//    public void testGetSavingAccountByAccountNumber() {
//        System.out.println("getSavingAccountByAccountNumber");
//        String number = "";
//        SavingAccountDAO instance = new SavingAccountDAO();
//        SavingAccount expResult = null;
//        SavingAccount result = instance.getSavingAccountByAccountNumber(number);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
