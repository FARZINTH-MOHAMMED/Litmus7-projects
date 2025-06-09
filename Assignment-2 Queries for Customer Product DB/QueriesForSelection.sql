--1. Get the list of all customers.
SELECT name FROM customers;

--2. Find all orders placed in the last 30 days.
SELECT order_id,order_date FROM orders WHERE orders.order_date BETWEEN CURDATE() - INTERVAL 30 DAY AND CURDATE();

--3. Show product names and their prices.
SELECT product_name,price FROM products;

--4. Find the total number of products in each category.
SELECT COUNT(product_id) as "product count",category FROM products GROUP BY category;

--5. Get all customers from the city 'Mumbai'.
SELECT name FROM customers WHERE city = 'Mumbai';

--6. Find orders with a total amount greater than ₹5000.
SELECT order_id FROM order_details WHERE price > 5000;

--7. List customers who signed up after '2024-01-01'.
SELECT name, sign_up_date FROM customers WHERE sign_up_date > '2024-01-01';

--8. Show all orders along with the customers name.
SELECT orders.*, customers.name FROM orders JOIN customers ON orders.customer_id = customers.customer_id;

--9. List products purchased in each order.
SELECT  orders.order_id, products.product_name, order_details.quantity, order_details.price
FROM order_details JOIN orders ON order_details.order_id = orders.order_id
JOIN products ON order_details.product_id = products.product_id ORDER BY orders.order_id;

--10. Find customers who have never placed an order.
SELECT customers.* FROM customers  LEFT JOIN orders  ON customers.customer_id = orders.customer_id WHERE orders.customer_id IS NULL;

--11. Find the total amount spent by each customer.
SELECT c.customer_id, c.name, SUM(o.total_amount) AS total_spent
FROM  customers c JOIN  orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id;

--12. Which product has been sold the most (by quantity)?
SELECT customer_id,SUM(total_amount) FROM orders GROUP BY customer_id;
SELECT p.product_name,SUM(od.quantity) AS total_quantity_sold FROM  order_details od 
JOIN  products p ON od.product_id = p.product_id GROUP BY  od.product_id, p.product_name 
ORDER BY  total_quantity_sold DESC LIMIT 1;

--13. Find the average order value for each customer.
SELECT customers.customer_id,customers.name,AVG(orders.total_amount) FROM customers JOIN orders ON customers.customer_id=orders.customer_id 
GROUP BY customers.customer_id,customers.name;

--14. Total sales amount per product category.
SELECT products.category,SUM(order_details.quantity*order_details.price) FROM products JOIN order_details ON 
products.product_id=order_details.product_id GROUP BY products.category; 

--15. Find customers who spent more than the average spending.
SELECT  c.customer_id, c.name, SUM(o.total_amount) AS total_spent
FROM customers c JOIN  orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id, c.name HAVING SUM(o.total_amount) > (SELECT AVG(total_amount) FROM orders);

--16. List products that have never been ordered.
SELECT products.product_name FROM products WHERE product_id NOT IN(SELECT order_details.product_id FROM order_details);

--17. Find the most recent order for each customer.
SELECT o.customer_id,c.name,o.order_id,o.order_date
FROM  orders o JOIN customers c ON o.customer_id = c.customer_id WHERE o.order_date = (
SELECT MAX(o2.order_date) FROM orders o2 WHERE o2.customer_id = o.customer_id) ORDER BY  o.customer_id;


--18. Rank customers by total spending (highest first).
SELECT c.customer_id,c.name, SUM(o.total_amount) AS total_spent FROM 
    customers c JOIN orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id ORDER BY total_spent DESC;

--19. Get the top 3 customers based on the number of orders placed.
SELECT c.customer_id,c.name,COUNT(o.order_id) AS orders_count FROM 
customers c JOIN orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id ORDER BY orders_count DESC LIMIT 3;


--20. For each product, find how many unique customers have purchased it.
SELECT p.product_id,p.product_name, COUNT(DISTINCT o.customer_id) FROM 
products p JOIN order_details od ON p.product_id = od.product_id JOIN orders o ON od.order_id = o.order_id GROUP BY p.product_id;
