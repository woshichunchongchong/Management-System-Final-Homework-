package part1;

import java.util.Scanner;

/**
 * 主界面
 **/
public class MainInterface {

	public String flag;// 判断功能

	/* 显示界面 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 马拉松赛信息管理系统  ");
		System.out.println("=======================");
		System.out.println("|1.登录               |");
		System.out.println("|                     |");
		System.out.println("|2.注册               |");
		System.out.println("|                     |");
		System.out.println("|3.退出系统           |");
		System.out.println("|                     |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		switch (flag) {

		/* 跳转至登录界面 */
		case "1":
			Test.toLoginInterface();
			break;

		/* 跳转至注册界面 */
		case "2":
			Test.toRegistrationInterface();
			break;
			
		/* 退出程序 */
		case "3":
			System.exit(0);
			break;

		/* 输入错误 */
		default:
			System.out.println("输入错误！");
			Test.toMainInterface();
		}
	}
}
