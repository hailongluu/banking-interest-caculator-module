
import bank.Account;
import bank.AccountDAO;
import bank.SavingAccountDAO;
import common.BankAccountGenID;
import common.PasswordHash;
import connection.DBconnection;
import customer.CustomerDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class AccountDAOTest {
    private Connection connection;
    AccountDAO accountDAO;
    BankAccountGenID bag;
    CustomerDAO customerDAO;

    public AccountDAOTest() {
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
        accountDAO = new AccountDAO();
    }

    @After
    public void tearDown() throws SQLException {
        connection.rollback();
    }

    /**
     * Test of addSavingAccount method, of class SavingAccountDAO.
     */
    @Test
    public void validLoginTest() {
        String username = "account1@bank.com";
        String password = PasswordHash.md5Hash("1234");
        boolean expectedResult = true;
        boolean result = accountDAO.authenticateAccount(username, password);
        Assert.assertEquals(expectedResult, result);
//        Account account = new Account(username, password, 0, 0)
    }
}
