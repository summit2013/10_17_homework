using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        public void fcfs()
        {
            int sumztime;
            int sumdqtime;
            job[] j = { new job(1,2),new job(1,2),new job(1,2)};
            for (int i = 0; i < 3; i++)
            {
                
            }
            
        }
    }

    public class job
    {
        public int ctime;
        public int stime;
        public int ftime;
        public int ztime;
        public int dqtime;
        public job(int a,int b) 
        {
            ctime = a;
            stime = b;
        }
        public void  f()
        {
            ztime=ftime-ctime;
            dqtime=ztime/stime;
        }
    }
}
