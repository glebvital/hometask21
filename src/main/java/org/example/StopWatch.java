package org.example;

import javax.swing.*;

class Stopwatch extends Thread implements TimerBase{

    private JTextField stopwatchText;
    private boolean booleanvalue;
    private int i = 0;

    public Stopwatch(JTextField stopwatchText) {
        this.stopwatchText = stopwatchText;
    }

    public boolean isBooleanvalue() {
        return booleanvalue;
    }

    public void setBooleanvalue(boolean booleanvalue) {
        this.booleanvalue = booleanvalue;
    }

    @Override
    public void run() {
        try {
            begin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void begin() throws Exception {
        while (booleanvalue) {
            String sec = String.valueOf(i % 60);
            String min = String.valueOf((i/60) % 60);
            String hour = String.valueOf((i/3600) % 24);
            String days = String.valueOf(i/86400);
            stopwatchText.setText(days + ":" + hour + ":" + min + ":" + sec);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

