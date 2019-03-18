/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import com.mysql.cj.protocol.Resultset;
import connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hailo
 */
public class BankAccountGenID {

    public int lastBankAccount;
    public int lastSavingAccount;
    public int lastCustomerId;
    private boolean checked;

    public BankAccountGenID() throws SQLException {
        init();
    }

    private void init() throws SQLException {
        try {
            DBconnection dbConnection = new DBconnection();
            Connection connection = dbConnection.getConnect();
            String getLastBankAccount = "SELECT * FROM bankaccount;";
            String getLastSavingAccount = "SELECT * FROM savingaccount;";
            String getLastCustomer = "SELECT * FROM customer;";
            PreparedStatement pre1 = connection.prepareStatement(getLastBankAccount);
            PreparedStatement pre2 = connection.prepareStatement(getLastSavingAccount);
            PreparedStatement pre3 = connection.prepareStatement(getLastCustomer);
            ResultSet rs1 = pre1.executeQuery();
            ResultSet rs2 = pre2.executeQuery();
            ResultSet rs3 = pre3.executeQuery();
            while (rs1.next()) {
                lastBankAccount = rs1.getInt(2);
            }
            while (rs2.next()) {
                lastSavingAccount = rs2.getInt(2);
            }
            while (rs3.next()) {
                lastCustomerId = rs3.getInt(1);
            }
            checked = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankAccountGenID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLastBankAccount() {
        return lastBankAccount;
    }

    public int getLastSavingAccount() {
        return lastSavingAccount;
    }

    public int getLastCustomerId() {
        return lastCustomerId;
    }

    public void setLastBankAccount(int lastBankAccount) {
        this.lastBankAccount = lastBankAccount;
    }

    public void setLastSavingAccount(int lastSavingAccount) {
        this.lastSavingAccount = lastSavingAccount;
    }

    public void setLastCustomerId(int lastCustomerId) {
        this.lastCustomerId = lastCustomerId;
    }

    public int getNewBankAccount() throws SQLException {
        if (checked == false) {
            init();
        }
        checked = false;
        return lastBankAccount++;

    }

    public int getNewSavingAccount() throws SQLException {
        if (checked == false) {
            init();
        }
        checked = false;
        return lastSavingAccount++;
    }

    @Override
    public String toString() {
        return "BankAccountGenID{" + "lastBankAccount=" + lastBankAccount + ", lastSavingAccount=" + lastSavingAccount + ", lastCustomerId=" + lastCustomerId + '}';
    }

}
