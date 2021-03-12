package pers.wxp.lambda.stream;

/**
 * @author wxp
 * @date 2020-11-11
 */
public class Tuple {
    String author;

    BlogPostType type;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }
}
