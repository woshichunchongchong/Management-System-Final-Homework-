package part1;

import java.util.Scanner;

/**
 * 账户管理系统界面
 **/
public class AccountManagementSystem {

	private String flag;// 判断功能

	/* 显示界面 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("          账户管理系统  ");
		System.out.println("=======================");
		System.out.println("|1.审批注册用户       |");
		System.out.println("|                     |");
		System.out.println("|2.查询用户信息       |");
		System.out.println("|                     |");
		System.out.println("|3.禁用用户账户       |");
		System.out.println("|                     |");
		System.out.println("|4.重置用户密码       |");
		System.out.println("|                     |");
		System.out.println("|5.返回上一级         |");
		System.out.println("|                     |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		Scanner sc = new Scanner(System.in);
		List l = new List();
		switch (flag) {

		/* 审批注册用户,有待审批用户时打印名单，否则提示没有待审批用户 */
		case "1":
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
			Test.toAccountManagementSystem();
			break;

		/* 查询用户，若输入用户名存在，查询用户的密码、状态并返回账户管理系统界面，否则提示用户名不存在并返回账户管理系统界面 */
		case "2":
			System.out.print("请输入您要查询的用户名：");
			String str = sc.next();
			if (isExist(str)) {
				System.out.println("查询成功！");
				System.out.println("您查询的用户名为：" + str);
				System.out.println("您查询用户名的密码为：" + password(str));
				if (status(str).equals("Available")) {
					System.out.println("您查询用户名的状态为：可登录！");
				} else if (status(str).equals("Reviewing")) {
					System.out.println("您查询用户名的状态为：待审批！");
				} else {
					System.out.println("您查询用户名的状态为：被禁用！");
				}
			} else {
				System.out.println("您输入的用户名不存在！");
			}
			Test.toAccountManagementSystem();
			break;

		/* 禁用用户，若输入用户名存在，将用户的状态改为被禁用并返回账户管理系统界面，否则提示用户名不存在并返回账户管理系统界面 */
		case "3":
			System.out.print("请输入您要禁用的用户名：");
			String str1 = sc.next();
			if (isExist(str1)) {
				if (status(str1).equals("Available")) {
					banUsers(str1);
					System.out.println("禁用成功！");
				} else if (status(str1).equals("Reviewing")) {
					System.out.println("该账户待审批，无法禁用！");
				} else {
					System.out.println("该账户已被禁用，无需再次禁用！");
				}
			} else {
				System.out.println("您输入的用户名不存在！");
			}
			Test.toAccountManagementSystem();
			break;

		/* 重置用户密码，若输入用户名存在，重置用户的密码为“123456”并返回账户管理系统界面，否则提示用户名不存在并返回账户管理系统界面 */
		case "4":
			System.out.print("请输入您要重置的用户名：");
			String str11 = sc.next();
			if (isExist(str11)) {
				if (status(str11).equals("Available")) {
					resetPassword(str11);
					System.out.println("重置成功！密码已经恢复为123456");
				} else if (status(str11).equals("Reviewing")) {
					System.out.println("该账户待审批，无法重置！");
				} else {
					System.out.println("该账户已被禁用，无法重置！");
				}
			} else {
				System.out.println("您输入的用户名不存在！");
			}
			Test.toAccountManagementSystem();
			break;

		/* 跳转至管理员界面 */
		case "5":
			Test.toAdministratorsInterface();
			break;

		/* 非法输入，并返回账户管理系统界面 */
		default:
			System.out.println("非法输入！");
			Test.toAccountManagementSystem();
		}
	}

	/* 有待审批的注册用户时返回true */
	public boolean hasRegisteredUsers() {
		List l = new List();
		boolean flag = false;
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getStatus().equals("Reviewing")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 打印待审批的注册用户名单 */
	public void printRegisteredUsers() {
		List l = new List();
		System.out.println("待审批的用户：");
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getStatus().equals("Reviewing")) {
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
			if (information.getStatus().equals("Reviewing") && information.getAccountNumber().equals(str)) {
				l.getList().get(i).setStatus("Available");
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 用户名存在时，返回true */
	public boolean isExist(String str) {
		List l = new List();
		boolean flag = false;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 返回用户名对应的密码 */
	public String password(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				return information.getPassword();
			}
		}
		return str;
	}

	/* 返回用户名对应的账号状态 */
	public String status(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				return information.getStatus();
			}
		}
		return str;
	}

	/* 禁用用户名 */
	public void banUsers(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				l.getList().get(i).setStatus("Disabled");
				break;
			}
		}
	}

	/* 将对应用户名的密码重置为“123456” */
	public void resetPassword(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				l.getList().get(i).setPassword("123456");
				break;
			}
		}
	}
}