package CCC;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import sun.awt.image.ToolkitImage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.TextField;
import java.awt.Rectangle;
import java.awt.Label;
import java.awt.Button;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class panel extends JFrame {
	
	ImageIO textPanel;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private TextField a1 = null;
	private TextField a2 = null;
	private TextField a3 = null;
	private TextField a4 = null;
	private TextField a5 = null;
	private TextField a6 = null;
	private Label l1 = null;
	private Label l2 = null;
	private Label l3 = null;
	private Label l4 = null;
	private Label l5 = null;
	private Button b1 = null;
	private Label l6 = null;
	private TextField a7 = null;
	private TextField a8 = null;
	private TextField a9 = null;
	private TextField a10 = null;
	private TextField a11 = null;
	private TextField a12 = null;
	private Label label = null;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	public static void main(String args[]) {
		panel frame = new panel();
		frame.setVisible(true);
		 
	}
	
	public panel() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(407, 236);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			label3 = new Label();
			label3.setBounds(new Rectangle(320, 2, 70, 25));
			label3.setText("运行时间int");
			label2 = new Label();
			label2.setBounds(new Rectangle(246, 5, 63, 20));
			label2.setText("进入时间int");
			label1 = new Label();
			label1.setBounds(new Rectangle(130, 4, 62, 20));
			label1.setText("运行时间int");
			label = new Label();
			label.setBounds(new Rectangle(59, 0, 70, 25));
			label.setText("进入时间int");
			l6 = new Label();
			l6.setBounds(new Rectangle(200, 108, 40, 25));
			l6.setText("进程6");
			l5 = new Label();
			l5.setBounds(new Rectangle(20, 110, 40, 25));
			l5.setText("进程5");
			l4 = new Label();
			l4.setBounds(new Rectangle(200, 70, 40, 25));
			l4.setText("进程4");
			l3 = new Label();
			l3.setBounds(new Rectangle(20, 70, 40, 25));
			l3.setText("进程3");
			l2 = new Label();
			l2.setBounds(new Rectangle(200, 30, 40, 25));
			l2.setText("进程2");
			l1 = new Label();
			l1.setBounds(new Rectangle(20, 30, 40, 25));
			l1.setText("进程1");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getA1(), null);
			jContentPane.add(getA2(), null);
			jContentPane.add(getA3(), null);
			jContentPane.add(getA4(), null);
			jContentPane.add(getA5(), null);
			jContentPane.add(getA6(), null);
			jContentPane.add(l1, null);
			jContentPane.add(l2, null);
			jContentPane.add(l3, null);
			jContentPane.add(l4, null);
			jContentPane.add(l5, null);
			jContentPane.add(getB1(), null);
			jContentPane.add(l6, null);
			jContentPane.add(getA7(), null);
			jContentPane.add(getA8(), null);
			jContentPane.add(getA9(), null);
			jContentPane.add(getA10(), null);
			jContentPane.add(getA11(), null);
			jContentPane.add(getA12(), null);
			jContentPane.add(label, null);
			jContentPane.add(label1, null);
			jContentPane.add(label2, null);
			jContentPane.add(label3, null);
		}
		return jContentPane;
	}

	
	private TextField getA1() {
		if (a1 == null) {
			a1 = new TextField();
			a1.setBounds(new Rectangle(72, 30,40, 25));
		}
		return a1;
	}

	
	private TextField getA2() {
		if (a2 == null) {
			a2 = new TextField();
			a2.setBounds(new Rectangle(140, 30, 40, 25));
		}
		return a2;
	}

	
	private TextField getA3() {
		if (a3 == null) {
			a3 = new TextField();
			a3.setBounds(new Rectangle(256,30, 40, 25));
		}
		return a3;
	}

	
	private TextField getA4() {
		if (a4 == null) {
			a4 = new TextField();
			a4.setBounds(new Rectangle(330, 30, 40, 25));
		}
		return a4;
	}

	
	private TextField getA5() {
		if (a5 == null) {
			a5 = new TextField();
			a5.setBounds(new Rectangle(72,70, 40, 25));
		}
		return a5;
	}

	
	private TextField getA6() {
		if (a6 == null) {
			a6 = new TextField();
			a6.setBounds(new Rectangle(140, 70, 40, 25));
		}
		return a6;
	}

	
	private Button getB1() {
		if (b1 == null) {
			b1 = new Button();
			b1.setBounds(new Rectangle(273, 158, 73, 30));
			b1.setLabel("执行");
			b1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					A b=new A();
					int rr=6;
					if(a1.getText()!=""&&a2.getText()!=""){
					try{b.add("1", Integer.parseInt(a1.getText()), Integer.parseInt(a2.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						rr--;
					}
					}
					if(a3.getText()!=""&&a4.getText()!=""){
						try{b.add("2", Integer.parseInt(a3.getText()), Integer.parseInt(a4.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							rr--;
						}
						}
					if(a5.getText()!=""&&a6.getText()!=""){
						try{b.add("3", Integer.parseInt(a5.getText()), Integer.parseInt(a6.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							rr--;
						}
						}
					if(a7.getText()!=""&&a7.getText()!=""){
						try{b.add("4", Integer.parseInt(a7.getText()), Integer.parseInt(a8.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							rr--;
						}
						}
					if(a9.getText()!=""&&a10.getText()!=""){
						try{b.add("5", Integer.parseInt(a9.getText()), Integer.parseInt(a10.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							rr--;
						}
						}
					if(a11.getText()!=""&&a12.getText()!=""){
						try{b.add("6", Integer.parseInt(a11.getText()), Integer.parseInt(a12.getText()));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							rr--;
						}
						}
					if(rr>=1)
					{b.fun();
					System.out.println("进程名 到达时间 服务时间\t完成时间\t周转时间\t带权周转时间") ;
					  b.print() ;}
					else System.out.println("没有数据或输入不正确");
					dispose();
					ImagePanel kkk=new ImagePanel();
					kkk.setVisible(true);
					
				}
			});
		}
		return b1;
	}

	/**
	 * This method initializes a7	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getA7() {
		if (a7 == null) {
			a7 = new TextField();
			a7.setBounds(new Rectangle(256, 70, 40,25));
		}
		return a7;
	}

	/**
	 * This method initializes a8	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getA8() {
		if (a8 == null) {
			a8 = new TextField();
			a8.setBounds(new Rectangle(330, 70, 40,25));
		}
		return a8;
	}

	/**
	 * This method initializes a9	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getA9() {
		if (a9 == null) {
			a9 = new TextField();
			a9.setBounds(new Rectangle(72, 110, 40,25));
		}
		return a9;
	}

	/**
	 * This method initializes a10	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getA10() {
		if (a10 == null) {
			a10 = new TextField();
			a10.setBounds(new Rectangle(140, 111, 42, 23));
		}
		return a10;
	}

	/**
	 * This method initializes a11	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getA11() {
		if (a11 == null) {
			a11 = new TextField();
			a11.setBounds(new Rectangle(256, 110, 40,25));
		}
		return a11;
	}

	/**
	 * This method initializes a12	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getA12() {
		if (a12 == null) {
			a12 = new TextField();
			a12.setBounds(new Rectangle(330, 110, 40,25));
		}
		return a12;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
