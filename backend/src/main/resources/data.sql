-- Categories
INSERT INTO categories (name, slug) VALUES ('Electronics', 'electronics') ON CONFLICT DO NOTHING;
INSERT INTO categories (name, slug) VALUES ('Clothing', 'clothing') ON CONFLICT DO NOTHING;
INSERT INTO categories (name, slug) VALUES ('Books', 'books') ON CONFLICT DO NOTHING;

-- Products (category_id 1 = Electronics)
INSERT INTO products (id, category_id, name, description, price, stock_quantity, active, created_at)
VALUES
    (gen_random_uuid(), 1, 'iPhone 15', 'Latest Apple smartphone', 999.99, 50, true, NOW()),
    (gen_random_uuid(), 1, 'MacBook Pro', 'M3 chip laptop', 1999.99, 20, true, NOW()),
    (gen_random_uuid(), 2, 'Nike T-Shirt', 'Cotton crew neck', 29.99, 200, true, NOW()),
    (gen_random_uuid(), 3, 'Clean Code', 'Robert C. Martin', 34.99, 100, true, NOW())
    ON CONFLICT DO NOTHING;