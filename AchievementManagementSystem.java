package part1;

import java.util.Collections;
import java.util.Scanner;

/**
 * �ɼ�����ϵͳ����
 **/
public class AchievementManagementSystem {

	private String flag; // �жϹ���

	/* ������ʾ */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("          �ɼ�����ϵͳ  ");
		System.out.println("=======================");
		System.out.println("|1.¼������ɼ�      |");
		System.out.println("|                    |");
		System.out.println("|2.��ѯ�����ɼ�������|");
		System.out.println("|                    |");
		System.out.println("|3.�鿴���а�        |");
		System.out.println("|                    |");
		System.out.println("|4.������һ��        |");
		System.out.println("|                    |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		Scanner sc = new Scanner(System.in);
		List l = new List();
		switch (flag) {

		/* ¼���û��ɼ����������û������ڣ����ɼ�¼�벢���سɼ�����ϵͳ���棬������ʾ�û��������ڲ����سɼ�����ϵͳ���� */
		case "1":
			System.out.print("��������Ҫ¼��ɼ����û�����");
			String str = sc.next();
			if (isExist(str)) {
				if (registrationStatus(str).equals("Approved")) {
					int time = sc.nextInt();
					setAchievementAndResetRegistrationStatus(str, time);
					System.out.println("¼��ɹ���");
					Collections.sort(l.getList());
					setRank(str);
				} else if (registrationStatus(str).equals("Score entered")) {
					System.out.println("��Ҫ¼��ɼ����û�����¼����ɼ���");
				} else if (registrationStatus(str).equals("Pending")) {
					System.out.println("��Ҫ¼��ɼ����û���δ����׼�μӱ�����");
				} else {
					System.out.println("��Ҫ¼��ɼ����û���δ�����μӱ�����");
				}
			} else {
				System.out.println("��������û��������ڣ�");
			}
			Test.toAchievementManagementSystem();
			break;

		/* ��ѯ�û��ɼ����������û������ڣ���ѯ�û��ĳɼ������������سɼ�����ϵͳ���棬������ʾ�û��������ڲ����سɼ�����ϵͳ���� */
		case "2":
			System.out.print("��������Ҫ��ѯ�ɼ����û�����");
			String str1 = sc.next();
			if (isExist(str1)) {
				if (registrationStatus(str1).equals("Approved")) {
					System.out.println("��Ҫ��ѯ�ɼ����û���δ¼��ɼ���");
				} else if (registrationStatus(str1).equals("Score entered")) {
					System.out.println("��ѯ�ɹ���");
					System.out.println("��Ҫ��ѯ�ɼ����û�����ʱ��Ϊ��" + achievement(str1));
					System.out.println("��Ҫ��ѯ�ɼ����û���������Ϊ��" + rank(str1));
				} else if (registrationStatus(str1).equals("Pending")) {
					System.out.println("��Ҫ��ѯ�ɼ����û�δ����׼�μӱ�����");
				} else {
					System.out.println("��Ҫ��ѯ�ɼ����û�δ�����μӱ�����");
				}
			} else {
				System.out.println("��������û��������ڣ�");
			}
			Test.toAchievementManagementSystem();
			break;

		/* ��ӡ���а�û���û�¼��ɼ�ʱ��ʾ�����سɼ�����ϵͳ���� */
		case "3":
			if (hasAchievement()) {
				printScoreEnteredUsers();
			} else {
				System.out.println("û���˶�Ա¼��ɼ���");
			}
			Test.toAchievementManagementSystem();
			break;

		/* ��ת������Ա���� */
		case "4":
			Test.toAdministratorsInterface();

			/* �Ƿ����� */
		default:
			System.out.println("�Ƿ����룡");
			Test.toAchievementManagementSystem();
		}
	}

	/* �û�������ʱ������true */
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

	/* �����û�����Ӧ�ı���״̬ */
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

	/* ���ɼ�¼���Ӧ�û�����������״̬��Ϊ��¼��ɼ� */
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

	/* �����û�����Ӧ�ĳɼ� */
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

	/* д���û�����Ӧ������ */
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

	/* �����û�����Ӧ������ */
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

	/* ��¼��ɼ����û�ʱ����true */
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

	/* ��ӡ¼��ɼ����û����� */
	public void printScoreEnteredUsers() {
		List l = new List();
		System.out.println("�û���         �ɼ�            ����");
		for (int i = 0; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Score entered")) {
				System.out.println(l.getList().get(i).getAccountNumber() + "            "
						+ l.getList().get(i).getAchievement() + "            " + l.getList().get(i).getRank());
			}
		}
	}

}