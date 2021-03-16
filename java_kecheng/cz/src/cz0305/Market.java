package cz0305;

/*
 * 定义超市类
 * 描述超市事物
 * 超市名
 * 超市的仓库，存储商品
 * 售货方法
 */
public class Market {
	private String marketName;// 超市名
	private Product[] productArr;// 仓库，存储商品，里面存储若干商品

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
