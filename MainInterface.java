package part1;

import java.util.Scanner;

/**
 * ������
 **/
public class MainInterface {

	public String flag;// �жϹ���

	/* ��ʾ���� */
	public void showInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ����������Ϣ����ϵͳ  ");
		System.out.println("=======================");
		System.out.println("|1.��¼               |");
		System.out.println("|                     |");
		System.out.println("|2.ע��               |");
		System.out.println("|                     |");
		System.out.println("|3.�˳�ϵͳ           |");
		System.out.println("|                     |");
		System.out.println("=======================");
		this.flag = sc.next();
	}

	/* ���幦��ʵ�� */
	public void jump() {
		switch (flag) {

		/* ��ת����¼���� */
		case "1":
			Test.toLoginInterface();
			break;

		/* ��ת��ע����� */
		case "2":
			Test.toRegistrationInterface();
			break;
			
		/* �˳����� */
		case "3":
			System.exit(0);
			break;

		/* ������� */
		default:
			System.out.println("�������");
			Test.toMainInterface();
		}
	}
}
