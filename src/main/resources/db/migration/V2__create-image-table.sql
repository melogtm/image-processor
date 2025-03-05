CREATE TABLE images (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    img_url VARCHAR(255) NOT NULL UNIQUE,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);