package part1;

import java.util.Scanner;

/**
 * �˶�Ա����
 **/
public class AthletesInterface {

	private String flag; // �жϹ���

	/* ������ʾ */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("           �����˶�Ա  ");
		System.out.println("=======================");
		System.out.println("|1.��������           |");
		System.out.println("|                     |");
		System.out.println("|2.��ѯ�ɼ�           |");
		System.out.println("|                     |");
		System.out.println("|3.�鿴���а�         |");
		System.out.println("|                     |");
		System.out.println("|4.�鿴����Ա֪ͨ     |");
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
		RegistrationManagementSystem r = new RegistrationManagementSystem();
		switch (flag) {

		/* �������������û����������ڱ���ʱ�䣬���û�������״̬��Ϊ����в������˶�Ա���棬������ʾ�û��������ڲ������˶�Ա���� */
		case "1":
			if (!r.getRS()) {
				System.out.print("���ڱ���ʱ�䣡");
			} else {
				System.out.print("�����������û�����");
				String str = sc.next();
				if (isExist(str)) {
					if (registrationStatus(str).equals("Not registered")) {
						System.out.println("�����ɹ�����ȴ�����Ա��ˣ�");
						pendUsers(str);
					} else if (registrationStatus(str).equals("Pending")) {
						System.out.println("���ı������������ ��");
					} else if (registrationStatus(str).equals("Approved")) {
						System.out.println("�����û����Ѿ�ͨ����� ��");
					} else {
						System.out.println("���ĳɼ��Ѿ��ϴ���");
					}
				} else {
					System.out.println("��������û��������ڣ�");
				}
			}
			Test.toAthletesInterface();
			break;

		/* ��ѯ�û��ɼ����������û������ڣ���ѯ�û��ĳɼ��������������˶�Ա���棬������ʾ�û��������ڲ������˶�Ա���� */
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
			Test.toAthletesInterface();
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

		/* ������Ա������Ϣ��������ӡ����û�д�ӡû�з�����ʾ */
		case "4":
			showNotice();
			Test.toAthletesInterface();

			/* ��ת�������� */
		case "5":
			Test.toMainInterface();

			/* �Ƿ����� */
		default:
			System.out.println("�Ƿ����룡");
			Test.toAthletesInterface();
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

	/* ������û����Ǵ������û�ʱ����true������ͨ�������򷵻�false */
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

	/* ������Ա������Ϣ��������ӡ����û�д�ӡû�з�����ʾ */
	public void showNotice() {
		List l = new List();
		if (l.getNotice().size() == 0) {
			System.out.println("����Աû�з�����Ϣ��");
		} else {
			for (int i = 0; i < l.getNotice().size(); ++i) {
				System.out.println(i + 1 + "." + l.getNotice().get(i).toString());
			}
		}
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
		int num = 0;
		System.out.println("�û���         �ɼ�            ����");
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