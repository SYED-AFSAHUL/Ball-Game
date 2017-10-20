/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package new_game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author afsah
 */
public class game extends JPanel implements KeyListener {
   
    //global constant
    int x,y,x1,y1,p,q,l_s,l_inc,score;
    JFrame frame;
    game o;
    
    /**
     * parent class - JPanel
     * draws the graphics in the JFrame
     */
    @Override
    public void paint(Graphics g){
        System.out.println("\tpaint");
        
        super.paint(g);
        Graphics2D gg = (Graphics2D)g;
        gg.fillOval(x, y, 30, 30);          //draws ball(startPosOfx,stsPosOfy,horLength,verLength)
        gg.draw3DRect(30, 20, 1300, 500, true);             //draw rectangle(same as above)
        Line2D ln = new Line2D.Float(l_s,460,l_s+200,460);  //draw line(start_x,start_y,end_x,end_y)
        gg.draw(ln);                                        //draws line in JFrame
        System.out.println(l_s);
        System.out.println("\tpaint ends");
    }
    
    @Override
    public void keyTyped(KeyEvent event){
    
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println("\n\tkeyPressed starts");
        switch (ke.getKeyCode()) {             
            case KeyEvent.VK_UP:
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("down");
                break;
            case KeyEvent.VK_LEFT:      //when left arrow key is pressed
                System.out.println("left");
                if(o.l_s>30)
                    o.l_s-=o.l_inc;
                System.out.println(o.l_s);
                break;
            case KeyEvent.VK_RIGHT:         //when right arrow key is pressed
                System.out.println("right");
                if(o.l_s<1130)
                    o.l_s+=o.l_inc;
                System.out.println(o.l_s);
                break;
            case KeyEvent.VK_D:
                if(o.l_s<1100)
                    o.l_s+=40;
                else if(o.l_s>=1100)
                    o.l_s=1130;
                break;
            case KeyEvent.VK_A:
                if(o.l_s>60)
                    o.l_s-=40;
                else if(o.l_s <=60){
                    o.l_s=30;
                }
                break;
            default:
                System.out.println("in key pressed");
                break;
        }
        System.out.println("\tkey pressed ends");
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println("\n\tkeyReleased");
    }
            
    public void moveBall(){
        if(x>1300 || x<28 )
            x1*=-1;                 //bounds the left most and right most limit
        if(y<18 )
            y1*=-1;                 //bounds the top most limit
                
        if(y==430){
            if(x>l_s-40 && x<l_s+200){
                y1*=-1;                 //bounce back after touching the bar
                score++;                //score inc every time bar is encountered
            }else{
                System.out.println("GAME OVER!!!!!!!!\nScore :-"+score);
                exit(0);
            }
        }
        x+=x1;                  //coordinate of
        y+=y1;                  //ball change
    }
    
    public void the_game(){
        System.out.println("\t1");
        frame = new JFrame();
         
        frame.setSize(1500,750);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        o = new game();

        o.x=28;o.y=18;o.x1=1;o.y1=1;o.p=1;
        o.q=1;o.l_s=200;o.l_inc=10;o.score=0;
        
        frame.add(o);           //add object of this class to JFrame and
                                 //calls paint method
        System.out.println("\t2");

        try{
            System.out.println(Thread.currentThread());
            
        }catch(Exception e){
            e.printStackTrace();
        }
        frame.requestFocusInWindow();   //key responses when JFrame is in focus
        frame.addKeyListener(this);

        System.out.println("\t3");
        double time = 10; 
       int incre=1;
        while(true){
            System.out.println(o.l_s);
            o.moveBall();
            o.repaint();                //ultimately calls paint() with changed parameters

            try{
                Thread.sleep((int)time);
            }catch(InterruptedException e){}
            System.out.println("**********************after try catch main");
            System.out.println("\t"+o.l_s);
            System.out.println("**********************");
            System.out.println("\trepeat");
            time = log(incre++)*time + time;             //increases speed of ball
        }
    }
}
