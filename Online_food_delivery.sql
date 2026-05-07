SELECT * 
FROM Food_Items;

SELECT food_name, price 
FROM Food_Items
WHERE price > 200;

SELECT food_name, price, restaurant_id
FROM Food_Items
WHERE price > 150 AND restaurant_id = 2;

SELECT restaurant_name, city
FROM Restaurants
WHERE city = 'Chennai' OR city = 'Bangalore';

SELECT name, city, phone
FROM Customers
WHERE name LIKE 'A%';

SELECT food_name, price
FROM Food_Items
WHERE food_name LIKE '%Pizza%';

SELECT food_name, price
FROM Food_Items
WHERE price BETWEEN 100 AND 300;

SELECT food_name, price
FROM Food_Items
ORDER BY price DESC;
