package com.joezhou.thread.sync;

/**
 * 发现因为线程之间互相争抢资源，所以会出现两个售票点重复卖票的情况。
 * @author JoeZhou*/
public class TicketSellTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.setName("江北售票点：");
        t2.setName("香坊售票点：");
        t1.start();
        t2.start();
    }
}

/**@author Joe*/
class Ticket implements Runnable {

    /** 票号 */
    private Integer ticketNo = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                sell();
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }
        }
    }

    private void sell() {
        int max = 100;
        if(ticketNo < max){
           System.out.println(Thread.currentThread().getName() + "卖了第" + (++ticketNo) + "张票"); 
        }
    }
}