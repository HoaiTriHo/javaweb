package tp.kits3.livedinner.vo;
import tp.kits3.livedinner.connectDB.ConnectDB;

public class Category {
    //@JsonProperty("ctgid")
    private Integer ctgid;

    @Override
	public String toString() {
		return "Category [ctgid=" + ctgid + ", ctname=" + ctname + ", service=" + service + "]";
	}

	private String ctname;

    private String service;

    public Integer getCtgid() {
        return ctgid;
    }

    public void setCtgid(Integer ctgid) {
        this.ctgid = ctgid;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    // Cateory 모델 복사
    public void CopyData(Category param)
    {
        this.ctgid = param.getCtgid();
        this.ctname = param.getCtname();
        this.service = param.getService();
    }
}