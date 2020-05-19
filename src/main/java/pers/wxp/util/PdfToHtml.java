package pers.wxp.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.*;

/**
 * @author wuxiaopeng
 * @create 2018-05-23 13:48
 * Java将pdf文件转换成String,其中需要commons-logging-1.2.jar、fontbox-2.0.4.jar、pdfbox-2.0.4.jar这三个包就可以。
 **/
public class PdfToHtml {
    public static String getText(String file) throws Exception {
        // 是否排序
        boolean sort = false;
        // PDF的本地路径或者url
        String pdfFile = file;
        // 编码方式
        String encoding = "UTF-8";
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage = Integer.MAX_VALUE;
        //获取本地路径资源
        FileInputStream in = new FileInputStream(file);
        // 文件输入流，生成文本文件
        Writer output = null;
        // 内存中存储的PDF Document
        PDDocument document = PDDocument.load(in);
        try{
            // 采用PDFTextStripper提取文本
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            String text = stripper.getText(document);
            //尝试把前边或后边接有空白字符的换行符换成其他的文字，然后把换行符替换掉，之后再把其他文字换成换行符
            //原理是pdf转成String中间有过多的回车换行符\r\n这种，但是如果换行符前后都是有文字的（不为空），则这应该是一个被pdf强行换行出来的
            //这里的Jacck最好换成一个更复杂的文本，作为中间替换物存在尽量在中间转化过程中和文档中没有任何匹配
            text = text.replaceAll("\\r\\n\\s","Jacck");
            text = text.replaceAll("\\s\\r\\n","Jacck");
            //处理掉被强行加上来的回车换行符
            text = text.replaceAll("\\n|\\r","");
            text = text.replaceAll("Jacck","\r\n");
            return text;
//          stripper.writeText(document, output);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(document != null){
                document.close();
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String file = "D:\\test\\1000093_contract.pdf";
        try {
            String text = getText(file);
            System.out.println(text);
            //readText();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * 读取文本文件
     */
    public static void readText(){
        try {
            /* 读入TXT文件 */
            String pathname = "D:\\test\\contract.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader( new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            StringBuffer sbf = new StringBuffer();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                sbf.append(line + "\r\n");
            }
            System.out.println(sbf);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

