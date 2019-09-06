import javax.swing.*;
import java.sql.*;

public class PatPage extends javax.swing.JFrame {


    public PatPage() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        patID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayArea = new javax.swing.JTextArea();
        seeInfoButton = new javax.swing.JButton();
        newpLabel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(73, 10, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Your ID");

        newpLabel.setFont(new java.awt.Font("Tahoma", 1, 15));
        newpLabel.setText("I am new");
        newpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newpLabelMouseClicked(evt);
            }
        });


        displayArea.setEditable(false);
        displayArea.setBackground(new java.awt.Color(73, 10, 10));
        displayArea.setColumns(20);
        displayArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        displayArea.setForeground(new java.awt.Color(255, 255, 255));
        displayArea.setRows(5);
        jScrollPane1.setViewportView(displayArea);

        seeInfoButton.setText("See My Information");
        seeInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seeInfoButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(patID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(newpLabel)
                                                .addGap(5,5,5))
                                        .addComponent(seeInfoButton))
                                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(patID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newpLabel)
                                        .addGap(5,5,5))
                                .addGap(30, 30, 30)
                                .addComponent(seeInfoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void seeInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {
        String patid=patID.getText();
        int flag=0;
        try (Connection connection = DbConnection.getInstance().getConnection()) {
            String idSQL="SELECT * FROM patients";
            PreparedStatement statement = connection.prepareStatement(idSQL);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int compareid=resultSet.getInt("id_pat");
                String compId=String.valueOf(compareid);
                if(patid.equals(compId)){
                    flag=1;
                    displayArea.append(resultSet.getString("id_pat")+'\n');
                    displayArea.append(resultSet.getString(("fullname_pat"))+'\n');
                    displayArea.append(resultSet.getString(("gender_pat"))+'\n');
                    displayArea.append(resultSet.getString(("age_pat"))+'\n');
                    displayArea.append(resultSet.getString(("address_pat"))+'\n');
                    displayArea.append(resultSet.getString(("phone_pat"))+'\n');
                    displayArea.append(resultSet.getString(("bloodtype_pat")));
                    break;
                }
            }
            if(flag==0){
                JOptionPane.showMessageDialog(this,"Incorrect ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void newpLabelMouseClicked(java.awt.event.MouseEvent evt) {
        DocPassPage docPassPage=new DocPassPage();
        docPassPage.setVisible(true);
        docPassPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }


    // Variables declaration - do not modify
    private javax.swing.JTextArea displayArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField patID;
    private javax.swing.JButton seeInfoButton;
    private javax.swing.JButton newpLabel;
    // End of variables declaration
}
