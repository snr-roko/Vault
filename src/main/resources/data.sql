-- Insert statements for users table
-- Note: ID is auto-generated, so we exclude it from the INSERT

-- User 1
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1990-05-15', 'MALE', '2025-07-15', 'New York', 'john.doe@email.com', 'John', '40.7128,-74.0060', 'Doe', '+1-555-0123', 'New York', '10001');

-- User 2
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1985-03-22', 'FEMALE', '2025-07-15', 'Los Angeles', 'jane.smith@email.com', 'Jane', '34.0522,-118.2437', 'Smith', '+1-555-0456', 'California', '90210');

-- User 3
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1992-08-10', 'MALE', '2025-07-15', 'Chicago', 'mike.johnson@email.com', 'Mike', '41.8781,-87.6298', 'Johnson', '+1-555-0789', 'Illinois', '60601');

-- User 4
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1988-12-03', 'FEMALE', '2025-07-15', 'Houston', 'sarah.williams@email.com', 'Sarah', '29.7604,-95.3698', 'Williams', '+1-555-0321', 'Texas', '77001');

-- User 5
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1995-01-25', 'MALE', '2025-07-15', 'Phoenix', 'david.brown@email.com', 'David', '33.4484,-112.0740', 'Brown', '+1-555-0654', 'Arizona', '85001');

-- User 6
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1987-11-18', 'FEMALE', '2025-07-15', 'Philadelphia', 'emily.davis@email.com', 'Emily', '39.9526,-75.1652', 'Davis', '+1-555-0987', 'Pennsylvania', '19101');

-- User 7
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1993-06-07', 'MALE', '2025-07-15', 'San Antonio', 'chris.miller@email.com', 'Chris', '29.4241,-98.4936', 'Miller', '+1-555-0147', 'Texas', '78201');

-- User 8
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1991-09-14', 'FEMALE', '2025-07-15', 'San Diego', 'lisa.wilson@email.com', 'Lisa', '32.7157,-117.1611', 'Wilson', '+1-555-0258', 'California', '92101');

-- User 9
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1989-04-30', 'MALE', '2025-07-15', 'Dallas', 'robert.moore@email.com', 'Robert', '32.7767,-96.7970', 'Moore', '+1-555-0369', 'Texas', '75201');

-- User 10
INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
VALUES ('2025-07-15', '1994-07-12', 'FEMALE', '2025-07-15', 'San Jose', 'amanda.taylor@email.com', 'Amanda', '37.3382,-121.8863', 'Taylor', '+1-555-0741', 'California', '95101');

-- Template for creating more users:
-- INSERT INTO users (CREATED_AT, DATE_OF_BIRTH, GENDER, UPDATED_AT, CITY, EMAIL, FIRST_NAME, GPS, LAST_NAME, PHONE, REGION, ZIP_CODE)
-- VALUES ('2025-07-15', 'YYYY-MM-DD', 'MALE_or_FEMALE', '2025-07-15', 'City', 'email@domain.com', 'FirstName', 'lat,lng', 'LastName', '+1-555-XXXX', 'Region', 'ZipCode');