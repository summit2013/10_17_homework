using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing.Drawing2D;
namespace 优先级调度时序图
{
    public partial class Graphs_Form : Form
    {
        Graphics MyGraphics;
        Brush MyBrush;
        Pen MyPen;
        public Graphs_Form()
        {
            MyGraphics = this.CreateGraphics();
            MyBrush = new SolidBrush(Color.Blue);
            MyPen = new Pen(MyBrush);
            InitializeComponent();
        }
        protected void ShowGraph(string No_0, string No_1, string No_2)
        {
             //实例化 Bitmap
            Bitmap image = new Bitmap(500, 350);//图片尺寸
            //从 Bitmap 实例创建Graphics实例
            Graphics graphics = Graphics.FromImage(image);
            //坐标原点转换到图片左下角(GDI+默认原点在左上角)
            graphics.TranslateTransform(0, 298);
            //以白色填充图片
            graphics.Clear(Color.AliceBlue);
            //画坐标轴  此图特殊  坐标起点是（100，-0）0-5实际上对应的是100-130  所以要用比例来换算
            Pen pen = new Pen(Color.Black);
            graphics.DrawLine(pen, new Point(100, 0), new Point(400, 0));
            graphics.DrawLine(pen, new Point(100, 0), new Point(100, -300));
            //-CPU
            graphics.DrawString(No_2, new Font("宋体", 15),  new SolidBrush(Color.Red), 40, -70);
            //-CPU
            graphics.DrawString(No_1, new Font("宋体", 15), new SolidBrush(Color.BlueViolet), 40, -160);
            //-CPU
            graphics.DrawString(No_0, new Font("宋体", 15), new SolidBrush(Color.CornflowerBlue),40, -250);
            //画箭头
            graphics.DrawLine(pen,402,0,398,-5);
            //刻度        
            for (int i = 0; i <300; i = i + 30)
            {
                //x轴
                graphics.DrawLine(pen, new Point(i+100 , 0), new Point(i+100 , -5));
                graphics.DrawString((i/6).ToString(), new System.Drawing.Font("宋体", 10), new SolidBrush(Color.Black), new Point(i+100, 0));
                //虚线y轴
                graphics.DrawLine(new Pen(new HatchBrush(HatchStyle.DiagonalCross,Color.DarkOrange, Color.Orange)), new Point(i+100 , 0), new Point(i+100, -300));
            }
            graphics.DrawString("50", new System.Drawing.Font("宋体", 10), new SolidBrush(Color.Black), new Point(400, 0));
            //画图
            //最开始执行的一个进程的
            graphics.DrawLine(new Pen(new SolidBrush(Color.CornflowerBlue)), new Point(Main_Form.Infomations.JobLine[0].Begin_Time * 6+100, -250), new Point(Main_Form.Infomations.JobLine[0].Fintime * 6+100, -250));
            graphics.DrawLine(new Pen(new SolidBrush(Color.BlueViolet)), new Point(Main_Form.Infomations.JobLine[1].Begin_Time * 6+100, -160), new Point(Main_Form.Infomations.JobLine[1].Fintime * 6+100, -160));
            graphics.DrawLine(new Pen(new SolidBrush(Color.Red)), new Point(Main_Form.Infomations.JobLine[2].Begin_Time * 6+100, -70), new Point(Main_Form.Infomations.JobLine[2].Fintime * 6+100, -70));
            pictureBox1.Image = image;
        }

        private void Graphs_Form_Load(object sender, EventArgs e)
        {
            string No_0 = Main_Form.Infomations.JobLine[0].Name;
            string No_1 = Main_Form.Infomations.JobLine[1].Name;
            string No_2 = Main_Form.Infomations.JobLine[2].Name;
            ShowGraph(No_0,No_1,No_2);
        }
        }
    }
