package player.models;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LightningTimer extends JPanel {
   private static final String INTRO = "intro";
   private static final String USED_BEFORE = "used before";
   private CardLayout cardLayout = new CardLayout();
   private JLabel countDownLabel = new JLabel("", SwingConstants.CENTER);

   public LightningTimer() {
      JPanel introSouthPanel = new JPanel();
      introSouthPanel.add(new JLabel("Status:"));
      introSouthPanel.add(countDownLabel);

      JPanel introPanel = new JPanel();
      introPanel.setPreferredSize(new Dimension(200, 50));
      introPanel.setLayout(new BorderLayout());
      //introPanel.add(new JLabel("WELCOME", SwingConstants.CENTER), BorderLayout.CENTER);
      introPanel.add(introSouthPanel, BorderLayout.SOUTH);

      JPanel usedBeforePanel = new JPanel(new BorderLayout());
      usedBeforePanel.setBackground(Color.pink);
      usedBeforePanel.add(new JLabel("Used Before", SwingConstants.CENTER));

      setLayout(cardLayout);
      add(introPanel, INTRO);
      add(usedBeforePanel, USED_BEFORE);

      new HurdlerTimer(this).start();
   }

   protected static void createAndShowUI() {
      JFrame frame = new JFrame("");
      frame.getContentPane().add(new LightningTimer());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }

   public void setCountDownLabelText(String text) {
      countDownLabel.setText(text);
   }

   public void showNextPanel() {
      cardLayout.next(this);
   }
}

class HurdlerTimer {
   private static final int TIMER_PERIOD = 1000;
   protected static final int MAX_COUNT = 60;
   private LightningTimer timer; // holds a reference to the Welcome class
   private int count;

   public HurdlerTimer(LightningTimer timer) {
      this.timer = timer; // initializes the reference to the Welcome class.
      String text = "" + (MAX_COUNT - count) + "seconds left";
      timer.setCountDownLabelText(text);
   }

   public void start() {
      new Timer(TIMER_PERIOD, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (count < MAX_COUNT) {
               count++;
               String text = "" + (MAX_COUNT - count) + " seconds left";
               timer.setCountDownLabelText(text); // uses the reference to Welcome
            } else {
               ((Timer) e.getSource()).stop();
               timer.showNextPanel();
            }
         }
      }).start();
   }

}
