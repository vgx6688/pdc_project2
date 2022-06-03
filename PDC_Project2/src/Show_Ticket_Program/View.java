/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author JL Lopez
 */
public class View extends JFrame implements Observer {

    /**
     * Creates new form view_trial
     */
    public View() {
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

        showsButtonGroup = new javax.swing.ButtonGroup();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        detailsPanel = new javax.swing.JPanel();
        detailsLabel = new javax.swing.JLabel();
        showATitle = new javax.swing.JLabel();
        showAGold = new javax.swing.JLabel();
        showASilver = new javax.swing.JLabel();
        showABronze = new javax.swing.JLabel();
        showBTitle = new javax.swing.JLabel();
        showCTitle = new javax.swing.JLabel();
        showBGold = new javax.swing.JLabel();
        showBSilver = new javax.swing.JLabel();
        showBBronze = new javax.swing.JLabel();
        showCBronze = new javax.swing.JLabel();
        showCSilver = new javax.swing.JLabel();
        showCGold = new javax.swing.JLabel();
        inputShowPanel = new javax.swing.JPanel();
        showsTitle = new javax.swing.JLabel();
        showAButton = new javax.swing.JRadioButton();
        showBButton = new javax.swing.JRadioButton();
        showCButton = new javax.swing.JRadioButton();
        selectShow = new javax.swing.JLabel();
        ticketTypes = new javax.swing.JLabel();
        ticketQuants = new javax.swing.JLabel();
        goldQuant = new javax.swing.JComboBox<>();
        silverQuant = new javax.swing.JComboBox<>();
        bronzeQuant = new javax.swing.JComboBox<>();
        costLabel = new javax.swing.JLabel();
        goldCost = new javax.swing.JLabel();
        silverCost = new javax.swing.JLabel();
        bronzeCost = new javax.swing.JLabel();
        totalCost = new javax.swing.JLabel();
        goldTotal = new javax.swing.JLabel();
        silverTotal = new javax.swing.JLabel();
        bronzeTotal = new javax.swing.JLabel();
        goldTickets = new javax.swing.JLabel();
        silverTickets = new javax.swing.JLabel();
        bronzeTickets = new javax.swing.JLabel();
        infoInputPanel = new javax.swing.JPanel();
        requiredInfo = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        userPhNum = new javax.swing.JLabel();
        phNumField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        finalCostlabel = new javax.swing.JLabel();
        finalCost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(540, 720));
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("TICKET SHOW BOOKING");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(120, 120, 120))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(titleLabel))
        );

        detailsPanel.setPreferredSize(new java.awt.Dimension(520, 166));
        detailsPanel.setLayout(null);

        detailsLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        detailsLabel.setText("Show - Tickets Left");
        detailsPanel.add(detailsLabel);
        detailsLabel.setBounds(190, 0, 160, 25);

        showATitle.setText("SHOW A - May 27, 2022 ");
        detailsPanel.add(showATitle);
        showATitle.setBounds(30, 40, 163, 21);

        showAGold.setText("Gold Tickets Left: ???");
        detailsPanel.add(showAGold);
        showAGold.setBounds(30, 70, 150, 21);

        showASilver.setText("Silver Tickets left: ???");
        detailsPanel.add(showASilver);
        showASilver.setBounds(30, 100, 139, 21);

        showABronze.setText("Bronze Tickets left: ???");
        detailsPanel.add(showABronze);
        showABronze.setBounds(30, 130, 149, 21);

        showBTitle.setText("SHOW B - May 28, 2022 ");
        detailsPanel.add(showBTitle);
        showBTitle.setBounds(200, 40, 182, 21);

        showCTitle.setText("SHOW C - May 29, 2022 ");
        detailsPanel.add(showCTitle);
        showCTitle.setBounds(370, 40, 162, 21);

        showBGold.setText("Gold Tickets left: ???");
        detailsPanel.add(showBGold);
        showBGold.setBounds(200, 70, 139, 21);

        showBSilver.setText("Silver Tickets left: ???");
        detailsPanel.add(showBSilver);
        showBSilver.setBounds(200, 100, 139, 21);

        showBBronze.setText("Bronze Tickets left: ???");
        detailsPanel.add(showBBronze);
        showBBronze.setBounds(200, 130, 149, 21);

        showCBronze.setText("Bronze Tickets left: ???");
        detailsPanel.add(showCBronze);
        showCBronze.setBounds(370, 130, 149, 21);

        showCSilver.setText("Silver Tickets left: ???");
        detailsPanel.add(showCSilver);
        showCSilver.setBounds(370, 100, 139, 21);

        showCGold.setText("Gold Tickets left: ???");
        detailsPanel.add(showCGold);
        showCGold.setBounds(370, 70, 135, 21);

        showsTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        showsTitle.setText("Book");

        showsButtonGroup.add(showAButton);
        showAButton.setText("Show A");
        showAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAButtonActionPerformed(evt);
            }
        });

        showsButtonGroup.add(showBButton);
        showBButton.setText("Show B");
        showBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBButtonActionPerformed(evt);
            }
        });

        showsButtonGroup.add(showCButton);
        showCButton.setText("Show C");
        showCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCButtonActionPerformed(evt);
            }
        });

        selectShow.setText("Select a show:");

        ticketTypes.setText("Ticket Types:");

        ticketQuants.setText("Select Quantity:");

        goldQuant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        goldQuant.setActionCommand("Gold Ticket");

        silverQuant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        silverQuant.setActionCommand("Silver Ticket");

        bronzeQuant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        bronzeQuant.setActionCommand("Bronze Ticket");

        costLabel.setText("Cost:");

        goldCost.setText("$30.00");

        silverCost.setText("$21.00");

        bronzeCost.setText("$12.00");

        totalCost.setText("Total:");

        goldTotal.setText("$0.00");

        silverTotal.setText("$0.00");

        bronzeTotal.setText("$0.00");

        goldTickets.setText("Gold");

        silverTickets.setText("Silver");

        bronzeTickets.setText("Bronze");

        javax.swing.GroupLayout inputShowPanelLayout = new javax.swing.GroupLayout(inputShowPanel);
        inputShowPanel.setLayout(inputShowPanelLayout);
        inputShowPanelLayout.setHorizontalGroup(
            inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputShowPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(silverTickets)
                    .addComponent(goldTickets)
                    .addComponent(bronzeTickets)
                    .addComponent(ticketTypes))
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(silverQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goldQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bronzeQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97))
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(ticketQuants)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(goldCost)
                    .addComponent(silverCost)
                    .addComponent(bronzeCost)
                    .addComponent(costLabel))
                .addGap(44, 44, 44)
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalCost)
                    .addComponent(goldTotal)
                    .addComponent(silverTotal)
                    .addComponent(bronzeTotal))
                .addGap(75, 75, 75))
            .addGroup(inputShowPanelLayout.createSequentialGroup()
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(selectShow))
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(showsTitle))
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(showAButton)
                        .addGap(28, 28, 28)
                        .addComponent(showBButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showCButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputShowPanelLayout.setVerticalGroup(
            inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputShowPanelLayout.createSequentialGroup()
                .addComponent(showsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectShow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showBButton)
                        .addComponent(showCButton))
                    .addComponent(showAButton))
                .addGap(18, 18, 18)
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ticketTypes)
                    .addComponent(ticketQuants)
                    .addComponent(costLabel)
                    .addComponent(totalCost))
                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputShowPanelLayout.createSequentialGroup()
                                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(goldCost)
                                    .addComponent(goldTotal))
                                .addGap(18, 18, 18)
                                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(silverCost)
                                    .addComponent(silverTotal))
                                .addGap(18, 18, 18)
                                .addGroup(inputShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bronzeCost)
                                    .addComponent(bronzeTotal)))
                            .addGroup(inputShowPanelLayout.createSequentialGroup()
                                .addComponent(goldTickets)
                                .addGap(18, 18, 18)
                                .addComponent(silverTickets)
                                .addGap(18, 18, 18)
                                .addComponent(bronzeTickets))))
                    .addGroup(inputShowPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(goldQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(silverQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bronzeQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        requiredInfo.setText("User Information Required");

        userName.setText("Full Name: ");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        userPhNum.setText("Phone Number:");

        phNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phNumFieldActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.setPreferredSize(new java.awt.Dimension(95, 30));
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(95, 30));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        finalCostlabel.setText("Total Cost:");

        finalCost.setText("$0.00");

        javax.swing.GroupLayout infoInputPanelLayout = new javax.swing.GroupLayout(infoInputPanel);
        infoInputPanel.setLayout(infoInputPanelLayout);
        infoInputPanelLayout.setHorizontalGroup(
            infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoInputPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoInputPanelLayout.createSequentialGroup()
                        .addGroup(infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userPhNum)
                            .addComponent(userName))
                        .addGap(18, 18, 18)
                        .addGroup(infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField)
                            .addComponent(phNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoInputPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoInputPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(finalCostlabel)
                                .addGap(46, 46, 46)
                                .addComponent(finalCost))))
                    .addGroup(infoInputPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(requiredInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        infoInputPanelLayout.setVerticalGroup(
            infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requiredInfo)
                .addGap(20, 20, 20)
                .addGroup(infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalCostlabel)
                    .addComponent(finalCost))
                .addGap(22, 22, 22)
                .addGroup(infoInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPhNum)
                    .addComponent(phNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputShowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputShowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showAButtonActionPerformed

    private void showBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showBButtonActionPerformed

    private void showCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showCButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void phNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phNumFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cancelButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_confirmButtonActionPerformed

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
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bronzeCost;
    public javax.swing.JComboBox<String> bronzeQuant;
    private javax.swing.JLabel bronzeTickets;
    private javax.swing.JLabel bronzeTotal;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel finalCost;
    private javax.swing.JLabel finalCostlabel;
    private javax.swing.JLabel goldCost;
    public javax.swing.JComboBox<String> goldQuant;
    private javax.swing.JLabel goldTickets;
    private javax.swing.JLabel goldTotal;
    private javax.swing.JPanel infoInputPanel;
    private javax.swing.JPanel inputShowPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phNumField;
    private javax.swing.JLabel requiredInfo;
    private javax.swing.JLabel selectShow;
    private javax.swing.JLabel showABronze;
    private javax.swing.JRadioButton showAButton;
    private javax.swing.JLabel showAGold;
    private javax.swing.JLabel showASilver;
    private javax.swing.JLabel showATitle;
    private javax.swing.JLabel showBBronze;
    private javax.swing.JRadioButton showBButton;
    private javax.swing.JLabel showBGold;
    private javax.swing.JLabel showBSilver;
    private javax.swing.JLabel showBTitle;
    private javax.swing.JLabel showCBronze;
    private javax.swing.JRadioButton showCButton;
    private javax.swing.JLabel showCGold;
    private javax.swing.JLabel showCSilver;
    private javax.swing.JLabel showCTitle;
    private javax.swing.ButtonGroup showsButtonGroup;
    private javax.swing.JLabel showsTitle;
    private javax.swing.JLabel silverCost;
    public javax.swing.JComboBox<String> silverQuant;
    private javax.swing.JLabel silverTickets;
    private javax.swing.JLabel silverTotal;
    private javax.swing.JLabel ticketQuants;
    private javax.swing.JLabel ticketTypes;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel totalCost;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userPhNum;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        ShowData data = (ShowData) arg;
        if (!data.display) {
            if (data.show.equalsIgnoreCase("A")) {
//                System.out.println("Changing text...");
                showATitle.setText("Show A   " + data.date);
                showAGold.setText("Gold: " + Integer.toString(data.goldTicks.quantity));
                showASilver.setText("Silver: " + Integer.toString(data.silverTicks.quantity));
                showABronze.setText("Bronze: " + Integer.toString(data.bronzeTicks.quantity));
            } else if (data.show.equalsIgnoreCase("B")) {
                showBTitle.setText("Show B   " + data.date);
                showBGold.setText("Gold: " + Integer.toString(data.goldTicks.quantity));
                showBSilver.setText("Silver: " + Integer.toString(data.silverTicks.quantity));
                showBBronze.setText("Bronze: " + Integer.toString(data.bronzeTicks.quantity));
            } else {
                showCTitle.setText("Show C   " + data.date);
                showCGold.setText("Gold: " + Integer.toString(data.goldTicks.quantity));
                showCSilver.setText("Silver: " + Integer.toString(data.silverTicks.quantity));
                showCBronze.setText("Bronze: " + Integer.toString(data.bronzeTicks.quantity));
            }

            goldCost.setText(String.format("$%.2f", data.goldTicks.price));
            silverCost.setText(String.format("$%.2f", data.silverTicks.price));
            bronzeCost.setText(String.format("$%.2f", data.bronzeTicks.price));
            detailsPanel.repaint();
        } else if (data.chosen) {
//            System.out.println("Updating JComboBoxes...");
            goldQuant.removeAllItems();
            silverQuant.removeAllItems();
            bronzeQuant.removeAllItems();
            for (int i = 0; i <= data.goldTicks.quantity; i++) {
                goldQuant.addItem(Integer.toString(i));
            }
            for (int i = 0; i <= data.silverTicks.quantity; i++) {
                silverQuant.addItem(Integer.toString(i));
            }
            for (int i = 0; i <= data.bronzeTicks.quantity; i++) {
                bronzeQuant.addItem(Integer.toString(i));
            }
            inputShowPanel.repaint();
        } else if (data.update) {
//            System.out.println("Changing Total costs");
            
            double goldCost = 1.0 * data.goldTicks.quantity * data.goldTicks.price;
            goldTotal.setText(String.format("$%.2f", goldCost));
            
            double silverCost =  1.0 * data.silverTicks.quantity * data.silverTicks.price;
            silverTotal.setText(String.format("$%.2f", silverCost));
            
            double bronzeCost =  1.0 * data.bronzeTicks.quantity * data.bronzeTicks.price;
            bronzeTotal.setText(String.format("$%.2f", bronzeCost));
            inputShowPanel.repaint();
            
            double totalCost = goldCost + silverCost + bronzeCost;
            finalCost.setText(String.format("$%.2f", totalCost));
            infoInputPanel.repaint();
        }
    }

    public void addActionListener(ActionListener listener) {
        this.showAButton.addActionListener(listener);
        this.showBButton.addActionListener(listener);
        this.showCButton.addActionListener(listener);
        this.goldQuant.addActionListener(listener);
        this.silverQuant.addActionListener(listener);
        this.bronzeQuant.addActionListener(listener);
        this.confirmButton.addActionListener(listener);
        this.cancelButton.addActionListener(listener);
    }
}
