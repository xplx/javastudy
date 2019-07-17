package pers.wxp.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author wuxiaopeng
 * @description: 按行读取文件
 * @date 2019/7/16 17:23
 */
public class ReadLine {
    public static void main(String[] args) throws Exception{
        //获取文件路径
        FileInputStream fileStream=new FileInputStream("F:/file.txt");
        byte[] b = new byte[3];
        fileStream.read(b);

        InputStreamReader readStream=new InputStreamReader(fileStream, "utf-8");
        BufferedReader reader=new BufferedReader(readStream);

        String temp=null;

        StringBuffer stringBuffer = new StringBuffer();
        //添加数据标志位
        int flag = 0;
        while((temp=reader.readLine())!=null){
            if ("<paragraph>".equals(temp)) {
                flag = 1;
            }
            if ("</paragraph>".equals(temp)) {
                flag = 0;
            }
            if (flag > 1 ) {
                if (!"".equals(temp)) {
                    stringBuffer.append(temp.trim()+"\n");
                }
            }
            if (flag == 1) {
                flag++;
            }
        }

        if(readStream!=null){
            readStream.close();
        }
        if(reader!=null){
            reader.close();
        }
        System.out.println("最终结果：\n"+ stringBuffer.toString());
    }
}
