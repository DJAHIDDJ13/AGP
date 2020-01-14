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

/*------------   Table Station  ------------
-- id_station, name, latitude, longitude, -- 
--------------------------------------------*/
# HOTELS
INSERT INTO station VALUES (1, 'Hotel Berjaya Beau Vallon Bay', -4.614931, 55.426747);
INSERT INTO station VALUES (2, 'Hotel MAIA Luxury Resort', -4.716797, 55.479342);
INSERT INTO station VALUES (3, 'Hotel La Belle Tortue', -4.485815, 55.253051);
INSERT INTO station VALUES (4, 'Hotel Hilton Seychelles Labriz', -4.481282, 55.248330);
INSERT INTO station VALUES (5, 'Hotel Le lion d\'or', -4.660673, 55.362001);
INSERT INTO station VALUES (6, 'Hotel Venus', -4.666522, 55.371957);
INSERT INTO station VALUES (7, 'Hotel Sainte Therese', -4.669209, 55.397591);
INSERT INTO station VALUES (8, 'Hotel Pluton', -4.678122, 55.405005);
INSERT INTO station VALUES (9, 'Hotel Mercure', -4.610455, 55.496891);
INSERT INTO station VALUES (10, 'Hotel Le Quincys', -4.599804, 55.499345);
INSERT INTO station VALUES (11, 'Hotel Cerf Island Resort', -4.630498, 55.493472);
INSERT INTO station VALUES (12, 'Hotel Jupiter', -4.639362, 55.500801);
INSERT INTO station VALUES (13, 'Hotel Constance Lemuria', -4.299230, 55.681470);
INSERT INTO station VALUES (14, 'Hotel L\'Archipel', -4.319137, 55.763596);
INSERT INTO station VALUES (15, 'Hotel L\'Ocean', -4.337518, 55.832570);
INSERT INTO station VALUES (16, 'Hotel La Digue Island Lodge', -4.354841, 55.826255);
INSERT INTO station VALUES (17, 'Hotel Hilltop Boutique', -4.622245, 55.446411);
INSERT INTO station VALUES (18, 'Hotel Le Nautique Luxury Beachfront', -4.747073, 55.515514);

