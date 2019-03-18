/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.SQLException;

/**
 *
 * @author hailo
 */
public class TestCommon {
    public static void main(String[] args) throws SQLException {
        BankAccountGenID bagid = new BankAccountGenID();
        System.out.println(bagid.toString());
    }
}
