/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.veteranRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PermHousingOrganization;
import Business.Organization.VeteranOrganization;
import Business.Organization.VocationalSchoolOrganization;
import Business.UserAccount.UserAccount;
import Business.Veteran.VeteranDirectory;
import Business.WorkQueue.VocTrainingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shivanginagar
 */
public class RequestVocTrainingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestVocTrainingJPanel
     */
    private JPanel userProcessContainer;
    private VeteranOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;
    private VeteranDirectory vd;

    RequestVocTrainingJPanel(JPanel userProcessContainer, UserAccount userAccount, VeteranDirectory vd, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.vd = vd;
        this.userAccount = userAccount;
        this.system = system;

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
        fundingAssistanceComboBox = new javax.swing.JComboBox<>();
        campusComboBox = new javax.swing.JComboBox<>();
        coursesComboBox = new javax.swing.JComboBox<>();
        educationComboBox = new javax.swing.JComboBox<>();
        txtSubmit = new javax.swing.JButton();
        txtAdditionalSkills = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Apply for Vocational Education");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Vocational schools typically offer relatively short, career-focused programs that quickly prepare you for the workforce.");
        jLabel2.setFocusable(false);

        fundingAssistanceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        campusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Boston", "New Jersey", "Phoenix" }));

        coursesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carpentry", "Welding", "Construction", "Landscaping" }));
        coursesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesComboBoxActionPerformed(evt);
            }
        });

        educationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High School", "High School Diploma", "Bachelors", "Masters" }));

        txtSubmit.setBackground(new java.awt.Color(255, 204, 51));
        txtSubmit.setText("Submit");
        txtSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubmitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Area of Interest");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Campus");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Highest Qualification");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Funding Required?");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Additional Information");

        backJButton.setBackground(new java.awt.Color(255, 204, 51));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addComponent(backJButton))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(coursesComboBox, 0, 169, Short.MAX_VALUE)
                                .addComponent(fundingAssistanceComboBox, 0, 169, Short.MAX_VALUE)
                                .addComponent(educationComboBox, 0, 169, Short.MAX_VALUE)
                                .addComponent(txtAdditionalSkills, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coursesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(educationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fundingAssistanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtAdditionalSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtSubmit)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void coursesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursesComboBoxActionPerformed

    private void txtSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubmitActionPerformed
        // TODO add your handling code here:

        VocTrainingRequest request = new VocTrainingRequest();
        request.setMessage(txtAdditionalSkills.getText());
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setAreaOfInterest((String) coursesComboBox.getSelectedItem());
        request.setHighestQualification((String) educationComboBox.getSelectedItem());
        request.setCampus((String) campusComboBox.getSelectedItem());
        request.setFundingRequired((String) fundingAssistanceComboBox.getSelectedItem());
        request.setAdditionalComments(txtAdditionalSkills.getText());

        String message = "User: " + userAccount.getUsername() + " raised a request for " + (String) coursesComboBox.getSelectedItem() + " at " + (String) campusComboBox.getSelectedItem() + " Campus";
        try {
            URL yahoo = new URL("https://api.telegram.org/bot886367737:AAE0-wbD4ww50nkPy7M-6KKrMtN2sg70z_Q/sendMessage?chat_id=@AED_Helper&text=" + message);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Oops Something went wrong.");

        }

        Organization org = null;
        System.out.println("Collected Variables");
        System.out.println(coursesComboBox.getSelectedItem());

        for (Network network : system.getNetworkList()) {
            //Step 2.a: check against each enterprise
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                System.out.println(enterprise);

//                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                //Step 3:check against each organization for each enterprise
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    System.out.println(organization);

                    if (organization instanceof VocationalSchoolOrganization) {
                        org = organization;

                        System.out.println(org);
                        break;
                    }

                }
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            System.out.println("Added VocationalRequest to Org");
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            System.out.println("Added VocationalRequest to UserAccount");

            JOptionPane.showMessageDialog(null, "Request Submitted Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_txtSubmitActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        VeteranWorkAreaJPanel dwjp = (VeteranWorkAreaJPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox<String> campusComboBox;
    private javax.swing.JComboBox<String> coursesComboBox;
    private javax.swing.JComboBox<String> educationComboBox;
    private javax.swing.JComboBox<String> fundingAssistanceComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAdditionalSkills;
    private javax.swing.JButton txtSubmit;
    // End of variables declaration//GEN-END:variables
}
