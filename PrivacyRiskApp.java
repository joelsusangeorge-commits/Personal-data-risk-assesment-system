import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrivacyRiskApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Personal Data Privacy Risk Assessment");
        frame.setSize(650, 560);
        frame.setLayout(null);

        JLabel title = new JLabel("Personal Data Privacy Risk Assessment Dashboard");
        title.setBounds(170, 10, 400, 30);
        frame.add(title);

        // PASSWORD MANAGEMENT
        JLabel q1 = new JLabel("Password Management:");
        q1.setBounds(20, 50, 200, 20);
        frame.add(q1);

        JRadioButton p1 = new JRadioButton("Same password everywhere");
        JRadioButton p2 = new JRadioButton("Few passwords reused");
        JRadioButton p3 = new JRadioButton("Unique passwords");

        p1.setBounds(40, 70, 200, 20);
        p2.setBounds(40, 90, 200, 20);
        p3.setBounds(40, 110, 200, 20);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(p1); g1.add(p2); g1.add(p3);

        frame.add(p1); frame.add(p2); frame.add(p3);

        // SOCIAL MEDIA
        JLabel q2 = new JLabel("Social Media Privacy:");
        q2.setBounds(20, 140, 200, 20);
        frame.add(q2);

        JRadioButton s1 = new JRadioButton("Public profile");
        JRadioButton s2 = new JRadioButton("Partially private");
        JRadioButton s3 = new JRadioButton("Fully private");

        s1.setBounds(40, 160, 200, 20);
        s2.setBounds(40, 180, 200, 20);
        s3.setBounds(40, 200, 200, 20);

        ButtonGroup g2 = new ButtonGroup();
        g2.add(s1); g2.add(s2); g2.add(s3);

        frame.add(s1); frame.add(s2); frame.add(s3);

        // WIFI USAGE
        JLabel q3 = new JLabel("Public WiFi Usage:");
        q3.setBounds(20, 230, 200, 20);
        frame.add(q3);

        JRadioButton w1 = new JRadioButton("Frequently");
        JRadioButton w2 = new JRadioButton("Occasionally");
        JRadioButton w3 = new JRadioButton("Never");

        w1.setBounds(40, 250, 200, 20);
        w2.setBounds(40, 270, 200, 20);
        w3.setBounds(40, 290, 200, 20);

        ButtonGroup g3 = new ButtonGroup();
        g3.add(w1); g3.add(w2); g3.add(w3);

        frame.add(w1); frame.add(w2); frame.add(w3);

        // OTP SECURITY
        JLabel q4 = new JLabel("OTP Security:");
        q4.setBounds(320, 50, 200, 20);
        frame.add(q4);

        JRadioButton o1 = new JRadioButton("Sometimes share OTP");
        JRadioButton o2 = new JRadioButton("Rarely share");
        JRadioButton o3 = new JRadioButton("Never share");

        o1.setBounds(340, 70, 200, 20);
        o2.setBounds(340, 90, 200, 20);
        o3.setBounds(340, 110, 200, 20);

        ButtonGroup g4 = new ButtonGroup();
        g4.add(o1); g4.add(o2); g4.add(o3);

        frame.add(o1); frame.add(o2); frame.add(o3);

        // TWO FACTOR AUTH
        JLabel q5 = new JLabel("Two-Factor Authentication:");
        q5.setBounds(320, 140, 200, 20);
        frame.add(q5);

        JRadioButton t1 = new JRadioButton("Never use 2FA");
        JRadioButton t2 = new JRadioButton("Use for some accounts");
        JRadioButton t3 = new JRadioButton("Use for most accounts");

        t1.setBounds(340, 160, 200, 20);
        t2.setBounds(340, 180, 200, 20);
        t3.setBounds(340, 200, 200, 20);

        ButtonGroup g5 = new ButtonGroup();
        g5.add(t1); g5.add(t2); g5.add(t3);

        frame.add(t1); frame.add(t2); frame.add(t3);

        // PASSWORD UPDATE
        JLabel q6 = new JLabel("Password Update Frequency:");
        q6.setBounds(320, 230, 200, 20);
        frame.add(q6);

        JRadioButton u1 = new JRadioButton("Never change password");
        JRadioButton u2 = new JRadioButton("Once a year");
        JRadioButton u3 = new JRadioButton("Every few months");

        u1.setBounds(340, 250, 200, 20);
        u2.setBounds(340, 270, 200, 20);
        u3.setBounds(340, 290, 200, 20);

        ButtonGroup g6 = new ButtonGroup();
        g6.add(u1); g6.add(u2); g6.add(u3);

        frame.add(u1); frame.add(u2); frame.add(u3);

        JButton btn = new JButton("Calculate Risk");
        btn.setBounds(250, 330, 150, 30);
        frame.add(btn);

        JTextArea dashboard = new JTextArea();
        dashboard.setBounds(170, 370, 300, 100);
        dashboard.setEditable(false);
        frame.add(dashboard);

        // Risk meter
        JProgressBar riskBar = new JProgressBar(0, 150);
        riskBar.setBounds(170, 480, 300, 25);
        riskBar.setStringPainted(true);
        frame.add(riskBar);

        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int authRisk = 0;
                int socialRisk = 0;
                int networkRisk = 0;
                int financialRisk = 0;

                if (p1.isSelected()) authRisk += 30;
                else if (p2.isSelected()) authRisk += 15;

                if (s1.isSelected()) socialRisk += 25;
                else if (s2.isSelected()) socialRisk += 10;

                if (w1.isSelected()) networkRisk += 25;
                else if (w2.isSelected()) networkRisk += 10;

                if (o1.isSelected()) financialRisk += 30;
                else if (o2.isSelected()) financialRisk += 10;

                if (t1.isSelected()) authRisk += 20;
                else if (t2.isSelected()) authRisk += 10;

                if (u1.isSelected()) authRisk += 20;
                else if (u2.isSelected()) authRisk += 10;

                int totalRisk = authRisk + socialRisk + networkRisk + financialRisk;

                String level;

                if (totalRisk <= 40)
                    level = "LOW";
                else if (totalRisk <= 80)
                    level = "MODERATE";
                else if (totalRisk <= 120)
                    level = "HIGH";
                else
                    level = "CRITICAL";

                dashboard.setText(
                        "====== PRIVACY RISK DASHBOARD ======\n" +
                        "Authentication Risk : " + authRisk + "\n" +
                        "Social Media Risk   : " + socialRisk + "\n" +
                        "Network Risk        : " + networkRisk + "\n" +
                        "Financial Risk      : " + financialRisk + "\n\n" +
                        "TOTAL RISK SCORE    : " + totalRisk + "\n" +
                        "RISK LEVEL          : " + level
                );

                riskBar.setValue(totalRisk);

                // COLOR CHANGE BASED ON RISK
                if (totalRisk <= 40)
                    riskBar.setForeground(Color.GREEN);
                else if (totalRisk <= 80)
                    riskBar.setForeground(Color.YELLOW);
                else if (totalRisk <= 120)
                    riskBar.setForeground(Color.ORANGE);
                else
                    riskBar.setForeground(Color.RED);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}