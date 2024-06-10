/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author VilPa977
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 *
 * @author Foxyi03
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener{
    private Snake snake;
    private boolean inField = false;
    private final int Width = 300; //width of the drawPanel
    private final int Height = 300; //height of the drawPanel
    private int gameSpeed = 100;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        //common things to add to the frame
        setResizable(false);
        pack();
        setPreferredSize(new Dimension(Width,Height));
        setTitle("Snake_Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        snake = new Snake();
        add(new Snake());
        drawPanel.setSnake(snake);
        
        
        
    }
    //creates the snake, randomly places an apple, starts the timer
    public void initGame(){
        snake.parts = 3;

        for(int i = 0; i < snake.parts; i++){
            snake.x[i] = 50 - i * 10;
            snake.y[i] = 50;
        }
        snake.appleLoc();
        snake.breadLoc();
        Timer timer = new Timer(gameSpeed, this);
        timer.start();
        
    }
    //checks if everything is in the field, if not then the drawPanel needs to repaint
    @Override
    public void actionPerformed(ActionEvent e){
        if(!inField){
            snake.checkApple();
            snake.checkBread();
            snake.checkCollision();
            snake.move();
        }
        drawPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawPanel = new DrawPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drawPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                drawPanelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drawPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_drawPanelKeyPressed
        int key = evt.getKeyCode(); //key is read and put into the right direction

        if((key == KeyEvent.VK_LEFT) && (!snake.goRight)){
            snake.goLeft = true;
            snake.goUp = false;
            snake.goDown = false;
        }
        if((key == KeyEvent.VK_RIGHT)&&(!snake.goLeft)){
            snake.goRight = true;
            snake.goUp = false;
            snake.goDown = false;
        }
        if((key == KeyEvent.VK_UP)&&(!snake.goDown)){
            snake.goLeft = false;
            snake.goUp = true;
            snake.goRight = false;
        }
        if((key == KeyEvent.VK_DOWN)&&(!snake.goUp)){
            snake.goLeft = false;
            snake.goDown = true;
            snake.goRight = false;
        }
    }//GEN-LAST:event_drawPanelKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DrawPanel drawPanel;
    // End of variables declaration//GEN-END:variables
}
