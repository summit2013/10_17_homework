using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;
namespace 优先级调度时序图
{
    public partial class Main_Form : Form
    {
        public Main_Form()
        { 
            InitializeComponent();
        }
        /// <summary>
        /// 各种中转数据初始化
        /// </summary>
        Gzuo[] jobline;
       // protected int[] Run_Orders = new int[3];// FCFS运行顺序
        protected int[] Finish_Time = new int[3];//进程完成时间
        protected int[] Run_Time = new int[3]; //进程周转时间
        protected float[] Weight_Run_Time = new float[3];//进程带权周转时间
        protected int[] Begin_Time = new int[3];
        /// <summary>
        /// 用来保存各线程的初始时间和优先级
        /// </summary>
        public struct Gzuo
        {
            public int Id;
            public int Arrtime;  //到达时间
            public int Sevtime;  //执行时间
            public int Fintime;  //完成时间
            public int Runtime;  //周转时间
            public float Wtime;  //带权周转时间
            public int Begin_Time;//开始运行时间
            public string Name;

        }
        /// <summary>
        /// 用于输入的函数
        /// </summary>
    
        void Input_FCFS()
        {
            //优先级
            jobline[0].Id = 0;
            jobline[1].Id = 1;
            jobline[2].Id = 2;
            jobline[0].Name = "进程A";
            jobline[1].Name = "进程B";
            jobline[2].Name = "进程C";
            //到达时间
            jobline[0].Arrtime = int.Parse(this.Txb_ID_1.Text);
            jobline[1].Arrtime = int.Parse(this.Txb_ID_2.Text);
            jobline[2].Arrtime = int.Parse(this.Txb_ID_3.Text);
            //运行时间
            jobline[0].Sevtime = int.Parse(this.Txb_SID_1.Text);
            jobline[1].Sevtime = int.Parse(this.Txb_SID_2.Text);
            jobline[2].Sevtime = int.Parse(this.Txb_SID_3.Text);


        }
        /// <summary>
        /// FCFS（先来先服务算法）
        /// </summary>
        void FCFS()
    {
    int b, j;
    int temp;
    int TempArr, TempSev;
    string TempName;
    for (b = 0; b < 3; b++)
    {
        for (j = 0; j < b; j++)
            if (jobline[b].Arrtime < jobline[j].Arrtime)
            {
                temp = jobline[j].Id;
                jobline[j].Id = jobline[b].Id;
                jobline[b].Id = temp;
                TempArr = jobline[j].Arrtime;
                jobline[j].Arrtime = jobline[b].Arrtime;
                jobline[b].Arrtime = TempArr;
                TempSev = jobline[j].Sevtime;
                jobline[j].Sevtime = jobline[b].Sevtime;
                jobline[b].Sevtime = TempSev;
                TempName = jobline[j].Name;
                jobline[j].Name = jobline[b].Name;
                jobline[b].Name = TempName;
            }
    }
    //计算进程完成时间
    jobline[0].Fintime = jobline[0].Sevtime +jobline[0].Arrtime;
    for (b = 1; b < 3; b++)
    {
        if (jobline[b].Arrtime <= jobline[b - 1].Fintime)
        { jobline[b].Fintime = jobline[b - 1].Fintime + jobline[b].Sevtime; }
        else
        { jobline[b].Fintime = jobline[b].Arrtime + jobline[b].Sevtime; }
    }
  
    for (b = 0; b < 3; b++)
    {
        Finish_Time[b] = jobline[b].Fintime;
    }

   //计算进程周转时间
    jobline[0].Runtime = jobline[0].Sevtime ;
    for (b = 1; b < 3; b++)
    {
        jobline[b].Runtime = jobline[b].Fintime - jobline[b].Arrtime;
    }
  
    for (b = 0; b < 3; b++)
    {
        Run_Time[b] = jobline[b].Runtime;
    }
      //进程开始执行的时间
            jobline[0].Begin_Time=jobline[0].Arrtime;
            for (b = 1; b < 3; b++)
            {
                jobline[b].Begin_Time = jobline[b - 1].Fintime;

            }
      //进程带权周转时间   
            for (b = 0; b < 3; b++)
            {
                jobline[b].Wtime = (float)jobline[b].Runtime / (float)jobline[b].Sevtime;
                Weight_Run_Time[b] = jobline[b].Wtime;
                Begin_Time[b] = jobline[b].Begin_Time;
            }
}

     
        void Output_FCFS()
        {
            //进程真正开始执行的时间
            Txb_Begin_0.Text = Begin_Time[0].ToString();
            Txb_Begin_1.Text = Begin_Time[1].ToString();
            Txb_Begin_2.Text = Begin_Time[2].ToString();
            //完成时间
            Txb_FinishTime_1.Text = Finish_Time[0].ToString();
            Txb_FinishTime_2.Text = Finish_Time[1].ToString();
            Txb_FinishTime_3.Text = Finish_Time[2].ToString();
        
            //周转时间
            Txb_Round_Time1.Text = Run_Time[0].ToString();
            Txb_Round_Time2.Text = Run_Time[1].ToString();
            Txb_Round_Time3.Text = Run_Time[2].ToString();
           
            //带权周转时间
            Txb_WeightTime_1.Text = Weight_Run_Time[0].ToString();
            Txb_WeightTime_2.Text = Weight_Run_Time[1].ToString();
            Txb_WeightTime_3.Text = Weight_Run_Time[2].ToString();
            //FCFS运行顺序
            Label_No_0.Text = jobline[0].Name.Trim();
            Label_No_1.Text = jobline[1].Name.Trim();
            Label_No_2.Text = jobline[2].Name.Trim();
            Txb_Order_0.Text = jobline[0].Name.Trim();
            Txb_Order_1.Text = jobline[1].Name.Trim();
            Txb_Order_2.Text = jobline[2].Name.Trim();
            //平均周转时间
            Txb_Average_2.Text = ((Run_Time[0] + Run_Time[1] + Run_Time[2]) / 3).ToString().Trim();     
        }

     

        private void Form1_Load(object sender, EventArgs e)
        {
            this.groupBox2.Visible = false;
        }

        private void Btn_Show_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked == true)
            {
                jobline = new Gzuo[3];
                
                Input_FCFS();
                FCFS();
                Output_FCFS();
                this.groupBox2.Visible = true;
                this.button1.Enabled = true;
                
                //时序图数据的保存
                for (int i = 0; i < 3; i++)
                {
                    Infomations.JobLine[i] = jobline[i];
                }
            }
            else if (radioButton2.Checked == true)
            {
                try
                {
                    System.Diagnostics.Process.Start(@"Scheduling.exe"); 
                 }
                  catch (Exception ex)
                {
                    MessageBox.Show(ex.ToString());
                }
               
            }
            else MessageBox.Show("您还没选择你想用的算法呢！","很抱歉！",MessageBoxButtons.OK,MessageBoxIcon.Information);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Graphs_Form Forms = new Graphs_Form();
            Forms.Show();
        }
      public static  class Infomations 
        {
            public static Gzuo[] JobLine=new Gzuo[3];
        
        
        }

      private void radioButton1_CheckedChanged(object sender, EventArgs e)
      {
          this.panel1.Enabled = true;
      }

      private void radioButton2_CheckedChanged(object sender, EventArgs e)
      {
          this.panel1.Enabled = false;
          this.groupBox2.Visible = false;
      }

      private void Main_Form_Activated(object sender, EventArgs e)
      {
          this.button1.Enabled = false;
      }
    }
}

