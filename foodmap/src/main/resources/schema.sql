CREATE DATABASE IF NOT EXISTS `foodmap` ;

USE foodmap;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS store;
CREATE TABLE store (
                       store_id INT,
                       store_name VARCHAR(200) NOT NULL,
                       address_name VARCHAR(300) NOT NULL,
                       category VARCHAR (300) NOT NULL,
                       place_url VARCHAR(300) NOT NULL,
                       x DOUBLE NOT NULL,
                       y DOUBLE NOT NULL,
                       reg_cnt INT NOT NULL DEFAULT(0),
                       PRIMARY KEY(store_id)

);
desc store;
DROP TABLE IF EXISTS review;
CREATE TABLE review (
                        review_id INT AUTO_INCREMENT,
                        store_id INT NOT NULL,
                        visit_date DATE NOT NULL,
                        star INT NOT NULL,
                        memo TEXT NOT NULL,
                        image_url VARCHAR(500) NOT NULL,
                        PRIMARY KEY(review_id),
                        FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);
desc review;
SELECT * FROM store;

INSERT INTO store
VALUES(61954627, "즐거버", "인천 부평구 부평동 211-69", "음식점 > 양식 > 햄버거", "http://place.map.kakao.com/61954627", 126.723881792115, 37.4947783368621, 0);

INSERT INTO review(store_id, visit_date, star, memo, image_url)
VALUES(61954627, CURDATE(), 5, "너무 맛있어요", "link");

