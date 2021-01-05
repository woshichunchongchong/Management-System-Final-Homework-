package part1;

import java.util.*;

public class List {
	private static ArrayList<Information> list = new ArrayList<>(); // 信息列表
	private static ArrayList<String> notice = new ArrayList<>(); // 公告列表

	public ArrayList<Information> getList() {
		return list;
	}

	public ArrayList<String> getNotice() {
		return notice;
	}
}