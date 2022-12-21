package toy.foodmap.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchCondition {
    private String searchType=""; // 조회 타입 = none, 지역, 음식 종류
    private String keyword="";
    private String sortType=""; // 정렬 기준 (별점순, 방문순)
    private String sortDir = "asc"; // 기본: 오름차순



}