# SITES
INSERT INTO station VALUES (19, 'Pointe au Sel', -4.710817, 55.519360);
INSERT INTO station VALUES (20, 'Francis Rachel St', -4.623168, 55.452309);
INSERT INTO station VALUES (21, 'Victoria', -4.641255, 55.465292);
INSERT INTO station VALUES (22, 'Rue De La Poudrière', -4.625628, 55.452397);
INSERT INTO station VALUES (23, 'Cap Matoopa', -4.639464, 55.375215);
INSERT INTO station VALUES (24, 'Anse Major Trail', -4.621595, 55.391576);
INSERT INTO station VALUES (25, 'Mare Aux Cochons Trail', -4.626966, 55.420058);
INSERT INTO station VALUES (26, 'Dans Gallas Trail', -4.624341, 55.426691);
INSERT INTO station VALUES (27, 'Glacis La Reserve Trail', -4.706771, 55.500458);
INSERT INTO station VALUES (28, 'Vacoa Nature Trail', -4.682461, 55.455898);
INSERT INTO station VALUES (29, 'Anse Capucin Trail', -4.786514, 55.525911);
INSERT INTO station VALUES (30, 'Morne Blanc Trail', -4.660455, 55.437482);
INSERT INTO station VALUES (31, 'Salazie Trail', -4.652031, 55.445115);
INSERT INTO station VALUES (32, 'Copolia Trail', -4.646963, 55.452784);
INSERT INTO station VALUES (33, 'Sihouette Est', -4.504413, 55.255792);
INSERT INTO station VALUES (34, 'Plage de la Grande Guerre', -4.466778, 55.245835);
INSERT INTO station VALUES (35, 'Sihouette Nord', -4.466108, 55.21219);
INSERT INTO station VALUES (36, 'Grand Barbe', -4.502474, 55.225150);
INSERT INTO station VALUES (37, 'Petite Barbe', -4.488199, 55.212361);
INSERT INTO station VALUES (38, 'Silhouette Sud', -4.512171, 55.23811);
INSERT INTO station VALUES (39, 'Silhouette Centre', -4.488056, 55.232961);
INSERT INTO station VALUES (40, 'Conception Nord', -4.659746, 55.364574);
INSERT INTO station VALUES (41, 'Conception Ouest', -4.664939, 55.363372);
INSERT INTO station VALUES (42, 'Conception Sud', -4.666582, 55.369037);
INSERT INTO station VALUES (43, 'Conception Est', -4.662922, 55.37011);
INSERT INTO station VALUES (44, 'Conception Centre', -4.663517, 55.366269);
INSERT INTO station VALUES (45, 'Petite Cigale', -4.661283, 55.360986);
INSERT INTO station VALUES (46, 'Grande Cigale', -4.666911, 55.373517);
INSERT INTO station VALUES (47, 'Therese Sud', -4.67941, 55.40379);
INSERT INTO station VALUES (48, 'Therese Est', -4.675681, 55.406794);
INSERT INTO station VALUES (49, 'Therese Centre', -4.673521, 55.400099);
INSERT INTO station VALUES (50, 'Oreille de Lapin', -4.667312, 55.401472);
INSERT INTO station VALUES (51, 'Therese Ouest', -4.675546, 55.399927);
INSERT INTO station VALUES (52, 'Le Grand Creux', -4.670399, 55.40173);
INSERT INTO station VALUES (53, 'Therese Nord', -4.669508, 55.396923);
INSERT INTO station VALUES (54, 'Sainte Anne Centre', -4.605047, 55.503517);
INSERT INTO station VALUES (55, 'Sainte Anne Sud', -4.610625, 55.50467);
INSERT INTO station VALUES (56, 'Sainte Anne Ouest', -4.601751, 55.497287);
INSERT INTO station VALUES (57, 'Anse Mare Jupe', -4.613921, 55.499825);
INSERT INTO station VALUES (58, 'La Retraite', -4.605297, 55.494748);
INSERT INTO station VALUES (59, 'Sainte Anne Est', -4.605737, 55.511477);
INSERT INTO station VALUES (60, 'Ma Constance', -4.600122, 55.505016);
INSERT INTO station VALUES (61, 'Ile au Cerf Nord', -4.628564, 55.494748);
INSERT INTO station VALUES (62, 'Ile au Cerf Est', -4.63347, 55.505593);
INSERT INTO station VALUES (63, 'Viewpoint Cerf', -4.632071, 55.499248);
INSERT INTO station VALUES (64, 'L\'Habitation', -4.633317, 55.492903);
INSERT INTO station VALUES (65, 'Ile au Cerf Sud', -4.639737, 55.501786);
INSERT INTO station VALUES (66, 'St. James Chapel', -4.634467, 55.497287);
INSERT INTO station VALUES (67, 'Cascade', -4.629886, 55.501671);
INSERT INTO station VALUES (68, 'Salazie-Track', -4.320583, 55.749477);
INSERT INTO station VALUES (69, 'Baie Sainte Anne Nord', -4.330251, 55.775721);
INSERT INTO station VALUES (70, 'Baie Sainte Anne Sud', -4.339714, 55.766107);
INSERT INTO station VALUES (71, 'Praslin Sud', -4.358976, 55.755104);
INSERT INTO station VALUES (72, 'Vallée de Mai', -4.329098, 55.740148);
INSERT INTO station VALUES (73, 'Praslin Centre', -4.321836, 55.718036);
INSERT INTO station VALUES (74, 'Anse Boudin', -4.297904, 55.708742);
INSERT INTO station VALUES (75, 'Union Estate Farm', -4.363827, 55.825754);
INSERT INTO station VALUES (76, 'Island Bungalow', -4.341461, 55.833822);
INSERT INTO station VALUES (77, 'La Digue Est', -4.359234, 55.848928);
INSERT INTO station VALUES (78, 'La Digue Ouest', -4.350448, 55.829702);
INSERT INTO station VALUES (79, 'La Digue Centre', -4.360005, 55.838628);
INSERT INTO station VALUES (80, 'Anse aux Cedres', -4.378633, 55.833135);
INSERT INTO station VALUES (81, 'Anse Marron', -4.381942, 55.8388);

