package Client.View;

import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thiennguyen
 */
public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form InventoryGUI
     */
    public LoginGUI() {
        initComponents();
        this.setVisible(false);
    }


    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        Header2 = new javax.swing.JLabel();
        loginPane = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        backPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(590, 446));
        setResizable(false);

        jPanel2.setLayout(null);

        Header.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("Inventory Management System");
        jPanel2.add(Header);
        Header.setBounds(10, 20, 573, 43);

        Header2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        Header2.setForeground(new java.awt.Color(255, 255, 255));
        Header2.setText("Login");
        jPanel2.add(Header2);
        Header2.setBounds(260, 70, 51, 22);

        loginPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        usernameLabel.setText("Username");

        passLabel.setText("Password");

       

        loginButton.setText("Login");
    

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passLabel)
                    .addComponent(usernameLabel))
                .addGap(30, 30, 30)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userField, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(passField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(171, 171, 171))
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(loginButton)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.add(loginPane);
        loginPane.setBounds(60, 110, 462, 279);

        backPic.setIcon(new javax.swing.ImageIcon("/Users/thiennguyen/NetBeansProjects/GUI/src/Untitled design.png")); // NOI18N
        jPanel2.add(backPic);
        backPic.setBounds(0, 0, 600, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addButtonListener(ActionListener listen) {
    	loginButton.addActionListener(listen);
    }
    
    public javax.swing.JLabel getHeader() {
		return Header;
	}

	public void setHeader(javax.swing.JLabel header) {
		Header = header;
	}

	public javax.swing.JLabel getHeader2() {
		return Header2;
	}

	public void setHeader2(javax.swing.JLabel header2) {
		Header2 = header2;
	}

	public javax.swing.JLabel getBackPic() {
		return backPic;
	}

	public void setBackPic(javax.swing.JLabel backPic) {
		this.backPic = backPic;
	}

	public javax.swing.JPanel getjPanel2() {
		return jPanel2;
	}

	public void setjPanel2(javax.swing.JPanel jPanel2) {
		this.jPanel2 = jPanel2;
	}

	public javax.swing.JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(javax.swing.JButton loginButton) {
		this.loginButton = loginButton;
	}

	public javax.swing.JPanel getLoginPane() {
		return loginPane;
	}

	public void setLoginPane(javax.swing.JPanel loginPane) {
		this.loginPane = loginPane;
	}

	public javax.swing.JPasswordField getPassField() {
		return passField;
	}

	public void setPassField(javax.swing.JPasswordField passField) {
		this.passField = passField;
	}

	public javax.swing.JLabel getPassLabel() {
		return passLabel;
	}

	public void setPassLabel(javax.swing.JLabel passLabel) {
		this.passLabel = passLabel;
	}

	public javax.swing.JTextField getUserField() {
		return userField;
	}

	public void setUserField(javax.swing.JTextField userField) {
		this.userField = userField;
	}

	public javax.swing.JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(javax.swing.JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Header;
    private javax.swing.JLabel Header2;
    private javax.swing.JLabel backPic;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPane;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
