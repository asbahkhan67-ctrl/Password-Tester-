import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
 
public class PasswordTester { 
 
    public static void main(String[] args) { 
        JFrame frame = new JFrame("Password Tester"); 
        frame.setSize(380, 180); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setResizable(false); 
         
        frame.setLocationRelativeTo(null); 
 
        JPanel panel = new JPanel(); 
        panel.setLayout(null); 
        frame.add(panel); 
 
        
        JLabel label = new JLabel("Enter Password:"); 
        label.setFont(new Font("Arial", Font.BOLD, 14)); 
        label.setBounds(20, 20, 120, 25); 
        panel.add(label); 
 
      
        JPasswordField passwordField = new JPasswordField(); 
        passwordField.setBounds(150, 20, 180, 25); 
        passwordField.setToolTipText("Password must be at least 6 characters."); 
        panel.add(passwordField); 
 
        JButton checkButton = new JButton("Check"); 
        checkButton.setBounds(150, 55, 100, 28); 
        checkButton.setBackground(new Color(70, 130, 180)); 
        checkButton.setForeground(Color.WHITE); 
        panel.add(checkButton); 
        JLabel resultLabel = new JLabel(""); 
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 13)); 
        resultLabel.setBounds(20, 95, 350, 25); 
        resultLabel.setForeground(new Color(0, 128, 0)); 
        panel.add(resultLabel); 
      
        checkButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                String password = new String(passwordField.getPassword()); 
                String strength = checkStrength(password); 
                resultLabel.setText("Password Strength: " + strength); 
            } 
        }); 
 
        frame.setVisible(true); 
    } 
 
    public static String checkStrength(String password) { 
        if (password.length() < 6) { 
            return "Weak"; 
        } 
 
        boolean hasLetter = false; 
        boolean hasDigit = false; 
        boolean hasSymbol = false; 
 
        for (char c : password.toCharArray()) { 
            if (Character.isLetter(c)) hasLetter = true; 
            else if (Character.isDigit(c)) hasDigit = true; 
            else hasSymbol = true; 
        } 
 
        if (password.length() >= 8 && hasLetter && hasDigit && hasSymbol) { 
            return "Strong"; 
        } else if (hasLetter && hasDigit) { 
            return "Medium"; 
        } else { 
            return "Weak"; 
        } 
    } 
} 