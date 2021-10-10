package buybuyla.model.record_30;

import java.io.Serializable;

public class Updatebean implements Serializable {

	private  int record_id;
	private  int pid;
	private  int pcount;

	public Updatebean() {

	}

	public Updatebean(int record_id, int pid, int pcount) {
		this.record_id=record_id;
		this.pid=pid;
		this.pcount=pcount;

	}

	public  int getRecord_id() {
		return record_id;
	}

	public  void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public  int getPid() {
		return pid;
	}

	public  void setPid(int pid) {
		this.pid = pid;
	}

	public  int getPcount() {
		return pcount;
	}

	public  void setPcount(int pcount) {
		this.pcount = pcount;
	}
}
