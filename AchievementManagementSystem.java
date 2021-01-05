package part1;

import java.util.Collections;
import java.util.Scanner;

/**
 * 成绩管理系统界面
 **/
public class AchievementManagementSystem {

	private String flag; // 判断功能

	/* 界面显示 */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("          成绩管理系统  ");
		System.out.println("=======================");
		System.out.println("|1.录入比赛成绩      |");
		System.out.println("|                    |");
		System.out.println("|2.查询比赛成绩及排名|");
		System.out.println("|                    |");
		System.out.println("|3.查看排行榜        |");
		System.out.println("|                    |");
		System.out.println("|4.返回上一级        |");
		System.out.println("|                    |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* 具体功能实现 */
	public void jump() {
		Scanner sc = new Scanner(System.in);
		List l = new List();
		switch (flag) {

		/* 录入用户成绩，若输入用户名存在，将成绩录入并返回成绩管理系统界面，否则提示用户名不存在并返回成绩管理系统界面 */
		case "1":
			System.out.print("请输入您要录入成绩的用户名：");
			String str = sc.next();
			if (isExist(str)) {
				if (registrationStatus(str).equals("Approved")) {
					int time = sc.nextInt();
					setAchievementAndResetRegistrationStatus(str, time);
					System.out.println("录入成功！");
					Collections.sort(l.getList());
					setRank(str);
				} else if (registrationStatus(str).equals("Score entered")) {
					System.out.println("您要录入成绩的用户名已录入过成绩！");
				} else if (registrationStatus(str).equals("Pending")) {
					System.out.println("您要录入成绩的用户名未被批准参加比赛！");
				} else {
					System.out.println("您要录入成绩的用户名未报名参加比赛！");
				}
			} else {
				System.out.println("您输入的用户名不存在！");
			}
			Test.toAchievementManagementSystem();
			break;

		/* 查询用户成绩，若输入用户名存在，查询用户的成绩、排名并返回成绩管理系统界面，否则提示用户名不存在并返回成绩管理系统界面 */
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
			Test.toAchievementManagementSystem();
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

		/* 跳转至管理员界面 */
		case "4":
			Test.toAdministratorsInterface();

			/* 非法输入 */
		default:
			System.out.println("非法输入！");
			Test.toAchievementManagementSystem();
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

	/* 将成绩录入对应用户名并将报名状态改为已录入成绩 */
	public void setAchievementAndResetRegistrationStatus(String str, int time) {
		List l = new List();
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAccountNumber().equals(str)) {
				l.getList().get(i).setAchievement(time);
				l.getList().get(i).setRegistrationStatus("Score entered");
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

	/* 写入用户名对应的排名 */
	public void setRank(String str) {
		List l = new List();
		boolean flag = false;
		int rank = 0;
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getAchievement() != 0) {
				rank++;
			}
			if (flag) {
				information.setRank(rank);
			}
			if (information.getAccountNumber().equals(str)) {
				information.setRank(rank);
				flag = true;
			}
		}
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
		System.out.println("用户名         成绩            排名");
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Score entered")) {
				System.out.println(l.getList().get(i).getAccountNumber() + "            "
						+ l.getList().get(i).getAchievement() + "            " + l.getList().get(i).getRank());
			}
		}
	}

}