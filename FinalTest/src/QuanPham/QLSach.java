/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanPham;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS FX504
 */
public class QLSach extends javax.swing.JFrame {
    private int rowSelected = -1;
    /**
     * Creates new form QLSach
     */
    public QLSach() {
        initComponents();
    }
    
    private boolean LookingForBook (String code) {
        for(int i = 0 ; i < tbSach.getRowCount(); i += 1) {
            if (code.trim().equals(tbSach.getValueAt(i, 0).toString().trim())) {
                this.rowSelected = i;
                return true;
            }
        } 
        rowSelected = -1;
        return false;
    }
    
    private int CheckEmpty() {
        if (txtTenSach.getText().equals("") || txtGia.getText().equals("") || txtMaSach.getText().equals("") || txtNamXB.getText().equals("")) {
            return -1;
        } else if (txtMaSach.getText().length() != 6) {
            return -2;
        } else if (Integer.parseInt(txtNamXB.getText()) > 2021) {
            return -3;
        }
        return 1;
    }
    
    private void UpdateAvaPrice(){
        float total = 0;
        for (int i = 0 ; i < tbSach.getRowCount(); i += 1) {
            total += Integer.parseInt(tbSach.getValueAt(i, 3).toString());
        }            
        total /= tbSach.getRowCount();
        txtGiaTB.setText(String.valueOf(total) + " VNĐ");
    }
    
    private void DeleteBook (int row) {
        ((DefaultTableModel)tbSach.getModel()).removeRow(row);
        UpdateAvaPrice();
    }
    
    private void UpdateBook (String ten, String nam, String gia, String tl){
        tbSach.setValueAt(ten, this.rowSelected, 1);
        tbSach.setValueAt(nam, this.rowSelected, 2);
        tbSach.setValueAt(gia, this.rowSelected, 3);
        tbSach.setValueAt(tl, this.rowSelected, 4); 
        UpdateAvaPrice();
    }
    
