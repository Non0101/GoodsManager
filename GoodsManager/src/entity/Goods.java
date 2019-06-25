package entity;

public class Goods {
	int goods_id;
	private String goods_name;
	private String goods_changjia;
	private String goods_guige;
	private long goods_price;
	private String goods_picture;
	private String goods_pihao;
	private String goods_tiaoma;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_changjia() {
		return goods_changjia;
	}

	public void setGoods_changjia(String goods_changjia) {
		this.goods_changjia = goods_changjia;
	}

	public String getGoods_guige() {
		return goods_guige;
	}

	public void setGoods_guige(String goods_guige) {
		this.goods_guige = goods_guige;
	}

	public long getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(long goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_picture() {
		return goods_picture;
	}

	public void setGoods_picture(String goods_picture) {
		this.goods_picture = goods_picture;
	}

	public String getGoods_pihao() {
		return goods_pihao;
	}

	public void setGoods_pihao(String goods_pihao) {
		this.goods_pihao = goods_pihao;
	}

	public String getGoods_tiaoma() {
		return goods_tiaoma;
	}

	public void setGoods_tiaoma(String goods_tiaoma) {
		this.goods_tiaoma = goods_tiaoma;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(int goods_id, String goods_name, String goods_changjia,
			String goods_guige, long goods_price, String goods_picture,
			String goods_pihao, String goods_tiaoma) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_changjia = goods_changjia;
		this.goods_guige = goods_guige;
		this.goods_price = goods_price;
		this.goods_picture = goods_picture;
		this.goods_pihao = goods_pihao;
		this.goods_tiaoma = goods_tiaoma;
	}

	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", goods_name=" + goods_name
				+ ", goods_changjia=" + goods_changjia + ", goods_guige="
				+ goods_guige + ", goods_price=" + goods_price
				+ ", goods_picture=" + goods_picture + ", goods_pihao="
				+ goods_pihao + ", goods_tiaoma=" + goods_tiaoma + "]";
	}

}
