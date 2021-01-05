package part1;

import java.util.Scanner;

/**
 * ע�����
 **/
public class RegistrationInterface {

	private String accountNumber; // Ҫע����û���
	private String password; // Ҫע�������
	private String flag; // �жϹ���

	/* ������ʾ */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("                      �û�ע��  ");
		System.out.println("===================================");
		System.out.print("��������Ҫע����˺ţ�");
		this.accountNumber = sc.next();
		System.out.print("��������Ҫע������룺");
		this.password = sc.next();
		System.out.print(" ����1ȷ��ע�ᣬ����2���������棺");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		List l = new List();
		switch (flag) {

		/* ȷ��ע�� */
		case "1":

			/* �ж��û����Ƿ�ע�ᣬ����д�������б����������棬 ������ʾʧ�ܲ�����ע����� */
			if (!isUsed()) {
				Information information = new Information(this.accountNumber, this.password, "Reviewing",
						"Not registered", 0, 0);
				l.getList().add(information);
				System.out.println("ע��ɹ�����ȴ�����Ա���");
				Test.toMainInterface();
			} else {
				System.out.println("ע��ʧ�ܣ����˺��ѱ�ע��");
				Test.toRegistrationInterface();
			}
			break;

		/* ���������� */
		case "2":
			Test.toMainInterface();
			break;

		/* ������� */
		default:
			Test.toRegistrationInterface();
		}
	}

	/* ���û����ѱ�ע��ʱ������true */
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