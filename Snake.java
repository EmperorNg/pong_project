import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener
{
    Timer tm= new Timer(5, this);
    int x=0,y=0,velX=0,velY=0;
    public Snake()
    {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void keyReleased(KeyEvent e)
    {
        //velX=0;
        //velY=0;
        
    }

    public void keyPressed(KeyEvent e)
    {
        int c = e.getKeyCode();    

        if(c == KeyEvent.VK_LEFT)
        {
            velX=-1;
            velY=0;
        }
        if(c==KeyEvent.VK_UP)
        {
            velX=0;
            velY=-1;
        }
        if(c==KeyEvent.VK_RIGHT)
        {
            velX=1;
            velY=0;
        }
        if(c==KeyEvent.VK_DOWN)
        {
            velX=0;
            velY=1;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(x,y,20,20);
    }
    // make death method
    // if snake hits self or edge start over at random spot
    //make food method 
    //randomly spawns one food on grid 
    // make grow method 
    // if head equals same space as food grow the tail plus 1
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(x<0)
        {
            velX=0;
            x=0;
        }
        if(x>780)
        {
            velX=0;
            x=780;
        }
        if(y<0)
        {
            velY=0;
            y=0;
        }
        if(y>560)
        {
            velY=0;
            y=560;
        }
        x=x+velX;
        y=y+velY;
        repaint();
    }

    public static void main(String[] args)
    {
        Snake s = new Snake();
        JFrame jf = new JFrame();
        jf.setTitle("Snake Game");
        jf.setSize(800,600);
        //jf.getContentPane().setBackground(Color.BLACK);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(s);
    }
}
