package toy.foodmap.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toy.foodmap.model.dao.ReviewDao;
import toy.foodmap.model.dto.Review;
import toy.foodmap.model.dto.SearchCondition;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Override
    public void addReview(Review review) {
        reviewDao.insertReview(review);
    }

    @Override
    public List<Review> getAllReviewByStore(int storeId) {
        return reviewDao.selectReviewByStore(storeId);
    }

    @Override
    public List<Review> getReviewByCondition(SearchCondition searchCondition) {
        return reviewDao.selectByCondition(searchCondition);
    }
}
