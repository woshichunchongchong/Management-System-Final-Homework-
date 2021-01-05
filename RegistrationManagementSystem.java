package part1;

import java.util.Scanner;

/**
 * 报名管理系统界面
 **/
public class RegistrationManagementSystem {

	private String flag; // 功能判断
	private static boolean RS = false; // 报名通道开启/关闭

	/* 界面显示 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("          报名管理系统  ");
		System.out.println("=======================");
		System.out.println("|1.开启/停止报名         |");
		System.out.println("|                        |");
		System.out.println("|2.审批参赛申请          |");
		System.out.println("|                        |");
		System.out.println("|3.查看并统计赛事报名情况|");
		System.out.println("|                        |");
		System.out.println("|4.返回上一级            |");
		System.out.println("|                        |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		List l = new List();
		Scanner sc = new Scanner(System.in);
		switch (flag) {

		/* 关闭或开启报名通道并返回报名管理系统界面 */
		case "1":
			if (RS == true) {
				RS = false;
				System.out.println("已关闭报名通道");
			} else {
				RS = true;
				System.out.println("已开启报名通道");
			}
			Test.toRegistrationManagementSystem();
			break;

		/* 审批报名用户,有待审批用户时打印名单，否则提示没有待审批用户 */
		case "2":
			if (!hasRegisteredUsers()) {
				System.out.println("没有需要审批的用户！");
			} else {
				printRegisteredUsers();
				System.out.print("请输入您要批准的用户名：");
				String str = sc.next();

				/* 输入用户名时待审批用户时，通过审批，否则提示不在待审批列表中 */
				if (isAndPassRegisteredUsers(str)) {
					System.out.println("审批成功！");
				} else {
					System.out.println("您输入的用户名不处于待审批列表中！");
				}
			}
			Test.toRegistrationManagementSystem();
			break;

		/* 查看并统计赛事报名情况,有报名成功用户时打印名单并统计人数，否则提示没有报名成功用户 */
		case "3":
			if (!hasAcceptedUsers()) {
				System.out.println("没有选手被批准参赛！");
			} else {
				printAcceptedUsers();
			}
			Test.toRegistrationManagementSystem();
			break;

		/* 跳转至管理员界面 */
		case "4":
			Test.toAdministratorsInterface();
			break;

		/* 非法输入 */
		default:
			System.out.println("非法输入！");
			Test.toRegistrationManagementSystem();
		}
	}

	public boolean getRS() {
		return RS;
	}

	/* 有待审批的报名用户时返回true */
	public boolean hasRegisteredUsers() {
		List l = new List();
		boolean flag = false;
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Pending")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 打印待审批的报名用户名单 */
	public void printRegisteredUsers() {
		List l = new List();
		System.out.println("待审批的用户：");
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Pending")) {
				System.out.println(l.getList().get(i).getAccountNumber());
			}
		}
	}

	/* 输入的用户名是待审批用户时返回true并审批通过，否则返回false */
	public boolean isAndPassRegisteredUsers(String str) {
		List l = new List();
		boolean flag = false;
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Pending") && information.getAccountNumber().equals(str)) {
				l.getList().get(i).setRegistrationStatus("Approved");
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 有报名成功的用户时返回true */
	public boolean hasAcceptedUsers() {
		List l = new List();
		boolean flag = false;
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Approved")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 打印待审批的用户名单 */
	public void printAcceptedUsers() {
		List l = new List();
		int cnt = 0;
		System.out.println("报名成功的用户：");
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Approved")) {
				System.out.println(l.getList().get(i).getAccountNumber());
				cnt++;
			}
		}
		System.out.println("已有" + cnt + "位选手被批准参赛");
	}
}