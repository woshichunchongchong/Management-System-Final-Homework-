package part1;

import java.util.*;

/**
 * 登录界面
 **/
public class LoginInterface {

	private String accountNumber; // 要登录的用户名
	private String password; // 要登录的密码
	private String flag; // 判断功能

	/* 界面显示 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("                      用户登录  ");
		System.out.println("===================================");
		System.out.print("请输入您的账号：");
		this.accountNumber = sc.next();
		System.out.print("请输入您的密码：");
		this.password = sc.next();
		System.out.print(" 输入1确认登录，输入2返回上一层：");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		List l = new List();
		switch (flag) {

		/* 确认登录，用户名、密码、账号状态均匹配时，跳转至相应界面，否则提示错误并返回登录界面 */
		case "1":
			if (isAdministrator()) {
				System.out.println("登录成功！您是管理员");
				Test.toAdministratorsInterface();
			} else if (isAthlete()) {
				System.out.println("登录成功！您是运动员");
				Test.toAthletesInterface();
			} else if (isAbnormalState()) {
				System.out.println("登录失败！账户状态非可用！");
				Test.toLoginInterface();
			} else if (isNotExist()) {
				System.out.println("登录失败！用户名不存在！");
				Test.toLoginInterface();
			} else {
				System.out.println("登录失败！密码错误！");
				Test.toLoginInterface();
			}
			break;

		/* 跳转至主界面 */
		case "2":
			Test.toMainInterface();
			break;

		/* 非法输入 */
		default:
			System.out.println("非法输入！");
			Test.toLoginInterface();
		}
	}

	/* 当输入用户名密码符合管理员用户名、密码时返回true */
	public boolean isAdministrator() {
		boolean flag = false;
		if (this.accountNumber.equals("ad123") && this.password.equals("123456")) {
			flag = true;
		}
		return flag;
	}

	/* 当输入用户名密码符合运动员用户名、密码，且账号状态正常时返回true */
	public boolean isAthlete() {
		List l = new List();
		boolean flag = false;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(this.accountNumber)
					&& information.getPassword().equals(this.password) && information.getStatus().equals("Available")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 当输入用户名密码符合运动员用户名、密码，且账号状态异常时返回true */
	public boolean isAbnormalState() {
		List l = new List();
		boolean flag = false;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(this.accountNumber)
					&& information.getPassword().equals(this.password)
					&& !information.getStatus().equals("Available")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 当输入用户名不符合运动员用户名时返回true */
	public boolean isNotExist() {
		List l = new List();
		boolean flag = true;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(this.accountNumber)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}