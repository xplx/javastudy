package pers.wxp.pattern.proxyI.staticProxy;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/20 10:10
 */
public class ProxyImage implements Image {
    private ImageImpl realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new ImageImpl(fileName);
        }
        realImage.display();
    }
}
