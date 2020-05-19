package pers.wxp.util;

/**
 *
 */
public final class ConfParameterUtil {
	public static volatile ConfParameterUtil instance = null;
	
	public Integer ssoTimeOut;
	
	public String basUrl;
	public String afcUrl;
	public String itsUrl;
	public String vcsUrl;
	
	public String ssoUrl;
	
	public String docPath;
	
	public void init(){
		if(instance==null){
			synchronized(ConfParameterUtil.class) {
                if(instance == null) {
                    instance = this;
                }
            }
		}
	}

	public Integer getSsoTimeOut() {
		return ssoTimeOut;
	}

	public void setSsoTimeOut(Integer ssoTimeOut) {
		this.ssoTimeOut = ssoTimeOut;
	}

	public String getBasUrl() {
		return basUrl;
	}

	public void setBasUrl(String basUrl) {
		this.basUrl = basUrl;
	}

	public String getAfcUrl() {
		return afcUrl;
	}

	public void setAfcUrl(String afcUrl) {
		this.afcUrl = afcUrl;
	}

	public String getItsUrl() {
		return itsUrl;
	}

	public void setItsUrl(String itsUrl) {
		this.itsUrl = itsUrl;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public String getVcsUrl() {
		return vcsUrl;
	}

	public void setVcsUrl(String vcsUrl) {
		this.vcsUrl = vcsUrl;
	}

}