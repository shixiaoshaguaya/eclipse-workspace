package Ex0324;

/*
 * ר�����䳵��
 */
public class Ztransportation extends Transportation implements Careable {
	// �޲ι���
	public Ztransportation() {
		super();
	}

	// �вι��죺�������롢�ͺš�������
	public Ztransportation(String number, String model, String admin) {
		super(number, model, admin);
	}

	// ���䷽��
	public void transport() {
		System.out.println("��������С�����");
	}

	// ��д������������
	public void upKeep() {
		System.out.println("�������䳵��������ϣ�");
	}
}
