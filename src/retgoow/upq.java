/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package retgoow;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.awt.*;

/**
 *
 * @author USER
 */
public class upq extends javax.swing.JFrame {
    private static Connection koneksi;
    private DefaultTableModel model;
    private ResultSet res;
    private ButtonGroup bg, btn;

    /**
     * Creates new form upq
     */
    public upq() {
        initComponents();
        model = new DefaultTableModel();
        jTable1.setModel(model);
        bg = new ButtonGroup();
        bg.add(pmr1);
        bg.add(seni1);
        bg.add(bahasa1);
        bg.add(pramuka1);
        bg.add(paskibra1);
        bg.add(english1);
        bg.add(futsal1);
        bg.add(rohis1);
        bg.add(basket1);
        bg.add(band1);
        bg.add(badminton1);
        bg.add(sepak1);
        pmr1.setActionCommand("PMR");
        seni1.setActionCommand("SENI");
        bahasa1.setActionCommand("BAHASA");
        pramuka1.setActionCommand("PRAMUKA");
        paskibra1.setActionCommand("PASKIBRA");
        english1.setActionCommand("ENGLISH");
        futsal1.setActionCommand("FUTSAL");
        rohis1.setActionCommand("ROHIS");
        basket1.setActionCommand("BASKET");
        band1.setActionCommand("BAND");
        badminton1.setActionCommand("BADMINTON");
        sepak1.setActionCommand("SEPAK BOLA");
        btn = new ButtonGroup();
        btn.add(pmr2);
        btn.add(seni2);
        btn.add(bahasa2);
        btn.add(pramuka2);
        btn.add(paskibra2);
        btn.add(english2);
        btn.add(futsal2);
        btn.add(rohis2);
        btn.add(basket2);
        btn.add(band2);
        btn.add(badminton2);
        btn.add(sepak2);
        pmr2.setActionCommand("PMR");
        seni2.setActionCommand("SENI");
        bahasa2.setActionCommand("BAHASA");
        pramuka2.setActionCommand("PRAMUKA");
        paskibra2.setActionCommand("PASKIBRA");
        english2.setActionCommand("ENGLISH");
        futsal2.setActionCommand("FUTSAL");
        rohis2.setActionCommand("ROHIS");
        basket2.setActionCommand("BASKET");
        band2.setActionCommand("BAND");
        badminton2.setActionCommand("BADMINTON");
        sepak2.setActionCommand("SEPAK BOLA");
        model.addColumn("id");
        model.addColumn("nama");
        model.addColumn("nis");
        model.addColumn("kelas");
        model.addColumn("jurusan");
        model.addColumn("ekstrakulikuler");
        model.addColumn("alamat");
        
        datatable();
    }
    
