-- Run this SQL script in your PostgreSQL database to fix the schema issue
-- Connect to your database: psql -U postgres -d springSecurity

-- Drop tables in correct order (drop dependent tables first)
DROP TABLE IF EXISTS session CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- The application will automatically recreate these tables with the correct schema
-- Make sure application.properties has: spring.jpa.hibernate.ddl-auto=update



