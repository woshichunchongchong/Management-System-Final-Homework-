package part1;

import java.util.Scanner;

/**
 * ����Ա����
 **/
public class AdministratorsInterface {

	private String flag; // �жϹ���

	/* ��ʾ���� */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("           ���ǹ���Ա  ");
		System.out.println("=======================");
		System.out.println("|1.�û��˻�����       |");
		System.out.println("|                     |");
		System.out.println("|2.�û���������       |");
		System.out.println("|                     |");
		System.out.println("|3.�û��ɼ�����       |");
		System.out.println("|                     |");
		System.out.println("|4.����֪ͨ           |");
		System.out.println("|                     |");
		System.out.println("|5.����������         |");
		System.out.println("|                     |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		Scanner sc = new Scanner(System.in);
		List l = new List();

		switch (flag) {

		/* ��ת���˻�����ϵͳ */
		case "1":
			Test.toAccountManagementSystem();
			break;

		/* ��ת����������ϵͳ */
		case "2":
			Test.toRegistrationManagementSystem();
			break;

		/* ��ת���ɼ�����ϵͳ */
		case "3":
			Test.toAchievementManagementSystem();
			break;

		/* ����֪ͨ */
		case "4":
			l.getNotice().add(sc.next());
			System.out.println("�����ɹ���");
			Test.toAdministratorsInterface();
			break;

		/* ��ת�������� */
		case "5":
			Test.toMainInterface();
			break;

		/* ��ʾ�Ƿ����룬�����ع���Ա���� */
		default:
			System.out.println("�Ƿ����룡");
			Test.toAdministratorsInterface();
		}
	}
}