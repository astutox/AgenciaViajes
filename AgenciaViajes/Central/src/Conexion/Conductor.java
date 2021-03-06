/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIANELA
 */
public class Conductor extends javax.swing.JFrame {
    
    DefaultTableModel model;

    /**
     * Creates new form Conductor
     */

    public Conductor() {
        initComponents();
        limpiar();
        bloquear();
        cargar("");
        combo();
        combo2();
        bactualizar.setEnabled(false);
    }
   
    
    
     void combo(){
        //this.AC.removeAllItems();
        conectar cc=new conectar();
        Connection cn=cc.conexion();
        String sql="SELECT * FROM camion";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                this.AC.addItem(rs.getString("Matricula_cli"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void combo2(){
        //this.AC.removeAllItems();
        conectar cc=new conectar();
        Connection cn=cc.conexion();
        String sql="SELECT * FROM departamento";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                this.Domc.addItem(rs.getString("departamento"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    
     void cargar(String valor){
            String[] titulos={"ID","DNI","Nombre","Domicilio","Telefono","FechaNacimiento","Matricula de Camion"};
            String[] registros = new String[7];
            
            String sql="SELECT * FROM conductor,camion where conductor.IDcamion_cli=camion.ID_cli && RFC_cli LIKE '%"+valor+"%'";
            
            model = new DefaultTableModel(null,titulos);
            
            conectar cc=new conectar();
            Connection cn=cc.conexion();
            
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
                       
            while(rs.next()){
                registros[0]=rs.getString("ID_cli");
                registros[1]=rs.getString("RFC_cli");
                registros[2]=rs.getString("Nombre_cli");
                registros[3]=rs.getString("Domicilio_cli");
                registros[4]=rs.getString("Telefono_cli");
                registros[5]=rs.getString("FechaNacimiento_cli");
                registros[6]=rs.getString("Matricula_cli");
                model.addRow(registros);
            }
                        
            tconductor.setModel(model);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    void limpiar(){
        rfc.setText("");
        nomb.setText("");
        telf.setText("");
        fn.setText("");
    }
    
    void bloquear(){
         rfc.setEnabled(false);
        nomb.setEnabled(false);
        Domc.setEnabled(false);
        telf.setEnabled(false);
        fn.setEnabled(false);
        AC.setEnabled(false);
        bnuevo.setEnabled(true);
        bguardar.setEnabled(false);
        bcancelar.setEnabled(false);        
    }
    
    void habilitar(){
        rfc.setEnabled(true);
        nomb.setEnabled(true);
        Domc.setEnabled(true);
        telf.setEnabled(true);
        fn.setEnabled(true);
        AC.setEnabled(true);
        bnuevo.setEnabled(false);
        bguardar.setEnabled(true);
        bcancelar.setEnabled(true);        
    }
    
    void actualizar(){
        rfc.setEnabled(true);
        nomb.setEnabled(true);
        Domc.setEnabled(true);
        telf.setEnabled(true);
        fn.setEnabled(true);
        AC.setEnabled(true);
        bactualizar.setEnabled(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        rfc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        telf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        bnuevo = new javax.swing.JButton();
        bguardar = new javax.swing.JButton();
        bcancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tconductor = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        aux = new javax.swing.JTextField();
        bmostar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        AC = new javax.swing.JComboBox();
        bactualizar = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Domc = new javax.swing.JComboBox();
        backhome = new javax.swing.JLabel();
        rfc1 = new javax.swing.JTextField();

        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conductor");
        setResizable(false);

        jLabel1.setText("DNI: ");

        rfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfcActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        nomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombActionPerformed(evt);
            }
        });

        jLabel3.setText("Domicilio: ");

        jLabel4.setText("Telefono: ");

        telf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telfActionPerformed(evt);
            }
        });

        jLabel5.setText("FechaNacimiento: ");

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });

        bnuevo.setText("Nuevo");
        bnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnuevoActionPerformed(evt);
            }
        });

        bguardar.setText("Guardar");
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });

        bcancelar.setText("Cancelar");
        bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelarActionPerformed(evt);
            }
        });

        tconductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tconductor.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tconductor);

        jLabel6.setText("Buscar: ");

        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });

        bmostar.setText("Mostrar Todos");
        bmostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmostarActionPerformed(evt);
            }
        });

        jLabel7.setText("Asignar Camion: ");

        AC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona.." }));

        bactualizar.setText("Actualizar");
        bactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualizarActionPerformed(evt);
            }
        });

        id.setEnabled(false);

        jLabel8.setText("ID: ");

        Domc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona.." }));

        backhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/backhome.png"))); // NOI18N
        backhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backhomeMouseClicked(evt);
            }
        });

        rfc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfc1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(aux, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(bmostar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(bnuevo)
                                .addGap(16, 16, 16)
                                .addComponent(bactualizar)
                                .addGap(18, 18, 18)
                                .addComponent(bguardar)
                                .addGap(18, 18, 18)
                                .addComponent(bcancelar)
                                .addGap(39, 39, 39)
                                .addComponent(backhome)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AC, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Domc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nomb, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(rfc1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(261, 261, 261)))
                        .addGap(52, 52, 52))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bactualizar, bcancelar, bguardar, bnuevo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rfc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Domc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bnuevo)
                        .addComponent(bguardar)
                        .addComponent(bcancelar)
                        .addComponent(bactualizar))
                    .addComponent(backhome))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(aux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bmostar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        rfc.requestFocus();
    }//GEN-LAST:event_bnuevoActionPerformed

    private void bcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
        bloquear();
    }//GEN-LAST:event_bcancelarActionPerformed

    private void rfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfcActionPerformed
        // TODO add your handling code here:
        rfc.requestFocus();
    }//GEN-LAST:event_rfcActionPerformed

    private void nombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombActionPerformed
        // TODO add your handling code here:
        nomb.requestFocus();
    }//GEN-LAST:event_nombActionPerformed

    private void telfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telfActionPerformed
        // TODO add your handling code here:
        telf.requestFocus();
    }//GEN-LAST:event_telfActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
        fn.requestFocus();
    }//GEN-LAST:event_fnActionPerformed

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        // TODO add your handling code here:
        
        if(this.rfc.getText().length()==0 || this.nomb.getText().length()==0 || 
           this.Domc.getSelectedIndex()==0 || this.telf.getText().length()==0 || 
           this.fn.getText().length()==0 || this.AC.getSelectedIndex()==0 ){
        
            JOptionPane.showMessageDialog(this,"Todos los Campos Deben Llenarse","Mensaje",1);}
        else{
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        String rf,nom,te,fen,mat;
        
     
        
                
        int idcamion;
        String sql="";
        
        rf = rfc.getText();
        nom = nomb.getText(); 
        String dom = (String)Domc.getSelectedItem();
        te = telf.getText();
        fen = fn.getText();
        idcamion = AC.getSelectedIndex();
        sql="INSERT INTO conductor(RFC_cli, Nombre_cli, Domicilio_cli, Telefono_cli, FechaNacimiento_cli ,Matricula_cli, IDcamion_cli)"
                + " VALUES(?,?,?,?,?,?,?)";
        

         String p= "";
     
        
     Statement stm = null;
            try {
                stm = cn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Conductor.class.getName()).log(Level.SEVERE, null, ex);
            }
     // almaceno resultado de consulta en ResultSet
     ResultSet rs = null;
            try {
                rs = stm.executeQuery("SELECT Matricula_cli from camion WHERE ID_cli ="+idcamion);
            } catch (SQLException ex) {
                Logger.getLogger(Conductor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // chequeo que el result set no sea vacío, moviendo el cursor a la
                // primer fila. (El cursor inicia antes de la primer fila)
                if(rs.next()) {
                    //Si hay resultados obtengo el valor.
                    p= rs.getString(1);
                }      } catch (SQLException ex) {
                Logger.getLogger(Conductor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, rf);
            pst.setString(2, nom);
            pst.setString(3, dom);
            pst.setString(4, te);
            pst.setString(5, fen);
            pst.setString(6, p);
            pst.setInt(7, idcamion);
            int n=pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"Registro Guardado");
                bloquear();
                cargar("");
            }
            limpiar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Boleto.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }//GEN-LAST:event_bguardarActionPerformed

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
        // TODO add your handling code here:
        cargar(aux.getText());
    }//GEN-LAST:event_auxKeyReleased

    private void bmostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmostarActionPerformed
        // TODO add your handling code here:
        aux.setText("");
        cargar("");
    }//GEN-LAST:event_bmostarActionPerformed

    private void bactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizarActionPerformed
        // TODO add your handling code here:
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        try{
            PreparedStatement pst = cn.prepareStatement("UPDATE conductor SET RFC_cli='"+
                    rfc.getText()+"',Nombre_cli='"+nomb.getText()+"',Domicilio_cli='"+
                    Domc.getSelectedIndex()+"',Telefono_cli='"+telf.getText()+"',FechaNacimiento_cli='"+
                    fn.getText()+"',IDcamion_cli='"+AC.getSelectedIndex()+"' WHERE ID_cli='"+
                    id.getText()+"'");
            pst.executeUpdate();
            cargar("");
            bactualizar.setEnabled(false);
            bloquear();
            limpiar();
        }
        catch(SQLException e){JOptionPane.showMessageDialog(null,e.getMessage());}
        
    }//GEN-LAST:event_bactualizarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fil=tconductor.getSelectedRow();
        if(fil>=0){
            id.setText(tconductor.getValueAt(fil, 0).toString());
            rfc.setText(tconductor.getValueAt(fil, 1).toString());
            nomb.setText(tconductor.getValueAt(fil, 2).toString());
            Domc.setSelectedItem(tconductor.getValueAt(fil, 3).toString());
            telf.setText(tconductor.getValueAt(fil, 4).toString());
            fn.setText(tconductor.getValueAt(fil, 5).toString());
            AC.setSelectedItem(tconductor.getValueAt(fil, 6));
            actualizar();
        }
        else{
            JOptionPane.showMessageDialog(null,"No se ha Seleccionado Una Fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void backhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backhomeMouseClicked
        new Menu().setVisible(true);  this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_backhomeMouseClicked

    private void rfc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rfc1ActionPerformed

    
    
    
    
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
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AC;
    private javax.swing.JComboBox Domc;
    private javax.swing.JTextField aux;
    private javax.swing.JLabel backhome;
    private javax.swing.JButton bactualizar;
    private javax.swing.JButton bcancelar;
    private javax.swing.JButton bguardar;
    private javax.swing.JButton bmostar;
    private javax.swing.JButton bnuevo;
    private javax.swing.JTextField fn;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomb;
    private javax.swing.JTextField rfc;
    private javax.swing.JTextField rfc1;
    private javax.swing.JTable tconductor;
    private javax.swing.JTextField telf;
    // End of variables declaration//GEN-END:variables
}
