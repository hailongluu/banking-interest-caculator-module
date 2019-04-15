/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AccountDAO {
    
    private Connection connection;

    public AccountDAO() {
        try {
            DBconnection dbConnection = new DBconnection();
            this.connection = dbConnection.getConnect();
        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SavingAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean authenticateAccount(String username, String userPassword) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT password FROM account WHERE username = ?");
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String password = rs.getString(1);
                if (password.equals(userPassword))
                    return true;
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public int getPermission(String username) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT premission FROM account WHERE username = ?");
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int permission = rs.getInt(1);
                return permission;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
