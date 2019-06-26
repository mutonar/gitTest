/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ad
 */
public class JavaApplication5 extends javax.swing.JFrame {

    private String SAMPLE_CSV_FILE_PATH;
    DefaultListModel listModel = new DefaultListModel(); // модель для динамического добавления данных
    int[] columnSend = null;
    // Листенер работает только в настройке элемента в графике
    //jList1.addListSelectionListener(new listSelectionListener());  

    /**
     * Creates new form JavaApplication5
     */
    public JavaApplication5() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new JList<String>(listModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new listSelectionListener());
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    JFileChooser fileopen = new JFileChooser(System.getProperty("user.dir"));
    //JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Чтение CSV");                
        if (ret == JFileChooser.APPROVE_OPTION) {
        File file = fileopen.getSelectedFile();
        SAMPLE_CSV_FILE_PATH = file.getPath();

        }
         try {
            // инициализировать другое окно с классом в этом
             //RunGraph frame = new RunGraph(SAMPLE_CSV_FILE_PATH);
             NewJFrameSimpleGraph_1 frame = new NewJFrameSimpleGraph_1(SAMPLE_CSV_FILE_PATH);
             
             String[]  dataList = frame.getlistNamedGraph();         
             for (int i = 0; i < dataList.length; i++) {
               listModel.addElement(dataList[i]);
             }
            //int removeIndex = 3;
            //listModel.remove(removeIndex); // Это удаление элементов
            
            //frame.setLayout(new BorderLayout());
            //frame.add(ui, BorderLayout.CENTER);
            //frame.pack();
            frame.setSize(800, 600);
            frame.setDefaultLookAndFeelDecorated(true); // С такими параметрами завелось отображение 2 Фрейма на windows7

            frame.setLocationRelativeTo(null); // position in the center of the screen
            //frame.setDefaultCloseOperation(RunGraph.DISPOSE_ON_CLOSE);
            frame.setDefaultCloseOperation(NewJFrameSimpleGraph_1.DISPOSE_ON_CLOSE);
                    
            //new RunGraph(SAMPLE_CSV_FILE_PATH).setVisible(true);
            frame.setVisible(true);
            
            
                } catch (IOException ex) {
                    Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
                   

                }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JavaApplication5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaApplication5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaApplication5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaApplication5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaApplication5().setVisible(true);
            }
        });
    }
    
    // Класс нашего слушателя списка
    class listSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            // Выделенная строка
            columnSend = ((JList<?>)e.getSource()).getSelectedIndices();
            for(int i=0; i<columnSend.length; ++i){
                System.out.print(columnSend[i]);
            }
            System.out.println();
         //   int selected = ((JList<?>)e.getSource()).
           //                                   getSelectedIndex();
           // System.out.println ("Выделенная строка : " + 
            //                         String.valueOf(selected));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
