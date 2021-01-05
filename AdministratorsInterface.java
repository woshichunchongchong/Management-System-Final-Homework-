package part1;

import java.util.Scanner;

/**
 * 管理员界面
 **/
public class AdministratorsInterface {

	private String flag; // 判断功能

	/* 显示界面 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("           您是管理员  ");
		System.out.println("=======================");
		System.out.println("|1.用户账户管理       |");
		System.out.println("|                     |");
		System.out.println("|2.用户报名管理       |");
		System.out.println("|                     |");
		System.out.println("|3.用户成绩管理       |");
		System.out.println("|                     |");
		System.out.println("|4.发布通知           |");
		System.out.println("|                     |");
		System.out.println("|5.返回主界面         |");
		System.out.println("|                     |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		Scanner sc = new Scanner(System.in);
		List l = new List();

		switch (flag) {

		/* 跳转至账户管理系统 */
		case "1":
			Test.toAccountManagementSystem();
			break;

		/* 跳转至报名管理系统 */
		case "2":
			Test.toRegistrationManagementSystem();
			break;

		/* 跳转至成绩管理系统 */
		case "3":
			Test.toAchievementManagementSystem();
			break;

		/* 发布通知 */
		case "4":
			l.getNotice().add(sc.next());
			System.out.println("发布成功！");
			Test.toAdministratorsInterface();
			break;

		/* 跳转至主界面 */
		case "5":
			Test.toMainInterface();
			break;

		/* 提示非法输入，并返回管理员界面 */
		default:
			System.out.println("非法输入！");
			Test.toAdministratorsInterface();
		}
	}
}