/*--------------------   Table Hotel  --------------------
-- id_hotel, id_island, id_station, name, stars, price  -- 
----------------------------------------------------------*/
INSERT INTO hotel VALUES (1, 1, 1, 'Berjaya Beau Vallon Bay', 3, 180); # -4.614931, 55.426747
INSERT INTO hotel VALUES (2, 1, 2, 'MAIA Luxury Resort', 5, 2005); # -4.716797, 55.479342
INSERT INTO hotel VALUES (3, 2, 3, 'La Belle Tortue', 4, 425); # -4.485815, 55.253051
INSERT INTO hotel VALUES (4, 2, 4, 'Hilton Seychelles Labriz', 5, 336); # -4.481282, 55.248330
INSERT INTO hotel VALUES (5, 3, 5, 'Le lion d\'or', 3, 155); # -4.660673, 55.362001
INSERT INTO hotel VALUES (6, 3, 6, 'Venus', 4, 199); # -4.666522, 55.371957
INSERT INTO hotel VALUES (7, 4, 7, 'Sainte Therese', 2, 115); # -4.669209, 55.397591
INSERT INTO hotel VALUES (8, 4, 8, 'Pluton', 5, 399); # -4.678122, 55.405005
INSERT INTO hotel VALUES (9, 5, 9, 'Mercure', 4, 245); # -4.610455, 55.496891
INSERT INTO hotel VALUES (10, 5, 10, 'Le Quincys', 3, 150); # -4.599804, 55.499345
INSERT INTO hotel VALUES (11, 6, 11, 'Cerf Island Resort', 4, 413); # -4.630498, 55.493472
INSERT INTO hotel VALUES (12, 6, 12, 'Jupiter', 3, 185); # -4.639362, 55.500801
INSERT INTO hotel VALUES (13, 7, 13, 'Constance Lemuria', 5, 718); # -4.299230, 55.681470
INSERT INTO hotel VALUES (14, 7, 14, 'Hotel L\'Archipel', 4, 349); # -4.319137, 55.763596
INSERT INTO hotel VALUES (15, 8, 15, 'L\'Ocean', 2, 139); # -4.337518, 55.832570
INSERT INTO hotel VALUES (16, 8, 16, 'La Digue Island Lodge', 4, 228); # -4.354841, 55.826255
INSERT INTO hotel VALUES (17, 1, 17, 'Hilltop Boutique Hotel', 3, 119); # -4.622245, 55.446411
INSERT INTO hotel VALUES (18, 1, 18, 'Le Nautique Luxury Beachfront Apartments', 4, 204); # -4.747073, 55.515514

