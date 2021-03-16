package Ex0324;

/*
 * 专用运输车类
 */
public class Ztransportation extends Transportation implements Careable {
	// 无参构造
	public Ztransportation() {
		super();
	}

	// 有参构造：车辆编码、型号、负责人
	public Ztransportation(String number, String model, String admin) {
		super(number, model, admin);
	}

	// 运输方法
	public void transport() {
		System.out.println("运输进行中。。。");
	}

	// 重写车辆保养方法
	public void upKeep() {
		System.out.println("货物运输车辆保养完毕！");
	}
}
