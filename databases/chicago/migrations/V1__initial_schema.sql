CREATE TABLE chicago_table (
id  INT NOT NULL AUTO_INCREMENT,
tire_num    INT,
vehicle_id  INT,
latitude    VARCHAR(255),
longitude   VARCHAR(255),
address VARCHAR(255),

PRIMARY KEY (id)
)

DEFAULT CHARSET = utf8;