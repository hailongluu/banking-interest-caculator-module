/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import connection.DBconnection;
import customer.Customer;
import customer.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailo
 */
public class SavingAccountDAO {

    private Connection connection;

    public SavingAccountDAO() {
        try {
            DBconnection dbConnection = new DBconnection();
            this.connection = dbConnection.getConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addSavingAccount(SavingAccount account) {
        try {
            String addSavingAccount = "INSERT INTO savingaccount ( `number`, `cash`, `interestrate`, `term`, `idcustomer`, `kind`, `date`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pre = connection.prepareStatement(addSavingAccount);
            pre.setString(1, account.getNumber());
            pre.setDouble(2, account.getCash());
            pre.setFloat(3, account.getInterestRate());
            pre.setInt(4, account.getTerm());
            pre.setInt(5, account.getCustomer().getId());
            pre.setString(6, account.getKind());
            pre.setString(7, account.getDate().toString());
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SavingAccount> getSavingAccountByIdCard(int idCard) {

        return null;
    }

    public SavingAccount getSavingAccountByAccountNumber(String number) {
        try {
            SavingAccount savingAccount=null;
            String getSavingAccount = "SELECT * FROM savingaccount WHERE number = ?;";
            PreparedStatement pre = connection.prepareStatement(getSavingAccount);
            pre.setString(1, number);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                savingAccount = new SavingAccount(rs.getInt(1), rs.getString(1), rs.getDouble(2), rs.getFloat(3), rs.getInt(4), rs.getString(6), new CustomerDAO().getCustomerByIdCard(rs.getInt(5)), null);
            }
            return savingAccount;
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
