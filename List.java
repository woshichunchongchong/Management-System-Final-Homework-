package part1;

import java.util.*;

public class List {
	private static ArrayList<Information> list = new ArrayList<>(); // ��Ϣ�б�
	private static ArrayList<String> notice = new ArrayList<>(); // �����б�

	public ArrayList<Information> getList() {
		return list;
	}

	public ArrayList<String> getNotice() {
		return notice;
	}
}