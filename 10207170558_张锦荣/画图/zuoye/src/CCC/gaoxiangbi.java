package CCC;


import java.util.Scanner;
import java.awt.Color; 
import java.awt.Font; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.text.DecimalFormat; 
import java.text.NumberFormat; 

import javax.xml.ws.http.HTTPException;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.axis.CategoryAxis; 
import org.jfree.chart.axis.CategoryLabelPositions; 
import org.jfree.chart.axis.NumberAxis; 
import org.jfree.chart.axis.ValueAxis; 
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator; 
import org.jfree.chart.labels.StandardPieSectionLabelGenerator; 
import org.jfree.chart.plot.CategoryPlot; 
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.chart.renderer.category.BarRenderer; 
import org.jfree.chart.renderer.category.LineAndShapeRenderer; 
import org.jfree.chart.renderer.category.StackedBarRenderer; 
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle; 
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities; 
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.data.general.PieDataset; 
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

class A{
	 class B{//�ڲ��෽��
	  private String processname ;//s������
	  private int arrivetime ;//����ʱ��
	  private int servetime ;//����ʱ��   
	  private int finishtime ;//���ʱ��
	  private int turnovertime ;//��תʱ��
	  private int weighturnovertime ;//��Ȩ��תʱ��
	  private int flag=0 ;//��Ǹý����Ƿ��Ѿ����
	  
	  public B(String processname,int arrivetime,int servetime){//���췽��ֻ������֪��
	   this.processname=processname ;
	   this.arrivetime=arrivetime ;
	   this.servetime=servetime ;
	  }
	  public void setFlag(){
	   this.flag=1 ;
	  }
	  public void setFinishtime(int finishtime){
	   this.finishtime=finishtime ;  
	  }
	  public void setTurnovertime(){//������תʱ��
	   this.turnovertime=this.finishtime-this.arrivetime ;
	  }
	  public void setWeightturnovertime(){//�����Ȩ��תʱ��
	   this.weighturnovertime=this.turnovertime/this.servetime ;
	  }
	  public String toString(){//��дtoString����
	   return this.processname + "\t" + this.arrivetime+ "\t\t" + this.servetime + "  \t"
	    + this.finishtime + "\t\t" + this.turnovertime + "\t\t" + this.weighturnovertime + "\n" ;
	  }
	 }
	  
	 private B processes[]=new B[10] ;//��������
	 private int n=0 ;//��¼������
	 private int finishnum=0 ;//��¼�Ѿ���ɵĽ�����
	 private  int finish=0 ;
	 private int aveturnovertime ;//ƽ����תʱ��
	 private int aveweighturnovertime ;//ƽ����Ȱ��תʱ��
	 public void setFinish(int servetime){
	  finish+=servetime ;
	 }
	 public void add(String processname,int arrivetime,int servetime){//��ӽ��̲��������ʱ��
	  B process=new B(processname,arrivetime,servetime) ;
	  this.processes[n]=process ;
	  n++ ;
	 }

