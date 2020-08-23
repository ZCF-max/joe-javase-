package com.joezhou.communication;

/**@author JoeZhou*/
public class ReadWriteTest {
	public static void main(String[] args) {

        // 共享资源，写在这里是为了让两个线程共享同一个res
		Res res = new Res();
        
        // 在创建Input线程类的时候将共享资源传入
		WriteRes write = new WriteRes(res);
  
        // 在创建Output线程类的时候将共享资源传入
		ReadRes read = new ReadRes(res);
		new Thread(write).start();
		new Thread(read).start();
	}
}

/**@author Joe*/
class WriteRes implements Runnable {
    
    /** 共享资源 */
	private Res res;
 
    /** 中英文切换写入标志，false时写中文，true时写英文 */
	private boolean flag = false;

    /** 通过构造方法获取共享资源res，并传递给当前类属性res */
	public WriteRes(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
        // 无限写
		while (true) {
			if (flag) {
				res.setName("zhaosi");
				res.setGender("male");
				flag = false;
			} else {
				res.setName("赵四");
				res.setGender("男");
				flag = true;
			}
		}
	}
}

/**@author Joe*/
class ReadRes implements Runnable {
    
    /** 共享资源 */
	private Res res;

    /** 通过构造方法获取共享资源res，并传递给当前类属性res */
	public ReadRes(Res res) {
		this.res = res;
	}

	@Override
	public void run() {
        // 无限读
		while (true) {
			System.out.print(res.getName());
			System.out.print(" ---- ");
			System.out.println(res.getGender());
		}
	}
}

/**@author Joe*/
class Res {
	private String name;
	private String gender;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
}