package myapp.view;

import myapp.model.Student;
import myapp.model.Teacher;
import myapp.model.TeacherStudent;
import myapp.model.dao.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTable extends javax.swing.JFrame {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableStuTch;
    private javax.swing.JTable jTableStudents;
    private javax.swing.JTable jTableTeachers;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDeleteRowStuTch;
    private javax.swing.JButton jButtonDeleteRowStudent;
    private javax.swing.JButton jButtonDeleteRowsTeacher;
    private javax.swing.JButton jButtonReportStudents;
    private javax.swing.JButton jButtonReportTeachers;
    private javax.swing.JButton jButtonRefreshStudent;
    private javax.swing.JButton jButtonRefreshTeacher;


    // End of variables declaration//GEN-END:variables
    //*********************************************************************
    public DBTable() throws SQLException {
        initComponents();
    }

    //*********************************************************************
    @SuppressWarnings("unchecked")

    private void initComponents() throws SQLException {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudents = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTeachers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButtonAdd = new javax.swing.JButton();
        jButtonDeleteRowStudent = new javax.swing.JButton();
        jButtonDeleteRowsTeacher = new javax.swing.JButton();
        jButtonReportStudents = new javax.swing.JButton();
        jButtonReportTeachers = new javax.swing.JButton();
        jButtonRefreshStudent = new javax.swing.JButton();
        jButtonRefreshTeacher = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStuTch = new javax.swing.JTable();
        jButtonDeleteRowStuTch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jTableStudents.setName("Student\n"); // NOI18N
        jScrollPane1.setViewportView(jTableStudents);


        jScrollPane2.setViewportView(jTableTeachers);


        // set model for tables
        setStudentsModel();
        setTeachersModel();
        setStuTchModel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Students");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Teachers");

        jButtonAdd.setText("Add new record");
        jButtonDeleteRowStudent.setText("Delete Row");
        jButtonDeleteRowsTeacher.setText("Delete Row");
        jButtonReportStudents.setText("Report Students");
        jButtonReportTeachers.setText("Report Teachers");
        jButtonRefreshStudent.setText("Refresh");
        jButtonRefreshTeacher.setText("Refresh");

        jScrollPane3.setViewportView(jTableStuTch);

        jButtonDeleteRowStuTch.setText("Delete Row");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TeacherStudent");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                                .addComponent(jButtonDeleteRowStudent)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jButtonReportTeachers)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jButtonRefreshStudent))
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jButtonDeleteRowStuTch)
                                                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(98, 98, 98)
                                                                .addComponent(jButtonAdd))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonDeleteRowsTeacher)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonReportStudents)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonRefreshTeacher)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonDeleteRowStudent)
                                        .addComponent(jButtonDeleteRowStuTch)
                                        .addComponent(jButtonReportTeachers)
                                        .addComponent(jButtonRefreshStudent))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(jButtonAdd)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonDeleteRowsTeacher)
                                        .addComponent(jButtonReportStudents)
                                        .addComponent(jButtonRefreshTeacher))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ////////////////////////////////////////////////////////////////////
        // add action listeners
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    takeInputsDialog();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

        jButtonDeleteRowStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTableStudents.getSelectedRow();
                if (!(row < 0)) {
                    try {
                        deleteRecord(row, jTableStudents.getModel());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        jButtonDeleteRowsTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTableTeachers.getSelectedRow();
                if (!(row < 0)) {
                    try {
                        deleteRecord(row, jTableTeachers.getModel());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        jButtonDeleteRowStuTch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTableStuTch.getSelectedRow();
                if (!(row < 0)) {
                    try {
                        deleteRecord(row, jTableStuTch.getModel());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        jButtonReportTeachers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTableStudents.getSelectedRow();
                if (!(row < 0)) {
                    try {
                        reportTeachersOfStudent(row);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        jButtonReportStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTableTeachers.getSelectedRow();
                if (!(row < 0)) {
                    try {
                        reportStudentsOfTeacher(row);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });


        jButtonRefreshStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[][] objects = getFullTableStudent();
                    ((DefaultTableModel) jTableStudents.getModel()).setDataVector(objects,
                            new String[]{"Id", "name", "code"});
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        jButtonRefreshTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[][] objects = getFullTableTeacher();
                    ((DefaultTableModel) jTableTeachers.getModel()).setDataVector(objects,
                            new String[]{"Id", "name", "code"});
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });

        ////////////////////////////////////////////////////////////////////

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //*********************************************************************
    public void reportStudentsOfTeacher(int row) throws SQLException {
        Long id = (Long) jTableTeachers.getModel().getValueAt(row, 0);
        Teacher tch = new Teacher();
        tch.setId(id);

        TeacherStudentDAO dao = new TeacherStudentDAOImpl();
        ArrayList<Student> students = (ArrayList<Student>) dao.findStudentsOfTeacher(tch);


        Object[][] objects = new Object[students.size()][3];

        for (int i = 0; i < students.size(); i++) {
            objects[i][0] = students.get(i).getId();
            objects[i][1] = students.get(i).getName();
            objects[i][2] = students.get(i).getCode();
        }
        ((DefaultTableModel) jTableStudents.getModel()).setDataVector(objects,
                new String[]{"Id", "name", "code"});
    }

    //*********************************************************************
    public void reportTeachersOfStudent(int row) throws SQLException {
        Long id = (Long) jTableStudents.getModel().getValueAt(row, 0);
        Student stu = new Student();
        stu.setId(id);

        TeacherStudentDAO dao = new TeacherStudentDAOImpl();
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) dao.findTeachersOfStudent(stu);


        Object[][] objects = new Object[teachers.size()][3];

        for (int i = 0; i < teachers.size(); i++) {
            objects[i][0] = teachers.get(i).getId();
            objects[i][1] = teachers.get(i).getName();
            objects[i][2] = teachers.get(i).getCode();
        }
        //((DefaultTableModel)jTableTeachers.getModel()).getDataVector().removeAllElements();
        ((DefaultTableModel) jTableTeachers.getModel()).setDataVector(objects,
                new String[]{"Id", "name", "code"});

    }

    //*********************************************************************
    public void deleteRecord(int row, TableModel model) throws SQLException {
        // delete from DB
        Long id = (Long) model.getValueAt(row, 0);
        if (model.equals(jTableStudents.getModel())) {
            Student stu = new Student();
            stu.setId(id);
            StudentDAO dao = new StudentDaoImpl();
            dao.delete(stu);
        } else if (model.equals(jTableTeachers.getModel())) {
            Teacher tch = new Teacher();
            tch.setId(id);
            TeacherDAO dao = new TeacherDaoImpl();
            dao.delete(tch);
        } else if (model.equals(jTableStuTch.getModel())) {
            Long tchId = (Long) ((DefaultTableModel) model).getValueAt(row, 0);
            Long stuId = (Long) ((DefaultTableModel) model).getValueAt(row, 1);
            TeacherStudent tchStu = new TeacherStudent(stuId, tchId);
            TeacherStudentDAO dao = new TeacherStudentDAOImpl();
            dao.delete(tchStu);
        }

        // delete from table
        ((DefaultTableModel) model).removeRow(row);
    }

    //*********************************************************************
    public Object[][] getFullTableStudent() throws SQLException {
        StudentDAO dao = new StudentDaoImpl();
        ArrayList<Student> all = (ArrayList<Student>) dao.findAll();

        Object[][] objects = new Object[all.size()][3];

        for (int i = 0; i < all.size(); i++) {
            objects[i][0] = all.get(i).getId();
            objects[i][1] = all.get(i).getName();
            objects[i][2] = all.get(i).getCode();
        }
        return objects;
    }

    //*********************************************************************
    public void setStudentsModel() throws SQLException {
        Object[][] objects = getFullTableStudent();
        TableModel studentsModel = new DefaultTableModel(objects,
                new String[]{"Id", "name", "code"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // make read only fields except column 0,13,14
                return (column != 0);
            }
        };


        jTableStudents.setModel(studentsModel);
        jTableStudents.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    try {
                        if (!(e.getFirstRow() < 0))
                            updateStudentTable(e.getFirstRow(), e.getColumn(), (String) jTableStudents.getValueAt(e.getFirstRow(), e.getColumn()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

    }

    //*********************************************************************

    public void updateStudentTable(int row, int col, String value) throws SQLException {
        Long id = (Long) jTableStudents.getValueAt(row, 0);
        String name = (String) jTableStudents.getValueAt(row, 1);
        //int code = Integer.parseInt((String) jTableStudents.getValueAt(row, 2));
        int code = (Integer) (jTableStudents.getValueAt(row, 2));
        Student stu = new Student(name, code);
        stu.setId(id);
        StudentDAO dao = new StudentDaoImpl();
        dao.update(stu);
    }

    //*********************************************************************
    public Object[][] getFullTableTeacher() throws SQLException {
        TeacherDAO dao = new TeacherDaoImpl();
        ArrayList<Teacher> all = (ArrayList<Teacher>) dao.findAll();

        Object[][] objects = new Object[all.size()][3];

        for (int i = 0; i < all.size(); i++) {
            objects[i][0] = all.get(i).getId();
            objects[i][1] = all.get(i).getName();
            objects[i][2] = all.get(i).getCode();
        }

        return objects;
    }
    //*********************************************************************

    public void setTeachersModel() throws SQLException {
        Object[][] objects = getFullTableTeacher();

        TableModel teachersModel = new DefaultTableModel(objects,
                new String[]{"Id", "name", "code"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return (column != 0);
            }
        };

        jTableTeachers.setModel(teachersModel);
        jTableTeachers.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    try {
                        if (!(e.getFirstRow() < 0))
                            updateTeacherTable(e.getFirstRow(), e.getColumn(), (String) jTableTeachers.getValueAt(e.getFirstRow(), e.getColumn()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

    }
    //*********************************************************************

    public void updateTeacherTable(int row, int col, String value) throws SQLException {

        Long id = (Long) jTableTeachers.getValueAt(row, 0);
        String name = (String) jTableTeachers.getValueAt(row, 1);
        int code = (Integer) (jTableTeachers.getValueAt(row, 2));
        Teacher tch = new Teacher(name, code);
        tch.setId(id);
        TeacherDAO dao = new TeacherDaoImpl();
        dao.update(tch);
    }

    //*********************************************************************
    public void setStuTchModel() throws SQLException {
        TeacherStudentDAO dao = new TeacherStudentDAOImpl();
        ArrayList<TeacherStudent> all = (ArrayList<TeacherStudent>) dao.findAll();

        Object[][] objects = new Object[all.size()][2];

        for (int i = 0; i < all.size(); i++) {
            objects[i][0] = all.get(i).getIdTeacher();
            objects[i][1] = all.get(i).getIdStudent();
        }

        TableModel stuTchModel = new DefaultTableModel(objects,
                new String[]{"Teacher id", "Student id"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableStuTch.setModel(stuTchModel);
//        jTableStuTch.getModel().addTableModelListener(new TableModelListener() {
//
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                if (e.getType() == TableModelEvent.UPDATE) {
//                    try {
//                        updateTeacherTable(e.getFirstRow(), e.getColumn(), (String) jTableTeachers.getValueAt(e.getFirstRow(), e.getColumn()));
//                    } catch (SQLException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        });


    }

    //*********************************************************************
    public void takeInputsDialog() throws SQLException {
        String[] tablesStr = {"Students", "Teachers", "teacher_student"};
        JComboBox comboTables = new JComboBox(tablesStr);

        JTextField Field1 = new JTextField(5);
        JTextField Field2 = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout());
        myPanel.add(comboTables);
        JLabel jLabel1 = new JLabel("name:");
        myPanel.add(jLabel1);

        myPanel.add(Field1);
        JLabel jLabel2 = new JLabel("code;");
        myPanel.add(jLabel2);
        myPanel.add(Field2);


        comboTables.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object item = e.getItem();

                    if (item.equals(tablesStr[0])) {
                        jLabel1.setText("name:");
                        jLabel2.setText("code:");
                    } else if (item.equals(tablesStr[1])) {
                        jLabel1.setText("name:");
                        jLabel2.setText("code:");
                    } else {
                        jLabel1.setText("teacher id:");
                        jLabel2.setText("student id:");
                    }
                }
            }
        });


        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Values", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // students table
            if ((comboTables.getSelectedItem()).equals(tablesStr[0])) {
                Student stu = new Student(Field1.getText(), Integer.parseInt(Field2.getText()));
                StudentDAO dao = new StudentDaoImpl();
                Long idLong = dao.insert(stu);
                ((DefaultTableModel) (jTableStudents.getModel())).addRow(new Object[]{idLong.toString(), stu.getName(), stu.getCode()});

            }
            // teachers table
            else if ((comboTables.getSelectedItem()).equals(tablesStr[1])) {
                Teacher tch = new Teacher(Field1.getText(), Integer.parseInt(Field2.getText()));
                TeacherDAO dao = new TeacherDaoImpl();
                Long idLong = dao.insert(tch);
                ((DefaultTableModel) (jTableTeachers.getModel())).addRow(new Object[]{idLong.toString(), tch.getName(), tch.getCode()});
            }
            // teacher_student table
            else if ((comboTables.getSelectedItem()).equals(tablesStr[2])) {
                TeacherStudent teacherStudent = new TeacherStudent(Long.parseLong(Field2.getText()), Long.parseLong(Field1.getText()));
                TeacherStudentDAO dao = new TeacherStudentDAOImpl();
                dao.insert(teacherStudent);
                ((DefaultTableModel) (jTableStuTch.getModel())).addRow(new Object[]{String.valueOf(teacherStudent.getIdTeacher()), String.valueOf(teacherStudent.getIdStudent())});
            }

            System.out.println("1 value: " + Field1.getText());
            System.out.println("2 value: " + Field2.getText());
        }
    }
    //*********************************************************************

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    //*********************************************************************
    public static void main(String args[]) throws ClassNotFoundException {
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
            java.util.logging.Logger.getLogger(DBTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Class.forName(DRIVER_NAME);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DBTable().setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //*********************************************************************

}

