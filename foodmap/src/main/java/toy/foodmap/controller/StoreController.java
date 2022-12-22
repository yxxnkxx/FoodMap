package toy.foodmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.foodmap.model.dto.SearchCondition;
import toy.foodmap.model.dto.Store;
import toy.foodmap.model.service.ReviewService;
import toy.foodmap.model.service.StoreService;
import toy.foodmap.model.service.StoreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    static final String SUCCESS = "success";
    static final String FAIL = "fail";
    @Autowired
    StoreService storeService;

    @PostMapping
    public ResponseEntity<String> addStore(Store store) {
        storeService.addStore(store);
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getStoreByCondition(SearchCondition searchCondition){
        List<Store> stores = storeService.getStoreByCondition(searchCondition);
        if (stores==null || stores.size()==0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
}
