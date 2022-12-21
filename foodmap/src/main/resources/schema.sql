CREATE DATABASE IF NOT EXISTS `foodmap` ;

USE foodmap;
DROP TABLE IF EXISTS store;
CREATE TABLE store (
                       store_id INT,
                       store_name VARCHAR(200) NOT NULL,
                       address_name VARCHAR(300) NOT NULL,
                       category VARCHAR (300) NOT NULL,
                       place_url VARCHAR(300) NOT NULL,
                       x INT NOT NULL,
                       y INT NOT NULL,
                       reg_cnt INT NOT NULL DEFAULT(0),
                       PRIMARY KEY(store_id)

);
desc store;
DROP TABLE IF EXISTS review;
CREATE TABLE review (
                        review_seq INT,
                        store_id INT NOT NULL,
                        visit_date DATE NOT NULL,
                        star INT NOT NULL,
                        memo TEXT NOT NULL,
                        image_url VARCHAR(500) NOT NULL,
                        PRIMARY KEY(review_seq),
                        FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);
desc review;