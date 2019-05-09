/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Date;

/**
 * @author hailongluu
 */


public class InterestCaculator {
    public double caculateInterest(SavingAccount savingAccount, Date endDate){
        InterestRate interestRate = new InterestRate();
        long diff = endDate.getTime()-savingAccount.getDate().getTime();
        long days = (long) diff/(1000*60*60*24);         //so ngay thuc gui tien tai ngan hang
        System.out.println(diff/(1000*60*60*24));
        if (savingAccount.getTerm() == 0){          // ki han gui =0 -> gui khong lai suat
            return (days*savingAccount.getCash()*savingAccount.getInterestRate())/36000;
        }
        else if (savingAccount.getTerm() > 0){          // ki han gui >0 gui co lai xuat
            int dayterms = savingAccount.getTerm() * 30;  // so ngay trong 1 ki han
            long loopTerm = days / dayterms ;              // so ki han da trai qua
            if (loopTerm == 0){                             // chua trai qua duoc ki han nao
                double rate = interestRate.getRateByMonth(0,savingAccount.getDate());  // rate tinh bang rate cua k ki han ngay gui
                return (days*savingAccount.getCash()*rate)/36000; // tra ve so tien tinh nhu khong ki han
            }
            else if (loopTerm > 0){                 // trai qua nhieu hon 1 ki han
                Date startDate = savingAccount.getDate();  // ngay bat dau ki han
                double interest = 0;                        // interest
                double cash = savingAccount.getCash();      // tien ban dau trong tai khoan
                double rate = savingAccount.getInterestRate(); //rate cua ki han dau tien
                for (int i = 1 ; i <= loopTerm ;i++){      // lap qua cac ki han
                    if (i>=2){     // neu ki han lon hon 2 thi cap nhap cac thong so nhu ngay bat dau ki han moi va tinh lai rate cua ki han do
                        Date newDate = new Date(startDate.getTime()+(long) dayterms*24*60*60*1000);  // ngay bat dau moi
                        rate = interestRate.getRateByMonth(savingAccount.getTerm(),newDate); // rate cua ki han moi
                        startDate = newDate; // cap nhat ngay bat dau ki han moi
                    }
                    interest = cash*rate*dayterms/36000;    // tinh lai sau 1 ki han
                    cash += interest;   // cong lai vao goc
                }
                if(days%dayterms > 0){   // so ngay vuot qua ki han tinh nhu ls khong ki han
                    Date newDate = new Date(startDate.getTime()+(long) dayterms*24*60*60*1000);  // ngay bat dau moi
                    rate = interestRate.getRateByMonth(0,newDate); // rate cua ki han moi tinh la khong ki han
                    cash += cash*rate*(days%dayterms)/36000;
                }
                return  Math.round(cash - savingAccount.getCash());
            }
            else {
                System.out.println("gia tri cua loop term nho hon 0");
            }
        }
        else {
            System.out.println("gia tri cua term nho hon 0");
        }
         return 0;
    }
    double getNoTermInterest(){
        return 0;
    }
    double getTermInterest(){
        return 0;
    }
}
