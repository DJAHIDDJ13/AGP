DROP DATABASE IF EXISTS voyageDB;
CREATE DATABASE voyageDB;
USE voyageDB;


/*-----------------------------------------------
-- Création des tables de la base de données -- 
-----------------------------------------------*/
DROP TABLE IF EXISTS island, hotel, site, station, line, s_belongs_to_l CASCADE;

CREATE TABLE island
(
  id_island    INT NOT NULL,
  name_island  VARCHAR(100),
  PRIMARY KEY (id_Island)
);

CREATE TABLE hotel
(
  id_hotel  	INT NOT NULL,
  id_island 	INT NOT NULL, 
  name_hotel	VARCHAR(100),
  stars         INTEGER,
  price_hotel   INTEGER,
  PRIMARY KEY (id_hotel),
  FOREIGN KEY (id_island) REFERENCES  island(id_island)
);

CREATE TABLE site 
(
  id_site	    INT NOT NULL,
  id_island	    INT NOT NULL,
  name_site     VARCHAR(100),
  type_site     ENUM('activity', 'historic'),
  activity 	    VARCHAR(100),
  monument 	    VARCHAR(100),
  price_site    FLOAT,
  PRIMARY KEY (id_site),
  FOREIGN KEY (id_island) REFERENCES island(id_island)
);


CREATE TABLE station 
(
  id_station	INT NOT NULL,
  id_site	  	INT,
  id_hotel  	INT,    
  name_station  VARCHAR(100),
  latitude   	FLOAT,
  longitude		FLOAT,
  PRIMARY KEY (id_station),
  FOREIGN KEY (id_site) REFERENCES site(id_site),
  FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel)
);

CREATE TABLE line 
(
  id_line		INT NOT NULL,
  type          ENUM('boat', 'bus'),
  price         FLOAT,
  number_line  	INTEGER,
  PRIMARY KEY (id_line)
);

CREATE TABLE s_belongs_to_l
(
  id            INT NOT NULL,
  id_station    INT NOT NULL,
  id_line       INT NOT NULL,
  station_order	INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (id_station) REFERENCES station(id_station),
  FOREIGN KEY (id_line) REFERENCES line(id_line)
);