/*-----------------------------   Table Site  ------------------------------
-- id_site, id_island, id_station, name, type, activity, monument, price  -- 
----------------------------------------------------------------------------*/
# 1
INSERT INTO site VALUES (1, 1, 19, 'Pointe au Sel', 'historic', NULL, 'Domaine de Val des Prés', 10); # -4.710817, 55.519360
INSERT INTO site VALUES (2, 1, 20, 'Francis Rachel St', 'historic', NULL, 'Horloge de Victoria', 0); # -4.623168, 55.452309
INSERT INTO site VALUES (3, 1, 21, 'Victoria', 'historic', NULL, 'Eglise Sainte Thérèse Plaisance', 0); # -4.641255, 55.465292
INSERT INTO site VALUES (4, 1, 22, 'Rue De La Poudrière', 'historic', NULL, 'Victoria Mosque', 0); # -4.625628, 55.452397
INSERT INTO site VALUES (5, 1, 23, 'Cap Matoopa', 'historic', NULL, 'Buste de Jean Jaurès', 0); # -4.639464, 55.375215
INSERT INTO site VALUES (6, 1, 24, 'Anse Major Trail', 'activity', 'Randonnée', NULL, 57); # -4.621595, 55.391576
INSERT INTO site VALUES (7, 1, 25, 'Mare Aux Cochons Trail', 'activity', 'Randonnée', NULL, 59); # -4.626966, 55.420058
INSERT INTO site VALUES (8, 1, 26, 'Dans Gallas Trail', 'activity', 'Randonnée', NULL, 45); # -4.624341, 55.426691
INSERT INTO site VALUES (9, 1, 27, 'Glacis La Reserve Trail', 'activity', 'Randonnée', NULL, 49); # -4.706771, 55.500458
INSERT INTO site VALUES (10, 1, 28, 'Vacoa Nature Trail', 'activity', 'Randonnée', NULL, 35); # -4.682461, 55.455898
INSERT INTO site VALUES (11, 1, 29, 'Anse Capucin Trail', 'activity', 'Randonnée', NULL, 35); # -4.786514, 55.525911
INSERT INTO site VALUES (12, 1, 30, 'Morne Blanc Trail', 'activity', 'Randonnée', NULL, 44); # -4.660455, 55.437482
INSERT INTO site VALUES (13, 1, 31, 'Salazie Trail', 'activity', 'Randonnée', NULL, 60); # -4.652031, 55.445115
INSERT INTO site VALUES (14, 1, 32, 'Copolia Trail', 'activity', 'Randonnée', NULL, 59); # -4.646963, 55.452784

# 2
INSERT INTO site VALUES (15, 2, 33, 'Silhouette Est', 'historic', NULL, 'Epaves des Premiers Hommes', 0); # -4.504413, 55.255792
INSERT INTO site VALUES (16, 2, 34, 'Plage de la Grande Guerre', 'historic', NULL, 'Vestiges de guerre', 0); # -4.466778, 55.245835
INSERT INTO site VALUES (17, 2, 35, 'Sihouette Nord', 'historic', NULL, 'Eglise de Silhouette', 0); # -4.466108, 55.21219
INSERT INTO site VALUES (18, 2, 36, 'Grand Barbe', 'activity', 'Randonnée Plant Trail', NULL, 25); # -4.502474, 55.225150
INSERT INTO site VALUES (19, 2, 37, 'Petite Barbe', 'activity', 'Surf', NULL, 25); # -4.488199, 55.212361
INSERT INTO site VALUES (20, 2, 38, 'Silhouette Sud', 'activity', 'Jetski', NULL, 35); # -4.512171, 55.23811
INSERT INTO site VALUES (21, 2, 39, 'Silhouette Centre', 'activity', 'Accrobranche', NULL, 29); # -4.488056, 55.232961

# 3
INSERT INTO site VALUES (22, 3, 40, 'Conception Nord', 'historic', NULL, 'Mosquée de Conception', 0); # -4.659746, 55.364574
INSERT INTO site VALUES (23, 3, 41, 'Conception Ouest', 'historic', NULL, 'Falaises sculptées', 0); # -4.664939, 55.363372
INSERT INTO site VALUES (24, 3, 42, 'Conception Sud', 'historic', NULL, 'Temple autochtone', 0); # -4.666582, 55.369037
INSERT INTO site VALUES (25, 3, 43, 'Conception Est', 'activity', 'Surf', NULL, 27); # -4.662922, 55.37011
INSERT INTO site VALUES (26, 3, 44, 'Conception Centre', 'activity', 'Escalade', NULL, 45); # -4.663517, 55.366269
INSERT INTO site VALUES (27, 3, 45, 'Petite Cigale', 'activity', 'Voilier', NULL, 55); # -4.661283, 55.360986
INSERT INTO site VALUES (28, 3, 46, 'Grande Cigale', 'activity', 'Discothèque', NULL, 10); # -4.666911, 55.373517

