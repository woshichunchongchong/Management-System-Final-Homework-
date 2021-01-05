package part1;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		List l = new List();
		Information information = new Information("ad123", "123456", "Available", "Not registered", 0, 0);
		l.getList().add(information);
		toMainInterface();
	}

	/* 跳转至主界面 */
	public static void toMainInterface() {
		MainInterface mainInterface = new MainInterface();
		mainInterface.showInfo();
		mainInterface.jump();
	}

	/* 跳转至注册界面 */
	public static void toRegistrationInterface() {
		RegistrationInterface registrationInterface = new RegistrationInterface();
		registrationInterface.showInfo();
		registrationInterface.jump();
	}

	/* 跳转至登录界面 */
	public static void toLoginInterface() {
		LoginInterface loginInterface = new LoginInterface();
		loginInterface.showInfo();
		loginInterface.jump();
	}

	/* 跳转至管理员界面 */
	public static void toAdministratorsInterface() {
		AdministratorsInterface administratorsInterface = new AdministratorsInterface();
		administratorsInterface.showInfo();
		administratorsInterface.jump();
	}

	/* 跳转至运动员界面 */
	public static void toAthletesInterface() {
		AthletesInterface athletesInterface = new AthletesInterface();
		athletesInterface.showInfo();
		athletesInterface.jump();
	}

	/* 跳转至账户管理系统界面 */
	public static void toAccountManagementSystem() {
		AccountManagementSystem accountManagementSystem = new AccountManagementSystem();
		accountManagementSystem.showInfo();
		accountManagementSystem.jump();
	}

	/* 跳转至报名管理系统界面 */
	public static void toRegistrationManagementSystem() {
		RegistrationManagementSystem registrationManagementSystem = new RegistrationManagementSystem();
		registrationManagementSystem.showInfo();
		registrationManagementSystem.jump();
	}

	/* 跳转至成绩管理系统界面 */
	public static void toAchievementManagementSystem() {
		AchievementManagementSystem achievementManagementSystem = new AchievementManagementSystem();
		achievementManagementSystem.showInfo();
		achievementManagementSystem.jump();
	}
}