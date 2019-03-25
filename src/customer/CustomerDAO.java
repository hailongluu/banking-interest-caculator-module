package customer;

import bank.SavingAccountDAO;
import connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {
    
    private Connection connection;

    public CustomerDAO() {
        try {
            DBconnection dbConnection = new DBconnection();
            this.connection = dbConnection.getConnect();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer getCustomerByGeneratedId(int id) {
        try {
            String query = "SELECT * FROM account WHERE id = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setInt(1, id);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(5), rs.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public Customer getCustomerByIdCard(String cardId) {
        try {
            String query = "SELECT * FROM account WHERE idcard = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setString(1, cardId);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(5), rs.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public boolean addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer(id, name, address, idcard, phone) VALUES = (?,?,?,?,?)";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setInt(1, customer.getId());
            sttm.setString(2, customer.getFullName());
            sttm.setString(3, customer.getAddress());
            sttm.setString(4, customer.getIdCard());
            sttm.setString(5, customer.getPhoneNumber());
            int rowAffected = sttm.executeUpdate();
            if (rowAffected > 0)
                return true;
            return false;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean deleteCustomer(Customer customer) {
        try {
            String query = "DELETE FROM customer WHERE id = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setInt(1, customer.getId());
            int rowAffected = sttm.executeUpdate();
            if (rowAffected > 0)
                return true;
            return false;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        try {
            String query = "UPDATE customer SET name = ?, address = ?, idcard = ?, phone = ? WHERE id = ?";
            PreparedStatement sttm = connection.prepareStatement(query);
            sttm.setString(1, customer.getFullName());
            sttm.setString(2, customer.getAddress());
            sttm.setString(3, customer.getIdCard());
            sttm.setString(4, customer.getPhoneNumber());
            sttm.setInt(5, customer.getId());
            int rowAffected = sttm.executeUpdate();
            if (rowAffected > 0)
                return true;
            return false;
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
