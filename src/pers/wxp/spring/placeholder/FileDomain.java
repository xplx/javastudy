package pers.wxp.spring.placeholder;

public class FileDomain {
	public static volatile FileDomain instance;

	private String name;
	private String path;

	public void init() {
		if (instance == null) {
			// synchronized当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码
			synchronized (FileDomain.class) {
				if (instance == null) {
					instance = this;
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		System.out.println(path);
		return "FileDomain [name=" + name + ", path=" + path + "]";
	}

}
