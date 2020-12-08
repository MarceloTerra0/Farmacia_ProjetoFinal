/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klm.farmacia;
 
    import com.klm.farmacia.obj.Funcionario;
    import com.klm.farmacia.obj.Produto;

    import java.math.BigDecimal;
    import java.sql.*;
    import java.awt.Window;
    import javax.swing.*;

/**
 *
 * @author luc_p
 */
public class Employee extends javax.swing.JPanel {
    
    private String itemName,itemCode,id,name;
    private Funcionario funcionario;
    //VarName = Integer.parseInt(TextFieldName.getText());    pra transformar a leitura em int, caso queira
    //Pode ser usado no back, então ta safe
    
    /**
     * Creates new form Employee
     */
    public Employee(Connection SQLconnection, Funcionario funcio) {
        connection = SQLconnection;
        funcionario = funcio;
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

        JPemployee = new javax.swing.JPanel();
        JLwelcomeMessage = new javax.swing.JLabel();
        JLpharmacyName = new javax.swing.JLabel();
        JTPemployeeButtons = new javax.swing.JTabbedPane();
        JPsearch = new javax.swing.JPanel();
        JLitemName = new javax.swing.JLabel();
        JTFitemName = new javax.swing.JTextField();
        JTFitemQuantity = new javax.swing.JTextField();
        JLitemQuantity = new javax.swing.JLabel();
        JBaddToCart = new javax.swing.JButton();
        JLitemCode = new javax.swing.JLabel();
        JTFitemCode = new javax.swing.JTextField();
        JLitemPrice = new javax.swing.JLabel();
        JTFitemPrice = new javax.swing.JTextField();
        JLstock = new javax.swing.JLabel();
        JTFstock = new javax.swing.JTextField();
        JPhistory = new javax.swing.JPanel();
        JLid = new javax.swing.JLabel();
        JTFid = new javax.swing.JTextField();
        JBsearch = new javax.swing.JButton();
        JCBisEmployee = new javax.swing.JCheckBox();
        JPregisterClient = new javax.swing.JPanel();
        JLclientName = new javax.swing.JLabel();
        JTFclientName = new javax.swing.JTextField();
        JLclientID = new javax.swing.JLabel();
        JTFclientID = new javax.swing.JTextField();
        JBregister = new javax.swing.JButton();
        JPcart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAcart = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JBlogout = new javax.swing.JButton();
        JPclient = new javax.swing.JPanel();

        JPemployee.setPreferredSize(new java.awt.Dimension(400, 302));

        JLwelcomeMessage.setText("Seja bem-vindo(a), " + funcionario.getNomeFuncionario());

        JLpharmacyName.setText(Integer.toString(funcionario.getIdCargo()));

        JLitemName.setText("Nome");

        JTFitemName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                try {
                    JTFitemNameFocusLost(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        JTFitemQuantity.setText("0");

        JLitemQuantity.setText("Qtd.");

        JBaddToCart.setText("Adicionar");
        JBaddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBaddToCartActionPerformed(evt);
            }
        });

        JLitemCode.setText("Código");

        JTFitemCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTFitemCodeFocusLost(evt);
            }
        });

        JLitemPrice.setText("Preço");

        JLstock.setText("Em estoque");

        JTFstock.setEditable(false);
        JTFstock.setText("?");

        javax.swing.GroupLayout JPsearchLayout = new javax.swing.GroupLayout(JPsearch);
        JPsearch.setLayout(JPsearchLayout);
        JPsearchLayout.setHorizontalGroup(
            JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPsearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTFitemName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(JLitemName)
                    .addComponent(JLitemCode)
                    .addComponent(JTFitemCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLstock)
                    .addGroup(JPsearchLayout.createSequentialGroup()
                        .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTFstock, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLitemQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFitemQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLitemPrice)
                            .addComponent(JTFitemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPsearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBaddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPsearchLayout.setVerticalGroup(
            JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPsearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLitemName)
                    .addComponent(JLitemQuantity)
                    .addComponent(JLitemPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFitemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFitemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFitemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLitemCode)
                    .addComponent(JLstock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFitemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(JBaddToCart)
                .addContainerGap())
        );

        JTPemployeeButtons.addTab("Busca", JPsearch);

        JLid.setText("ID Cliente");

        JBsearch.setText("Pesquisar");
        JBsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsearchActionPerformed(evt);
            }
        });

        JCBisEmployee.setText("Funcionário");
        JCBisEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBisEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPhistoryLayout = new javax.swing.GroupLayout(JPhistory);
        JPhistory.setLayout(JPhistoryLayout);
        JPhistoryLayout.setHorizontalGroup(
            JPhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPhistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLid)
                    .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(JPhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBisEmployee)
                    .addComponent(JBsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        JPhistoryLayout.setVerticalGroup(
            JPhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPhistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLid)
                    .addComponent(JCBisEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(JBsearch)
                .addContainerGap())
        );

        JTPemployeeButtons.addTab("Histórico", JPhistory);

        JLclientName.setText("Nome");

        JLclientID.setText("CPF");

        JBregister.setText("Cadastrar");
        JBregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    JBregisterActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout JPregisterClientLayout = new javax.swing.GroupLayout(JPregisterClient);
        JPregisterClient.setLayout(JPregisterClientLayout);
        JPregisterClientLayout.setHorizontalGroup(
            JPregisterClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPregisterClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPregisterClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLclientName)
                    .addComponent(JTFclientName)
                    .addComponent(JLclientID)
                    .addComponent(JTFclientID, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPregisterClientLayout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addComponent(JBregister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPregisterClientLayout.setVerticalGroup(
            JPregisterClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPregisterClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLclientName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFclientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLclientID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFclientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(JBregister)
                .addContainerGap())
        );

        JTPemployeeButtons.addTab("Cadastro", JPregisterClient);

        JTAcart.setEditable(false);
        JTAcart.setColumns(20);
        JTAcart.setRows(5);
        jScrollPane1.setViewportView(JTAcart);

        jLabel1.setText("ID do Produto");

        jButton1.setText("Editar");

        jButton2.setText("Remover");

        jButton3.setText("Finalizar");

        javax.swing.GroupLayout JPcartLayout = new javax.swing.GroupLayout(JPcart);
        JPcart.setLayout(JPcartLayout);
        JPcartLayout.setHorizontalGroup(
            JPcartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPcartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPcartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPcartLayout.createSequentialGroup()
                        .addGroup(JPcartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPcartLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(JPcartLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JPcartLayout.setVerticalGroup(
            JPcartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPcartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPcartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPcartLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPcartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        JTPemployeeButtons.addTab("Carrinho", JPcart);

        JBlogout.setText("Sair");
        JBlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    JBlogoutActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout JPemployeeLayout = new javax.swing.GroupLayout(JPemployee);
        JPemployee.setLayout(JPemployeeLayout);
        JPemployeeLayout.setHorizontalGroup(
            JPemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPemployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPemployeeLayout.createSequentialGroup()
                        .addComponent(JTPemployeeButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPemployeeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JPemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPemployeeLayout.createSequentialGroup()
                                .addComponent(JLwelcomeMessage)
                                .addGap(123, 123, 123))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPemployeeLayout.createSequentialGroup()
                                .addComponent(JLpharmacyName)
                                .addGap(170, 170, 170))))
                    .addGroup(JPemployeeLayout.createSequentialGroup()
                        .addComponent(JBlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        JPemployeeLayout.setVerticalGroup(
            JPemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPemployeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLwelcomeMessage)
                .addGap(18, 18, 18)
                .addComponent(JLpharmacyName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTPemployeeButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBlogout)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout JPclientLayout = new javax.swing.GroupLayout(JPclient);
        JPclient.setLayout(JPclientLayout);
        JPclientLayout.setHorizontalGroup(
            JPclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        JPclientLayout.setVerticalGroup(
            JPclientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 300, Short.MAX_VALUE)
                .addComponent(JPclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JPemployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 226, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JPemployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

//Isso executa quando clicam no botão "Sair" em qualquer ponto da interface
//Tudo certo por aqui (até onde eu sei)
    private void JBlogoutActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_JBlogoutActionPerformed
        // TODO add your handling code here:
        connection.close();
        //Loogin loogin = new Loogin(Connection connection);
        //loogin.initialize(connection);
        //JComponent comp = (JComponent) evt.getSource();
        //Window win = SwingUtilities.getWindowAncestor(comp);
        //win.dispose();
    }//GEN-LAST:event_JBlogoutActionPerformed

//Isso executa quando clicam fora da janela do nome em Busca
    private void JTFitemNameFocusLost(java.awt.event.FocusEvent evt) throws SQLException {//GEN-FIRST:event_JTFitemNameFocusLost
        // TODO add your handling code here:
        itemName = JTFitemName.getText();
        System.out.println(itemName);
        Produto produto = Armazem.checaProdutoPeloNome(itemName, funcionario.getIdFarmacia(), connection);

        //checagem no banco de dados se tem um produto com esse **nome**
        if(produto.getQtdEstoque()!=-1){
            JTFstock.setText(Integer.toString(produto.getQtdEstoque()));
            JTFitemName.setText(produto.getNomeProduto());
            JTFitemPrice.setText(produto.getPrecoProduto().toString());
            JTFitemCode.setText(Integer.toString(produto.getIdProduto()));
        }

    }//GEN-LAST:event_JTFitemNameFocusLost

    
//Isso executa quando clicam em "Adicionar" em Busca
//**Atenção necessária aqui**
    private void JBaddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBaddToCartActionPerformed
        // TODO add your handling code here:
        System.out.println("aba 1");
        //**Socorro
    }//GEN-LAST:event_JBaddToCartActionPerformed

//Isso executa quando clicam fora da janela do código em Busca
//**Atenção necessária aqui**
    private void JTFitemCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTFitemCodeFocusLost
        // TODO add your handling code here:
        itemCode = JTFitemCode.getText();
        //checagem no banco de dados se tem um produto com esse **código**
        /*se tiver{
            JTFitemName.setText(nomeDoItem);(vindo do banco de dados)
        }
        se nao tiver{
            JTFitemName.setText("?");
        }
        */
    }//GEN-LAST:event_JTFitemCodeFocusLost

//Isso executa quando apertam o botão de "Cadastrar" em Cadastro
//**Atenção necessária aqui**
    private void JBregisterActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_JBregisterActionPerformed
        // TODO add your handling code here:
        name = JTFclientName.getText();
        id = JTFclientID.getText();
        JOptionPane.showMessageDialog(null, Cadastro.cadastrarCliente(name, "telefoneTEMP", id, connection));
        //consegue passar pro banco de dados como um cliente novo só com isso?
    }//GEN-LAST:event_JBregisterActionPerformed

//Isso executa quando apertam o botão de "Pesquisar" em Histórico
//**Atenção necessária aqui**
    private void JBsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsearchActionPerformed
        // TODO add your handling code here:
        id = JTFid.getText();               //o id, independente
        if (JCBisEmployee.isSelected()){   //se for funcionario
          
        }
        else{                               //se for cliente                               
            
        }
        id = ("");
        JTFid.setText("");
    }//GEN-LAST:event_JBsearchActionPerformed

//Essa classe é responsável só por mudar a interface
//Quando o usuário selecionar a caixa de funcionário, a JLabel muda para ID funcionário
//Ta certo (até onde eu sei)
    private void JCBisEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBisEmployeeActionPerformed
        // TODO add your handling code here:
        if (JCBisEmployee.isSelected()){
            JLid.setText("ID Funcionário");
        }
        else{
            JLid.setText("ID Cliente");
        }
    }//GEN-LAST:event_JCBisEmployeeActionPerformed

    public void initialize(){
        JFrame tela = new JFrame("App");
        tela.setContentPane(new Employee(connection, funcionario).JTPemployeeButtons);
        //window.dispose
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBaddToCart;
    private javax.swing.JButton JBlogout;
    private javax.swing.JButton JBregister;
    private javax.swing.JButton JBsearch;
    private javax.swing.JCheckBox JCBisEmployee;
    private javax.swing.JLabel JLclientID;
    private javax.swing.JLabel JLclientName;
    private javax.swing.JLabel JLid;
    private javax.swing.JLabel JLitemCode;
    private javax.swing.JLabel JLitemName;
    private javax.swing.JLabel JLitemPrice;
    private javax.swing.JLabel JLitemQuantity;
    private javax.swing.JLabel JLpharmacyName;
    private javax.swing.JLabel JLstock;
    private javax.swing.JLabel JLwelcomeMessage;
    private javax.swing.JPanel JPcart;
    private javax.swing.JPanel JPclient;
    private javax.swing.JPanel JPemployee;
    private javax.swing.JPanel JPhistory;
    private javax.swing.JPanel JPregisterClient;
    private javax.swing.JPanel JPsearch;
    private javax.swing.JTextArea JTAcart;
    private javax.swing.JTextField JTFclientID;
    private javax.swing.JTextField JTFclientName;
    private javax.swing.JTextField JTFid;
    private javax.swing.JTextField JTFitemCode;
    private javax.swing.JTextField JTFitemName;
    private javax.swing.JTextField JTFitemPrice;
    private javax.swing.JTextField JTFitemQuantity;
    private javax.swing.JTextField JTFstock;
    private javax.swing.JTabbedPane JTPemployeeButtons;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private Connection connection;
    // End of variables declaration//GEN-END:variables
}
