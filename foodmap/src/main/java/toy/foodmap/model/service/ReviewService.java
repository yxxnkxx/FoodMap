package toy.foodmap.model.service;

import toy.foodmap.model.dto.Review;
import toy.foodmap.model.dto.SearchCondition;

import java.util.List;

public interface ReviewService {

    void addReview(Review review);



    List<Review> getAllReviewByStore(int storeId);

    List<Review> getReviewByCondition(SearchCondition searchCondition);

}
