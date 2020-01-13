USE voyageDB;

/*--------------------------------------------------
-- Remplissage des tables de la base de données -- 
--------------------------------------------------*/


/*---------   Table Island  ---------
----------- id_hotel, name ---------- 
-------------------------------------*/
INSERT INTO island VALUES (1,'Mahe');
INSERT INTO island VALUES (2,'Silhouette');
INSERT INTO island VALUES (3,'Conception');
INSERT INTO island VALUES (4,'Therese');
INSERT INTO island VALUES (5,'Sainte Anne');
INSERT INTO island VALUES (6,'Ile au Cerf');
INSERT INTO island VALUES (7,'Praslin');
INSERT INTO island VALUES (8,'La Digue');


/*--------------   Table Hotel  --------------
-- id_hotel, id_island, name, stars, price  -- 
----------------------------------------------*/
INSERT INTO hotel VALUES (1, 1,'Berjaya Beau Vallon Bay', 3, 180); # -4.614931, 55.426747
INSERT INTO hotel VALUES (2, 1,'MAIA Luxury Resort', 5, 2005); # -4.716797, 55.479342
INSERT INTO hotel VALUES (3, 2,'La Belle Tortue', 4, 425); # -4.485815, 55.253051
INSERT INTO hotel VALUES (4, 2,'Hilton Seychelles Labriz', 5, 336); # -4.481282, 55.248330
INSERT INTO hotel VALUES (5, 3,'Le lion d\'or', 3, 155); # -4.660673, 55.362001
INSERT INTO hotel VALUES (6, 3,'Venus', 4, 199); # -4.666522, 55.371957
INSERT INTO hotel VALUES (7, 4,'Sainte Therese', 2, 115); # -4.669209, 55.397591
INSERT INTO hotel VALUES (8, 4,'Pluton', 5, 399); # -4.678122, 55.405005
INSERT INTO hotel VALUES (9, 5,'Mercure', 4, 245); # -4.610455, 55.496891
INSERT INTO hotel VALUES (10, 5,'Le Quincys', 3, 150); # -4.599804, 55.499345
INSERT INTO hotel VALUES (11, 6,'Cerf Island Resort', 4, 413); # -4.630498, 55.493472
INSERT INTO hotel VALUES (12, 6,'Jupiter', 3, 185); # -4.639362, 55.500801
INSERT INTO hotel VALUES (13, 7,'Constance Lemuria', 5, 718); # -4.299230, 55.681470
INSERT INTO hotel VALUES (14, 7,'Hotel L\'Archipel', 4, 349); # -4.319137, 55.763596
INSERT INTO hotel VALUES (15, 8,'L\'Ocean', 2, 139); # -4.337518, 55.832570
INSERT INTO hotel VALUES (16, 8,'La Digue Island Lodge', 4, 228); # -4.354841, 55.826255
INSERT INTO hotel VALUES (17, 1,'Hilltop Boutique Hotel', 3, 119); # -4.622245, 55.446411
INSERT INTO hotel VALUES (18, 1,'Le Nautique Luxury Beachfront Apartments', 4, 204); # -4.747073, 55.515514

