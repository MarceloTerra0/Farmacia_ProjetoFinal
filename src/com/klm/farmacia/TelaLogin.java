package com.klm.farmacia;
    
import com.klm.farmacia.obj.Funcionario;
import com.klm.farmacia.obj.Produto;

import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luc_p
 */

public class TelaLogin extends javax.swing.JPanel {
    
    private static String userLogin;
    private JButton JBexit;
    private JButton JBtryLogin;
    private JLabel JLfranchiseName;
    private JLabel JLpassword;
    private JLabel JLusername;
    private JPasswordField JPFpassword;
    private JPanel JPlogin;
    private JTextField JTFusername;
    private Connection connection;
    private Funcionario funcionario;
    
    /**
     * Creates new form Login
     */
    public TelaLogin(Connection connection1) {
        connection = connection1;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPlogin = new javax.swing.JPanel();
        JLfranchiseName = new javax.swing.JLabel();
        JLusername = new javax.swing.JLabel();
        JTFusername = new javax.swing.JTextField();
        JLpassword = new javax.swing.JLabel();
        JPFpassword = new javax.swing.JPasswordField();
        JBtryLogin = new javax.swing.JButton();
        JBexit = new javax.swing.JButton();

        JLfranchiseName.setText("Farmácia");

        JLusername.setText("Usuário:");

        JLpassword.setText("Senha:");

        JBtryLogin.setText("Login");
        JBtryLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    JBtryLoginActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });

        JBexit.setText("Sair");
        JBexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPloginLayout = new javax.swing.GroupLayout(JPlogin);
        JPlogin.setLayout(JPloginLayout);
        JPloginLayout.setHorizontalGroup(
            JPloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPloginLayout.createSequentialGroup()
                .addGroup(JPloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPloginLayout.createSequentialGroup()
                        .addGroup(JPloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPloginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(JPloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JPFpassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(JLusername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLpassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTFusername, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(JPloginLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(JLfranchiseName))
                            .addGroup(JPloginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JBtryLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 180, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPloginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBexit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JPloginLayout.setVerticalGroup(
            JPloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPloginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(JLfranchiseName)
                .addGap(62, 62, 62)
                .addComponent(JLusername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(JLpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPFpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBtryLogin)
                .addGap(29, 29, 29)
                .addComponent(JBexit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JPlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JPlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void JBtryLoginActionPerformed(ActionEvent evt) throws SQLException, NoSuchAlgorithmException {
        String userLogin = JTFusername.getText();
        String passwordLogin = new String(JPFpassword.getPassword()).trim();

        funcionario = Logar.login(userLogin, passwordLogin, connection);

        if (funcionario.getIdCargo() == -1){
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
        }else{
            userLogin = ("");
            passwordLogin = ("");
            JTFusername.setText("");
            JPFpassword.setText("");
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            BigDecimal valorTotal = new BigDecimal("0"), valorTotalDescontado = new BigDecimal("0");
            List<Produto> listaProdutosCarrinho = new ArrayList<Produto>();
            List<Integer> quantidadeProdutosCarrinho = new ArrayList<Integer>();
            String carrinho = "";
            TelaFuncionario telaFuncionario = new TelaFuncionario(connection, funcionario, valorTotal
                    ,valorTotalDescontado, listaProdutosCarrinho, quantidadeProdutosCarrinho, carrinho);

            telaFuncionario.initialize();
        }

    }

    private void JBexitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public void initialize(){
        JFrame tela = new JFrame("Tela de login");
        tela.setContentPane(new TelaLogin(connection).JPlogin);
        //window.dispose
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setVisible(true);
    }
}