	 public void fun(){//���ҵ�һ������ʱ�����ҵĽ���
	 creatchat aaa=new creatchat();
	 DefaultCategoryDataset datata=new DefaultCategoryDataset();
	 DefaultCategoryDataset dada=new DefaultCategoryDataset();	
	  int temp=processes[0].arrivetime ;//��¼��С�ĵ���ʱ��
	  int qq=0;
	  int k=0 ;//��־��ִ�еĽ���
	  for(int i=0;i<this.n;i++){//�ҵ��ﵽʱ������Ľ���
	   if(temp>processes[i].arrivetime){
	    temp=processes[i].arrivetime ;
	    k=i ;
	    qq=i;
	   }
	  }
	  this.finish=temp ;//����finish�ĳ�ʼֵΪ��������Ľ��̵ĵ���ʱ��
	  for(int jj=temp;jj<=processes[k].servetime;jj++){
		  String w=String.valueOf(k+1);
		  String q=String.valueOf(jj);
	  datata.addValue(0, w,q);}  
	  for(int j=temp;j<=(processes[k].servetime+processes[k].arrivetime);j++){
		  String w=String.valueOf(k+1);
    	  String q=String.valueOf(j);
      dada.addValue(k+1,w,q);}
	  this.set(k) ;
	  while(this.finishnum!=this.n){
	   k=setRp() ;
	   while(k==qq){
	    this.finish++ ;
	    k=setRp() ;
	   }
	   for(int jj=finish;jj<=(finish+processes[k].servetime);jj++){
		   String w=String.valueOf(k+1);
			  String q=String.valueOf(jj);
		  datata.addValue(0, w,q);}	 
		  for(int j=processes[k].arrivetime;j<=(processes[k].servetime+processes[k].arrivetime);j++){
			  String w=String.valueOf(k+1);
	    	  String q=String.valueOf(j);
	      dada.addValue(k+1,w,q);}
	   this.set(k) ;
	  }
	  for(int i=processes[qq].arrivetime;i<=finish;i++){
		  String q=String.valueOf(i);
		  dada.addValue(-1, "", q);
	  }
	  aaa.creatchat(datata,0);
	  aaa.creatchat(dada,1);
	  
	  for (int i=0;i<this.n;i++ ){
	   this.aveturnovertime+=processes[i].turnovertime ;
	  }
	  this.aveturnovertime/=this.n ;
	  for (int i=0;i<this.n;i++ ){
	   this.aveweighturnovertime+=processes[i].weighturnovertime ;
	  }
	  this.aveweighturnovertime/=this.n ;
	 }
	 public int setRp(){//��������Ȩ������������Ȩ��Ľ����±��
	  int i=0 ;
	  int m=0 ;//��¼����Ȩ���Ľ��̵��±�
	  float temp=0.0f ;//��¼��������Ȩ
	  while(i<this.n){//���̻�ûִ�в����Ѿ�����
	   if(this.processes[i].flag==0 && this.processes[i].arrivetime<=this.finish){
	    float Rp=(this.finish-this.processes[i].arrivetime)/ this.processes[i].servetime ;
	    if(temp<=Rp){
	     temp=Rp ;
	     m=i ;  
	    }
	   }
	   i++ ;
	  }
	  return m ;
	 }
	 public void set(int i){//����һ�����̵����ʱ�䣬��תʱ�䣬��Ȩ��תʱ��
	  this.setFinish(this.processes[i].servetime) ;
	  this.processes[i].setFinishtime(finish) ;
	  this.processes[i].setTurnovertime() ;
	  this.processes[i].setWeightturnovertime() ;
	  this.processes[i].setFlag() ;//�������
	  this.finishnum++ ;
	 }
	 public void print(){//��ӡ���
	  for(int i=0;i<this.n;i++){
	   System.out.print(this.processes[i]);
	  }
	  System.out.println("ƽ����תʱ�䣺" +this.aveturnovertime) ;
	  System.out.println("ƽ����Ȩ��תʱ�䣺" + this.aveweighturnovertime) ;
	 }
	}
	public class gaoxiangbi{
	 public static void main(String args[]) {
		 A a=new A() ;
				
		  String b;
		  int c,d; 
		  
		 /* System.out.println("��������̵�����(int)��");
	      Scanner scan = new Scanner(System.in);
	      int num = scan.nextInt();
	      for (int i = 1; i <= num; i++) {       
	          System.out.println("�������" + i + "�Ľ�����(String)��������ʱ��(int)��������ʱ��(int)");
	          b=scan.next();
	          c=scan.nextInt();
	          d=scan.nextInt();     
	          a.add(b,c,d);     
	          } */
		 a.add("dsad", 4, 3);
		 a.add("dsad", 0, 3);
		 a.add("dsad", 4, 2);
		 a.add("dsad", 2, 3);
		 a.add("dsad", 3, 7);
		 
	     a.fun() ; 	 	 
		
		 
		 System.out.println("������ ����ʱ�� ����ʱ��\t���ʱ��\t��תʱ��\t��Ȩ��תʱ��") ;
		  a.print() ;
	 }
	}
