package money;

public class Money {
	private static int money;
	
	public static int getMoney() {
		return money;
	}
	
	public static void setMoney(int setmoney) {
		money = setmoney;
	}
	
	public static void addMoney(int addmoney) {
		money += addmoney;
	}
	
	public static void subMoney(int submoney) {
		money -= submoney;
	}
}
