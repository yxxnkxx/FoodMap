package toy.foodmap.model.dto;

import lombok.Data;

@Data
public class Review {
    private int reviewSeq;
    private String visitDate;
    private int star;
    private String memo;
    private String imageUrl;
    private Store store;
}
