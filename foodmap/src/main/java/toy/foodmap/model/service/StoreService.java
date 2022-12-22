package toy.foodmap.model.service;

import toy.foodmap.model.dto.SearchCondition;
import toy.foodmap.model.dto.Store;

import java.util.List;

public interface StoreService {

    void addStore(Store store);

    List<Store> getStoreByCondition(SearchCondition searchCondition);
}
