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
	 class B{//内部类方便
	  private String processname ;//s进程名
	  private int arrivetime ;//到达时间
	  private int servetime ;//服务时间   
	  private int finishtime ;//完成时间
	  private int turnovertime ;//周转时间
	  private int weighturnovertime ;//带权周转时间
	  private int flag=0 ;//标记该进程是否已经完成
	  
	  public B(String processname,int arrivetime,int servetime){//构造方法只传入已知量
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
	  public void setTurnovertime(){//计算周转时间
	   this.turnovertime=this.finishtime-this.arrivetime ;
	  }
	  public void setWeightturnovertime(){//计算带权周转时间
	   this.weighturnovertime=this.turnovertime/this.servetime ;
	  }
	  public String toString(){//覆写toString函数
	   return this.processname + "\t" + this.arrivetime+ "\t\t" + this.servetime + "  \t"
	    + this.finishtime + "\t\t" + this.turnovertime + "\t\t" + this.weighturnovertime + "\n" ;
	  }
	 }
	  
	 private B processes[]=new B[10] ;//进程数组
	 private int n=0 ;//记录进程数
	 private int finishnum=0 ;//记录已经完成的进程数
	 private  int finish=0 ;
	 private int aveturnovertime ;//平均周转时间
	 private int aveweighturnovertime ;//平均带劝周转时间
	 public void setFinish(int servetime){
	  finish+=servetime ;
	 }
	 public void add(String processname,int arrivetime,int servetime){//添加进程并计算完成时间
	  B process=new B(processname,arrivetime,servetime) ;
	  this.processes[n]=process ;
	  n++ ;
	 }

	 public void fun(){//查找第一个到达时间最找的进程
	 creatchat aaa=new creatchat();
	 DefaultCategoryDataset datata=new DefaultCategoryDataset();
	 DefaultCategoryDataset dada=new DefaultCategoryDataset();	
	  int temp=processes[0].arrivetime ;//记录最小的到达时间
	  int qq=0;
	  int k=0 ;//标志该执行的进程
	  for(int i=0;i<this.n;i++){//找到达到时间最早的进程
	   if(temp>processes[i].arrivetime){
	    temp=processes[i].arrivetime ;
	    k=i ;
	    qq=i;
	   }
	  }
	  this.finish=temp ;//设置finish的初始值为到达最早的进程的到达时间
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
	 public int setRp(){//计算优先权，并返回优先权大的进程下表标
	  int i=0 ;
	  int m=0 ;//记录优先权最大的进程的下标
	  float temp=0.0f ;//记录最大的优先权
	  while(i<this.n){//进程还没执行并且已经到达
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
	 public void set(int i){//计算一个进程的完成时间，周转时间，带权周转时间
	  this.setFinish(this.processes[i].servetime) ;
	  this.processes[i].setFinishtime(finish) ;
	  this.processes[i].setTurnovertime() ;
	  this.processes[i].setWeightturnovertime() ;
	  this.processes[i].setFlag() ;//进程完成
	  this.finishnum++ ;
	 }
	 public void print(){//打印输出
	  for(int i=0;i<this.n;i++){
	   System.out.print(this.processes[i]);
	  }
	  System.out.println("平均周转时间：" +this.aveturnovertime) ;
	  System.out.println("平均带权周转时间：" + this.aveweighturnovertime) ;
	 }
	}
	public class gaoxiangbi{
	 public static void main(String args[]) {
		 A a=new A() ;
				
		  String b;
		  int c,d; 
		  
		 /* System.out.println("请输入进程的数量(int)：");
	      Scanner scan = new Scanner(System.in);
	      int num = scan.nextInt();
	      for (int i = 1; i <= num; i++) {       
	          System.out.println("输入进程" + i + "的进程名(String)……到达时间(int)……运行时间(int)");
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
		
		 
		 System.out.println("进程名 到达时间 服务时间\t完成时间\t周转时间\t带权周转时间") ;
		  a.print() ;
	 }
	}
