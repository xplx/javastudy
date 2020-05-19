package pers.wxp.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/18 16:47
 */
public class StreamTest {
    public List<Student> init() {
        // 初始化
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        return students;
    }

    @Test
    public void filterTest() {
        List<Student> students = init().stream().filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());
        System.out.println(students);
    }
}
