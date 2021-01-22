package test.example.mapper;

//指定为Spring环境中的单元测试

import org.example.Application;
import org.example.entity.Article;
import org.example.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.System.out;

//指定为Spring环境中的单元测试
@RunWith(SpringRunner.class)
//指定为SpringBoot环境的单元测试，Application为启动类
@SpringBootTest(classes = Application.class)
//使用事务，在SpringBoot的单元测试中会自动回滚
@Transactional
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper mapper;

    @Test
    public void testSelectArticlesByUserId() {
        List<Article> list = mapper.selectArticlesByUserId(1);
        for (Article article:list) {
            out.println("查询结果："+article);
        }
    }

    @Test
    public void testUpdateArticlesByUserId() {
        Article article = new Article();
        String content = "public static void main(String[] args){}";
        article.setContent(content);
        article.setId(2);
        int i = mapper.updateArticleByUserId(article);
        out.println("修改数据"+i+"条");
    }

    @Test
    public void testDeleteArticleByUserName() {
        int i = mapper.deleteArticleByUserName("c");
    }

    @Test
    public void testSelectArticlesLike() {
        List<Article> list = mapper.selectArticlesLike("id", "desc");
        for (Article article : list) {
            out.println(article);
        }
    }

    @Test
    public void testSelectAll() {
        List<Article> list = mapper.selectAll("id", "desc");
        for (Article article:list){
            out.println(article);;
        }
    }

}
