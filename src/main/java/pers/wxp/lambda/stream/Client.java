package pers.wxp.lambda.stream;

import com.sun.org.apache.regexp.internal.RE;
import pers.wxp.lambda.stream.BlogPostType;


import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author wxp
 * @date 2020-11-11
 */
public class Client {
    public static void main(String[] args) {
        List<BlogPost> posts = new ArrayList<BlogPost>();
        BlogPost blog = new BlogPost();
        blog.setTitle("今天");
        blog.setAuthor("小张");
        blog.setType(BlogPostType.GUIDE);
        blog.setLikes(2);
        posts.add(blog);
        BlogPost blog1 = new BlogPost();
        blog1.setTitle("明天");
        blog1.setAuthor("小刘");
        blog1.setType(BlogPostType.GUIDE);
        blog1.setLikes(1);
        posts.add(blog1);

        //分组返回list
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(groupingBy(post -> new Tuple()));
        //自定义返回值
        Map<BlogPostType, List<Map<String, Object>>> postsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, mapping(n->getBlogPost(n), toList())));
        System.out.println(postsPerType);

        //对分组进行转换，对分组内元素进行计算
        Map<BlogPostType, Map<String, Object>> postsPerTypeList = posts.stream()
                .collect(groupingBy(BlogPost::getType, collectingAndThen(toList(), m->{
                    Map<String, Object> map = new HashMap<>();
                    map.put("count", m.stream().count());
                    //对分组的list求和
                    map.put("money", m.stream().mapToDouble(BlogPost::getLikes).sum());
                    return map;
                })));
        System.out.println(postsPerTypeList);

        //对分组排序

        Map<BlogPostType, Map<String, Object>> postsPerTypeSort = posts.stream()
                .collect(groupingBy(BlogPost::getType, collectingAndThen(toList(), m->{
                    Map<String, Object> map = new HashMap<>();
                    map.put("count", m.stream().count());
                    //对分组的list求和
                    map.put("money", m.stream().mapToDouble(BlogPost::getLikes).sum());
                    return map;
                })));

    }

    private static Map<String, Object> getBlogPost(BlogPost blogPost) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", blogPost.getTitle());
        return map;
    }
}
