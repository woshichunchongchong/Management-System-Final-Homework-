package part1;

import java.util.Scanner;

/**
 * 运动员界面
 **/
public class AthletesInterface {

	private String flag; // 判断功能

	/* 界面显示 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("           您是运动员  ");
		System.out.println("=======================");
		System.out.println("|1.报名参赛           |");
		System.out.println("|                     |");
		System.out.println("|2.查询成绩           |");
		System.out.println("|                     |");
		System.out.println("|3.查看排行榜         |");
		System.out.println("|                     |");
		System.out.println("|4.查看管理员通知     |");
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
		RegistrationManagementSystem r = new RegistrationManagementSystem();
		switch (flag) {

		/* 报名，若输入用户名存在且在报名时间，则将用户名报名状态改为审核中并返回运动员界面，否则提示用户名不存在并返回运动员界面 */
		case "1":
			if (!r.getRS()) {
				System.out.print("不在报名时间！");
			} else {
				System.out.print("请输入您的用户名：");
				String str = sc.next();
				if (isExist(str)) {
					if (registrationStatus(str).equals("Not registered")) {
						System.out.println("报名成功！请等待管理员审核！");
						pendUsers(str);
					} else if (registrationStatus(str).equals("Pending")) {
						System.out.println("您的报名正在审核中 ！");
					} else if (registrationStatus(str).equals("Approved")) {
						System.out.println("您的用户名已经通过审核 ！");
					} else {
						System.out.println("您的成绩已经上传！");
					}
				} else {
					System.out.println("您输入的用户名不存在！");
				}
			}
			Test.toAthletesInterface();
			break;

		/* 查询用户成绩，若输入用户名存在，查询用户的成绩、排名并返回运动员界面，否则提示用户名不存在并返回运动员界面 */
		case "2":
			System.out.print("请输入您要查询成绩的用户名：");
			String str1 = sc.next();
			if (isExist(str1)) {
				if (registrationStatus(str1).equals("Approved")) {
					System.out.println("您要查询成绩的用户还未录入成绩！");
				} else if (registrationStatus(str1).equals("Score entered")) {
					System.out.println("查询成功！");
					System.out.println("您要查询成绩的用户比赛时长为：" + achievement(str1));
					System.out.println("您要查询成绩的用户比赛排名为：" + rank(str1));
				} else if (registrationStatus(str1).equals("Pending")) {
					System.out.println("您要查询成绩的用户未被批准参加比赛！");
				} else {
					System.out.println("您要查询成绩的用户未报名参加比赛！");
				}
			} else {
				System.out.println("您输入的用户名不存在！");
			}
			Test.toAthletesInterface();
			break;

		/* 打印排行榜，没有用户录入成绩时提示并返回成绩管理系统界面 */
		case "3":
			if (hasAchievement()) {
				printScoreEnteredUsers();
			} else {
				System.out.println("没有运动员录入成绩！");
			}
			Test.toAchievementManagementSystem();
			break;

		/* 若管理员发布消息则逐条打印，若没有打印没有发布提示 */
		case "4":
			showNotice();
			Test.toAthletesInterface();

			/* 跳转至主界面 */
		case "5":
			Test.toMainInterface();

			/* 非法输入 */
		default:
			System.out.println("非法输入！");
			Test.toAthletesInterface();
		}
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

	/* 返回用户名对应的报名状态 */
	public String registrationStatus(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				return information.getRegistrationStatus();
			}
		}
		return str;
	}

	/* 输入的用户名是待审批用户时返回true并审批通过，否则返回false */
	public void pendUsers(String str) {
		List l = new List();
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				l.getList().get(i).setRegistrationStatus("Pending");
				break;
			}
		}
	}

	/* 返回用户名对应的成绩 */
	public int achievement(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				return information.getAchievement();
			}
		}
		return 0;
	}

	/* 返回用户名对应的排名 */
	public int rank(String str) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				return information.getRank();
			}
		}
		return 0;
	}

	/* 若管理员发布消息则逐条打印，若没有打印没有发布提示 */
	public void showNotice() {
		List l = new List();
		if (l.getNotice().size() == 0) {
			System.out.println("管理员没有发布消息！");
		} else {
			for (int i = 0; i < l.getNotice().size(); ++i) {
				System.out.println(i + 1 + "." + l.getNotice().get(i).toString());
			}
		}
	}

	/* 有录入成绩的用户时返回true */
	public boolean hasAchievement() {
		List l = new List();
		boolean flag = false;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Score entered")) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/* 打印录入成绩的用户名单 */
	public void printScoreEnteredUsers() {
		List l = new List();
		int num = 0;
		System.out.println("用户名         成绩            排名");
		for (int i = 0; i < l.getList().size(); ++i) {
			if (num == 10) {
				break;
			}
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Score entered")) {
				System.out.println(l.getList().get(i).getAccountNumber() + "            "
						+ l.getList().get(i).getAchievement() + "            " + l.getList().get(i).getRank());
				num++;
			}
		}
	}

}