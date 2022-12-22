package toy.foodmap.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toy.foodmap.model.dao.StoreDao;
import toy.foodmap.model.dto.SearchCondition;
import toy.foodmap.model.dto.Store;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    StoreDao storeDao;

    @Override
    public void addStore(Store store) {
        storeDao.insertStore(store);
    }

    @Override
    public List<Store> getStoreByCondition(SearchCondition searchCondition) {
        return storeDao.selectByCondition(searchCondition);
    }
}
