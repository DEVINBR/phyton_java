 import java.*;
 import java.awt.*;
 import java.awt.event.*;

 public class CatsAdventure extends JPanel implements ActionListener, KeyListener {


    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int CAT_SIZE = 50;
    private final int SPEED = 5;
    private int catX = WIDTH / 2 - CAT_SIZE / 2;
    private int catY = HEIGHT / 2 - CAT_SIZE / 2;

    
    private boolean up, down, left, right;

    // Timer for game loop (calls actionPerformed)
    private Timer timer;

    public CatsAdventure() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(16, this); // ~60 FPS
        timer.start();
    }

    
    public void actionPerformed(ActionEvent e) {
        if (up)    catY -= SPEED;
        if (down)  catY += SPEED;
        if (left)  catX -= SPEED;
        if (right) catX += SPEED;

        // Prevent the cat from going off-screen
        catX = Math.max(0, Math.min(catX, WIDTH - CAT_SIZE));
        catY = Math.max(0, Math.min(catY, HEIGHT - CAT_SIZE));

        repaint(); // Calls paintComponent
    }

 }