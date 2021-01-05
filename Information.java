package part1;

/**
 * �˻���Ϣ
 */
public class Information implements Comparable<Information> {
	private String accountNumber; // �û���
	private String password; // ����
	private String status; // �˺�״̬
	private String registrationStatus; // ����״̬
	private int achievement; // �ɼ�
	private int rank; // ����

	public Information(String accountNumber, String password, String status, String registrationStatus, int achievement,
			int rank) {
		this.accountNumber = accountNumber;
		this.password = password;
		this.status = status;
		this.registrationStatus = registrationStatus;
		this.achievement = achievement;
		this.rank = rank;
	}

	public Information() {

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public int getAchievement() {
		return achievement;
	}

	public void setAchievement(int achievement) {
		this.achievement = achievement;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/* ArrayList���ݳɼ����� */
	@Override
	public int compareTo(Information o) {
		if (this.achievement < o.achievement) {
			return -1;
		} else if (this.achievement == o.achievement) {
			return 0;
		} else {
			return 1;
		}
	}
}