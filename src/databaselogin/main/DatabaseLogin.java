/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaselogin.main;

import databaselogin.dao.UserDAO;
import databaselogin.dao.impl.UserDAOImpl;
import databaselogin.dbutil.DBConnection;
import databaselogin.entity.Users;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Sujin
 */
public class DatabaseLogin extends JFrame {

    JTextField txtUsername, txtPassword;
    JButton btnLogin, btnCancel;
    JComboBox<String> cmbAccount;
    UserDAO userDAO = new UserDAOImpl();
    //DBConnection conn = new DBConnection();

    public DatabaseLogin() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel userLabel = new JLabel("Username");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(userLabel, c);

        txtUsername = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        add(txtUsername, c);

        JLabel passLabel = new JLabel("Passwird");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(passLabel, c);

        txtPassword = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        add(txtPassword, c);

        JLabel userType = new JLabel("Account Type");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        add(userType, c);

        String[] users = {"Users", "Admin"};
        cmbAccount = new JComboBox<String>(users);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        add(cmbAccount, c);

        btnLogin = new JButton("Login");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(btnLogin, c);

        btnCancel = new JButton("Cancel");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        add(btnCancel, c);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    processLogin();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DatabaseLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void processLogin() throws SQLException, ClassNotFoundException {
        //conn.open();

        String user = txtUsername.getText();
        String pass = txtPassword.getText();
        String type = cmbAccount.getSelectedItem().toString();
//        String sql = "SELECT * FROM TBLUSER WHERE username=? AND password = ?";
//
//        PreparedStatement stmt = conn.initStatement(sql);
//        stmt.setString(1, user);
//        stmt.setString(2, pass);
//        ResultSet rs = conn.executeQuery();
//        if(rs.next()){
//            System.out.println("Login successful");
//        }else{
//            System.out.println("Login Failed");
//        }
//        conn.close();

        Users userObj = userDAO.getByUserAndPass(user, pass, type);
        if (userObj != null) {
            //System.out.println("Login success");
            SecondFrame sf = new SecondFrame();
            sf.setVisible(true);
            dispose();
            
        } else {
            //System.out.println("Login failed");
            JOptionPane.showMessageDialog(this, "Invalid credentials","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new DatabaseLogin().setVisible(true);
    }

}
