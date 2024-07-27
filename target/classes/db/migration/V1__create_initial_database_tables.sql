CREATE TABLE doctor (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         speciality VARCHAR(255),
                         crm VARCHAR(20) NOT NULL,
                         crm_state CHAR(2) NOT NULL,
                         registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patient (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         cpf VARCHAR(11) NOT NULL,
                         registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);