/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.veteranRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import static Business.Enterprise.Enterprise.EnterpriseType.Housing;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PermHousingOrganization;
import Business.UserAccount.UserAccount;
import Business.Veteran.VeteranDirectory;
import Business.WorkQueue.PermHousingRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import userinterface.PermHousing.PermHousingWorkAreaJPanel;

import Business.DB4OUtil.DB4OUtil;
import Business.Listings.HouseListing;
import Business.Listings.HouseListingDirectory;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akshatananjappa
 */
public class RequestPermHousingJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private VeteranDirectory vd;
    private EcoSystem system;
    HouseListingDirectory hsd;
//    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    private DB4OUtil dB4OUtil;

    /**
     * Creates new form RequestPermHousing
     */
    public RequestPermHousingJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
//        this.enterprise = enterprise;
        this.userAccount = account;
        this.system = system;
        populatePermTable();
    }

    RequestPermHousingJPanel(JPanel userProcessContainer, UserAccount userAccount, VeteranDirectory vd, EcoSystem system) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.vd = vd;
        this.system = system;
        populatePermTable();

//        system = dB4OUtil.retrieveSystem();
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
        messageJTextField = new javax.swing.JTextField();
        requestTestJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        housingListTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Additional Information");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 334, 510, 30));

        requestTestJButton.setBackground(new java.awt.Color(255, 204, 51));
        requestTestJButton.setText("Apply");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 210, -1));

        backJButton.setBackground(new java.awt.Color(255, 204, 51));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 418, 100, -1));

        housingListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area", "Street Name", "Door Number", "City"
            }
        ));
        jScrollPane1.setViewportView(housingListTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 674, 210));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Apply for Permanent Accomodation");
        jLabel2.setFocusable(false);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Choose one listing from the table below and click on Apply - to submit a request");
        jLabel3.setFocusable(false);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        String message = messageJTextField.getText();
        int row = housingListTable.getSelectedRow();
        HouseListing houseListing = (HouseListing) housingListTable.getValueAt(row, 0);
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            PermHousingRequest request = new PermHousingRequest();
            request.setMessage(message);
            request.setSender(userAccount);
            request.setStatus("Sent");
            request.setArea(houseListing.getArea());
            request.setCity(houseListing.getCity());
            request.setDoorNumber(houseListing.getDoorNumber());
            request.setPinCode(houseListing.getPinCode());
            houseListing.setAvailability(1);

            Organization org = null;

            for (Network network : system.getNetworkList()) {
                //Step 2.a: check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
//                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);

                    //Step 3:check against each organization for each enterprise
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof PermHousingOrganization) {
                            org = organization;
                            break;
                        }

                    }
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(request);
                System.out.println("Added Request to Org ");
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                System.out.println("Added Request to UserAccount ");
//            dB4OUtil.storeSystem(system);
//            System.out.println("Stored Inside System");
            }
            JOptionPane.showMessageDialog(null, "Request Has Been Raised. You will be notified accordingly.", "Warning", JOptionPane.WARNING_MESSAGE);
            requestTestJButton.setEnabled(false);
            messageJTextField.setText("");
            messageJTextField.setEnabled(false);
        }


    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        VeteranWorkAreaJPanel dwjp = (VeteranWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    public void populatePermTable() {
        DefaultTableModel model = (DefaultTableModel) housingListTable.getModel();

        model.setRowCount(0);
        System.out.println("Inside PopulateTable");

        for (HouseListing houseListing : system.getHsd().getHouseListing_Dir()) {
            System.out.println("Inside LOOP");
            Object[] row = new Object[4];

            if (houseListing.getAvailability() == 0) {

                row[0] = houseListing;
                row[1] = houseListing.getStreetName();
                row[2] = houseListing.getDoorNumber();
                row[3] = houseListing.getCity();

                model.addRow(row);

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable housingListTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestTestJButton;
    // End of variables declaration//GEN-END:variables
}
