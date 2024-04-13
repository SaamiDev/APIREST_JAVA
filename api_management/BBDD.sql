CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surnames VARCHAR(255),
    dni BIGINT,
    UNIQUE KEY idx_dni (dni) -- Opcional: Si quieres que el DNI sea único
);

CREATE TABLE courier_companies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id VARCHAR(255) NOT NULL,
    image_name VARCHAR(255),
    UNIQUE KEY idx_company_id (company_id)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id VARCHAR(255) NOT NULL,
    order_desc TEXT,
    registration_date DATETIME NOT NULL,
    status ENUM('PENDING', 'IN_PROGRESS', 'COMPLETED') DEFAULT 'PENDING',
    user_id BIGINT,
    courier_company_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (courier_company_id) REFERENCES courier_companies(id),
    UNIQUE KEY idx_order_id (order_id)
);