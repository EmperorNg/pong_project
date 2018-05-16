import java.awt.Color;
import java.awt.Graphics;
public class Food
{
    private int x;
    private int y;
    public Food()
    {
        x=20*(int)(Math.random()*40);
        y=20*(int)(Math.random()*30);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x,y,20,20);

    }

    public int getFoodPosX()
    {
        return x;
    }
    public int getFoodPosY()
    {
        return y;
    }
}