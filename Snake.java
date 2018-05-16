import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener
{
    private int t = 175;
    Timer tm= new Timer(t, this);
    
    int x=20*(int)(Math.random()*40),y=20*(int)(Math.random()*30),velX=0,velY=0;
    int count=0;
    
    Food f;
    ArrayList<Integer> snek = new ArrayList<>(1);
    public Snake()
    {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public void grow(Graphics g)
    {
        if(velX > 0)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x-20,y,20,20);
        }
        else if(velX < 0)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x+20,y,20,20);
        }
        else if(velY < 0)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x,y+20,20,20);
        }
        else if(velY > 0)
        {
            g.setColor(Color.GREEN);
            g.fillRect(x,y-20,20,20);
        }
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
            velX=-20;
            velY=0;
        }
        if(c==KeyEvent.VK_UP)
        {
            velX=0;
            velY=-20;
        }
        if(c==KeyEvent.VK_RIGHT)
        {
            velX=20;
            velY=0;
        }
        if(c==KeyEvent.VK_DOWN)
        {
           velX=0;
           velY=20;
        }
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //background color
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,600);
        //snake color
        g.setColor(Color.GREEN);
        g.fillRect(x,y,20,20);
        if(f!=null)
            f.draw(g);
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

        if(f==null)
        {
            f= new Food();
            
        }
        if(x==f.getFoodPosX() && y==f.getFoodPosY())
        {
            
            f=null;
        }
        //if(count%7==0)
        //{
            
        //}
        repaint();
    }

    public static void main(String[] args)
    {

        Snake s = new Snake();

        JFrame jf = new JFrame();
        //jf.frameRate(20);
        jf.setTitle("Snake Game");
        jf.setSize(800,600);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(s);
        jf.setVisible(true);
    }
}
