USE VideoGameStore;
GO

PRINT 'Eliminando tablas si existen...';
GO

-- DROP en orden inverso (por FK)
IF OBJECT_ID('sale_coupon', 'U') IS NOT NULL DROP TABLE sale_coupon;
IF OBJECT_ID('sale_detail', 'U') IS NOT NULL DROP TABLE sale_detail;
IF OBJECT_ID('sale', 'U') IS NOT NULL DROP TABLE sale;
IF OBJECT_ID('inventory_log', 'U') IS NOT NULL DROP TABLE inventory_log;
IF OBJECT_ID('inventory', 'U') IS NOT NULL DROP TABLE inventory;
IF OBJECT_ID('game_developer', 'U') IS NOT NULL DROP TABLE game_developer;
IF OBJECT_ID('game_genre', 'U') IS NOT NULL DROP TABLE game_genre;
IF OBJECT_ID('review', 'U') IS NOT NULL DROP TABLE review;
IF OBJECT_ID('library', 'U') IS NOT NULL DROP TABLE library;
IF OBJECT_ID('wishlist', 'U') IS NOT NULL DROP TABLE wishlist;
IF OBJECT_ID('developer', 'U') IS NOT NULL DROP TABLE developer;
IF OBJECT_ID('customer', 'U') IS NOT NULL DROP TABLE customer;
IF OBJECT_ID('game', 'U') IS NOT NULL DROP TABLE game;
IF OBJECT_ID('genre', 'U') IS NOT NULL DROP TABLE genre;
IF OBJECT_ID('platform', 'U') IS NOT NULL DROP TABLE platform;
IF OBJECT_ID('coupon', 'U') IS NOT NULL DROP TABLE coupon;
IF OBJECT_ID('country', 'U') IS NOT NULL DROP TABLE country;
GO

PRINT 'Creando tablas...';
GO

-- BASE
CREATE TABLE country (
    id_country UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name VARCHAR(50) NOT NULL,
    code VARCHAR(10) NOT NULL
);
GO

CREATE TABLE platform (
    id_platform UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name VARCHAR(50) NOT NULL,
    slug VARCHAR(20),
    icon_url VARCHAR(255)
);
GO

CREATE TABLE genre (
    id_genre UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name VARCHAR(50) NOT NULL
);
GO

CREATE TABLE game (
    id_game UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    title VARCHAR(50) NOT NULL,
    base_price DECIMAL(10,2) NOT NULL,
    release_date DATE,
    description VARCHAR(MAX),
    cover_image_url VARCHAR(255),
    is_active BIT NOT NULL DEFAULT 1,
    updated_at DATETIME
);
GO

CREATE TABLE coupon (
    id_coupon UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    code VARCHAR(50) UNIQUE NOT NULL,
    discount_percent DECIMAL(5,2) NOT NULL,
    valid_from DATETIME NOT NULL,
    valid_until DATETIME NOT NULL,
    max_uses INT
);
GO

-- DEPENDIENTES
CREATE TABLE developer (
    id_developer UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name VARCHAR(50) NOT NULL,
    id_country UNIQUEIDENTIFIER NOT NULL,
    website_url VARCHAR(255),
    description VARCHAR(500),
    logo_url VARCHAR(255),
    FOREIGN KEY (id_country) REFERENCES country(id_country)
);
GO

CREATE TABLE customer (
    id_customer UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name VARCHAR(50) NOT NULL,
    profile_name VARCHAR(50),
    last_name VARCHAR(50),
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    registration_date DATE,
    is_verified BIT NOT NULL DEFAULT 0,
    id_country UNIQUEIDENTIFIER NOT NULL,
    deleted_at DATETIME,
    FOREIGN KEY (id_country) REFERENCES country(id_country)
);
GO

