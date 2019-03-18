//package customer;
//
//
//import connection.DBconnection;
//import customer.Customer;
//import customer.CustomerDAO;
//
//
//
//
//import java.sql.*;
//
//public class CustomerDAOImpl implements CustomerDAO {
//    Connection connection;
//
//    public CustomerDAOImpl() {
//        DBconnection dBconnection = new DBconnection();
//        try {
//            this.connection = dBconnection.getConnect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Customer getCustomer(int id) {
//        try {
//            String sql = "SELECT * FROM customer; where id = ?";
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setInt(1, id);
//            String fullName = "";
//            String address = "";
//            ResultSet rs = pre.executeQuery();
//            int customerId = 0;
//            while (rs.next()) {
//                address = rs.getString(2);
//                fullName = rs.getString(3);
//                customerId = rs.getInt(1);
//            }
//            return new Customer(null, fullName, address, customerId);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//
//    @Override
//    public Customer getCustomerByAccount(int id) {
//        try {
//            String sql = "SELECT * FROM bookstoreweb.customer where AccountId = ?";
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setInt(1, id);
//            FullName fullName = null;
//            Address address = null;
//            ResultSet rs = pre.executeQuery();
//            int customerId = 0;
//            while (rs.next()) {
//                address = getAddress(rs.getInt(2));
//                fullName = getFullName(rs.getInt(3));
//                customerId = rs.getInt(1);
//            }
//            return new Customer(null, fullName, address, customerId);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public int checkAccount(String userName, String pass) {
//        try {
//            String sql = "SELECT * FROM bookstoreweb.account where Username =  ? and Password =?;";
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setString(1, userName);
//            pre.setString(2, pass);
//            int id = 0;
//            ResultSet rs = pre.executeQuery();
//            while (rs.next()) {
//                id = rs.getInt(1);
//            }
//            return id;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    @Override
//    public void addCustomer(Customer customer) {
//        try {
//            String sqlAdd = "INSERT INTO `bookstoreweb`.`address` (`Street`, `Number`, `WardId`) VALUES (?, ?, '1');\n";
//            String sqlName = "INSERT INTO `bookstoreweb`.`fullname` (`FirstName`, `MiddleName`, `LastName`) VALUES (?, ?, ?);\n";
//            String sqlAcc = "INSERT INTO `bookstoreweb`.`account` (`Username`, `Password`) VALUES (?, ?);\n";
//            String sqlCus = "INSERT INTO `bookstoreweb`.`customer` (`AddressId`, `FullNameId`, `AccountId`) VALUES (?, ?, ?);\n";
//            PreparedStatement preAdd = connection.prepareStatement(sqlAdd, Statement.RETURN_GENERATED_KEYS);
//            PreparedStatement preName = connection.prepareStatement(sqlName, Statement.RETURN_GENERATED_KEYS);
//            PreparedStatement preAcc = connection.prepareStatement(sqlAcc, Statement.RETURN_GENERATED_KEYS);
//            PreparedStatement preCus = connection.prepareStatement(sqlCus, Statement.RETURN_GENERATED_KEYS);
//            preAdd.setString(1, customer.getAddress().getStreet());
//            preAdd.setString(2, customer.getAddress().getNumber());
//            preName.setString(1, customer.getFullName().getFirstName());
//            preName.setString(2, customer.getFullName().getMiddleName());
//            preName.setString(3, customer.getFullName().getLastName());
//            preAcc.setString(1, customer.getAccount().getUsername());
//            preAcc.setString(2, customer.getAccount().getPassword());
//
//            int add = 0;
//            int name = 0;
//            int acc = 0;
//
//            preAdd.executeUpdate();
//            preName.executeUpdate();
//            preAcc.executeUpdate();
//
//            ResultSet rsAdd = preAdd.getGeneratedKeys();
//            ResultSet rsName = preName.getGeneratedKeys();
//            ResultSet rsAcc = preAcc.getGeneratedKeys();
//            while (rsAdd.next()) {
//                add = rsAdd.getInt(1);
//            }
//            while (rsName.next()) {
//                name = rsName.getInt(1);
//            }
//            while (rsAcc.next()) {
//                acc = rsAcc.getInt(1);
//            }
//
//            preCus.setInt(1,add);
//            preCus.setInt(2,name);
//            preCus.setInt(3,acc);
//            preCus.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
// 
//    @Override
//    public void updateCustomer(int Customer) {
//
//    }
//
//    @Override
//    public void deleteCustomer(Customer customer) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}