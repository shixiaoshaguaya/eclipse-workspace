package cz0312;

//定义银行类
class Bank {
	static String bankName;// 定义静态变量银行名称
	private String name;// 储户姓名
	private String password;// 密码
	private double balance;// 账户余额
	private double turnover;// 交易额
	// 定义私有成员name公有的访问成员的getXxx()方法和setXxx()方法

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 定义私有成员password公有的访问成员的getXxx()方法和setXxx()方法
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 定义私有成员balance公有的访问成员的getXxx()方法和setXxx()方法
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 静态方法，打出银行欢迎语句
	public static void welcome() {
		System.out.println("欢迎来到" + bankName);
	}

	// 定义无参的构造方法
	public Bank() {
	}

	// 定义带有name，password，turnover参数的构造方法（开户）
	public Bank(String name, String password, double turnover) {
		this.name = name;
		this.password = password;
		balance = balance + turnover - 10;
		System.out.println(name + "开户成功，账户余额为" + balance + "开户手续费为10");
	}

	// 存款功能
	public double deposit(double turnover) {
		balance += turnover;
		System.out.println(name + "您好，你的账户已经存入" + turnover + "元，" + "余额为" + balance + "元");
		return balance;
	}

	// 取款功能
	public void withdrawal(String password, double turnove) {
		// 判断密码是否正确
		if (this.password != password) {
			System.out.println("您输入的密码错误");
			return;
		}
		// 判断余额是否充足
		if (balance >= turnove) {
			balance -= turnove;
			System.out.println(name + "您好，您的账户已取出" + turnove + "元，" + "当前余额" + balance + "元");
		} else {
			System.out.println("对不起，账户余额不足");
		}
	}

	// 静态方法，打印出银行欢迎下次光临
	public static void welcomeNext() {
		System.out.println("请携带好随身财物，欢迎下次光临" + bankName);
	}
}

public class Trade {
	public static void main(String[] args) {
		// 定义一家银行给静态变量（银行名称）赋值
		Bank.bankName = "测试类银行";
		// 银行打印欢迎语句
		Bank.welcome();
		// 开户操作
		Bank zs = new Bank("陈喆", "654321", 1000.0);
		// 进行存款操作
		zs.deposit(500.0);
		// 取款时密码输入错误，取款失败
		zs.withdrawal("123456", 200.0);
		// 取款时余额不足，取款失败
		zs.withdrawal("654321", 1500.0);
		// 取款时密码正确，余额充足，取款成功
		zs.withdrawal("654321", 200.0);
		// 银行打印道别语句
		Bank.welcomeNext();
	}
}
