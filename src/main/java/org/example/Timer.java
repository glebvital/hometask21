package org.example;

import javax.swing.*;

class Timer extends Thread{

    private JTextField text;
    private JTextField timerText;
    private int i = 0;

    public Timer(JTextField text, JTextField timerText) {
        this.timerText = timerText;
        this.text = text;
    }


    // open-closed
    public void timer() throws Exception{
        if (!text.getText().matches("[0-9]+")){
            new Exception();
            return;
        }
        while (i <= Integer.parseInt(text.getText())) {
            String sec = String.valueOf(i % 60);
            String min = String.valueOf((i/60) % 60);
            String hour = String.valueOf((i/3600) % 24);
            String days = String.valueOf(i/86400);
            timerText.setText(days + ":" + hour + ":" + min + ":" + sec);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        try {
            timer();
        } catch (Exception e) {
            System.out.println("make sure you inputted numbers");
            throw new RuntimeException(e);
        }
    }


}
