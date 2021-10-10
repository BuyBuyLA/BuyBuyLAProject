package buybuyla.model.record_30;

import java.io.Serializable;

public class SelectBean implements Serializable {
	private   String user;

	public SelectBean() {

	}

	public SelectBean(String user) {
		this.user=user;
	}

	public String getUser() {
		return user;
	}

	public  void setUser(String user) {
		this.user = user;
	}
}
