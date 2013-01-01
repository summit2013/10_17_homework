package CCC;

import java.awt.Color; 
import java.awt.Font; 
import java.awt.Image;
import java.awt.Paint;
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.text.DecimalFormat; 
import java.text.NumberFormat; 

import javax.imageio.ImageIO;
import javax.xml.bind.JAXB;
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
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.chart.renderer.category.BarRenderer; 
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer; 
import org.jfree.chart.renderer.category.StackedBarRenderer; 
import org.jfree.chart.renderer.xy.XYItemRenderer;
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
public class creatchat {
	
  public String creatchat(CategoryDataset cr,int ss){
	  JFreeChart chart=ChartFactory.createLineChart("先来先服务", "进程", "时间", cr, PlotOrientation.VERTICAL, true, true, false);
	  CategoryPlot ccc = (CategoryPlot) chart.getPlot();
	
	  //Plot plo=chart.getPlot();
	  //plo.setDrawingSupplier(getSupplier());
	  

	 
	  ValueAxis valueaxis = ccc.getRangeAxis();//getRangeAxis(); 
	  //数据为整型
	  valueaxis .setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	  // 设定显示范围,即总是显示1-10
	  if(ss==1){
		  Image image;
			try {
				image = ImageIO.read(new File("C:/wancheng.png"));
				chart.setBackgroundImage(image);chart.setBackgroundImageAlpha(1.0f);chart.setBorderPaint(Color.white);
				ccc.setBackgroundPaint(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		  valueaxis .setLowerBound(-1);
	  valueaxis .setUpperBound(7); }
	  else {
		  valueaxis .setLowerBound(-1);
	  valueaxis .setUpperBound(7); }
	  CategoryItemRenderer renderer =  ccc.getRenderer();
	  renderer.setSeriesPaint(0,Color.YELLOW);
	  renderer.setSeriesPaint(1,Color.red);
	  renderer.setSeriesPaint(2,Color.green);
	  renderer.setSeriesPaint(3,Color.gray);
	  renderer.setSeriesPaint(4,Color.cyan);
	  renderer.setSeriesPaint(5,Color.magenta);
	  renderer.setSeriesPaint(6,Color.pink);
	  
	  FileOutputStream fos_jpg = null;
	  try{if(ss==1){
	  String chaername="C:/jincheng.png";
	  fos_jpg = new FileOutputStream(chaername); 

	// 将报表保存为png文件 
	ChartUtilities.writeChartAsPNG(fos_jpg,chart,500, 510); 
	return chaername;}
	  else {String chaername="C:/wancheng.png";
	  fos_jpg = new FileOutputStream(chaername); 

		// 将报表保存为png文件 
		ChartUtilities.writeChartAsPNG(fos_jpg,chart,500, 510); 
		return chaername;}

	} 
	catch (Exception e) 
	{ 
	e.printStackTrace(); 
	return null; 
	} 
	finally 
	{ 
	try 
	{ 
	fos_jpg.close(); 
	System.out.println("create time-createTimeXYChar."); 
	} 
	catch (Exception e) 
	{ 
	e.printStackTrace(); 
	} 
	}
    }
  
}
