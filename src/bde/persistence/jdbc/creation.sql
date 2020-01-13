DROP DATABASE IF EXISTS voyageDB;
CREATE DATABASE voyageDB;
USE voyageDB;


-----------------------------------------------
-- Création des tables de la base de données -- 
-----------------------------------------------
DROP TABLE IF EXISTS island, hotel, site, station, line, s_belongs_to_l CASCADE;

CREATE TABLE island
(
  id_island    INTEGER NOT NULL,
  name_island  VARCHAR(100),
  PRIMARY KEY (id_Island)
);

CREATE TABLE hotel
(
  id_hotel  	INTEGER NOT NULL,
  id_island 	INTEGER NOT NULL, 
  name_hotel	VARCHAR(100),
  price_hotel   FLOAT,
  PRIMARY KEY (id_hotel),
  FOREIGN KEY (id_island) REFERENCES  island(id_island)
);

CREATE TABLE site 
(
  id_site	  INTEGER NOT NULL,
  id_island	  INTEGER NOT NULL,
  name_site  VARCHAR(100),
  details  	  TEXT,
  type_site  ENUM('activity', 'historic'),
  activity 	  VARCHAR(100),
  monument 	  VARCHAR(100),
  price_site FLOAT,
  PRIMARY KEY (id_site),
  FOREIGN KEY (id_island) REFERENCES island(id_island)
);


CREATE TABLE station 
(
  id_station	INTEGER NOT NULL,
  id_site	  	INTEGER,
  id_hotel  	INTEGER,
  name_station	VARCHAR(100),
  latitude   	FLOAT,
  longitude		FLOAT,
  PRIMARY KEY (id_station),
  FOREIGN KEY (id_site) REFERENCES site(id_site),
  FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel)
);

CREATE TABLE line 
(
  id_line		INTEGER NOT NULL,
  number_line  	INTEGER,
  PRIMARY KEY (id_line)
);

CREATE TABLE s_belongs_to_l
(
  id 			INTEGER NOT NULL,
  id_station	INTEGER NOT NULL,
  id_line		INTEGER NOT NULL,
  station_order	INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (id_station) REFERENCES station(id_station),
  FOREIGN KEY (id_line) REFERENCES line(id_line)
);

--------------------------------------------------
-- Remplissage des tables de la base de données -- 
--------------------------------------------------