    private static Connection koneksi(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "sarasma";
            //koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/retgoow" ,"root" ,"");

            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("bisa kakk koneksinya");
        } catch (SQLException e) {
                System.out.println("error" + e.getMessage());
        } catch (ClassNotFoundException e) {
                System.out.println("error" + e.getMessage());
        }
        return koneksi;
    }
    
    private void datatable() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = koneksi();
            String sql = "SELECT * FROM data_siswa";
            PreparedStatement p = c.prepareStatement(sql);
            res = p.executeQuery();
            while (res.next()) {
                Object[] o = new Object[7];
                o[0] = res.getString("id");
                o[1] = res.getString("nama");
                o[2] = res.getString("nis");
                o[3] = res.getString("kelas");
                o[4] = res.getString("jurusan");
                o[5] = res.getString("ekstrakulikuler");
                o[6] = res.getString("alamat");
                model.addRow(o);
            }
            p.close();
            res.close();
            tableclick();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "gagal menampilkan data" + e.getMessage());
        }
    }
    
    private void tableclick() {
        int i = jTable1.getSelectedRow();
        if (i== -1) {
            return;
        }
        Connection c = koneksi();
        try {
            String sql = "SELECT * FROM data_siswa WHERE id = " + model.getValueAt(i, 0);
            PreparedStatement p = c.prepareStatement(sql);
            res = p.executeQuery();
            while (res.next()) {
                nama1.setText(res.getString("nama"));
                nis1.setText(res.getString("nis"));
                kelas1.setText(res.getString("kelas"));
                jurusan1.setText(res.getString("jurusan"));
                String eks = res.getString("ekstrakulikuler");
                switch(eks) {
                    case "PMR":
                        pmr1.setSelected(true);
                        break;
                    case "SENI":
                        seni1.setSelected(true);
                        break;
                    case "BAHASA":
                        bahasa1.setSelected(true);
                        break;
                    case "PRAMUKA":
                        pramuka1.setSelected(true);
                        break;
                    case "PASKIBRA":
                        paskibra1.setSelected(true);
                        break;
                    case "ENGLISH":
                        english1.setSelected(true);
                        break;
                    case "FUTSAL":
                        futsal1.setSelected(true);
                        break;
                    case "ROHIS":
                        rohis1.setSelected(true);
                        break;
                    case "BASKET":
                        basket1.setSelected(true);
                        break;
                    case "BAND":
                        band1.setSelected(true);
                        break;
                    case "BADMINTON":
                        badminton1.setSelected(true);
                        break;
                    case "SEPAK BOLA":
                        sepak1.setSelected(true);
                        break;
                }
                alamat1.setText(res.getString("alamat"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, "gagal menambahkan data" + e.getMessage());
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        datasiswa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pmr1 = new javax.swing.JRadioButton();
        seni1 = new javax.swing.JRadioButton();
        bahasa1 = new javax.swing.JRadioButton();
        view = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        kelas1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jurusan1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        paskibra1 = new javax.swing.JRadioButton();
        futsal1 = new javax.swing.JRadioButton();
        english1 = new javax.swing.JRadioButton();
        basket1 = new javax.swing.JRadioButton();
        band1 = new javax.swing.JRadioButton();
        badminton1 = new javax.swing.JRadioButton();
        alamat1 = new javax.swing.JTextField();
        pramuka1 = new javax.swing.JRadioButton();
        rohis1 = new javax.swing.JRadioButton();
        sepak1 = new javax.swing.JRadioButton();
        nama1 = new javax.swing.JTextField();
        nis1 = new javax.swing.JTextField();
        createsiswa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama2 = new javax.swing.JTextField();
        nis2 = new javax.swing.JTextField();
        pmr2 = new javax.swing.JRadioButton();
        seni2 = new javax.swing.JRadioButton();
        bahasa2 = new javax.swing.JRadioButton();
        pict22 = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        kelas2 = new javax.swing.JTextField();
        jurusan2 = new javax.swing.JTextField();
        paskibra2 = new javax.swing.JRadioButton();
        english2 = new javax.swing.JRadioButton();
        futsal2 = new javax.swing.JRadioButton();
        pramuka2 = new javax.swing.JRadioButton();
        rohis2 = new javax.swing.JRadioButton();
        basket2 = new javax.swing.JRadioButton();
        band2 = new javax.swing.JRadioButton();
        badminton2 = new javax.swing.JRadioButton();
        sepak2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        alamat2 = new javax.swing.JTextField();
        viewpanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nama3 = new javax.swing.JLabel();
        jurusan3 = new javax.swing.JLabel();
        nis3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        kelas3 = new javax.swing.JLabel();
        ekstra3 = new javax.swing.JLabel();
        alamat3 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Nama :");

        jLabel2.setText("Nis :");

        jLabel3.setText("Ekstrakulikuler :");

        pmr1.setText("PMR");
        pmr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmr1ActionPerformed(evt);
            }
        });

        seni1.setText("SENI");
        seni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seni1ActionPerformed(evt);
            }
        });

        bahasa1.setText("BAHASA");
        bahasa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bahasa1ActionPerformed(evt);
            }
        });

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        jLabel4.setText("Kelas :");

        jLabel13.setText("Jurusan :");

        jLabel14.setText("Alamat  :");

        paskibra1.setText("PASKIBRA");
        paskibra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paskibra1ActionPerformed(evt);
            }
        });

        futsal1.setText("FUTSAL");
        futsal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                futsal1ActionPerformed(evt);
            }
        });

        english1.setText("ENGLISH");
        english1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                english1ActionPerformed(evt);
            }
        });

        basket1.setText("BASKET");
        basket1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basket1ActionPerformed(evt);
            }
        });

        band1.setText("BAND");
        band1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                band1ActionPerformed(evt);
            }
        });

        badminton1.setText("BADMINTON");
        badminton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badminton1ActionPerformed(evt);
            }
        });

        pramuka1.setText("PRAMUKA");
        pramuka1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pramuka1ActionPerformed(evt);
            }
        });

        rohis1.setText("ROHIS");
        rohis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rohis1ActionPerformed(evt);
            }
        });

        sepak1.setText("SEPAK BOLA");
        sepak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepak1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datasiswaLayout = new javax.swing.GroupLayout(datasiswa);
        datasiswa.setLayout(datasiswaLayout);
        datasiswaLayout.setHorizontalGroup(
            datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(datasiswaLayout.createSequentialGroup()
                        .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addGap(36, 36, 36)
                        .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datasiswaLayout.createSequentialGroup()
                                .addComponent(nis1)
                                .addGap(268, 268, 268)
                                .addComponent(edit))
                            .addGroup(datasiswaLayout.createSequentialGroup()
                                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pmr1)
                                    .addComponent(paskibra1)
                                    .addComponent(basket1))
                                .addGap(37, 37, 37)
                                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seni1)
                                    .addComponent(english1)
                                    .addComponent(band1))
                                .addGap(46, 46, 46)
                                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bahasa1)
                                    .addComponent(futsal1)
                                    .addComponent(badminton1))
                                .addGap(49, 49, 49)
                                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sepak1)
                                    .addComponent(rohis1)
                                    .addComponent(pramuka1))
                                .addGap(0, 35, Short.MAX_VALUE))
                            .addGroup(datasiswaLayout.createSequentialGroup()
                                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alamat1)
                                    .addComponent(jurusan1)
                                    .addComponent(kelas1))
                                .addGap(340, 340, 340))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datasiswaLayout.createSequentialGroup()
                                .addComponent(nama1)
                                .addGap(268, 268, 268)
                                .addComponent(view)))))
                .addContainerGap())
        );
        datasiswaLayout.setVerticalGroup(
            datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(datasiswaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(view)
                            .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datasiswaLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(edit))
                            .addGroup(datasiswaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(nis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4))
                    .addComponent(kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jurusan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pmr1)
                    .addComponent(seni1)
                    .addComponent(bahasa1)
                    .addComponent(pramuka1))
                .addGap(18, 18, 18)
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paskibra1)
                    .addComponent(futsal1)
                    .addComponent(english1)
                    .addComponent(rohis1))
                .addGap(18, 18, 18)
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basket1)
                    .addComponent(band1)
                    .addComponent(badminton1)
                    .addComponent(sepak1))
                .addGap(18, 18, 18)
                .addGroup(datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(alamat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Data Siswa", datasiswa);

        jLabel5.setText("Nama :");

        jLabel6.setText("Nis :");

        jLabel7.setText("Ekstrakulikuler :");

        nama2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama2ActionPerformed(evt);
            }
        });

        nis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nis2ActionPerformed(evt);
            }
        });

        pmr2.setText("PMR");

        seni2.setText("SENI");

        bahasa2.setText("BAHASA");

        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        jLabel15.setText("Kelas :");

        jLabel16.setText("Jurusan :");

        kelas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas2ActionPerformed(evt);
            }
        });

        jurusan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jurusan2ActionPerformed(evt);
            }
        });

        paskibra2.setText("PASKIBRA");

        english2.setText("ENGLISH");

        futsal2.setText("FUTSAL");

        pramuka2.setText("PRAMUKA");

        rohis2.setText("ROHIS");

        basket2.setText("BASKET");

        band2.setText("BAND");
        band2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                band2ActionPerformed(evt);
            }
        });

        badminton2.setText("BADMINTON");

        sepak2.setText("SEPAK BOLA");
        sepak2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepak2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Alamat :");

        alamat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createsiswaLayout = new javax.swing.GroupLayout(createsiswa);
        createsiswa.setLayout(createsiswaLayout);
        createsiswaLayout.setHorizontalGroup(
            createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createsiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createsiswaLayout.createSequentialGroup()
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(62, 62, 62)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nis2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kelas2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jurusan2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createsiswaLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(pict22, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createsiswaLayout.createSequentialGroup()
                                .addComponent(create)
                                .addGap(34, 34, 34))))
                    .addGroup(createsiswaLayout.createSequentialGroup()
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(createsiswaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alamat2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(createsiswaLayout.createSequentialGroup()
                                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pmr2)
                                            .addComponent(paskibra2)
                                            .addComponent(basket2))
                                        .addGap(62, 62, 62)
                                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(seni2)
                                            .addComponent(english2)
                                            .addComponent(band2))
                                        .addGap(66, 66, 66)
                                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bahasa2)
                                            .addComponent(futsal2)
                                            .addComponent(badminton2))
                                        .addGap(63, 63, 63)
                                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sepak2)
                                            .addComponent(rohis2)
                                            .addComponent(pramuka2)))))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        createsiswaLayout.setVerticalGroup(
            createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createsiswaLayout.createSequentialGroup()
                .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createsiswaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pict22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createsiswaLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(create))
                        .addGap(18, 18, 18)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(kelas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jurusan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(pmr2)
                            .addComponent(seni2)
                            .addComponent(bahasa2)
                            .addComponent(pramuka2))
                        .addGap(18, 18, 18)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paskibra2)
                            .addComponent(english2)
                            .addComponent(futsal2)
                            .addComponent(rohis2))
                        .addGap(17, 17, 17)
                        .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(basket2)
                            .addComponent(band2)
                            .addComponent(badminton2)
                            .addComponent(sepak2))))
                .addGroup(createsiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createsiswaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(291, 291, 291))
                    .addGroup(createsiswaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alamat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Pendaftaran", createsiswa);

        jLabel9.setText("Nama :");

        jLabel10.setText("Nis :");

        jLabel11.setText("Ekstrakulikuler :");

        jLabel12.setText("alamat :");

        jLabel18.setText("Kelas :");

        jLabel19.setText("Jurusan :");

        javax.swing.GroupLayout viewpanelLayout = new javax.swing.GroupLayout(viewpanel);
        viewpanel.setLayout(viewpanelLayout);
        viewpanelLayout.setHorizontalGroup(
            viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(25, 25, 25)
                .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ekstra3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jurusan3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nis3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        viewpanelLayout.setVerticalGroup(
            viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewpanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(viewpanelLayout.createSequentialGroup()
                        .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(nama3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(nis3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(kelas3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel19))
                    .addComponent(jurusan3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewpanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11))
                    .addGroup(viewpanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ekstra3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(viewpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewpanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(alamat3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewpanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel12)))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View", viewpanel);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(refresh)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(refresh))
                .addContainerGap(587, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(64, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tableclick();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void pmr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pmr1ActionPerformed

    private void seni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seni1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seni1ActionPerformed

    private void bahasa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bahasa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bahasa1ActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        Connection c = koneksi();
        int i = jTable1.getSelectedRow();
        try{
            String sql = "SELECT * FROM data_siswa WHERE id = " +model.getValueAt(i, 0);
            PreparedStatement p = c.prepareStatement(sql);
            res = p.executeQuery();
            while (res.next()) {
                nama3.setText(res.getString("nama"));
                nis3.setText(res.getString("nis"));
                kelas3.setText(res.getString("kelas"));
                jurusan3.setText(res.getString("jurusan"));
                ekstra3.setText(res.getString("ekstrakulikuler"));
                alamat3.setText(res.getString("alamat"));
                //ImageIcon Icon = new ImageIcon("C:/" + res.getString("pict"));
                //Icon = new ImageIcon(Icon.getImage().getScaledInstance(pict3.getWidth(), pict3.getHeight(), Image.SCALE_DEFAULT));
                //pict3.setIcon(Icon);
            }
            JOptionPane.showMessageDialog(this, "silahkan ke view");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "gagal" +e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_viewActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        Connection c = koneksi();
        int i = jTable1.getSelectedRow();
        try {
            String sql = "UPDATE data_siswa SET"
            + " nama = '" + nama1.getText() +"', nis = '"+ nis1.getText()
            + "', kelas = '" + kelas1.getText() + "', jurusan = '" + jurusan1.getText()
            + "', ekstrakulikuler = '" + bg.getSelection().getActionCommand()
            + "', alamat = '" + alamat1.getText() + "' WHERE id = " + model.getValueAt(i, 0);
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Data berhasil di edit");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal diedit"+ e.getMessage());
        }
        nama1.setText("");
        nis1.setText("");
        kelas1.setText("");
        jurusan1.setText("");
        bg.clearSelection();
        alamat1.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void paskibra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paskibra1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paskibra1ActionPerformed

    private void futsal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_futsal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_futsal1ActionPerformed

    private void english1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_english1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_english1ActionPerformed

    private void basket1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basket1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basket1ActionPerformed

    private void band1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_band1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_band1ActionPerformed

    private void badminton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badminton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_badminton1ActionPerformed

    private void pramuka1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pramuka1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pramuka1ActionPerformed

    private void rohis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rohis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rohis1ActionPerformed

    private void sepak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepak1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sepak1ActionPerformed

    private void nama2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama2ActionPerformed

    private void nis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nis2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nis2ActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        Connection c = koneksi();
        try{
            String sql = "INSERT INTO data_siswa(nama, nis, kelas, jurusan, ekstrakulikuler, alamat) VALUES"
            + "(' " + nama2.getText() +"','" + nis2.getText() + "','" + kelas2.getText() + "','" +  jurusan2.getText() + "','" + btn.getSelection().getActionCommand()
            + "','" + alamat2.getText()+"')";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Berhasil menambahkan data");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "gagal menambahkan data" + e.getMessage());
        }
        nama2.setText("");
        nis2.setText("");
        kelas2.setText("");
        jurusan2.setText("");
        btn.clearSelection();
        alamat2.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_createActionPerformed

    private void kelas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelas2ActionPerformed

    private void jurusan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jurusan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jurusan2ActionPerformed

    private void band2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_band2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_band2ActionPerformed

    private void sepak2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepak2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sepak2ActionPerformed

    private void alamat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat2ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        Connection c = koneksi();
        try{
            String sql = "DELETE FROM data_siswa WHERE nis = '" +nis1.getText()+"'";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "data gagal dihapus" + e.getMessage());
        }
        nama1.setText("");
        nis1.setText("");
        kelas1.setText("");
        jurusan1.setText("");
        bg.clearSelection();
        alamat1.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        datatable();
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(upq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(upq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(upq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(upq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new upq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat1;
    private javax.swing.JTextField alamat2;
    private javax.swing.JLabel alamat3;
    private javax.swing.JRadioButton badminton1;
    private javax.swing.JRadioButton badminton2;
    private javax.swing.JRadioButton bahasa1;
    private javax.swing.JRadioButton bahasa2;
    private javax.swing.JRadioButton band1;
    private javax.swing.JRadioButton band2;
    private javax.swing.JRadioButton basket1;
    private javax.swing.JRadioButton basket2;
    private javax.swing.JButton create;
    private javax.swing.JPanel createsiswa;
    private javax.swing.JPanel datasiswa;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel ekstra3;
    private javax.swing.JRadioButton english1;
    private javax.swing.JRadioButton english2;
    private javax.swing.JRadioButton futsal1;
    private javax.swing.JRadioButton futsal2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jurusan1;
    private javax.swing.JTextField jurusan2;
    private javax.swing.JLabel jurusan3;
    private javax.swing.JTextField kelas1;
    private javax.swing.JTextField kelas2;
    private javax.swing.JLabel kelas3;
    private javax.swing.JTextField nama1;
    private javax.swing.JTextField nama2;
    private javax.swing.JLabel nama3;
    private javax.swing.JTextField nis1;
    private javax.swing.JTextField nis2;
    private javax.swing.JLabel nis3;
    private javax.swing.JRadioButton paskibra1;
    private javax.swing.JRadioButton paskibra2;
    private javax.swing.JLabel pict22;
    private javax.swing.JRadioButton pmr1;
    private javax.swing.JRadioButton pmr2;
    private javax.swing.JRadioButton pramuka1;
    private javax.swing.JRadioButton pramuka2;
    private javax.swing.JButton refresh;
    private javax.swing.JRadioButton rohis1;
    private javax.swing.JRadioButton rohis2;
    private javax.swing.JRadioButton seni1;
    private javax.swing.JRadioButton seni2;
    private javax.swing.JRadioButton sepak1;
    private javax.swing.JRadioButton sepak2;
    private javax.swing.JButton view;
    private javax.swing.JPanel viewpanel;
    // End of variables declaration//GEN-END:variables
}