    private void AddNewBook(String ma, String ten, String nam, String gia, String tl){
        DefaultTableModel model = (DefaultTableModel)tbSach.getModel();
        model.addRow(new Object[]{ma, ten, nam, gia, tl});        
        UpdateAvaPrice();
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
        txtMaSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtNamXB = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cbTheLoai = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtGiaTB = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUÁN LÝ THÔNG TIN SÁCH");

        jLabel2.setText("Mã sách : ");

        txtMaSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaSachKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSachKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaSachKeyTyped(evt);
            }
        });

        jLabel3.setText("Tên sách : ");

        jLabel4.setText("Năm XB : ");

        jLabel5.setText("Giá bán : ");

        jLabel6.setText("Thể loại : ");

        cbTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa học", "Văn hóa", "Công nghệ thông tin" }));
        cbTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTheLoaiActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"KH0001", "Em yêu khoa học", "2000", "50000", "Khoa học"},
                {"KH0002", "Hải dương học", "2012", "85000", "Khoa học"},
                {"VH0001", "Đắc nhân tâm", "2000", "120000", "Văn hóa"},
                {"CN0001", "Lập trình C cơ bản", "2012", "65000", "Công nghệ thông tin"},
                {"CN0002", "Lập trình Android", "2000", "145000", "Công nghệ thông tin"}
            },
            new String [] {
                "Mã sách", "Tên sách", "Năm XB", "Giá bán", "Thể loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSach);

        jLabel7.setText("Giá bán trung bình");

        txtGiaTB.setEditable(false);
        txtGiaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSach)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbTheLoai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnExit))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSachKeyPressed
        // TODO add your handling code here:
        //        System.out.println("Input : " + txtMaSach.getText());
        //        String maSach = this.txtMaSach.getText();
        //        if (LookingForBook(maSach)) {
            //            btnDelete.setEnabled(false);
            //        } else {
            //            btnDelete.setEnabled(true);
            //        }
    }//GEN-LAST:event_txtMaSachKeyPressed

    private void txtMaSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSachKeyReleased
        // TODO add your handling code here:
        String maSach = this.txtMaSach.getText();
        if (LookingForBook(maSach)) {
            btnDelete.setEnabled(true);
            for(int i = 0 ; i < tbSach.getRowCount(); i += 1) {
                if (maSach.equals(tbSach.getValueAt(i, 0))) {
                    txtTenSach.setText(tbSach.getValueAt(i, 1).toString());
                    txtNamXB.setText(tbSach.getValueAt(i, 2).toString());
                    txtGia.setText(tbSach.getValueAt(i, 3).toString());
                    cbTheLoai.setSelectedItem(tbSach.getValueAt(i, 4));
                }
            }
        } else {
            btnDelete.setEnabled(false);
            txtTenSach.setText("");
            txtGia.setText("");
            txtNamXB.setText("");
            cbTheLoai.setSelectedIndex(0);
        }
    }//GEN-LAST:event_txtMaSachKeyReleased

    private void txtMaSachKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSachKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaSachKeyTyped

    private void cbTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTheLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTheLoaiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String maSach = txtMaSach.getText();
        String tenSach = txtTenSach.getText();
        String gia = txtGia.getText();
        String namXB = txtNamXB.getText();
        String theLoai = cbTheLoai.getSelectedItem().toString();
        if (LookingForBook(maSach)) {
            if (CheckEmpty() > 0) {
                int answer = JOptionPane.showConfirmDialog(this, "Cập nhật sách: " + tbSach.getValueAt(this.rowSelected, 1).toString(), "Cập nhật", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    UpdateBook(tenSach, namXB, gia, theLoai);
                    JOptionPane.showMessageDialog(this, "Cập nhật sách thành công","Cập nhật", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (CheckEmpty() == -1){
                JOptionPane.showMessageDialog(this, "Xin nhập đủ thông tin", "Lỗi nhập dữ liệu", JOptionPane.ERROR_MESSAGE);
            } else if (CheckEmpty() == -3) {
                JOptionPane.showMessageDialog(this, "Nhập năm xuất bản phải lớn hơn năm hiện tại", "Lỗi nhập dữ liệu", JOptionPane.ERROR_MESSAGE);
            } else if (CheckEmpty() == -2) {
                JOptionPane.showMessageDialog(this, "Mã sách phải có đúng 6 ký tự", "Lỗi nhập dữ liệu", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (CheckEmpty() > 0) {
                int answer = JOptionPane.showConfirmDialog(this, "Thêm sách: " + txtTenSach.getText(), "Thêm", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    AddNewBook(maSach, tenSach, namXB, gia, theLoai);
                }
            } else if (CheckEmpty() == -1){
                JOptionPane.showMessageDialog(this, "Xin nhập đủ thông tin", "Lỗi nhập dữ liệu", JOptionPane.ERROR_MESSAGE);
            } else if (CheckEmpty() == -3) {
                JOptionPane.showMessageDialog(this, "Nhập năm xuất bản phải lớn hơn năm hiện tại", "Lỗi nhập dữ liệu", JOptionPane.ERROR_MESSAGE);
            } else if (CheckEmpty() == -2) {
                JOptionPane.showMessageDialog(this, "Mã sách phải có đúng 6 ký tự", "Lỗi nhập dữ liệu", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String maSach = txtMaSach.getText();
        if (LookingForBook(maSach)) {
            int answer = JOptionPane.showConfirmDialog(this, "Xác nhận xóa sách ?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                DeleteBook(this.rowSelected);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách cần xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        // TODO add your handling code here:
        if (tbSach.getSelectedRow() >= 0) {
            btnDelete.setEnabled(true);
        } else {
            btnDelete.setEnabled(false);
        }

        int row = tbSach.getSelectedRow();
        String maSach = tbSach.getValueAt(row, 0).toString();
        String tenSach = tbSach.getValueAt(row, 1).toString();
        String namXB = tbSach.getValueAt(row, 2).toString();
        String gia = tbSach.getValueAt(row, 3).toString();
        String theLoai = tbSach.getValueAt(row, 4).toString();

        txtMaSach.setText(maSach);
        txtTenSach.setText(tenSach);
        txtNamXB.setText(namXB);
        txtGia.setText(gia);
        cbTheLoai.setSelectedItem(theLoai);
    }//GEN-LAST:event_tbSachMouseClicked

    private void txtGiaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTBActionPerformed

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
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaTB;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNamXB;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}