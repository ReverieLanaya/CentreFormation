DROP DATABASE IF EXISTS centre_formation;
CREATE DATABASE centre_formation;
USE centre_formation;

-- =========================
-- TABLE Address

CREATE TABLE c_address (
    id_address INT AUTO_INCREMENT PRIMARY KEY,
    a_street VARCHAR(50),
    a_city VARCHAR(50),
    a_postal_code VARCHAR(10),
    a_country VARCHAR(50)
) ENGINE=InnoDB;

-- =========================
-- TABLE Customer

CREATE TABLE c_customer (
    id_customer INT AUTO_INCREMENT PRIMARY KEY,
    c_name VARCHAR(50) NOT NULL,
    c_phone_number VARCHAR(20) NOT NULL,
    c_email VARCHAR(50) NOT NULL,
    c_username VARCHAR(20) NOT NULL,
    c_password VARCHAR(50) NOT NULL,
    id_address INT,
    CONSTRAINT fk_customer_address
        FOREIGN KEY (id_address) REFERENCES c_address(id_address)
) ENGINE=InnoDB;

-- =========================
-- TABLE Cart

CREATE TABLE c_cart (
    id_cart INT AUTO_INCREMENT PRIMARY KEY
) ENGINE=InnoDB;

-- =========================
-- TABLE Delivery Address

CREATE TABLE c_delivery_address (
    id_delivery_address INT AUTO_INCREMENT PRIMARY KEY,
    d_firstname VARCHAR(50) NOT NULL,
    d_lastname VARCHAR(50) NOT NULL,
    d_email VARCHAR(50) NOT NULL,
    d_phone_number VARCHAR(20) NOT NULL
) ENGINE=InnoDB;

-- =========================
-- TABLE Order

CREATE TABLE c_order (
    id_order INT AUTO_INCREMENT PRIMARY KEY,
    c_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_cart INT NOT NULL,
    id_delivery_address INT NOT NULL,
    CONSTRAINT fk_order_cart
        FOREIGN KEY (id_cart) REFERENCES c_cart(id_cart),
    CONSTRAINT fk_order_delivery
        FOREIGN KEY (id_delivery_address) REFERENCES c_delivery_address(id_delivery_address)
) ENGINE=InnoDB;

-- =========================
-- TABLE Product

CREATE TABLE c_product (
    id_product INT AUTO_INCREMENT PRIMARY KEY,
    p_name VARCHAR(50) NOT NULL,
    p_description TEXT,
    p_length INT,
    p_workplace VARCHAR(20),
    p_price DECIMAL(10,2)
) ENGINE=InnoDB;

-- =========================
-- TABLE RELATION Product / Cart 

CREATE TABLE c_product_cart (
    id_product INT NOT NULL,
    id_cart INT NOT NULL,
    pc_quantity INT NOT NULL,
    PRIMARY KEY (id_product, id_cart),
    CONSTRAINT fk_pc_product
        FOREIGN KEY (id_product) REFERENCES c_product(id_product),
    CONSTRAINT fk_pc_cart
        FOREIGN KEY (id_cart) REFERENCES c_cart(id_cart)
) ENGINE=InnoDB;

-- =========================
-- INSERT PRODUCTS

INSERT INTO c_product (p_name, p_description, p_length, p_workplace, p_price) VALUES
('Java', 'Java SE 8 : Syntaxe & POO', 20, 'Présentiel', 700),
('Java Avancé', 'Exceptions, fichiers, JDBC, threads', 20, 'Présentiel', 700),
('Spring', 'Spring Core / MVC / Security', 20, 'Distanciel', 700),
('PHP Framework', 'Symfony', 15, 'Distanciel', 500),
('C#', 'DotNet Core', 20, 'Présentiel', 700),
('Python', 'Python : Syntaxe & POO', 20, 'Présentiel', 700),
('Python Avancé', 'Thread, DAO', 20, 'Présentiel', 700),
('Cuisine base', 'Outils de base et cuissons', 20, 'Présentiel', 700),
('Cuisine avancée', 'Gastronomie et ingrédients sensibles', 20, 'Présentiel', 900);
