package cart_30.model;


import java.io.Serializable;

public class Select2bean implements Serializable {
	private int record_id;
	private int pid;
	private String p_name;
	private int p_price;
	private String buy_time;
	private String userEmail;
	private int pcount;

	public Select2bean() {

	}

	public Select2bean(int record_id, int pid, String p_name, int p_price, String buy_time, String userEmail,
			int pcount) {
		super();
		this.record_id = record_id;
		this.pid = pid;
		this.p_name = p_name;
		this.p_price = p_price;
		this.buy_time = buy_time;
		this.userEmail = userEmail;
		this.pcount = pcount;
	}

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(String buy_time) {
		this.buy_time = buy_time;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

}