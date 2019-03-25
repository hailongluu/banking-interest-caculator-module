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
import java.util.Date;

/**
 * @author hailongluu
 */
public class InterestCaculator {
//    public double caculateInterest(SavingAccount savingAccount, Date endDate){
//        long diff = endDate.getTime()-savingAccount.getDate().getTime();
//        int days = (int) diff/(1000*60*60*24);
//        if (savingAccount.getTerm() == 0){
//            return (days*savingAccount.getCash()*savingAccount.getInterestRate())/36000;
//        }
//        else if (savingAccount.getTerm() > 0){
//            int dayterms = savingAccount.getTerm() * 30;
//
//        }
//    }
}
