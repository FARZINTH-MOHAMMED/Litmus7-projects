CREATE TABLE customers(
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    city VARCHAR(100),
    sign_up_date DATE
);

CREATE TABLE orders(
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE SET NULL
)

CREATE TABLE products(
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(10,2)
);

CREATE TABLE order_details(
    order_detail_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

ALTER TABLE customers MODIFY customer_id INT AUTO_INCREMENT;


INSERT INTO customers ( name, email, city, sign_up_date) VALUES
( 'Peter', 'peter@example.com', 'Delhi', '2024-01-07'),
( 'Harish', 'harish@example.com', 'Kochi', '2023-09-26'),
( 'Nihal', 'nihal@example.com', 'London', '2023-04-17'),
( 'Divya', 'divya@example.com', 'Calicut', '2022-02-20'),
( 'Alice Johnson', 'alice@example.com', 'New York', '2023-01-15'),
( 'Charlie Brown', 'charlie@example.com', 'Chicago', '2023-03-05'),
( 'Bob Smith', 'bob@example.com', 'Los Angeles', '2023-02-10'),
( 'Diana Prince', 'diana@example.com', 'Houston', '2023-04-22');

INSERT INTO products (product_id, product_name, category, price) VALUES
(1, 'Wireless Mouse', 'Electronics', 25.99),
(2, 'Bluetooth Speaker', 'Electronics', 45.00),
(3, 'Notebook', 'Stationery', 5.50),
(4, 'Pen Set', 'Stationery', 3.75),
(5, 'Backpack', 'Bags', 35.25);


INSERT INTO orders (order_id, customer_id, order_date, total_amount) VALUES
(101, 1, '2023-05-10', 71.99),
(102, 2, '2023-05-15', 40.75),
(103, 1, '2023-06-01', 5.50),
(104, 3, '2023-06-05', 45.00);

INSERT INTO order_details (order_detail_id, order_id, product_id, quantity, price) VALUES
(1001, 101, 1, 1, 25.99),
(1002, 101, 2, 1, 45.00),
(1003, 102, 4, 2, 3.75),
(1004, 102, 3, 1, 5.50),
(1005, 103, 3, 1, 5.50),
(1006, 104, 2, 1, 45.00);
