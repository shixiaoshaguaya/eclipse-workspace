package Ex0324;

/*
 * ���������
 */
public class SendTask {
	private String number;// ��ݵ���
	private double goodsWeight;// ��������

	public SendTask() {
		super();
	}

	public SendTask(String number, double goodsWeight) {
		super();
		this.number = number;
		this.goodsWeight = goodsWeight;
	}

	// ��ǰ׼��
	public void sendBefore() {
		System.out.println("������ʼ�����ֿ�����С�����");
		System.out.println("����������" + this.getGoodsWeight() + "kg");
		System.out.println("����������");
		System.out.println("����װ�����");
		System.out.println("��ݵ��ţ�" + this.getNumber());
	}

	// ���ͻ���
	public void send(Transportation t, GPS tool) {
		System.out.println("�˻���" + t.getAdmin() + "���ڼ�ʻ���Ϊ" + t.getNumber() + "��" + t.getModel() + "���ͻ��");
		t.transport();
		String showCoordiante = tool.showCoordinate();
		System.out.println("���ﵱǰ������Ϊ��" + showCoordiante);
	}

	// �ͻ�����
	public void sendAfter(Transportation t) {
		System.out.println("����������������ɣ�");
		System.out.println("�˻���" + t.getAdmin() + "����ʻ���Ϊ" + t.getNumber() + "��" + t.getModel() + "�ѹ黹��");
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
}
