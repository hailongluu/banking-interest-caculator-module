/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import common.DateTimeFomater;
import connection.DBconnection;
import customer.Customer;
import customer.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hailo
 */
public class SavingAccountDAO {

    private Connection connection;

    public SavingAccountDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addSavingAccount(SavingAccount account) {
        DateTimeFomater dtf = new DateTimeFomater();

        try {
            String addSavingAccount = "INSERT INTO savingaccount ( `number`, `cash`, `interestrate`, `term`, `idcustomer`, `kind`, `date`, `iswithdrawned`,`id`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?);";
            PreparedStatement pre = connection.prepareStatement(addSavingAccount);
            pre.setString(1, account.getNumber());
            pre.setDouble(2, account.getCash());
            pre.setDouble(3, account.getInterestRate());
            pre.setInt(4, account.getTerm());
            pre.setInt(5, account.getCustomer().getId());
            pre.setString(6, account.getKind());
            pre.setString(7, dtf.convertDateToString(account.getDate()));
            pre.setInt(8, account.getIsWithdrawned());
            pre.setInt(9,account.getId());
            pre.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SavingAccount> getSavingAccountByIdCard(String idCard) {
        DateTimeFomater dtf = new DateTimeFomater();
        try {
            List<SavingAccount> listSavingAccounts = new ArrayList<>();
            String getSavingAccount = "SELECT s.* FROM savingaccount s, customer c WHERE s.idcustomer = c.id and c.idcard = ?;";
            PreparedStatement pre = connection.prepareStatement(getSavingAccount);
            pre.setString(1, idCard);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                SavingAccount savingAccount = new SavingAccount(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(7),
                        new CustomerDAO(connection).getCustomerByGeneratedId(rs.getInt(6)),
                        dtf.convertStringToDate(rs.getString(8)),
                        rs.getInt(9));
                listSavingAccounts.add(savingAccount);
            }
            return listSavingAccounts;
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SavingAccount getSavingAccountByAccountNumber(String number) {
        DateTimeFomater dtf = new DateTimeFomater();
        try {
            SavingAccount savingAccount = null;
            String getSavingAccount = "SELECT * FROM savingaccount WHERE number = ?;";
            PreparedStatement pre = connection.prepareStatement(getSavingAccount);
            pre.setString(1, number);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                savingAccount = new SavingAccount(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(7),
                        new CustomerDAO(connection).getCustomerByGeneratedId(rs.getInt(6)),
                        dtf.convertStringToDate(rs.getString(8)),
                        rs.getInt(9));
            }
            return savingAccount;
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean deleteSavingAccountByCustomerId(int id) {
        try {
            String query = "DELETE FROM savingaccount WHERE idcustomer = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setInt(1, id);
            long rowAffected = sttm.executeUpdate();
            if (rowAffected > 0)
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