# 4
INSERT INTO site VALUES (29, 4, 47, 'Therese Sud', 'historic', NULL, 'Musée naval', 10); # -4.67941, 55.40379
INSERT INTO site VALUES (30, 4, 48, 'Therese Est', 'historic', NULL, 'Grand phare de l\'Est', 0); # -4.675681, 55.406794
INSERT INTO site VALUES (31, 4, 49, 'Therese Centre', 'historic', NULL, 'Village historique', 15); #  -4.673521, 55.400099
INSERT INTO site VALUES (32, 4, 50, 'Oreille de Lapin', 'activity', 'Parapente', NULL, 35); # -4.667312, 55.401472
INSERT INTO site VALUES (33, 4, 51, 'Therese Ouest', 'activity', 'Plongée', NULL, 65); # -4.675546, 55.399927
INSERT INTO site VALUES (34, 4, 52, 'Le Grand Creux', 'activity', 'Jetski', NULL, 49); # -4.670399, 55.40173
INSERT INTO site VALUES (35, 4, 53, 'Therese Nord', 'activity', 'Voilier', NULL, 75); #  -4.669508, 55.396923


# 5
INSERT INTO site VALUES (36, 5, 54, 'Sainte Anne Centre', 'historic', NULL, 'Ferme traditionnelle', 15); # -4.605047, 55.503517
INSERT INTO site VALUES (37, 5, 55, 'Sainte Anne Sud', 'historic', NULL, 'Visite d\'un bateau pirate', 0); # -4.610625, 55.50467
INSERT INTO site VALUES (38, 5, 56, 'Sainte Anne Ouest', 'historic', NULL, 'Grande Ancre de Sainte Anne', 0); # -4.601751, 55.497287
INSERT INTO site VALUES (39, 5, 57, 'Anse Mare Jupe, Saffron Avenue', 'activity', 'Tenis', NULL, 20); # -4.613921, 55.499825
INSERT INTO site VALUES (40, 5, 58, 'La Retraite', 'activity', 'Rencontre animale', NULL, 45); # -4.605297, 55.494748
INSERT INTO site VALUES (41, 5, 59, 'Sainte Anne Est', 'activity', 'Volleyball', NULL, 0); #  -4.605737, 55.511477
INSERT INTO site VALUES (42, 5, 60, 'North Coast Road, Ma Constance', 'activity', 'Plongée', NULL, 79); # -4.600122, 55.505016

# 6
INSERT INTO site VALUES (43, 6, 61, 'Ile au Cerf Nord', 'historic', NULL, 'Port historique de l\'Ile au Cerf', 0); # -4.628564, 55.494748
INSERT INTO site VALUES (44, 6, 62, 'Ile au Cerf Est', 'historic', NULL, 'Eglise de l\'Ile au Cerf', 0); # -4.63347, 55.505593
INSERT INTO site VALUES (45, 6, 63, 'Viewpoint Cerf, Cinnamon Drive', 'historic', NULL, 'Cimetière des cerfs', 0); # -4.632071, 55.499248
INSERT INTO site VALUES (46, 6, 64, 'L\'Habitation, Cinnamon Drive', 'activity', 'Production locale de rhum', NULL, 0); # -4.633317, 55.492903
INSERT INTO site VALUES (47, 6, 65, 'Ile au Cerf Sud', 'activity', 'Discothèque', NULL, 15); # -4.639737, 55.501786
INSERT INTO site VALUES (48, 6, 66, 'St. James Chapel, Cinnamon Drive', 'activity', 'Escalade', NULL, 59); # -4.634467, 55.497287
INSERT INTO site VALUES (49, 6, 67, 'Cascade', 'activity', 'Voilier', NULL, 69); # -4.629886, 55.501671
# 7
INSERT INTO site VALUES (50, 7, 68, 'Salazie-Track, Grande Anse', 'historic', NULL, 'Musée de Praslin', 0); # -4.320583, 55.749477
INSERT INTO site VALUES (51, 7, 69, 'Baie Sainte Anne Nord', 'historic', NULL, 'Grotte de Praslin', 0); # -4.330251, 55.775721
INSERT INTO site VALUES (52, 7, 70, 'Baie Sainte Anne Sud', 'historic', NULL, 'Plantation traditionnelle', 0); # -4.339714, 55.766107
INSERT INTO site VALUES (53, 7, 71, 'Praslin Sud', 'activity', 'Randonnée', NULL, 39); # -4.358976, 55.755104
INSERT INTO site VALUES (54, 7, 72, 'Réserve naturelle, Vallée de Mai', 'activity', 'Visite de la réserve naturelle', NULL, 49); # -4.329098, 55.740148
INSERT INTO site VALUES (55, 7, 73, 'Praslin Centre', 'activity', 'Escalade', NULL, 49); # -4.321836, 55.718036
INSERT INTO site VALUES (56, 7, 74, 'Anse Boudin', 'activity', 'Pêche traditionnelle', NULL, 50); # -4.297904, 55.708742

