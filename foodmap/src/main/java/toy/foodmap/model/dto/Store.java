package toy.foodmap.model.dto;

import lombok.Data;

@Data
public class Store {
    private int storeId;
    private String storeName;
    private String addressName;
    private String category;
    private String placeUrl;
    private double x;
    private double y;
}
