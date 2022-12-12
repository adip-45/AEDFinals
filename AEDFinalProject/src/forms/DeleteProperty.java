/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import bean.PropertyEnlist;
import dao.IQueryMapper;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import util.DbUtil;

/**
 *
 * @author Divyesh Rajput
 */
public class DeleteProperty extends javax.swing.JPanel {

    /**
     * Creates new form DeleteProperty
     */
    String fName;
    
    public DeleteProperty() {
        initComponents();
        show_property();
        
    }
    
    public DeleteProperty(String fName) {
        initComponents();
        this.fName = fName;
        show_property();
        
    }
    public ArrayList<PropertyEnlist> propertyList (){
           ArrayList <PropertyEnlist> propertyList = new ArrayList<>();
           try {
            Connection conn = DbUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(IQueryMapper.SELECT_PROPERTY_ENLIST_2);
            ps.setString(1, this.fName);
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs= ps.executeQuery();
            PropertyEnlist property;
            while (rs.next()){
            property = new PropertyEnlist(rs.getString("Property_id"), rs.getString("PropertyName"), rs.getString("Capacity"), rs.getString("Street"), rs.getString("City"));    
            propertyList.add(property);
            }
            
        }
           catch (Exception e){
               JOptionPane.showMessageDialog(null,e);
           }
           return propertyList;
    }
    
    public void show_property(){
        ArrayList <PropertyEnlist> list = propertyList();
        DefaultTableModel model = (DefaultTableModel)jTableProperty.getModel();
        Object[] row = new Object[5];
        for (int i =0; i<list.size(); i++)
        {
            row[0] = list.get(i).getPropertyID();
            row[1]= list.get(i).getPropertyName();
            row[2] = list.get(i).getCapacity();
            row[3] = list.get(i).getStreet();
            row[4] = list.get(i).getCity();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProperty = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(107, 112, 92));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(107, 112, 92));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(107, 112, 92));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Remove Property", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("  Delete Property ");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));

        jTableProperty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PropertyID", "Property Name", "Capacity", "Street", "City"
            }
        ));
        jScrollPane1.setViewportView(jTableProperty);

        jButton1.setBackground(new java.awt.Color(173, 239, 209));
        jButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/icons/delete (1).png"))); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            try {
            Connection conn = DbUtil.getConnection();
            int row = jTableProperty.getSelectedRow();
            if (row<0){
            JOptionPane.showMessageDialog(this, "Please select a record to delete");
        }
         String PropertyID = (jTableProperty.getModel().getValueAt(row, 0).toString());
         String deleteQuery = "DELETE FROM property_enlist WHERE Property_id ="+PropertyID;
         PreparedStatement pst = conn.prepareStatement(deleteQuery);
         pst.executeUpdate();
         
         DefaultTableModel model = (DefaultTableModel) jTableProperty.getModel();
         model.setRowCount(0);
         
         show_property();
         JOptionPane.showMessageDialog(null,"Deleted Successfully");
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProperty;
    // End of variables declaration//GEN-END:variables
}