# 8
INSERT INTO site VALUES (57, 8, 75, 'L\'Union Estate Farm, Allée Kersley', 'historic', NULL, 'Ferme taditionnelle sur plantation coloniale', 9); # -4.363827, 55.825754
INSERT INTO site VALUES (58, 8, 76, 'Island Bungalow, Allée Kersley', 'historic', NULL, 'Musée de La Digue', 10); # -4.341461, 55.833822
INSERT INTO site VALUES (59, 8, 77, 'La Digue Est', 'historic', NULL, 'Eglise de la Digue', 0); # -4.359234, 55.848928
INSERT INTO site VALUES (60, 8, 78, 'La Digue Ouest', 'activity', 'Pêche', NULL, 10); # -4.350448, 55.829702
INSERT INTO site VALUES (61, 8, 79, 'La Digue Centre', 'activity', 'Equitation', NULL, 25); # -4.360005, 55.838628
INSERT INTO site VALUES (62, 8, 80, 'Anse aux Cedres, Way to Anse Marron', 'activity', 'Surf', NULL, 35); # -4.378633, 55.833135
INSERT INTO site VALUES (63, 8, 81, 'Anse Marron, Way to Anse Marron', 'activity', 'Rencontre animale', NULL, 50); # -4.381942, 55.8388

/*------------   Table Line  -----------
-- id_line, type, price, number_line, -- 
----------------------------------------*/
INSERT INTO line VALUES (1, 'bus', 2.5, 1);
INSERT INTO line VALUES (2, 'bus', 2.5, 2);
INSERT INTO line VALUES (3, 'bus', 2.5, 3);
INSERT INTO line VALUES (4, 'bus', 2.5, 4);
INSERT INTO line VALUES (5, 'bus', 5, 5);
INSERT INTO line VALUES (6, 'bus', 5, 6);
INSERT INTO line VALUES (7, 'bus', 5, 7);
INSERT INTO line VALUES (8, 'bus', 7.5, 8);
INSERT INTO line VALUES (9, 'bus', 7.5, 9);
INSERT INTO line VALUES (10, 'bus', 7.5, 10);
INSERT INTO line VALUES (11, 'boat', 25, 1);
INSERT INTO line VALUES (12, 'boat', 25, 2);
INSERT INTO line VALUES (13, 'boat', 25, 3);
INSERT INTO line VALUES (14, 'boat', 25, 4);
INSERT INTO line VALUES (15, 'boat', 25, 5);
INSERT INTO line VALUES (16, 'boat', 25, 6);
INSERT INTO line VALUES (17, 'boat', 25, 7);

/*----------   Table s_belongs_to_l  --------
-- id, id_station, id_line, station_order, -- 
---------------------------------------------*/
# LINE BUS(1)
INSERT INTO s_belongs_to_l VALUES (1, 33, 1, 0);
INSERT INTO s_belongs_to_l VALUES (2, 3, 1, 1);
INSERT INTO s_belongs_to_l VALUES (3, 4, 1, 2);
INSERT INTO s_belongs_to_l VALUES (4, 34, 1, 3);
INSERT INTO s_belongs_to_l VALUES (5, 39, 1, 4);
INSERT INTO s_belongs_to_l VALUES (6, 35, 1, 5);
INSERT INTO s_belongs_to_l VALUES (7, 37, 1, 6);
INSERT INTO s_belongs_to_l VALUES (8, 36, 1, 7);
INSERT INTO s_belongs_to_l VALUES (9, 38, 1, 8);

