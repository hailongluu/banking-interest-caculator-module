/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.savingaccount;

import bank.InterestRate;
import bank.SavingAccount;
import bank.SavingAccountDAO;
import common.BankAccountGenID;
import customer.Customer;
import customer.CustomerDAO;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import view.BankMainFrm;

/**
 *
 * @author hailo
 */
public class SavingAccountRegisterFrm extends javax.swing.JFrame {

    /**
     * Creates new form SavingAccoutRegister
     */
    
    public SavingAccountRegisterFrm() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void setupTextColor(boolean status) {
        Color color = null;
        if (status)
            color = Color.WHITE;
        else
            color = Color.LIGHT_GRAY;
        txtName.setBackground(color);
        txtPhone.setBackground(color);
        txtAddress.setBackground(color);
    }
    
    private void changeTextEditableStatus(boolean status) {
        txtName.setEditable(status);
        txtPhone.setEditable(status);
        txtAddress.setEditable(status);
        setupTextColor(status);
    }
    
    private void clearTexts() {
        txtName.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
    }
    
    private double determineInterestRate(int term) {
        int[] interestMilestones = new int[] {0, 1, 3, 6, 9, 12, 18, 24, 36};
        int milestone = 0;
        for (int i = 0; i < interestMilestones.length; i++) {
            if (term < interestMilestones[i])
                break;
            milestone = interestMilestones[i];
        }
        InterestRate interestRate = new InterestRate();
        switch (milestone) {
            case 1:
                return interestRate.getRATE_1_MONTHS();
            case 3:
                return interestRate.getRATE_3_MONTHS();
            case 6:
                return interestRate.getRATE_6_MONTHS();
            case 9:
                return interestRate.getRATE_9_MONTHS();
            case 12:
                return interestRate.getRATE_12_MONTHS();
            case 18:
                return interestRate.getRATE_18_MONTHS();
            case 24:
                return interestRate.getRATE_24_MONTHS();
            case 36:
                return interestRate.getRATE_36_MONTHS();
            default:
                return interestRate.getRATE_0_MONTHS();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        pnlSearchCustomer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCardId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTerm = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Saving Account Registration");

        jLabel2.setText("ID Number");

        txtCardId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCardIdActionPerformed(evt);
            }
        });
        txtCardId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCardIdKeyPressed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer Name");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel4.setText("Address");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Phone number");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel6.setText("Term");

        txtTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTermActionPerformed(evt);
            }
        });

        jLabel8.setText("Amount");

        jLabel7.setText("(months)");

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        jLabel9.setText("(VNĐ)");

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel10.setText("________________________________________________________________________________________");

        javax.swing.GroupLayout pnlSearchCustomerLayout = new javax.swing.GroupLayout(pnlSearchCustomer);
        pnlSearchCustomer.setLayout(pnlSearchCustomerLayout);
        pnlSearchCustomerLayout.setHorizontalGroup(
            pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                        .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                                .addComponent(txtCardId, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                        .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTerm, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtAmount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                                .addComponent(btnOpen)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(80, 80, 80))
            .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel10)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pnlSearchCustomerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnOpen, btnSearch});

        pnlSearchCustomerLayout.setVerticalGroup(
            pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchCustomerLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(39, 39, 39)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCardId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(pnlSearchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pnlSearchCustomerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancel, btnOpen, btnSearch});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCardIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCardIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCardIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String idCard = txtCardId.getText();
        if (idCard.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter id number to search");
            return;
        }
        
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getCustomerByIdCard(idCard);
        if (customer == null) {
            JOptionPane.showMessageDialog(this, "Cannot find customer information with given id number");
            changeTextEditableStatus(true);
        }
        else {
            txtName.setText(customer.getFullName());
            txtPhone.setText(customer.getPhoneNumber());
            txtAddress.setText(customer.getAddress());
            changeTextEditableStatus(false);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTermActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        String cardId = txtCardId.getText().trim();
        String name = txtName.getText().trim();
        String phone = txtPhone.getText().trim();
        String address = txtAddress.getText().trim();
        String term = txtTerm.getText().trim();
        String amount = txtAmount.getText().trim();
        if (cardId.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter id card number");
            return;
        }
        if (!cardId.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Id number should only contains numbers"); 
            return;
        }
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter full name");
            return;
        }
        if (phone.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter phone number");
            return;
        }
        if (!phone.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "phone number should only contains numbers"); 
            return;
        }
        if (address.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter address");
            return;
        }
        if (term.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter saving term");
            return;
        }
        if (amount.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter deposit amount"); 
            return;
        }
        int termInt = -1;
        double amountDouble = -1;
        try {
            termInt = Integer.parseInt(term);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Term can only be integer");
            return;
        }
        try {
            amountDouble = Double.parseDouble(amount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Deposit amount can only be integer");
            return;
        }
        if (termInt < 1) {
            JOptionPane.showMessageDialog(this, "Term must be greater than 0"); 
            return;
        }
        if (amountDouble < 500000) {
            JOptionPane.showMessageDialog(this, "Deposit amount must be at least 500.000 VND"); 
            return;
        }
        double interestRate =  determineInterestRate(termInt);
        Customer customer = null;
        CustomerDAO customerDAO = new CustomerDAO();
        SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
        BankAccountGenID generator = new BankAccountGenID();
        customer = customerDAO.getCustomerByIdCard(cardId);
        if (customer == null) {
            customer = new Customer(generator.getNewCustomerId(), name, address, phone, cardId);
            customerDAO.addCustomer(customer);
        }
        SavingAccount savingAccount = new SavingAccount(generator.getNewSavingAccountId(), amountDouble, interestRate, termInt, "Deposite", customer, new Date());
        boolean isSuccess = savingAccountDAO.addSavingAccountWithId(savingAccount);
        if (isSuccess)
            JOptionPane.showMessageDialog(this, "Saving account is successfully created");
        else
            JOptionPane.showMessageDialog(this, "Error occured with database");
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        BankMainFrm frm = new BankMainFrm();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtCardIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCardIdKeyPressed
        int keycode = evt.getKeyCode();
        if (keycode == 8 || keycode == 127)
            changeTextEditableStatus(true);
    }//GEN-LAST:event_txtCardIdKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SavingAccountRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavingAccountRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavingAccountRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavingAccountRegisterFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SavingAccountRegisterFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel pnlSearchCustomer;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCardId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTerm;
    // End of variables declaration//GEN-END:variables
}
