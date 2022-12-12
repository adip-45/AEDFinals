/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import bean.PropertyEnlist;
import dao.IQueryMapper;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import util.DbUtil;

/**
 *
 * @author Aditya Prakash
 */
public class SelectPropertyForEvent extends javax.swing.JPanel {

    String filename = null;
    byte[] property_image = null;
    String filename1 = null;
    byte[] property_image1 = null;
    private PropertyEnlist property;
    private ArrayList<PropertyEnlist> propertyList;

    private ArrayList<String> location;
    private ArrayList<String> type;
    private ArrayList<String> capacity;

    private JPanel test;
    private int selectedPropertyIndex;
    private PropertyEnlist selectedProperty;
    String fName;

//    final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
    public SelectPropertyForEvent() {

        initComponents();
        propertyList();
        show_property();
        jPanel4.setVisible(false);
    }

    public SelectPropertyForEvent(String fName) {
        initComponents();
        propertyList();
        show_property();
        setComboLocation();
//        setComboType();
        setComboCapacity();

        this.fName = fName;
        jPanel4.setVisible(false);
    }

    public PropertyEnlist getSelectedProperty() {
        return selectedProperty;
    }

    public void setSelectedProperty(PropertyEnlist selectedProperty) {
        this.selectedProperty = selectedProperty;
    }

    public int getSelectedPropertyIndex() {
        return selectedPropertyIndex;
    }

    public void setSelectedPropertyIndex(int selectedPropertyIndex) {
        this.selectedPropertyIndex = selectedPropertyIndex;
    }

