/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prtjpa.views;

import daos.RepresentanteDao;
import entities.Representante;
import helpers.Validators;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
public class JFEditarRepresentante extends javax.swing.JFrame {
    
    private Representante representante;
    
    boolean isValidNome = true;
    boolean isValidCpf = true;
    boolean isValidEmpresa = true;
    
    private void  setRepresentante(Representante representante){
        this.representante = representante;
        jTFNome.setText(this.representante.nome);
        jFTFCPF.setText(this.representante.cpf);
        jTFEmpresa.setText(this.representante.empresa);
    }
    
    private void initDisabledButtons(){
        jBEditar.setEnabled(false);
    }
    
    private void initMasks(){
        try
        {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            jFTFCPF.setFormatterFactory(new DefaultFormatterFactory(mask));
        } catch (ParseException ex) {
            Logger.getLogger(JFAdicionarRepresentante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isValidForm(){
        jBEditar.setEnabled(isValidNome && isValidCpf && isValidEmpresa);
    }
    
    private void initListeners(){
        
        jTFNome.getDocument().addDocumentListener(Validators.getDocumentListener(()->{
             
            this.isValidNome = true;
            jLNome.setText("");
            
            String msg = Validators.validateTextRequired(jTFNome.getText());
            
            if(msg != null)
            {
                jLNome.setText(msg);
                
                this.isValidNome = false;
            }
            
            this.isValidForm();
        }));
        
        jFTFCPF.getDocument().addDocumentListener(Validators.getDocumentListener(()->{
            
            this.isValidCpf = true;
            jLCPF.setText("");
            
            String msg = Validators.validateCPFRequired(jFTFCPF.getText());
            
            if(msg != null)
            {
                jLCPF.setText(msg);
                
                this.isValidCpf = false;
            }
           
            this.isValidForm();
        }));
        
        jTFEmpresa.getDocument().addDocumentListener(Validators.getDocumentListener(()->{
             
            this.isValidEmpresa = true;
            jLEmpresa.setText("");
            
            String msg = Validators.validateTextRequired(jTFEmpresa.getText());
            
            if(msg != null)
            {
                jLEmpresa.setText(msg);
                
                this.isValidEmpresa = false;
            }
            
            this.isValidForm();
        }));
        
    }

    /**
     * Creates new form JFEditarRepresentante
     */
    public JFEditarRepresentante(Representante representante) {
        initComponents();
        initDisabledButtons();
        initListeners();
        initMasks();
        this.setRepresentante(representante); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFTFCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFEmpresa = new javax.swing.JTextField();
        jBEditar = new javax.swing.JButton();
        jLNome = new javax.swing.JLabel();
        jLCPF = new javax.swing.JLabel();
        jLEmpresa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Representante");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Editar Representante");

        jLabel2.setText("Nome:");

        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        jLabel4.setText("Empresa:");

        jBEditar.setText("Salvar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFNome)
                    .addComponent(jFTFCPF)
                    .addComponent(jTFEmpresa)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jBEditar)
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(216, 283));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        try
        {
            this.representante.nome = jTFNome.getText();
            this.representante.cpf = jFTFCPF.getText();
            this.representante.empresa = jTFEmpresa.getText();
            
            if(RepresentanteDao.getPerCPFNotByThisID(this.representante.cpf , this.representante.codigo) == null)
            {
                RepresentanteDao.update(this.representante);
                JOptionPane.showMessageDialog(this,"Alterações salvas com sucesso !");
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Representante com este cpf já existe !");
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao salvar as alterações !");
        }
    }//GEN-LAST:event_jBEditarActionPerformed

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
            java.util.logging.Logger.getLogger(JFEditarRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEditarRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEditarRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEditarRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new JFEditarRepresentante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEditar;
    private javax.swing.JFormattedTextField jFTFCPF;
    private javax.swing.JLabel jLCPF;
    private javax.swing.JLabel jLEmpresa;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTFEmpresa;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
