import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;

public class WorkingWithFormsTest {

    private WorkingWithForms workingWithForms;

    @BeforeEach
    void setUp() {
        // Create instance without showing the frame to avoid GUI issues in tests
        workingWithForms = new WorkingWithForms();
        // Dispose the frame to prevent it from showing during tests
        if (workingWithForms.MainFrame != null) {
            workingWithForms.MainFrame.setVisible(false);
            workingWithForms.MainFrame.dispose();
        }
    }

    @Test
    @DisplayName("Test Full Name Label Creation")
    void testPrepareJLabelFullName() {
        JLabel label = workingWithForms.prepareJLabelFullName();
        assertNotNull(label, "Full Name label should not be null");
        assertEquals("Full Name:", label.getText(), "Label text should be 'Full Name:'");
    }

    @Test
    @DisplayName("Test Full Name TextField Creation")
    void testPrepareJTextFieldFullName() {
        JTextField textField = workingWithForms.PrepareJTextFieldFullName();
        assertNotNull(textField, "Full Name text field should not be null");
        assertEquals(20, textField.getColumns(), "Text field should have 20 columns");
    }

    @Test
    @DisplayName("Test Email Label Creation")
    void testPrepareJLabelEmail() {
        JLabel label = workingWithForms.prepareJLabelEmailL();
        assertNotNull(label, "Email label should not be null");
        assertEquals("Email:", label.getText(), "Label text should be 'Email:'");
    }

    @Test
    @DisplayName("Test Email TextField Creation")
    void testPrepareJTextFieldEmailInput() {
        JTextField textField = workingWithForms.prepareJTextFieldEmailInput();
        assertNotNull(textField, "Email text field should not be null");
        assertEquals(20, textField.getColumns(), "Text field should have 20 columns");
    }

    @Test
    @DisplayName("Test Password Field Creation")
    void testPrepareJPasswordFieldPasswordInput() {
        JPasswordField passwordField = workingWithForms.prepareJPasswordFieldPasswordInput();
        assertNotNull(passwordField, "Password field should not be null");
        assertEquals(20, passwordField.getColumns(), "Password field should have 20 columns");
    }

    @Test
    @DisplayName("Test Department Label Creation")
    void testPrepareJLabelDepartment() {
        JLabel label = workingWithForms.prepareJLabelDepartment();
        assertNotNull(label, "Department label should not be null");
        assertEquals("Department:", label.getText(), "Label text should be 'Department:'");
    }

    @Test
    @DisplayName("Test Department ComboBox Creation")
    void testPrepareJComboBoxDepartment() {
        JComboBox<String> comboBox = workingWithForms.prepareJComboBoxDepartment();
        assertNotNull(comboBox, "Department combo box should not be null");
        assertEquals(4, comboBox.getItemCount(), "ComboBox should have 4 departments");
        assertEquals("HR", comboBox.getItemAt(0), "First item should be 'HR'");
        assertEquals("Finance", comboBox.getItemAt(1), "Second item should be 'Finance'");
        assertEquals("IT", comboBox.getItemAt(2), "Third item should be 'IT'");
        assertEquals("Marketing", comboBox.getItemAt(3), "Fourth item should be 'Marketing'");
    }

    @Test
    @DisplayName("Test Date of Birth Label Creation")
    void testPrepareJLabelDOB() {
        JLabel label = workingWithForms.prepareJLabelDOB();
        assertNotNull(label, "DOB label should not be null");
        assertEquals("Date of Birth:", label.getText(), "Label text should be 'Date of Birth:'");
    }

    @Test
    @DisplayName("Test Date of Birth Calendar Creation")
    void testPrepareJCalendarDOB() {
        assertNotNull(workingWithForms.prepareJCalendarDOB(), "DOB calendar should not be null");
    }

    @Test
    @DisplayName("Test Form Panel Creation")
    void testPrepareFormPanel() {
        JPanel formPanel = workingWithForms.prepareFormPanel();
        assertNotNull(formPanel, "Form panel should not be null");
        assertTrue(formPanel.getLayout() instanceof java.awt.GridBagLayout, 
                   "Form panel should use GridBagLayout");
    }

    @Test
    @DisplayName("Test Organization Tree Panel Creation")
    void testPrepareOrganizationTreePanel() {
        JScrollPane treePanel = workingWithForms.prepareOrganizationTreePanel();
        assertNotNull(treePanel, "Organization tree panel should not be null");
        assertNotNull(workingWithForms.OrganizationStructure, "Organization tree should not be null");
    }

    @Test
    @DisplayName("Test Buttons Panel Creation")
    void testPrepareButtonsPanel() {
        JPanel buttonPanel = workingWithForms.prepareButtonsPanel();
        assertNotNull(buttonPanel, "Button panel should not be null");
        assertNotNull(workingWithForms.SubmitButton, "Submit button should not be null");
        assertNotNull(workingWithForms.ClearButton, "Clear button should not be null");
        assertEquals("Submit", workingWithForms.SubmitButton.getText(), "Submit button text should be 'Submit'");
        assertEquals("Clear", workingWithForms.ClearButton.getText(), "Clear button text should be 'Clear'");
    }

    @Test
    @DisplayName("Test Clear Action")
    void testHandleClearAction() {
        // Set some values
        workingWithForms.PrepareJTextFieldFullName().setText("John Doe");
        workingWithForms.prepareJTextFieldEmailInput().setText("john@example.com");
        workingWithForms.prepareJPasswordFieldPasswordInput().setText("password123");
        workingWithForms.prepareJComboBoxDepartment().setSelectedIndex(2);
        
        // Execute clear action
        workingWithForms.handleClearAction();
        
        // Verify fields are cleared
        assertEquals("", workingWithForms.FullName.getText(), "Full name should be cleared");
        assertEquals("", workingWithForms.EmailInput.getText(), "Email should be cleared");
        assertEquals("", String.valueOf(workingWithForms.PasswordInput.getPassword()), "Password should be cleared");
        assertEquals(0, workingWithForms.Department.getSelectedIndex(), "Department should be reset to first item");
    }

    @Test
    @DisplayName("Test Main Frame Creation")
    void testPrepareMainFrame() {
        WorkingWithForms newForm = new WorkingWithForms();
        JFrame frame = newForm.PrepareMainFrame();
        assertNotNull(frame, "Main frame should not be null");
        assertEquals("Employee Registration System", frame.getTitle(), "Frame title should match");
        frame.dispose();
    }
}

