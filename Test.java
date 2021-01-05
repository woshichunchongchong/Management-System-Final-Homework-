package part1;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		List l = new List();
		Information information = new Information("ad123", "123456", "Available", "Not registered", 0, 0);
		l.getList().add(information);
		toMainInterface();
	}

	/* ��ת�������� */
	public static void toMainInterface() {
		MainInterface mainInterface = new MainInterface();
		mainInterface.showInfo();
		mainInterface.jump();
	}

	/* ��ת��ע����� */
	public static void toRegistrationInterface() {
		RegistrationInterface registrationInterface = new RegistrationInterface();
		registrationInterface.showInfo();
		registrationInterface.jump();
	}

	/* ��ת����¼���� */
	public static void toLoginInterface() {
		LoginInterface loginInterface = new LoginInterface();
		loginInterface.showInfo();
		loginInterface.jump();
	}

	/* ��ת������Ա���� */
	public static void toAdministratorsInterface() {
		AdministratorsInterface administratorsInterface = new AdministratorsInterface();
		administratorsInterface.showInfo();
		administratorsInterface.jump();
	}

	/* ��ת���˶�Ա���� */
	public static void toAthletesInterface() {
		AthletesInterface athletesInterface = new AthletesInterface();
		athletesInterface.showInfo();
		athletesInterface.jump();
	}

	/* ��ת���˻�����ϵͳ���� */
	public static void toAccountManagementSystem() {
		AccountManagementSystem accountManagementSystem = new AccountManagementSystem();
		accountManagementSystem.showInfo();
		accountManagementSystem.jump();
	}

	/* ��ת����������ϵͳ���� */
	public static void toRegistrationManagementSystem() {
		RegistrationManagementSystem registrationManagementSystem = new RegistrationManagementSystem();
		registrationManagementSystem.showInfo();
		registrationManagementSystem.jump();
	}

	/* ��ת���ɼ�����ϵͳ���� */
	public static void toAchievementManagementSystem() {
		AchievementManagementSystem achievementManagementSystem = new AchievementManagementSystem();
		achievementManagementSystem.showInfo();
		achievementManagementSystem.jump();
	}
}