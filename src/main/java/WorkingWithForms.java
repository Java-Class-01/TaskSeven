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

    }