# LINE BUS(2)
INSERT INTO s_belongs_to_l VALUES (10, 46, 2, 0);
INSERT INTO s_belongs_to_l VALUES (11, 43, 2, 1);
INSERT INTO s_belongs_to_l VALUES (12, 40, 2, 2);
INSERT INTO s_belongs_to_l VALUES (13, 5, 2, 3);
INSERT INTO s_belongs_to_l VALUES (14, 45, 2, 4);
INSERT INTO s_belongs_to_l VALUES (15, 41, 2, 5);
INSERT INTO s_belongs_to_l VALUES (16, 44, 2, 6);
INSERT INTO s_belongs_to_l VALUES (17, 42, 2, 7);
INSERT INTO s_belongs_to_l VALUES (18, 6, 2, 8);

# LINE BUS(3)
INSERT INTO s_belongs_to_l VALUES (19, 7, 3, 0);
INSERT INTO s_belongs_to_l VALUES (20, 51, 3, 1);
INSERT INTO s_belongs_to_l VALUES (21, 47, 3, 2);
INSERT INTO s_belongs_to_l VALUES (22, 8, 3, 3);
INSERT INTO s_belongs_to_l VALUES (23, 48, 3, 4);
INSERT INTO s_belongs_to_l VALUES (24, 49, 3, 5);
INSERT INTO s_belongs_to_l VALUES (25, 52, 3, 6);
INSERT INTO s_belongs_to_l VALUES (26, 50, 3, 7);
INSERT INTO s_belongs_to_l VALUES (27, 53, 3, 8);

# LINE BUS(4)
INSERT INTO s_belongs_to_l VALUES (28, 59, 4, 0);
INSERT INTO s_belongs_to_l VALUES (29, 54, 4, 1);
INSERT INTO s_belongs_to_l VALUES (30, 55, 4, 2);
INSERT INTO s_belongs_to_l VALUES (31, 57, 4, 3);
INSERT INTO s_belongs_to_l VALUES (32, 9, 4, 4);
INSERT INTO s_belongs_to_l VALUES (33, 58, 4, 5);
INSERT INTO s_belongs_to_l VALUES (34, 56, 4, 6);
INSERT INTO s_belongs_to_l VALUES (35, 10, 4, 7);
INSERT INTO s_belongs_to_l VALUES (36, 60, 4, 8);

# LINE BUS(5)
INSERT INTO s_belongs_to_l VALUES (37, 11, 5, 0);
INSERT INTO s_belongs_to_l VALUES (38, 61, 5, 1);
INSERT INTO s_belongs_to_l VALUES (39, 67, 5, 2);
INSERT INTO s_belongs_to_l VALUES (40, 62, 5, 3);
INSERT INTO s_belongs_to_l VALUES (41, 63, 5, 4);
INSERT INTO s_belongs_to_l VALUES (42, 12, 5, 5);
INSERT INTO s_belongs_to_l VALUES (43, 65, 5, 6);
INSERT INTO s_belongs_to_l VALUES (44, 66, 5, 7);
INSERT INTO s_belongs_to_l VALUES (45, 64, 5, 8);

# LINE BUS(6)
INSERT INTO s_belongs_to_l VALUES (46, 13, 6, 0);
INSERT INTO s_belongs_to_l VALUES (47, 73, 6, 1);
INSERT INTO s_belongs_to_l VALUES (48, 72, 6, 2);
INSERT INTO s_belongs_to_l VALUES (49, 71, 6, 3);
INSERT INTO s_belongs_to_l VALUES (50, 70, 6, 4);
INSERT INTO s_belongs_to_l VALUES (51, 69, 6, 5);
INSERT INTO s_belongs_to_l VALUES (52, 14, 6, 6);
INSERT INTO s_belongs_to_l VALUES (53, 68, 6, 7);
INSERT INTO s_belongs_to_l VALUES (54, 74, 6, 8);

