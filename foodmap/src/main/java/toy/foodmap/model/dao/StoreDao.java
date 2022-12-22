package toy.foodmap.model.dao;

import toy.foodmap.model.dto.SearchCondition;
import toy.foodmap.model.dto.Store;

import java.util.HashMap;
import java.util.List;

public interface StoreDao {

    void insertStore(Store store);


    List<Store> selectByCondition(SearchCondition searchCondition);
}
