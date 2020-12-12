/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prtjpa.views;

import daos.ContatoDao;
import daos.TelefoneDao;
import entities.Contato;
import entities.Representante;
import entities.Telefone;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
public class JFRepresentante extends javax.swing.JFrame {
    
    private Representante representante;
    private List<Telefone> telefones;
    private List<Contato> contatos;
    
    private void  setRepresentante(Representante representante){
        this.representante = representante;
        this.jLCodigo.setText(String.valueOf(this.representante.codigo));
        this.jLNome.setText(this.representante.nome);
        this.jLEmpresa.setText(this.representante.empresa);
        this.jLCPF.setText(this.representante.cpf);
    }

    /**
     * Creates new form JFRepresentante
     */
    public JFRepresentante(Representante representante) {
        initComponents();
        this.setRepresentante(representante);
    }
    
    public void listTelefones(){
        try
        {
            DefaultTableModel model = ( DefaultTableModel ) jTTelefones.getModel();
            jTTelefones.setRowSorter( new TableRowSorter(model));
            model.setRowCount(0);
        
            this.telefones = TelefoneDao.list(this.representante.codigo);
                 
            for (Telefone telefone :  this.telefones)
            {
                model.addRow( new Object[]{
                    telefone.codigo,
                    telefone.getTelefoneTipo(),
                    telefone.numero,
                });
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao listar telefones !");
        }
    }
    
    public Telefone getTelefoneSelected(){
        return this.telefones.get(this.jTTelefones.getSelectedRow());
    }
    
    public void listContatos(){
        try
        {
            DefaultTableModel model = ( DefaultTableModel ) jTContatos.getModel();
            jTContatos.setRowSorter( new TableRowSorter(model));
            model.setRowCount(0);
        
            this.contatos = ContatoDao.list(this.representante.codigo);
                 
            for (Contato contato :  this.contatos)
            {
                model.addRow( new Object[]{
                    contato.codigo,
                    contato.dateBr(),
                    contato.hora,
                    contato.assunto,
                });
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    
    public Contato getConatoSelected(){
        return this.contatos.get(this.jTContatos.getSelectedRow());
    }
    
    private void initDisabledButtons(){
        this.jBDeleteTelefone.setEnabled(false);
        this.jBEditarContato.setEnabled(false);
        this.jBDeleteContato.setEnabled(false);
        this.jBViewContato.setEnabled(false);
    }
    
    private void initDisabledButtonsContato(){
        this.jBEditarContato.setEnabled(true);
        this.jBDeleteContato.setEnabled(true);
        this.jBViewContato.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTTelefones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBDeleteTelefone = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTContatos = new javax.swing.JTable();
        jBAdcionarContato = new javax.swing.JButton();
        jBEditarContato = new javax.swing.JButton();
        jBDeleteContato = new javax.swing.JButton();
        jBViewContato = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLEmpresa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLCPF = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Representante");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Tipo", "Numero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTTelefones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTelefonesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTTelefones);

        jLabel2.setText("Nome:");

        jLabel4.setText("Empresa:");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBDeleteTelefone.setText("Excluir");
        jBDeleteTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteTelefoneActionPerformed(evt);
            }
        });

        jTContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Data", "Hora", "Assunto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTContatosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTContatos);

        jBAdcionarContato.setText("Adicionar");
        jBAdcionarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdcionarContatoActionPerformed(evt);
            }
        });

        jBEditarContato.setText("Editar");
        jBEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarContatoActionPerformed(evt);
            }
        });

        jBDeleteContato.setText("Excluir");
        jBDeleteContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteContatoActionPerformed(evt);
            }
        });

        jBViewContato.setText("Visualizar");
        jBViewContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBViewContatoActionPerformed(evt);
            }
        });

        jLabel1.setText("Contatos");

        jLabel3.setText("Telefones");

        jLabel5.setText("Informações do Representante");

        jLabel6.setText("CPF:");

        jLabel7.setText("Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBDeleteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAdcionarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEditarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jBDeleteContato, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBViewContato, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLNome)
                    .addComponent(jLabel7)
                    .addComponent(jLCodigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLEmpresa)
                    .addComponent(jLabel6)
                    .addComponent(jLCPF))
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDeleteTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdcionarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEditarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDeleteContato, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBViewContato, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        (  new JFAdicionarTelefone(this.representante)  ).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        this.listTelefones();
        this.listContatos();
        this.initDisabledButtons();
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void jTTelefonesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTelefonesMousePressed
       this.jBDeleteTelefone.setEnabled(true);
    }//GEN-LAST:event_jTTelefonesMousePressed

    private void jBDeleteTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteTelefoneActionPerformed
         
        try
        {
            Telefone telefone = this.getTelefoneSelected();
        
            int showConfirmDialog = JOptionPane.showConfirmDialog(
                this,
                "Você realmente desejá excluir este telefone ("+telefone.numero+")",
                "Excluir telefone",
                JOptionPane.OK_CANCEL_OPTION
            );

            if(showConfirmDialog==0)
            {
                TelefoneDao.delete(telefone);
                JOptionPane.showConfirmDialog(
                    this,
                    "Telefone excluido com sucesso !",
                    "INFO",
                    JOptionPane.CLOSED_OPTION
                );
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir telefone !");
        }
    }//GEN-LAST:event_jBDeleteTelefoneActionPerformed

    private void jBAdcionarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdcionarContatoActionPerformed
        ( new JFAdicionarContato(this.representante)).setVisible(true);
    }//GEN-LAST:event_jBAdcionarContatoActionPerformed

    private void jBDeleteContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteContatoActionPerformed
        try
        {
            Contato contato = this.getConatoSelected();
        
            int showConfirmDialog = JOptionPane.showConfirmDialog(
                this,
                "Você realmente desejá excluir este contato",
                "Excluir contato",
                JOptionPane.OK_CANCEL_OPTION
            );

            if(showConfirmDialog==0)
            {
                ContatoDao.delete(contato);
                JOptionPane.showConfirmDialog(
                    this,
                    "Contato excluido com sucesso !",
                    "INFO",
                    JOptionPane.CLOSED_OPTION
                );
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir contato !");
        }
    }//GEN-LAST:event_jBDeleteContatoActionPerformed

    private void jTContatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTContatosMousePressed
       this.initDisabledButtonsContato();
    }//GEN-LAST:event_jTContatosMousePressed

    private void jBEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarContatoActionPerformed
        (new JFEditarContato(this.getConatoSelected())).setVisible(true);
    }//GEN-LAST:event_jBEditarContatoActionPerformed

    private void jBViewContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBViewContatoActionPerformed
        try {
            (new JFVisualizarContato(this.getConatoSelected())).setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(JFRepresentante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBViewContatoActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new JFRepresentante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdcionarContato;
    private javax.swing.JButton jBDeleteContato;
    private javax.swing.JButton jBDeleteTelefone;
    private javax.swing.JButton jBEditarContato;
    private javax.swing.JButton jBViewContato;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLCPF;
    private javax.swing.JLabel jLCodigo;
    private javax.swing.JLabel jLEmpresa;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTContatos;
    private javax.swing.JTable jTTelefones;
    // End of variables declaration//GEN-END:variables
}