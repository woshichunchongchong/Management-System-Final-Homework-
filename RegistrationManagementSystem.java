package part1;

import java.util.Scanner;

/**
 * ��������ϵͳ����
 **/
public class RegistrationManagementSystem {

	private String flag; // �����ж�
	private static boolean RS = false; // ����ͨ������/�ر�

	/* ������ʾ */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("          ��������ϵͳ  ");
		System.out.println("=======================");
		System.out.println("|1.����/ֹͣ����         |");
		System.out.println("|                        |");
		System.out.println("|2.������������          |");
		System.out.println("|                        |");
		System.out.println("|3.�鿴��ͳ�����±������|");
		System.out.println("|                        |");
		System.out.println("|4.������һ��            |");
		System.out.println("|                        |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		List l = new List();
		Scanner sc = new Scanner(System.in);
		switch (flag) {

		/* �رջ�������ͨ�������ر�������ϵͳ���� */
		case "1":
			if (RS == true) {
				RS = false;
				System.out.println("�ѹرձ���ͨ��");
			} else {
				RS = true;
				System.out.println("�ѿ�������ͨ��");
			}
			Test.toRegistrationManagementSystem();
			break;

		/* ���������û�,�д������û�ʱ��ӡ������������ʾû�д������û� */
		case "2":
			if (!hasRegisteredUsers()) {
				System.out.println("û����Ҫ�������û���");
			} else {
				printRegisteredUsers();
				System.out.print("��������Ҫ��׼���û�����");
				String str = sc.next();

				/* �����û���ʱ�������û�ʱ��ͨ��������������ʾ���ڴ������б��� */
				if (isAndPassRegisteredUsers(str)) {
					System.out.println("�����ɹ���");
				} else {
					System.out.println("��������û��������ڴ������б��У�");
				}
			}
			Test.toRegistrationManagementSystem();
			break;

		/* �鿴��ͳ�����±������,�б����ɹ��û�ʱ��ӡ������ͳ��������������ʾû�б����ɹ��û� */
		case "3":
			if (!hasAcceptedUsers()) {
				System.out.println("û��ѡ�ֱ���׼������");
			} else {
				printAcceptedUsers();
			}
			Test.toRegistrationManagementSystem();
			break;

		/* ��ת������Ա���� */
		case "4":
			Test.toAdministratorsInterface();
			break;

		/* �Ƿ����� */
		default:
			System.out.println("�Ƿ����룡");
			Test.toRegistrationManagementSystem();
		}
	}

	public boolean getRS() {
		return RS;
	}

	/* �д������ı����û�ʱ����true */
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

	/* ��ӡ�������ı����û����� */
	public void printRegisteredUsers() {
		List l = new List();
		System.out.println("���������û���");
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Pending")) {
				System.out.println(l.getList().get(i).getAccountNumber());
			}
		}
	}

	/* ������û����Ǵ������û�ʱ����true������ͨ�������򷵻�false */
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

	/* �б����ɹ����û�ʱ����true */
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

	/* ��ӡ���������û����� */
	public void printAcceptedUsers() {
		List l = new List();
		int cnt = 0;
		System.out.println("�����ɹ����û���");
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getRegistrationStatus().equals("Approved")) {
				System.out.println(l.getList().get(i).getAccountNumber());
				cnt++;
			}
		}
		System.out.println("����" + cnt + "λѡ�ֱ���׼����");
	}
}