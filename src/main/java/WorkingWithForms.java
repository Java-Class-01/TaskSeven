import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkingWithForms {
    //creating instances of the JComponents
    JTextField FullName,EmailInput;
    JPasswordField PasswordInput;
    JComboBox Department;
    JButton SubmitButton,ClearButton;
    JFrame MainFrame;
    JTree OrganizationStructure;
    JCalendar DOB;
    JPanel formPanel;
    JLabel EmailLabel,FullNameLabel,DepartmentLabel,DOBLabel;

    public WorkingWithForms() {
        this.PrepareMainFrame();
    }
    public JFrame PrepareMainFrame(){
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
        formPanel.add(PrepareJTextFieldFullName(), gbc);
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

    public JTextField PrepareJTextFieldFullName() {
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

    }

