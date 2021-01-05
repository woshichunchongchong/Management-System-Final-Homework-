package part1;

import java.util.*;

/**
 * ��¼����
 **/
public class LoginInterface {

	private String accountNumber; // Ҫ��¼���û���
	private String password; // Ҫ��¼������
	private String flag; // �жϹ���

	/* ������ʾ */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("                      �û���¼  ");
		System.out.println("===================================");
		System.out.print("�����������˺ţ�");
		this.accountNumber = sc.next();
		System.out.print("�������������룺");
		this.password = sc.next();
		System.out.print(" ����1ȷ�ϵ�¼������2������һ�㣺");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		List l = new List();
		switch (flag) {

		/* ȷ�ϵ�¼���û��������롢�˺�״̬��ƥ��ʱ����ת����Ӧ���棬������ʾ���󲢷��ص�¼���� */
		case "1":
			if (isAdministrator()) {
				System.out.println("��¼�ɹ������ǹ���Ա");
				Test.toAdministratorsInterface();
			} else if (isAthlete()) {
				System.out.println("��¼�ɹ��������˶�Ա");
				Test.toAthletesInterface();
			} else if (isAbnormalState()) {
				System.out.println("��¼ʧ�ܣ��˻�״̬�ǿ��ã�");
				Test.toLoginInterface();
			} else if (isNotExist()) {
				System.out.println("��¼ʧ�ܣ��û��������ڣ�");
				Test.toLoginInterface();
			} else {
				System.out.println("��¼ʧ�ܣ��������");
				Test.toLoginInterface();
			}
			break;

		/* ��ת�������� */
		case "2":
			Test.toMainInterface();
			break;

		/* �Ƿ����� */
		default:
			System.out.println("�Ƿ����룡");
			Test.toLoginInterface();
		}
	}

	/* �������û���������Ϲ���Ա�û���������ʱ����true */
	public boolean isAdministrator() {
		boolean flag = false;
		if (this.accountNumber.equals("ad123") && this.password.equals("123456")) {
			flag = true;
		}
		return flag;
	}

	/* �������û�����������˶�Ա�û��������룬���˺�״̬����ʱ����true */
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

	/* �������û�����������˶�Ա�û��������룬���˺�״̬�쳣ʱ����true */
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

	/* �������û����������˶�Ա�û���ʱ����true */
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