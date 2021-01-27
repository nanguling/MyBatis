package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {
    List<Article> selectArticlesByUserId(Integer userid);

    int updateArticleById(Article article);

    int deleteArticleByUserName(String username);

    List<Article> selectArticlesLike(@Param("column") String column,@Param("orderBy") String order);

    List<Article> selectAll(@Param("column") String column,@Param("orderBy") String order);
}
