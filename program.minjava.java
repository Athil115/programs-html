import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MiniCraft extends JPanel implements KeyListener {

    // Player position
    int playerX = 100;
    int playerY = 100;

    // Block size
    int blockSize = 50;

    // Map (1 = grass block, 0 = empty)
    int[][] world = {
            {1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,1,0,1},
            {1,0,0,0,1,0,0,1,0,1},
            {1,1,1,0,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}
    };

    // Draw game
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sky background
        setBackground(Color.CYAN);

        // Draw blocks
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[row].length; col++) {

                if (world[row][col] == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(col * blockSize, row * blockSize,
                            blockSize, blockSize);

                    // Block border
                    g.setColor(Color.BLACK);
                    g.drawRect(col * blockSize, row * blockSize,
                            blockSize, blockSize);
                }
            }
        }

        // Draw player
        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, 40, 40);
    }

    // Keyboard controls
    public void keyPressed(KeyEvent e) {

        int speed = 10;

        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerY -= speed;
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerY += speed;
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            playerX -= speed;
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            playerX += speed;
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // Main method
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mini Minecraft Game");

        MiniCraft game = new MiniCraft();

        frame.add(game);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addKeyListener(game);
    }
}