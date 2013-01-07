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
            int sumztime=0;
            int sumdqtime=0;
            job[] j = { new job(1,2),new job(1,2),new job(1,2)};
            
            j[0].ftime = j[0].ctime + j[0].stime;
            sumztime = j[0].ftime;

            for (int i = 1; i < 3; i++)
            {                
                j[i].ftime = j[i-1].ftime + j[i].stime;
                j[i].f();
                sumztime += j[i].ftime;
                sumdqtime += j[i].dqtime;
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