    /**
     * Creates new form AddProperty
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProp = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(14, 44, 63));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Add Event ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("  LIST OF PROPERTIES");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--", "BOSTON", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTableProp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Property Name", "Location", "Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePropMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTablePropMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProp);

        jButton4.setBackground(new java.awt.Color(173, 239, 209));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/icons/accept.png"))); // NOI18N
        jButton4.setText("SELECT PROPERTY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("SORT BY");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("LOCATION");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("CAPACITY:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECT--" }));

        jButton1.setBackground(new java.awt.Color(14, 44, 63));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setText("FILTER");
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
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(jButton1)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 511, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Pictures", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        selectedPropertyIndex = jTableProp.getSelectedRow();
        if (selectedPropertyIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Select a Property");
        }

        selectedProperty = ((PropertyEnlist) jTableProp.getValueAt(getSelectedPropertyIndex(), 0));

        try ( Connection conn = DbUtil.getConnection();  PreparedStatement ps = conn.prepareStatement(IQueryMapper.INSERT_SELECTED_PLACES_FOR_EVENT);) {

            ps.setString(1, selectedProperty.getPropertyName());
            ps.setString(2, selectedProperty.getCapacity());
            ps.setString(3, selectedProperty.getCity());
            ps.setString(6, selectedProperty.getState());
            System.out.println(fName + " " + selectedProperty.getPropertyID() + selectedProperty);
            ps.setString(4, this.fName);
            ps.setString(5, selectedProperty.getPropertyID());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        }

        JOptionPane.showMessageDialog(this, "Property has been added to the Cart! "
                + "Please Add your Event Details Now :)" + selectedProperty + " " + selectedPropertyIndex);

        propertyList();
        show_property();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    int selectedRow;

    private void jTablePropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePropMouseClicked
        // TODO add your handling code here:
        selectedRow = jTableProp.getSelectedRow();
        PropertyEnlist e = (PropertyEnlist) jTableProp.getValueAt(selectedRow, 0);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(e.getImg_1()).getImage().getScaledInstance(687, jLabel8.getHeight(), Image.SCALE_SMOOTH));
        jLabel8.setIcon(imageIcon);

        //System.out.println(jLabel8.getWidth() + ' ' + jLabel8.getHeight());
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(e.getImg_2()).getImage().getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH));
        jLabel10.setIcon(imageIcon1);
        jPanel4.setVisible(true);

    }//GEN-LAST:event_jTablePropMouseClicked

    private void jTablePropMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePropMouseExited
        // TODO add your handling code here:
        selectedRow = -1;
    }//GEN-LAST:event_jTablePropMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String location = jComboBox1.getSelectedItem().toString();
        String capacity = jComboBox2.getSelectedItem().toString();

        if (!location.equals("--SELECT--") && capacity.equals("--SELECT--")) {
            DefaultTableModel model = (DefaultTableModel) jTableProp.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (PropertyEnlist property : propertyList) {
                if (property.getCity().equals(location)) {
                    row[0] = property;
                    row[1] = (property.getCity() + ", " + property.getState());
                    row[2] = property.getCapacity();
                    model.addRow(row);
                }
            }
        } else if (location.equals("--SELECT--") && !capacity.equals("--SELECT--")) {
            DefaultTableModel model = (DefaultTableModel) jTableProp.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (PropertyEnlist property : propertyList) {
                if (property.getCapacity().equals(capacity)) {
                    row[0] = property;
                    row[1] = (property.getCity() + ", " + property.getState());
                    row[2] = property.getCapacity();
                    model.addRow(row);
                }
            }
        } else if (!capacity.equals("--SELECT--") && !location.equals("--SELECT--")) {
            DefaultTableModel model = (DefaultTableModel) jTableProp.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (PropertyEnlist property : propertyList) {
                if (property.getCity().equals(location) && property.getCapacity().equals(capacity)) {
                    row[0] = property;
                    row[1] = (property.getCity() + ", " + property.getState());
                    row[2] = property.getCapacity();
                    model.addRow(row);
                }
            }
        } else {
            DefaultTableModel model = (DefaultTableModel) jTableProp.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (PropertyEnlist property : propertyList) {

                row[0] = property;
                row[1] = (property.getCity() + ", " + property.getState());
                row[2] = property.getCapacity();
                model.addRow(row);

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public ArrayList<PropertyEnlist> propertyList() {

        try {
            Connection conn = DbUtil.getConnection();
            PreparedStatement prep = conn.prepareStatement(IQueryMapper.SELECT_CREATED_PROPERTY_FOR_EVENT);
            //PreparedStatement prep1 = conn.prepareStatement(IQueryMapper.INSERT_PROPERTY_REVIEW);

            propertyList = new ArrayList<>();

            prep.setString(1, "Approved");
            ResultSet rs = null;
            rs = prep.executeQuery();

            while (rs.next()) {
                property = new PropertyEnlist();
                property.setPropertyID(rs.getString(1));
                property.setPropertyName(rs.getString(2));
                property.setCity(rs.getString(4));
                property.setState(rs.getString(5));
                property.setCapacity(rs.getString(7));
                property.setImg_1(rs.getBytes("Img_link"));
                property.setImg_2(rs.getBytes("Img_link1"));
                propertyList.add(property);
                System.out.println(property);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return propertyList;
    }

    public void show_property() {
//        ArrayList<PropertyEnlist> list = propertyList();
        System.out.println("client: " + propertyList);
        DefaultTableModel model = (DefaultTableModel) jTableProp.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for (PropertyEnlist property : propertyList) {
            row[0] = property;
            row[1] = (property.getCity() + ", " + property.getState());
            row[2] = property.getCapacity();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProp;
    // End of variables declaration//GEN-END:variables

    private void setComboLocation() {
        try ( Connection conn = DbUtil.getConnection();  PreparedStatement prep = conn.prepareStatement(IQueryMapper.FETCH_LOCATIONS);) {

            location = new ArrayList<>();
            location.add("--SELECT--");
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                location.add(rs.getString(1));
            }
            System.out.println(location);
            DefaultComboBoxModel model = new DefaultComboBoxModel(location.toArray());
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void setComboType() {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        try ( Connection conn = DbUtil.getConnection();  PreparedStatement prep = conn.prepareStatement(IQueryMapper.FETCH_TYPE);) {
//
//            type = new ArrayList<>();
//            type.add("--SELECT--");
//            ResultSet rs = prep.executeQuery();
//
//            while (rs.next()) {
//                type.add(rs.getString(1));
//            }
//            System.out.println(type);
//            DefaultComboBoxModel model = new DefaultComboBoxModel(type.toArray());
//            jComboBox3.setModel(model);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private void setComboCapacity() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try ( Connection conn = DbUtil.getConnection();  PreparedStatement prep = conn.prepareStatement(IQueryMapper.FETCH_CAPACITY);) {

            capacity = new ArrayList<>();
            capacity.add("--SELECT--");
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                capacity.add(rs.getString(1));
            }
            System.out.println(capacity);
            DefaultComboBoxModel model = new DefaultComboBoxModel(capacity.toArray());
            jComboBox2.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
