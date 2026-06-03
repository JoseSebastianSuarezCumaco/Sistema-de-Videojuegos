CREATE TABLE [country] (
  [id_country] uuid PRIMARY KEY,
  [name] varchar(50) NOT NULL,
  [code] varchar(10) NOT NULL
)
GO

CREATE TABLE [developer] (
  [id_developer] uuid PRIMARY KEY,
  [name] varchar(50) NOT NULL,
  [id_country] uuid NOT NULL,
  [website_url] varchar(255),
  [description] varchar(500),
  [logo_url] varchar(255)
)
GO

CREATE TABLE [platform] (
  [id_platform] uuid PRIMARY KEY,
  [name] varchar(50) NOT NULL,
  [slug] varchar(20),
  [icon_url] varchar(255)
)
GO

CREATE TABLE [genre] (
  [id_genre] uuid PRIMARY KEY,
  [name] varchar(50) NOT NULL
)
GO

CREATE TABLE [game] (
  [id_game] uuid PRIMARY KEY,
  [title] varchar(50) NOT NULL,
  [base_price] decimal(10,2) NOT NULL,
  [release_date] date,
  [description] text,
  [cover_image_url] varchar(255),
  [is_active] boolean NOT NULL DEFAULT (true),
  [updated_at] datetime
)
GO

CREATE TABLE [game_genre] (
  [id_game] uuid NOT NULL,
  [id_genre] uuid NOT NULL
)
GO

CREATE TABLE [game_developer] (
  [id_game] uuid NOT NULL,
  [id_developer] uuid NOT NULL
)
GO

CREATE TABLE [inventory] (
  [id_inventory] uuid PRIMARY KEY,
  [id_game] uuid NOT NULL,
  [id_platform] uuid NOT NULL,
  [stock] int NOT NULL,
  [updated_at] datetime
)
GO

CREATE TABLE [inventory_log] (
  [id_log] uuid PRIMARY KEY,
  [id_inventory] uuid NOT NULL,
  [movement_type] varchar(20) NOT NULL,
  [quantity] int NOT NULL,
  [reason] varchar(255),
  [log_date] datetime NOT NULL
)
GO

CREATE TABLE [customer] (
  [id_customer] uuid PRIMARY KEY,
  [name] varchar(50) NOT NULL,
  [profile_name] varchar(50),
  [last_name] varchar(50),
  [password] varchar(50) NOT NULL,
  [email] varchar(50) UNIQUE NOT NULL,
  [registration_date] date,
  [is_verified] boolean NOT NULL DEFAULT (false),
  [id_country] uuid NOT NULL,
  [deleted_at] datetime
)
GO

CREATE TABLE [sale] (
  [id_sale] uuid PRIMARY KEY,
  [sale_date] datetime NOT NULL,
  [total] decimal(10,2) NOT NULL,
  [id_customer] uuid NOT NULL,
  [status] varchar(20) NOT NULL DEFAULT 'pending',
  [payment_method] varchar(50),
  [currency] varchar(10) NOT NULL DEFAULT 'USD'
)
GO

CREATE TABLE [sale_detail] (
  [id_detail] uuid PRIMARY KEY,
  [id_sale] uuid NOT NULL,
  [id_game] uuid NOT NULL,
  [quantity] int NOT NULL,
  [unit_price] decimal(10,2) NOT NULL,
  [discount_applied] decimal(10,2) DEFAULT (0)
)
GO

CREATE TABLE [review] (
  [id_review] uuid PRIMARY KEY,
  [id_customer] uuid NOT NULL,
  [id_game] uuid NOT NULL,
  [rating] int NOT NULL,
  [body] text,
  [created_at] datetime NOT NULL
)
GO

CREATE TABLE [library] (
  [id_library] uuid PRIMARY KEY,
  [id_customer] uuid NOT NULL,
  [id_game] uuid NOT NULL,
  [acquired_at] datetime NOT NULL
)
GO

CREATE TABLE [wishlist] (
  [id_wishlist] uuid PRIMARY KEY,
  [id_customer] uuid NOT NULL,
  [id_game] uuid NOT NULL,
  [added_at] datetime NOT NULL
)
GO

CREATE TABLE [coupon] (
  [id_coupon] uuid PRIMARY KEY,
  [code] varchar(50) UNIQUE NOT NULL,
  [discount_percent] decimal(5,2) NOT NULL,
  [valid_from] datetime NOT NULL,
  [valid_until] datetime NOT NULL,
  [max_uses] int
)
GO

CREATE TABLE [sale_coupon] (
  [id_sale] uuid NOT NULL,
  [id_coupon] uuid NOT NULL
)
GO

ALTER TABLE [developer] ADD FOREIGN KEY ([id_country]) REFERENCES [country] ([id_country])
GO

ALTER TABLE [game_genre] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [game_genre] ADD FOREIGN KEY ([id_genre]) REFERENCES [genre] ([id_genre])
GO

ALTER TABLE [game_developer] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [game_developer] ADD FOREIGN KEY ([id_developer]) REFERENCES [developer] ([id_developer])
GO

ALTER TABLE [inventory] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [inventory] ADD FOREIGN KEY ([id_platform]) REFERENCES [platform] ([id_platform])
GO

ALTER TABLE [inventory_log] ADD FOREIGN KEY ([id_inventory]) REFERENCES [inventory] ([id_inventory])
GO

ALTER TABLE [customer] ADD FOREIGN KEY ([id_country]) REFERENCES [country] ([id_country])
GO

ALTER TABLE [sale] ADD FOREIGN KEY ([id_customer]) REFERENCES [customer] ([id_customer])
GO

ALTER TABLE [sale_detail] ADD FOREIGN KEY ([id_sale]) REFERENCES [sale] ([id_sale])
GO

ALTER TABLE [sale_detail] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [review] ADD FOREIGN KEY ([id_customer]) REFERENCES [customer] ([id_customer])
GO

ALTER TABLE [review] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [library] ADD FOREIGN KEY ([id_customer]) REFERENCES [customer] ([id_customer])
GO

ALTER TABLE [library] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [wishlist] ADD FOREIGN KEY ([id_customer]) REFERENCES [customer] ([id_customer])
GO

ALTER TABLE [wishlist] ADD FOREIGN KEY ([id_game]) REFERENCES [game] ([id_game])
GO

ALTER TABLE [sale_coupon] ADD FOREIGN KEY ([id_sale]) REFERENCES [sale] ([id_sale])
GO

ALTER TABLE [sale_coupon] ADD FOREIGN KEY ([id_coupon]) REFERENCES [coupon] ([id_coupon])
GO
