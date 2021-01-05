package part1;

import java.util.Scanner;

/**
 * �˻�����ϵͳ����
 **/
public class AccountManagementSystem {

	private String flag;// �жϹ���

	/* ��ʾ���� */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("          �˻�����ϵͳ  ");
		System.out.println("=======================");
		System.out.println("|1.����ע���û�       |");
		System.out.println("|                     |");
		System.out.println("|2.��ѯ�û���Ϣ       |");
		System.out.println("|                     |");
		System.out.println("|3.�����û��˻�       |");
		System.out.println("|                     |");
		System.out.println("|4.�����û�����       |");
		System.out.println("|                     |");
		System.out.println("|5.������һ��         |");
		System.out.println("|                     |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		Scanner sc = new Scanner(System.in);
		List l = new List();
		switch (flag) {

		/* ����ע���û�,�д������û�ʱ��ӡ������������ʾû�д������û� */
		case "1":
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
			Test.toAccountManagementSystem();
			break;

		/* ��ѯ�û����������û������ڣ���ѯ�û������롢״̬�������˻�����ϵͳ���棬������ʾ�û��������ڲ������˻�����ϵͳ���� */
		case "2":
			System.out.print("��������Ҫ��ѯ���û�����");
			String str = sc.next();
			if (isExist(str)) {
				System.out.println("��ѯ�ɹ���");
				System.out.println("����ѯ���û���Ϊ��" + str);
				System.out.println("����ѯ�û���������Ϊ��" + password(str));
				if (status(str).equals("Available")) {
					System.out.println("����ѯ�û�����״̬Ϊ���ɵ�¼��");
				} else if (status(str).equals("Reviewing")) {
					System.out.println("����ѯ�û�����״̬Ϊ����������");
				} else {
					System.out.println("����ѯ�û�����״̬Ϊ�������ã�");
				}
			} else {
				System.out.println("��������û��������ڣ�");
			}
			Test.toAccountManagementSystem();
			break;

		/* �����û����������û������ڣ����û���״̬��Ϊ�����ò������˻�����ϵͳ���棬������ʾ�û��������ڲ������˻�����ϵͳ���� */
		case "3":
			System.out.print("��������Ҫ���õ��û�����");
			String str1 = sc.next();
			if (isExist(str1)) {
				if (status(str1).equals("Available")) {
					banUsers(str1);
					System.out.println("���óɹ���");
				} else if (status(str1).equals("Reviewing")) {
					System.out.println("���˻����������޷����ã�");
				} else {
					System.out.println("���˻��ѱ����ã������ٴν��ã�");
				}
			} else {
				System.out.println("��������û��������ڣ�");
			}
			Test.toAccountManagementSystem();
			break;

		/* �����û����룬�������û������ڣ������û�������Ϊ��123456���������˻�����ϵͳ���棬������ʾ�û��������ڲ������˻�����ϵͳ���� */
		case "4":
			System.out.print("��������Ҫ���õ��û�����");
			String str11 = sc.next();
			if (isExist(str11)) {
				if (status(str11).equals("Available")) {
					resetPassword(str11);
					System.out.println("���óɹ��������Ѿ��ָ�Ϊ123456");
				} else if (status(str11).equals("Reviewing")) {
					System.out.println("���˻����������޷����ã�");
				} else {
					System.out.println("���˻��ѱ����ã��޷����ã�");
				}
			} else {
				System.out.println("��������û��������ڣ�");
			}
			Test.toAccountManagementSystem();
			break;

		/* ��ת������Ա���� */
		case "5":
			Test.toAdministratorsInterface();
			break;

		/* �Ƿ����룬�������˻�����ϵͳ���� */
		default:
			System.out.println("�Ƿ����룡");
			Test.toAccountManagementSystem();
		}
	}

	/* �д�������ע���û�ʱ����true */
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

	/* ��ӡ��������ע���û����� */
	public void printRegisteredUsers() {
		List l = new List();
		System.out.println("���������û���");
		for (int i = 1; i < l.getList().size(); ++i) {
			Information information = l.getList().get(i);
			if (information.getStatus().equals("Reviewing")) {
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
			if (information.getStatus().equals("Reviewing") && information.getAccountNumber().equals(str)) {
				l.getList().get(i).setStatus("Available");
				flag = true;
				break;
			}
		}
		return flag;
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

	/* �����û�����Ӧ������ */
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

	/* �����û�����Ӧ���˺�״̬ */
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

	/* �����û��� */
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

	/* ����Ӧ�û�������������Ϊ��123456�� */
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