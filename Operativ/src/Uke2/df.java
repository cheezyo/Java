package Uke2;

import java.lang.Thread;

class CalcThread extends Thread
{
   static int count = 0;
   int id;

   CalcThread()
        {
         count++;
         id = count;
        }

   public void run()
        {
         System.out.println("Thread nr." + id + " is starting");
         System.out.println("Thread nr." + id + " calculated " + work());
        }

   private float work()
        {
         int i,j;
           float res = 0;
            System.out.println("Thread nr." + id + " calculating");
            for(j = 1;j < 100;j++)
                {
                    for(i = 1;i < 30000000;i++)
                        {
                            res += 1.0/(1.0*i*i);
                        }
                     System.out.println("Thread nr." + id + " calculating" + j);
                }
         return(res);
        }
}

class Calc
{
   public static void main(String args[])
   {
    System.out.println("Starts two threads !\n");
    CalcThread s = new CalcThread();
    System.out.println("Thread s has id " + s.id + "\n");
    s.start(); // Allokerer minne og kaller s.run()

    CalcThread s2 = new CalcThread();
    System.out.println("Thread s2 has id " + s2.id + "\n");
    s2.start();
    System.out.println("s2 started !\n");

    }
}
