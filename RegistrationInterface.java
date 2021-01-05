package part1;

import java.util.Scanner;

/**
 * 注册界面
 **/
public class RegistrationInterface {

	private String accountNumber; // 要注册的用户名
	private String password; // 要注册的密码
	private String flag; // 判断功能

	/* 界面显示 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("                      用户注册  ");
		System.out.println("===================================");
		System.out.print("请输入您要注册的账号：");
		this.accountNumber = sc.next();
		System.out.print("请输入您要注册的密码：");
		this.password = sc.next();
		System.out.print(" 输入1确认注册，输入2返回主界面：");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		List l = new List();
		switch (flag) {

		/* 确认注册 */
		case "1":

			/* 判断用户名是否被注册，否则写入待审核列表并返回主界面， 是则提示失败并返回注册界面 */
			if (!isUsed()) {
				Information information = new Information(this.accountNumber, this.password, "Reviewing",
						"Not registered", 0, 0);
				l.getList().add(information);
				System.out.println("注册成功！请等待管理员审核");
				Test.toMainInterface();
			} else {
				System.out.println("注册失败！该账号已被注册");
				Test.toRegistrationInterface();
			}
			break;

		/* 返回主界面 */
		case "2":
			Test.toMainInterface();
			break;

		/* 输入错误 */
		default:
			Test.toRegistrationInterface();
		}
	}

	/* 当用户名已被注册时，返回true */
	public boolean isUsed() {
		List l = new List();
		boolean flag = false;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(this.accountNumber)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}