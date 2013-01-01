package CCC;



import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JFrame {
        private static final long serialVersionUID = 1L;
        ImagePanel contentPanel=null;
        BorderLayout bl = new BorderLayout();
        DrawCanvas canvas = new DrawCanvas();

        ImagePanel(){
                init();
        }
        
        private void init() {
                contentPanel = this;
                contentPanel.setLayout(bl);
                this.setSize(new Dimension(500, 510));
                contentPanel.add(this.canvas, BorderLayout.CENTER);
        }

         

        class DrawCanvas extends Canvas {
                private static final long serialVersionUID = 1L;
                Image image;

                public DrawCanvas() {
                        image = this.getToolkit().getImage("C://jincheng.png");
                        MediaTracker mt = new MediaTracker(this);
                        mt.addImage(image, 1);
                        try {
                                mt.waitForAll();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        if (image.getWidth(this) == -1) {
                                System.out.println("Could not get the image");
                                System.exit(-1);
                        }
                        this.setBackground(Color.black);
                }
                @Override
                 public void paint(Graphics g){
                         Graphics2D g2D = (Graphics2D)g;
                        BufferedImage bimage = (BufferedImage)this.createImage(this.getWidth(),this.getHeight());
                        bimage.createGraphics().drawImage(this.image,0,0,this);
                        g2D.drawImage(bimage,0,0,this); 
                 }
        }
}