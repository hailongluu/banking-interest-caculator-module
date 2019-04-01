/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import common.BankAccountGenID;
import common.DateTimeFomater;
import connection.DBconnection;
import customer.Customer;
import customer.CustomerDAO;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class SavingAccountDAOTest {
    private Connection connection;
    SavingAccountDAO savingAccountDAO;
    BankAccountGenID bag;
    CustomerDAO customerDAO;

    public SavingAccountDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {

        this.connection = new DBconnection().getConnect();
        connection.setAutoCommit(false);
        savingAccountDAO = new SavingAccountDAO(connection);
        customerDAO = new CustomerDAO(connection);
        bag = new BankAccountGenID();
    }

    @After
    public void tearDown() throws SQLException {
        connection.rollback();
    }

    /**
     * Test of addSavingAccount method, of class SavingAccountDAO.
     */

    @Test
    public void testAddSavingAccount() {
        System.out.println("addSavingAccount");
//        Customer customer = new Customer(1, "Nguyen Van A", "HN", "0123456789", "1234567890");
        Customer customer = customerDAO.getCustomerByGeneratedId(1);
        int accountId = bag.getNewSavingAccountId();
        SavingAccount account = new SavingAccount(accountId, (double) 100000000, 1, 0, "NoTerm", customer, DateTimeFomater.getCurrentDate());

        boolean expResult = true;
        boolean result = savingAccountDAO.addSavingAccount(account);
        assertEquals(result, expResult);

        //getting account which is recent inserted in DB
        SavingAccount recentInsertedAccount = savingAccountDAO.getSavingAccountByAccountNumber(account.getNumber());
        assertEquals(account, recentInsertedAccount);
        // TODO review the generated test code and remove the default call to fail.
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