# LINE BUS(7)
INSERT INTO s_belongs_to_l VALUES (55, 15, 7, 0);
INSERT INTO s_belongs_to_l VALUES (56, 78, 7, 1);
INSERT INTO s_belongs_to_l VALUES (57, 16, 7, 2);
INSERT INTO s_belongs_to_l VALUES (58, 75, 7, 3);
INSERT INTO s_belongs_to_l VALUES (59, 80, 7, 4);
INSERT INTO s_belongs_to_l VALUES (60, 81, 7, 5);
INSERT INTO s_belongs_to_l VALUES (61, 79, 7, 6);
INSERT INTO s_belongs_to_l VALUES (62, 77, 7, 7);
INSERT INTO s_belongs_to_l VALUES (63, 76, 7, 8);

# LINE BUS(8)
INSERT INTO s_belongs_to_l VALUES (64, 1, 8, 0);
INSERT INTO s_belongs_to_l VALUES (65, 24, 8, 1);
INSERT INTO s_belongs_to_l VALUES (66, 25, 8, 2);
INSERT INTO s_belongs_to_l VALUES (67, 26, 8, 3);
INSERT INTO s_belongs_to_l VALUES (68, 32, 8, 4);
INSERT INTO s_belongs_to_l VALUES (69, 31, 8, 5);
INSERT INTO s_belongs_to_l VALUES (70, 2, 8, 6);
INSERT INTO s_belongs_to_l VALUES (71, 17, 8, 7);
INSERT INTO s_belongs_to_l VALUES (72, 29, 8, 8);
INSERT INTO s_belongs_to_l VALUES (73, 19, 8, 9);
INSERT INTO s_belongs_to_l VALUES (74, 21, 8, 10);
INSERT INTO s_belongs_to_l VALUES (75, 18, 8, 11);
INSERT INTO s_belongs_to_l VALUES (76, 22, 8, 12);
INSERT INTO s_belongs_to_l VALUES (77, 20, 8, 13);

# LINE BUS(9)
INSERT INTO s_belongs_to_l VALUES (78, 20, 9, 0);
INSERT INTO s_belongs_to_l VALUES (79, 32, 9, 1);
INSERT INTO s_belongs_to_l VALUES (80, 31, 9, 2);
INSERT INTO s_belongs_to_l VALUES (81, 30, 9, 3);
INSERT INTO s_belongs_to_l VALUES (82, 28, 9, 4);
INSERT INTO s_belongs_to_l VALUES (83, 2, 9, 5);
INSERT INTO s_belongs_to_l VALUES (84, 27, 9, 6);
INSERT INTO s_belongs_to_l VALUES (85, 19, 9, 7);
INSERT INTO s_belongs_to_l VALUES (86, 21, 9, 8);

# LINE BOAT(1)
INSERT INTO s_belongs_to_l VALUES (87, 33, 1, 0);
INSERT INTO s_belongs_to_l VALUES (88, 1, 1, 1);

# LINE BOAT(2)
INSERT INTO s_belongs_to_l VALUES (89, 46, 2, 0);
INSERT INTO s_belongs_to_l VALUES (90, 7, 2, 1);

# LINE BOAT(3)
INSERT INTO s_belongs_to_l VALUES (91, 8, 3, 0);
INSERT INTO s_belongs_to_l VALUES (92, 2, 3, 1);

# LINE BOAT(4)
INSERT INTO s_belongs_to_l VALUES (93, 18, 4, 0);
INSERT INTO s_belongs_to_l VALUES (94, 12, 4, 1);

# LINE BOAT(5)
INSERT INTO s_belongs_to_l VALUES (95, 1, 5, 0);
INSERT INTO s_belongs_to_l VALUES (96, 9, 5, 1);

# LINE BOAT(6)
INSERT INTO s_belongs_to_l VALUES (97, 59, 6, 0);
INSERT INTO s_belongs_to_l VALUES (98, 13, 6, 1);

# LINE BOAT(7)
INSERT INTO s_belongs_to_l VALUES (99, 14, 7, 0);
INSERT INTO s_belongs_to_l VALUES (100, 15, 7, 1);


