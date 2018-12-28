package priv.lint.RedisCacheForJava;

import java.util.List;

public interface NewsDAO {
    List<News> getnews();
    void addNews(News news);
}
