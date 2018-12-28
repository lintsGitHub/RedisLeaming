package priv.lint.RedisCacheForJava;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService implements NewsDAO {
    NewsDAO newsDAO;

    @Override
    public List<News> getnews() {
        newsDAO.getnews();
        return null;
    }

    @Override
    public void addNews(News news) {

    }
}
