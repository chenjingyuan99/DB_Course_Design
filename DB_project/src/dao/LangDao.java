package dao;

import entity.Language;

import java.util.List;

public interface LangDao extends BaseDao {

    public Language findByID(int lanId);

    public List<Language> findAll();

    public Language findByLangName(String langNa);

}
