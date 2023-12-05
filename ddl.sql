CREATE TABLE PRODUCT(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(200),
    PRICE DOUBLE PRECISION NOT NULL,
    IMAGE_URL VARCHAR(200)
)