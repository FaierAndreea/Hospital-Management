import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocPage extends javax.swing.JFrame {


    public DocPage() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(73, 10, 10));

        jButton1.setText("See Information of all patients");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(73, 10, 10));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(jButton1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        try (Connection connection = DbConnection.getInstance().getConnection()){
            String idSQL="SELECT * FROM patients";
            PreparedStatement statement = connection.prepareStatement(idSQL);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                jTextArea1.append(resultSet.getString("id_pat")+'\n');
                jTextArea1.append(resultSet.getString("fullname_pat")+'\n');
                jTextArea1.append(resultSet.getString("gender_pat")+'\n');
                jTextArea1.append(resultSet.getString("age_pat")+'\n');
                jTextArea1.append(resultSet.getString("address_pat")+'\n');
                jTextArea1.append(resultSet.getString("phone_pat")+'\n');
                jTextArea1.append(resultSet.getString("bloodtype_pat")+'\n');
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
