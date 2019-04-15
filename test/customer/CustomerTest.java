/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import bank.SavingAccountDAO;
import common.BankAccountGenID;
import connection.DBconnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ASUS
 */
public class CustomerTest {
    private Connection connection;
    SavingAccountDAO savingAccountDAO;
    BankAccountGenID bag;
    CustomerDAO customerDAO;
    
    @Before
    public void setUp() throws SQLException, ClassNotFoundException {

        this.connection = new DBconnection().getConnect();
        connection.setAutoCommit(false);
        customerDAO = new CustomerDAO(connection);
        savingAccountDAO = new SavingAccountDAO(connection);
        bag = new BankAccountGenID();
    }

    @After
    public void tearDown() throws SQLException {
        connection.rollback();
    }
    
    @Test
    public void testAddCustomer() {
        int newCustomerId = bag.getNewCustomerId();
        Customer customer = new Customer(newCustomerId, "Nguyen Minh Hieu", "so 12 ngo 60", "12345789", "987654321");
        boolean expectedResult = true;
        boolean result = customerDAO.addCustomer(customer);
        assertEquals(expectedResult, result);
        
        Customer customerAfter = customerDAO.getCustomerByGeneratedId(customer.getId());
        assertEquals(customer, customerAfter);
    }
    
    @Test
    public void testDeleteCustomer() {
        Customer customer = customerDAO.getCustomerByGeneratedId(1);
        assertNotNull(customer);
        boolean expectedResult = true;
        boolean deleteResult1 = savingAccountDAO.deleteSavingAccountByCustomerId(customer.getId());
        assertEquals(expectedResult, deleteResult1);
        boolean deleteResult2 = customerDAO.deleteCustomer(customer);
        assertEquals(expectedResult, deleteResult2);
        customer = customerDAO.getCustomerByGeneratedId(1);
        assertNull(customer);
    }
}
