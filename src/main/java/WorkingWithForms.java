import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WorkingWithForms {
    //creating instances of the JComponents
    JTextField FullName,EmailInput;
    JPasswordField PasswordInput;
    JComboBox<String> Department;
    JButton SubmitButton,ClearButton;
    JFrame MainFrame;
    JTree OrganizationStructure;
    JCalendar DOB;
    JPanel formPanel,buttonPanel;
    JLabel EmailLabel,FullNameLabel,DepartmentLabel,DOBLabel;

    public WorkingWithForms() {
        // Only create frame if not in headless mode
        if (!java.awt.GraphicsEnvironment.isHeadless()) {
            this.prepareMainFrame();
        }
    }
    public JFrame prepareMainFrame(){
        // Skip frame creation in headless mode
        if (java.awt.GraphicsEnvironment.isHeadless()) {
            return null;
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        MainFrame=new JFrame("Employee Registration System");
        MainFrame.setSize(500,700);
        MainFrame.setLayout(new GridBagLayout());
        MainFrame.add(prepareFormPanel());
        MainFrame.setVisible(true);
        return MainFrame;
    }
    public JPanel prepareFormPanel() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Employee Information"));
        formPanel.setPreferredSize(new Dimension(400, 500));
        formPanel.setBackground(new Color(240, 240, 255));

        //chose gridbag as our layoutmanager
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        int y = 0;

        //the fullname to be arranged as the first item
        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(prepareJLabelFullName(), gbc);
        gbc.gridx = 1;
        formPanel.add(prepareJTextFieldFullName(), gbc);
        y++;

        //the email to be the second on the list
        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(prepareJLabelEmailL(), gbc);
        gbc.gridx = 1;
        formPanel.add(prepareJTextFieldEmailInput(), gbc);
        y++;

        //the password appears next
        gbc.gridx = 0; gbc.gridy = y;
        JLabel passwordLabel = new JLabel("Password:");
        formPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(prepareJPasswordFieldPasswordInput(), gbc);
        y++;

        //the position for department
        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(prepareJLabelDepartment(), gbc);
        gbc.gridx = 1;
        formPanel.add(prepareJComboBoxDepartment(), gbc);
        y++;

        // the position for DOB
        gbc.gridx = 0; gbc.gridy = y;
        formPanel.add(prepareJLabelDOB(), gbc);
        gbc.gridx = 1;
        formPanel.add(prepareJCalendarDOB(), gbc);
        y++;



        return formPanel;
    }

    //initializing the components
    public JLabel prepareJLabelFullName() {
        if (FullNameLabel == null) {
            FullNameLabel = new JLabel("Full Name:");
        }
        return FullNameLabel;
    }

    public JTextField prepareJTextFieldFullName() {
        if (FullName == null) {
            FullName = new JTextField(20);
        }
        return FullName;
    }

    public JLabel prepareJLabelEmailL() {
        if (EmailLabel == null) {
            EmailLabel = new JLabel("Email:");
        }
        return EmailLabel;
    }

    public JTextField prepareJTextFieldEmailInput() {
        if (EmailInput == null) {
            EmailInput = new JTextField(20);
        }
        return EmailInput;
    }

    public JPasswordField prepareJPasswordFieldPasswordInput() {
        if (PasswordInput == null) {
            PasswordInput = new JPasswordField(20);
        }
        return PasswordInput;
    }

    public JLabel prepareJLabelDepartment() {
        if (DepartmentLabel == null) {
            DepartmentLabel = new JLabel("Department:");
        }
        return DepartmentLabel;
    }

    public JComboBox<String> prepareJComboBoxDepartment() {
        if (Department == null) {
            Department = new JComboBox<>(new String[]{"HR", "Finance", "IT", "Marketing"});
        }
        return Department;
    }

    public JLabel prepareJLabelDOB() {
        if (DOBLabel == null) {
            DOBLabel = new JLabel("Date of Birth:");
        }
        return DOBLabel;
    }

    public JCalendar prepareJCalendarDOB() {
        if (DOB == null) {
            DOB = new JCalendar();
        }
        return DOB;
    }
    public JScrollPane prepareOrganizationTreePanel() {
        if (OrganizationStructure == null) {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Company");
            DefaultMutableTreeNode dept1 = new DefaultMutableTreeNode("HR");
            dept1.add(new DefaultMutableTreeNode("Recruitment"));
            dept1.add(new DefaultMutableTreeNode("Training"));
            DefaultMutableTreeNode dept2 = new DefaultMutableTreeNode("IT");
            dept2.add(new DefaultMutableTreeNode("Development"));
            dept2.add(new DefaultMutableTreeNode("Support"));
            DefaultMutableTreeNode dept3 = new DefaultMutableTreeNode("Finance");
            dept3.add(new DefaultMutableTreeNode("Accounts"));
            dept3.add(new DefaultMutableTreeNode("Payroll"));
            DefaultMutableTreeNode dept4 = new DefaultMutableTreeNode("Marketing");
            dept4.add(new DefaultMutableTreeNode("Advertising"));
            dept4.add(new DefaultMutableTreeNode("Sales"));

            root.add(dept1);
            root.add(dept2);
            root.add(dept3);
            root.add(dept4);

            OrganizationStructure = new JTree(root);
        }
        JScrollPane treeScroll = new JScrollPane(OrganizationStructure);
        treeScroll.setPreferredSize(new Dimension(300, 150));
        treeScroll.setBorder(BorderFactory.createTitledBorder("Organization Structure"));
        return treeScroll;
    }
    public JPanel prepareButtonsPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        SubmitButton = new JButton("Submit");
        ClearButton = new JButton("Clear");

        // Add action listeners
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmitAction();
            }
        });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearAction();
            }
        });

        buttonPanel.add(SubmitButton);
        buttonPanel.add(ClearButton);

        return buttonPanel;
    }
    public void handleSubmitAction() {
        String fullName = FullName.getText().trim();
        String email = EmailInput.getText().trim();
        String department = (String) Department.getSelectedItem();
        char[] passwordChars = PasswordInput.getPassword();

        if (fullName.isEmpty() || email.isEmpty() || passwordChars.length == 0) {
            JOptionPane.showMessageDialog(MainFrame, "Please fill in all required fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Use thread-safe DateTimeFormatter instead of SimpleDateFormat
        java.util.Date dobDate = DOB.getDate();
        String dobStr = dobDate != null 
            ? dobDate.toInstant().atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            : "";

        // Summary message (mask password)
        String summary = "Employee Registration Successful!\n\n" +
                "Full Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "Department: " + department + "\n" +
                "Date of Birth: " + dobStr + "\n" +
                "Password: ******";

        JOptionPane.showMessageDialog(MainFrame, summary, "Registration Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleClearAction() {
        FullName.setText("");
        EmailInput.setText("");
        PasswordInput.setText("");
        Department.setSelectedIndex(0);
        // Only clear DOB if it's initialized
        if (DOB != null) {
            // JCalendar doesn't accept null dates, so set to today's date as a reset
            try {
                DOB.setDate(null);
            } catch (NullPointerException e) {
                // If null is not allowed, set to current date instead
                DOB.setDate(new java.util.Date());
            }
        }
    }

}

