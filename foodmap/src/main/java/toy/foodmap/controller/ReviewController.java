package toy.foodmap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.foodmap.model.dto.Review;
import toy.foodmap.model.dto.SearchCondition;
import toy.foodmap.model.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    static final String SUCCESS = "success";
    static final String FAIL = "fail";
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> addReview(Review review) {
        reviewService.addReview(review);
        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getReviewByCondition(SearchCondition searchCondition) {
        List<Review> reviewByCondition = reviewService.getReviewByCondition(searchCondition);
        if (reviewByCondition==null || reviewByCondition.size()==0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviewByCondition, HttpStatus.OK);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<?> getReviewByStore(@PathVariable int storeId) {
        List<Review> allReviewByStore = reviewService.getAllReviewByStore(storeId);
        if (allReviewByStore==null || allReviewByStore.size()==0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(allReviewByStore, HttpStatus.OK);
    }


}
