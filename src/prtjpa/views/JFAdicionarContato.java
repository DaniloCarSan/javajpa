/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prtjpa.views;

import daos.ContatoDao;
import entities.Contato;
import entities.Representante;
import helpers.Converts;
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
public class JFAdicionarContato extends javax.swing.JFrame {
    
    Representante representante;
            
    boolean isValidData = false;
    boolean isValidHora = false;
    boolean isValidAssunto = false;
    
    public void validateForm(){
        this.jBSalvar.setEnabled(isValidData && isValidHora && isValidAssunto);
    }
    
    private void initMasks(){
        try
        {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            jFTFData.setFormatterFactory(new DefaultFormatterFactory(maskData));
            
            MaskFormatter maskHora = new MaskFormatter("##:##");
            jFTFHora.setFormatterFactory(new DefaultFormatterFactory(maskHora));
            
        } catch (ParseException ex) {
            Logger.getLogger(JFAdicionarRepresentante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initListeners(){
        
        jFTFData.getDocument().addDocumentListener(Validators.getDocumentListener(()->{
            
            jLData.setText("");
            this.isValidData = true;
            
            String msg = Validators.validateDateRequired(jFTFData.getText());
            
            if( msg != null)
            {
                jLData.setText(msg);
                this.isValidData = false;
            }
        
            this.validateForm();
        }));
        
        jFTFHora.getDocument().addDocumentListener(Validators.getDocumentListener(()->{
            
            jLHora.setText("");
            this.isValidHora = true;
            
            String msg = Validators.validateHoraRequired(jFTFHora.getText());
            
            if( msg != null)
            {
                jLHora.setText(msg);
                this.isValidHora = false;
            }
        
            this.validateForm();
        }));
        
        jTPAssunto.getDocument().addDocumentListener(Validators.getDocumentListener(()->{
            
            jLAssunto.setText("");
            this.isValidAssunto= true;
            
            String msg = Validators.validateTextRequired(jTPAssunto.getText());
            
            if( msg != null)
            {
                jLAssunto.setText(msg);
                this.isValidAssunto = false;
            }
        
            this.validateForm();
        }));
    
    }

    /**
     * Creates new form JFAdicionarContato
     */
    public JFAdicionarContato(Representante representante) {
        initComponents();
        initMasks();
        initListeners();
        
        this.jBSalvar.setEnabled(false);
        
        this.representante = representante;
        
        
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
        jFTFData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFTFHora = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPAssunto = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jBSalvar = new javax.swing.JButton();
        jLData = new javax.swing.JLabel();
        jLHora = new javax.swing.JLabel();
        jLAssunto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Contato");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Cadastrar Contato");

        jLabel2.setText("Data:");

        jFTFData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFDataActionPerformed(evt);
            }
        });

        jLabel3.setText("Hora:");

        jScrollPane1.setViewportView(jTPAssunto);

        jLabel4.setText("Assunto:");

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFTFData)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLHora)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jFTFHora)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLData))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLAssunto)))
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jBSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLAssunto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSalvar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(224, 369));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFTFDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFDataActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        
        try 
        {
            String data = jFTFData.getText();
            String hora = jFTFHora.getText();
            String assunto = jTPAssunto.getText();
            
            Contato contato = new Contato();
            
            contato.data = Converts.convertDateFromBrToUsa(data);
            contato.hora = hora;
            contato.assunto = assunto;
            contato.representante_codigo = this.representante.codigo;

            ContatoDao.create(contato);
            JOptionPane.showMessageDialog(this,"Contato cadastrado com sucesso !");
            this.dispose();
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao salvar contato !");
        }
        
    }//GEN-LAST:event_jBSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JFAdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAdicionarContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new JFAdicionarContato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFHora;
    private javax.swing.JLabel jLAssunto;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTPAssunto;
    // End of variables declaration//GEN-END:variables
}
