/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.billman.stp;

import javax.swing.JPanel;

public final class TrgVisualPanel1 extends JPanel
{
  public static final String TABLE_NAME = "tableName";
  public static final String BEFORE_OR_AFTER = "beforeOrAfter";
  public static final String UPDATE_EVENT = "updateEvent";

  /**
   * Creates new form xxxVisualPanel1
   */
  public TrgVisualPanel1()
  {
    initComponents();
  }

  @Override
  public String getName()
  {
    return "Step #1";
  }

  public String getTableName()
  {
    return jTableName.getText();
  }

  public String getBeforeOrAfter()
  {
    return jBeforeAfter.getSelectedItem().toString();
  }

  public String getUpdateEvent()
  {
    return jUpdateEvent.getSelectedItem().toString();
  }

  /**
   * This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jLabel1 = new javax.swing.JLabel();
    jTableName = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jBeforeAfter = new javax.swing.JComboBox<>();
    jUpdateEvent = new javax.swing.JComboBox<>();

    org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(TrgVisualPanel1.class, "TrgVisualPanel1.jLabel1.text")); // NOI18N

    jTableName.setText(org.openide.util.NbBundle.getMessage(TrgVisualPanel1.class, "TrgVisualPanel1.jTableName.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(TrgVisualPanel1.class, "TrgVisualPanel1.jLabel2.text")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(TrgVisualPanel1.class, "TrgVisualPanel1.jLabel3.text")); // NOI18N

    jBeforeAfter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "before", "after" }));
    jBeforeAfter.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jBeforeAfterActionPerformed(evt);
      }
    });

    jUpdateEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "insert", "update", "delete" }));
    jUpdateEvent.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jUpdateEventActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(jLabel3))
        .addGap(33, 33, 33)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jTableName, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
          .addComponent(jBeforeAfter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jUpdateEvent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(101, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(52, 52, 52)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jTableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jBeforeAfter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jUpdateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addContainerGap(148, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jBeforeAfterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBeforeAfterActionPerformed
  {//GEN-HEADEREND:event_jBeforeAfterActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jBeforeAfterActionPerformed

  private void jUpdateEventActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jUpdateEventActionPerformed
  {//GEN-HEADEREND:event_jUpdateEventActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jUpdateEventActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> jBeforeAfter;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField jTableName;
  private javax.swing.JComboBox<String> jUpdateEvent;
  // End of variables declaration//GEN-END:variables
}
