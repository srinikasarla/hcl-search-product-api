insert into products (id, name, description, average_rating, total_ratings, image_path) values (1, 'iPhone 8', 'Apple iPhone 8', 4, 53, 'images/iPhone8.png');
insert into products (id, name, description, average_rating, total_ratings, image_path) values (2, 'Google Pixel', 'Google Pixel', 4.5, 334, 'images/google-pixel.png');
insert into products (id, name, description, average_rating, total_ratings, image_path) values (3, 'Samsung 3d', 'Samsung three dimensional television', 4.7, 209, 'images/Samsung3d.jpg');
insert into products (id, name, description, average_rating, total_ratings, image_path) values (4, 'LG', 'LG Golden eye television', 3.7, 10, 'images/LG.jpg');

insert into categories (id, name) values (1, 'phone');
insert into categories (id, name) values (2, 'smart phone');
insert into categories (id, name) values (3, 'electronics');
insert into categories (id, name) values (4, 'video');
insert into categories (id, name) values (5, 'tv');
insert into categories (id, name) values (6, '3d');


insert into product_categories (product_id, categories_id) values (1,1);
insert into product_categories (product_id, categories_id) values (1,2);
insert into product_categories (product_id, categories_id) values (1,3);
insert into product_categories (product_id, categories_id) values (2,1);
insert into product_categories (product_id, categories_id) values (2,2);
insert into product_categories (product_id, categories_id) values (2,3);
insert into product_categories (product_id, categories_id) values (3,3);
insert into product_categories (product_id, categories_id) values (3,4);
insert into product_categories (product_id, categories_id) values (3,5);
insert into product_categories (product_id, categories_id) values (3,6);
insert into product_categories (product_id, categories_id) values (4,3);
insert into product_categories (product_id, categories_id) values (4,4);
insert into product_categories (product_id, categories_id) values (4,5);
