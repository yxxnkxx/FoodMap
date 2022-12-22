package toy.foodmap.model.dao;

import toy.foodmap.model.dto.Review;
import toy.foodmap.model.dto.SearchCondition;
import toy.foodmap.model.dto.Store;

import java.util.List;

public interface ReviewDao {

    void insertReview(Review review);


    List<Review> selectReviewByStore(int storeId);

    List<Review> selectByCondition(SearchCondition searchCondition);



}
