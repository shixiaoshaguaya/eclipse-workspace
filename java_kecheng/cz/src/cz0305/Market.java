package cz0305;

/*
 * ���峬����
 * ������������
 * ������
 * ���еĲֿ⣬�洢��Ʒ
 * �ۻ�����
 */
public class Market {
	private String marketName;// ������
	private Product[] productArr;// �ֿ⣬�洢��Ʒ������洢������Ʒ

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public Product[] getProductArr() {
		return productArr;
	}

	public void setProductArr(Product[] productArr) {
		this.productArr = productArr;
	}

	Product sell(String name) {
		for (int i = 0; i < productArr.length; i++) {
			if (productArr[i].getProNmae() == name) {
				return productArr[i];
			}
		}
		return null;
	}
}