-- RELACIONES
CREATE TABLE game_genre (
    id_game UNIQUEIDENTIFIER NOT NULL,
    id_genre UNIQUEIDENTIFIER NOT NULL,
    PRIMARY KEY (id_game, id_genre),
    FOREIGN KEY (id_game) REFERENCES game(id_game),
    FOREIGN KEY (id_genre) REFERENCES genre(id_genre)
);
GO

CREATE TABLE game_developer (
    id_game UNIQUEIDENTIFIER NOT NULL,
    id_developer UNIQUEIDENTIFIER NOT NULL,
    PRIMARY KEY (id_game, id_developer),
    FOREIGN KEY (id_game) REFERENCES game(id_game),
    FOREIGN KEY (id_developer) REFERENCES developer(id_developer)
);
GO

-- OPERACIÓN
CREATE TABLE inventory (
    id_inventory UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    id_game UNIQUEIDENTIFIER NOT NULL,
    id_platform UNIQUEIDENTIFIER NOT NULL,
    stock INT NOT NULL,
    updated_at DATETIME,
    FOREIGN KEY (id_game) REFERENCES game(id_game),
    FOREIGN KEY (id_platform) REFERENCES platform(id_platform)
);
GO

CREATE TABLE inventory_log (
    id_log UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    id_inventory UNIQUEIDENTIFIER NOT NULL,
    movement_type VARCHAR(20) NOT NULL,
    quantity INT NOT NULL,
    reason VARCHAR(255),
    log_date DATETIME NOT NULL,
    FOREIGN KEY (id_inventory) REFERENCES inventory(id_inventory)
);
GO

-- VENTAS
CREATE TABLE sale (
    id_sale UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    sale_date DATETIME NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    id_customer UNIQUEIDENTIFIER NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'pending',
    payment_method VARCHAR(50),
    currency VARCHAR(10) NOT NULL DEFAULT 'USD',
    FOREIGN KEY (id_customer) REFERENCES customer(id_customer)
);
GO

CREATE TABLE sale_detail (
    id_detail UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    id_sale UNIQUEIDENTIFIER NOT NULL,
    id_game UNIQUEIDENTIFIER NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    discount_applied DECIMAL(10,2) DEFAULT 0,
    FOREIGN KEY (id_sale) REFERENCES sale(id_sale),
    FOREIGN KEY (id_game) REFERENCES game(id_game)
);
GO

CREATE TABLE sale_coupon (
    id_sale UNIQUEIDENTIFIER NOT NULL,
    id_coupon UNIQUEIDENTIFIER NOT NULL,
    PRIMARY KEY (id_sale, id_coupon),
    FOREIGN KEY (id_sale) REFERENCES sale(id_sale),
    FOREIGN KEY (id_coupon) REFERENCES coupon(id_coupon)
);
GO

-- INTERACCIÓN
CREATE TABLE review (
    id_review UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    id_customer UNIQUEIDENTIFIER NOT NULL,
    id_game UNIQUEIDENTIFIER NOT NULL,
    rating INT NOT NULL,
    body VARCHAR(MAX),
    created_at DATETIME NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customer(id_customer),
    FOREIGN KEY (id_game) REFERENCES game(id_game)
);
GO

CREATE TABLE library (
    id_library UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    id_customer UNIQUEIDENTIFIER NOT NULL,
    id_game UNIQUEIDENTIFIER NOT NULL,
    acquired_at DATETIME NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customer(id_customer),
    FOREIGN KEY (id_game) REFERENCES game(id_game)
);
GO

CREATE TABLE wishlist (
    id_wishlist UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    id_customer UNIQUEIDENTIFIER NOT NULL,
    id_game UNIQUEIDENTIFIER NOT NULL,
    added_at DATETIME NOT NULL,
    FOREIGN KEY (id_customer) REFERENCES customer(id_customer),
    FOREIGN KEY (id_game) REFERENCES game(id_game)
);
GO

PRINT 'Tablas creadas correctamente en la base de datos VideoGameStore.';
GO