/*-----------------------   Table Site  ------------------------
-- id_site, id_island, name, type, activity, monument, price  -- 
----------------------------------------------------------------*/
# 1
INSERT INTO site VALUES (1, 1, 'NAME', 'historic', NULL, 'HISTORIC', XXXX); #
INSERT INTO site VALUES (2, 1, 'NAME', 'historic', NULL, 'HISTORIC', XXXX); #
INSERT INTO site VALUES (3, 1, 'NAME', 'historic', NULL, 'HISTORIC', XXXX); #
INSERT INTO site VALUES (4, 1, 'NAME', 'historic', NULL, 'HISTORIC', XXXX); #
INSERT INTO site VALUES (5, 1, 'NAME', 'historic', NULL, 'HISTORIC', XXXX); #
INSERT INTO site VALUES (6, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (7, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (8, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (9, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (10, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (11, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (12, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (13, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #
INSERT INTO site VALUES (14, 1, 'NAME', 'activity', 'ACTIVITY', NULL, XXXX); #

# 2
INSERT INTO site VALUES (15, 2, 'Silhouette Est', 'historic', NULL, 'Epaves des Premiers Hommes', XXXX); # -4.504413, 55.255792
INSERT INTO site VALUES (16, 2, 'Plage de la Grande Guerre', 'historic', NULL, 'Vestiges de guerre', XXXX); # -4.466778, 55.245835
INSERT INTO site VALUES (17, 2, 'Sihouette Nord', 'historic', NULL, 'Eglise de Silhouette', XXXX); # -4.466108, 55.21219
INSERT INTO site VALUES (18, 2, 'Grand Barbe', 'activity', 'Randonnée Plant Trail', NULL, XXXX); # -4.502474, 55.225150
INSERT INTO site VALUES (19, 2, 'Petite Barbe', 'activity', 'Surf', NULL, XXXX); # -4.488199, 55.212361
INSERT INTO site VALUES (20, 2, 'Silhouette Sud', 'activity', 'Jetski', NULL, XXXX); # -4.512171, 55.23811
INSERT INTO site VALUES (21, 2, 'Silhouette Centre', 'activity', 'Accrobranche', NULL, XXXX); # -4.488056, 55.232961

# 3
INSERT INTO site VALUES (22, 3, 'Conception Nord', 'historic', NULL, 'Mosquée de Conception', XXXX); # -4.659746, 55.364574
INSERT INTO site VALUES (23, 3, 'Conception Ouest', 'historic', NULL, 'Falaises sculptées', XXXX); # -4.664939, 55.363372
INSERT INTO site VALUES (24, 3, 'Conception Sud', 'historic', NULL, 'Temple autochtone', XXXX); # -4.666582, 55.369037
INSERT INTO site VALUES (25, 3, 'Conception Est', 'activity', 'Surf', NULL, XXXX); # -4.662922, 55.37011
INSERT INTO site VALUES (26, 3, 'Conception Centre', 'activity', 'Escalade', NULL, XXXX); # -4.663517, 55.366269
INSERT INTO site VALUES (27, 3, 'Petite Cigale', 'activity', 'Voilier', NULL, XXXX); # -4.661283, 55.360986
INSERT INTO site VALUES (28, 3, 'Grande Cigale', 'activity', 'Discothèque', NULL, XXXX); # -4.666911, 55.373517

# 4
INSERT INTO site VALUES (29, 4, 'Therese Sud', 'historic', NULL, 'Musée naval', XXXX); # -4.67941, 55.40379
INSERT INTO site VALUES (30, 4, 'Therese Est', 'historic', NULL, 'Grand phare de l\'Est', XXXX); # -4.675681, 55.406794
INSERT INTO site VALUES (31, 4, 'Therese Centre', 'historic', NULL, 'Village historique', XXXX); #  -4.673521, 55.400099
INSERT INTO site VALUES (32, 4, 'Oreille de Lapin', 'activity', 'Parapente', NULL, XXXX); # -4.667312, 55.401472
INSERT INTO site VALUES (33, 4, 'Therese Ouest', 'activity', 'Plongée', NULL, XXXX); # -4.675546, 55.399927
INSERT INTO site VALUES (34, 4, 'Le Grand Creux', 'activity', 'Jetski', NULL, XXXX); # -4.670399, 55.40173
INSERT INTO site VALUES (35, 4, 'Therese Nord', 'activity', 'Voilier', NULL, XXXX); #  -4.669508, 55.396923


# 5
INSERT INTO site VALUES (36, 5, 'Sainte Anne Centre', 'historic', NULL, 'Ferme traditionnelle', XXXX); # -4.605047, 55.503517
INSERT INTO site VALUES (37, 5, 'Sainte Anne Sud', 'historic', NULL, 'Visite d\'un bateau pirate', XXXX); # -4.610625, 55.50467
INSERT INTO site VALUES (38, 5, 'Sainte Anne Ouest', 'historic', NULL, 'Grande Ancre de Sainte Anne', XXXX); # -4.601751, 55.497287
INSERT INTO site VALUES (39, 5, 'Anse Mare Jupe, Saffron Avenue', 'activity', 'Tenis', NULL, XXXX); # -4.613921, 55.499825
INSERT INTO site VALUES (40, 5, 'La Retraite', 'activity', 'Rencontre animale', NULL, XXXX); # -4.605297, 55.494748
INSERT INTO site VALUES (41, 5, 'Sainte Anne Est', 'activity', 'Volleyball', NULL, XXXX); #  -4.605737, 55.511477
INSERT INTO site VALUES (42, 5, 'North Coast Road, Ma Constance', 'activity', 'Plongée', NULL, XXXX); # -4.600122, 55.505016

# 6
INSERT INTO site VALUES (43, 6, 'Ile au Cerf Nord', 'historic', NULL, 'Port historique de l\'Ile au Cerf', XXXX); # -4.628564, 55.494748
INSERT INTO site VALUES (44, 6, 'Ile au Cerf Est', 'historic', NULL, 'Eglise de l\'Ile au Cerf', XXXX); # -4.63347, 55.505593
INSERT INTO site VALUES (45, 6, 'Viewpoint Cerf, Cinnamon Drive', 'historic', NULL, 'Cimetière des cerfs', XXXX); # -4.632071, 55.499248
INSERT INTO site VALUES (46, 6, 'L\'Habitation, Cinnamon Drive', 'activity', 'Production locale de rhum', NULL, XXXX); # -4.633317, 55.492903
INSERT INTO site VALUES (47, 6, 'Ile au Cerf Sud', 'activity', 'Discothèque', NULL, XXXX); # -4.639737, 55.501786
INSERT INTO site VALUES (48, 6, 'St. James Chapel, Cinnamon Drive', 'activity', 'Escalade', NULL, XXXX); # -4.634467, 55.497287
INSERT INTO site VALUES (49, 6, 'Cascade', 'activity', 'Voilier', NULL, XXXX); # -4.629886, 55.501671
# 7
INSERT INTO site VALUES (50, 7, 'Salazie-Track, Grande Anse', 'historic', NULL, 'Musée de Praslin', XXXX); # -4.320583, 55.749477
INSERT INTO site VALUES (51, 7, 'Baie Sainte Anne Nord', 'historic', NULL, 'Grotte de Praslin', XXXX); # -4.330251, 55.775721
INSERT INTO site VALUES (52, 7, 'Baie Sainte Anne Sud', 'historic', NULL, 'Plantation traditionnelle', XXXX); # -4.339714, 55.766107
INSERT INTO site VALUES (53, 7, 'Praslin Sud', 'activity', 'Randonnée', NULL, XXXX); # -4.358976, 55.755104
INSERT INTO site VALUES (54, 7, 'Réserve naturelle, Vallée de Mai', 'activity', 'Visite de la réserve naturelle', NULL, XXXX); # -4.329098, 55.740148
INSERT INTO site VALUES (55, 7, 'Praslin Centre', 'activity', 'Escalade', NULL, XXXX); # -4.321836, 55.718036
INSERT INTO site VALUES (56, 7, 'Anse Boudin', 'activity', 'Pêche traditionnelle', NULL, XXXX); # -4.297904, 55.708742

# 8
INSERT INTO site VALUES (57, 8, 'L\'Union Estate Farm, Allée Kersley', 'historic', NULL, 'Ferme taditionnelle sur plantation coloniale', XXXX); # -4.363827, 55.825754
INSERT INTO site VALUES (58, 8, 'Island Bungalow, Allée Kersley', 'historic', NULL, 'Musée de La Digue', XXXX); # -4.341461, 55.833822
INSERT INTO site VALUES (59, 8, 'La Digue Est', 'historic', NULL, 'Eglise de la Digue', XXXX); # -4.359234, 55.848928
INSERT INTO site VALUES (60, 8, 'La Digue Ouest', 'activity', 'Pêche', NULL, XXXX); # -4.350448, 55.829702
INSERT INTO site VALUES (61, 8, 'La Digue Centre', 'activity', 'Equitation', NULL, XXXX); # -4.360005, 55.838628
INSERT INTO site VALUES (62, 8, 'Anse aux Cedres, Way to Anse Marron', 'activity', 'ACTIVITY', NULL, XXXX); # -4.378633, 55.833135
INSERT INTO site VALUES (63, 8, 'Anse Marron, Way to Anse Marron', 'activity', 'Rencontre animale', NULL, XXXX); # -4.381942, 55.8388

