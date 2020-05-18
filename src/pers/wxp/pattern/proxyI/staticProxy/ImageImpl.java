package pers.wxp.pattern.proxyI.staticProxy;

/**
 * @author wuxiaopeng
 * @description: image实现类
 * @date 2020/3/20 10:09
 */
public class ImageImpl implements Image {
    private String fileName;

    public ImageImpl(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
