package com.joezhou.thread.start;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest{
	public static void main(String[] args) throws IOException {
		Timer timer = new Timer();// 定时对象
		MyTask myTask = new MyTask();// 定时任务
		timer.schedule(myTask, 0, 1000);// 0毫秒后，每隔1000毫秒执行一次myTask
		if (System.in.read() == 'q') {
			// timer.cancel(); // 关闭schedule
			myTask.setFlag(false);// 闹钟设置为不响
		}
	}
}

class MyTask extends TimerTask {
	private boolean flag = false;// 闹钟标志位 - 不响
	@Override
	public void run() {
		String dateStr = new SimpleDateFormat("hhmmss").format(new Date());// 获取系统时间格式化成时分秒
		// System.out.println(dateStr);
		if ("060000".equals(dateStr)) {// 每日早晨6点
			flag = true;// 闹钟标志位 - 响
		}
		if (flag) {
			System.out.println("起床了.....");
		}
	}
	public boolean isFlag() {return flag;}
	public void setFlag(boolean flag) {this.flag = flag;}
}