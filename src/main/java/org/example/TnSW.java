package org.example;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TnSW extends JFrame implements ActionListener {

    JTextField timerText = new JTextField();
    JTextField stopwatchText = new JTextField();
    JTextField text = new JTextField();
    JButton button1 = new JButton("Play");
    JButton button2 = new JButton("Play");
    Stopwatch stopwatch = new Stopwatch(stopwatchText);
    Timer timer = new Timer(text,timerText);
    private boolean isRunning;
    private boolean isTimerRunning;

    TnSW() {
        setSize(600, 400);
        setLayout(null);


        button1.setBounds(50, 200, 100, 50);
        add(button1);
        button1.addActionListener(this);
        button2.setBounds(210,300,100,50);
        button2.addActionListener(this);
        add(button2);
        text.setBounds(210,200,100,50);
        add(text);
        stopwatchText.setBounds(50,100,100,50);
        stopwatchText.setHorizontalAlignment(JTextField.CENTER);
        stopwatchText.setText(" : : : ");
        stopwatchText.setEditable(false);
        timerText.setBounds(210,100,100,50);
        timerText.setHorizontalAlignment(JTextField.CENTER);
        timerText.setText(" : : : ");
        timerText.setEditable(false);
        add(stopwatchText);
        add(timerText);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            if (!isRunning) {
                isRunning = true;
                button1.setText("Stop");
                stopwatch.setBooleanvalue(isRunning);
                stopwatch.start();
            } else {
                isRunning = false;
                button1.setText("Play");
                stopwatch.setBooleanvalue(isRunning);
                stopwatch.stop();
            }
        } else if (e.getSource() == button2) {
            if (!isTimerRunning){

                isTimerRunning = true;
                button2.setText("Stop");
                timer.start();

            } else {
                text.setText("");
                isTimerRunning = false;
                button2.setText("Play");
                timer.stop();
            }
        }
    }
}
