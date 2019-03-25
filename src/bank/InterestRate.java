package bank;

import connection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterestRate {
    public double RATE_0_MONTHS;
    public double RATE_1_MONTHS;
    public double RATE_3_MONTHS;
    public double RATE_6_MONTHS;
    public double RATE_9_MONTHS;
    public double RATE_12_MONTHS;
    public double RATE_18_MONTHS;
    public double RATE_24_MONTHS;
    public double RATE_36_MONTHS;

    public InterestRate() {
        getRate();
    }

    void getRate() {
        try {
            Connection connection = new DBconnection().getConnect();
            String getRate = "SELECT * FROM banking.customer WHERE id = ? ;";
            PreparedStatement pre = connection.prepareStatement(getRate);
            pre.setInt(1, 1);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                this.RATE_0_MONTHS = rs.getDouble(3);
                this.RATE_1_MONTHS = rs.getDouble(4);
                this.RATE_3_MONTHS = rs.getDouble(5);
                this.RATE_6_MONTHS = rs.getDouble(6);
                this.RATE_9_MONTHS = rs.getDouble(7);
                this.RATE_12_MONTHS = rs.getDouble(8);
                this.RATE_18_MONTHS = rs.getDouble(9);
                this.RATE_24_MONTHS = rs.getDouble(10);
                this.RATE_36_MONTHS = rs.getDouble(11);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double getRATE_0_MONTHS() {
        return RATE_0_MONTHS;
    }

    public double getRATE_1_MONTHS() {
        return RATE_1_MONTHS;
    }

    public double getRATE_3_MONTHS() {
        return RATE_3_MONTHS;
    }

    public double getRATE_6_MONTHS() {
        return RATE_6_MONTHS;
    }

    public double getRATE_9_MONTHS() {
        return RATE_9_MONTHS;
    }

    public double getRATE_12_MONTHS() {
        return RATE_12_MONTHS;
    }

    public double getRATE_18_MONTHS() {
        return RATE_18_MONTHS;
    }

    public double getRATE_24_MONTHS() {
        return RATE_24_MONTHS;
    }

    public double getRATE_36_MONTHS() {
        return RATE_36_MONTHS;
    }
}
