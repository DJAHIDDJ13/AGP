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

/*---------   Table Position  ---------
-- id_position, latitude, longitude, -- 
---------------------------------------*/
INSERT INTO coordinate VALUES (1, -4.614931, 55.426747);
INSERT INTO coordinate VALUES (2, -4.716797, 55.479342);
INSERT INTO coordinate VALUES (3, -4.485815, 55.253051);
INSERT INTO coordinate VALUES (4, -4.481282, 55.248330);
INSERT INTO coordinate VALUES (5, -4.660673, 55.362001);
INSERT INTO coordinate VALUES (6, -4.666522, 55.371957);
INSERT INTO coordinate VALUES (7, -4.669209, 55.397591);
INSERT INTO coordinate VALUES (8, -4.678122, 55.405005);
INSERT INTO coordinate VALUES (9, -4.610455, 55.496891);
INSERT INTO coordinate VALUES (10, -4.599804, 55.499345);
INSERT INTO coordinate VALUES (11, -4.630498, 55.493472);
INSERT INTO coordinate VALUES (12, -4.639362, 55.500801);
INSERT INTO coordinate VALUES (13, -4.299230, 55.681470);
INSERT INTO coordinate VALUES (14, -4.319137, 55.763596);
INSERT INTO coordinate VALUES (15, -4.337518, 55.832570);
INSERT INTO coordinate VALUES (16, -4.354841, 55.826255);
INSERT INTO coordinate VALUES (17, -4.622245, 55.446411);
INSERT INTO coordinate VALUES (18, -4.747073, 55.515514);
INSERT INTO coordinate VALUES (19, -4.710817, 55.519360);
INSERT INTO coordinate VALUES (20, -4.623168, 55.452309);
INSERT INTO coordinate VALUES (21, -4.641255, 55.465292);
INSERT INTO coordinate VALUES (22, -4.625628, 55.452397);
INSERT INTO coordinate VALUES (23, -4.639464, 55.375215);
INSERT INTO coordinate VALUES (24, -4.621595, 55.391576);
INSERT INTO coordinate VALUES (25, -4.626966, 55.420058);
INSERT INTO coordinate VALUES (26, -4.624341, 55.426691);
INSERT INTO coordinate VALUES (27, -4.706771, 55.500458);
INSERT INTO coordinate VALUES (28, -4.682461, 55.455898);
INSERT INTO coordinate VALUES (29, -4.786514, 55.525911);
INSERT INTO coordinate VALUES (30, -4.660455, 55.437482);
INSERT INTO coordinate VALUES (31, -4.652031, 55.445115);
INSERT INTO coordinate VALUES (32, -4.646963, 55.452784);
INSERT INTO coordinate VALUES (33, -4.504413, 55.255792);
INSERT INTO coordinate VALUES (34, -4.466778, 55.245835);
INSERT INTO coordinate VALUES (35, -4.466108, 55.21219);
INSERT INTO coordinate VALUES (36, -4.502474, 55.225150);
INSERT INTO coordinate VALUES (37, -4.488199, 55.212361);
INSERT INTO coordinate VALUES (38, -4.512171, 55.23811);
INSERT INTO coordinate VALUES (39, -4.488056, 55.232961);
INSERT INTO coordinate VALUES (40, -4.659746, 55.364574);
INSERT INTO coordinate VALUES (41, -4.664939, 55.363372);
INSERT INTO coordinate VALUES (42, -4.666582, 55.369037);
INSERT INTO coordinate VALUES (43, -4.662922, 55.37011);
INSERT INTO coordinate VALUES (44, -4.663517, 55.366269);
INSERT INTO coordinate VALUES (45, -4.661283, 55.360986);
INSERT INTO coordinate VALUES (46, -4.666911, 55.373517);
INSERT INTO coordinate VALUES (47, -4.67941, 55.40379);
INSERT INTO coordinate VALUES (48, -4.675681, 55.406794);
INSERT INTO coordinate VALUES (49, -4.673521, 55.400099);
INSERT INTO coordinate VALUES (50, -4.667312, 55.401472);
INSERT INTO coordinate VALUES (51, -4.675546, 55.399927);
INSERT INTO coordinate VALUES (52, -4.670399, 55.40173);
INSERT INTO coordinate VALUES (53, -4.669508, 55.396923);
INSERT INTO coordinate VALUES (54, -4.605047, 55.503517);
INSERT INTO coordinate VALUES (55, -4.610625, 55.50467);
INSERT INTO coordinate VALUES (56, -4.601751, 55.497287);
INSERT INTO coordinate VALUES (57, -4.613921, 55.499825);
INSERT INTO coordinate VALUES (58, -4.605297, 55.494748);
INSERT INTO coordinate VALUES (59, -4.605737, 55.511477);
INSERT INTO coordinate VALUES (60, -4.600122, 55.505016);
INSERT INTO coordinate VALUES (61, -4.628564, 55.494748);
INSERT INTO coordinate VALUES (62, -4.63347, 55.505593);
INSERT INTO coordinate VALUES (63, -4.632071, 55.499248);
INSERT INTO coordinate VALUES (64, -4.633317, 55.492903);
INSERT INTO coordinate VALUES (65, -4.639737, 55.501786);
INSERT INTO coordinate VALUES (66, -4.634467, 55.497287);
INSERT INTO coordinate VALUES (67, -4.629886, 55.501671);
INSERT INTO coordinate VALUES (68, -4.320583, 55.749477);
INSERT INTO coordinate VALUES (69, -4.330251, 55.775721);
INSERT INTO coordinate VALUES (70, -4.339714, 55.766107);
INSERT INTO coordinate VALUES (71, -4.358976, 55.755104);
INSERT INTO coordinate VALUES (72, -4.329098, 55.740148);
INSERT INTO coordinate VALUES (73, -4.321836, 55.718036);
INSERT INTO coordinate VALUES (74, -4.297904, 55.708742);
INSERT INTO coordinate VALUES (75, -4.363827, 55.825754);
INSERT INTO coordinate VALUES (76, -4.341461, 55.833822);
INSERT INTO coordinate VALUES (77, -4.359234, 55.848928);
INSERT INTO coordinate VALUES (78, -4.350448, 55.829702);
INSERT INTO coordinate VALUES (79, -4.360005, 55.838628);
INSERT INTO coordinate VALUES (80, -4.378633, 55.833135);
INSERT INTO coordinate VALUES (81, -4.381942, 55.8388);

/*------------------   Table Station  -------------------
-- id_station, id_position, name, latitude, longitude, -- 
---------------------------------------------------------*/
# HOTELS
INSERT INTO station VALUES (1, 1, 'Hotel Berjaya Beau Vallon Bay');
INSERT INTO station VALUES (2, 2, 'Hotel MAIA Luxury Resort');
INSERT INTO station VALUES (3, 3, 'Hotel La Belle Tortue');
INSERT INTO station VALUES (4, 4, 'Hotel Hilton Seychelles Labriz');
INSERT INTO station VALUES (5, 5, 'Hotel Le lion d\'or');
INSERT INTO station VALUES (6, 6, 'Hotel Venus');
INSERT INTO station VALUES (7, 7, 'Hotel Sainte Therese');
INSERT INTO station VALUES (8, 8, 'Hotel Pluton');
INSERT INTO station VALUES (9, 9, 'Hotel Mercure');
INSERT INTO station VALUES (10, 10, 'Hotel Le Quincys');
INSERT INTO station VALUES (11, 11, 'Hotel Cerf Island Resort');
INSERT INTO station VALUES (12, 12, 'Hotel Jupiter');
INSERT INTO station VALUES (13, 13, 'Hotel Constance Lemuria');
INSERT INTO station VALUES (14, 14, 'Hotel L\'Archipel');
INSERT INTO station VALUES (15, 15, 'Hotel L\'Ocean');
INSERT INTO station VALUES (16, 16, 'Hotel La Digue Island Lodge');
INSERT INTO station VALUES (17, 17, 'Hotel Hilltop Boutique');
INSERT INTO station VALUES (18, 18, 'Hotel Le Nautique Luxury Beachfront');

# SITES
INSERT INTO station VALUES (19, 19, 'Pointe au Sel');
INSERT INTO station VALUES (20, 20, 'Francis Rachel St');
INSERT INTO station VALUES (21, 21, 'Victoria');
INSERT INTO station VALUES (22, 22, 'Rue De La Poudrière');
INSERT INTO station VALUES (23, 23, 'Cap Matoopa');
INSERT INTO station VALUES (24, 24, 'Anse Major Trail');
INSERT INTO station VALUES (25, 25, 'Mare Aux Cochons Trail');
INSERT INTO station VALUES (26, 26, 'Dans Gallas Trail');
INSERT INTO station VALUES (27, 27, 'Glacis La Reserve Trail');
INSERT INTO station VALUES (28, 28, 'Vacoa Nature Trail');
INSERT INTO station VALUES (29, 29, 'Anse Capucin Trail');
INSERT INTO station VALUES (30, 30, 'Morne Blanc Trail');
INSERT INTO station VALUES (31, 31, 'Salazie Trail');
INSERT INTO station VALUES (32, 32, 'Copolia Trail');
INSERT INTO station VALUES (33, 33, 'Sihouette Est');
INSERT INTO station VALUES (34, 34, 'Plage de la Grande Guerre');
INSERT INTO station VALUES (35, 35, 'Sihouette Nord');
INSERT INTO station VALUES (36, 36, 'Grand Barbe');
INSERT INTO station VALUES (37, 37, 'Petite Barbe');
INSERT INTO station VALUES (38, 38, 'Silhouette Sud');
INSERT INTO station VALUES (39, 39, 'Silhouette Centre');
INSERT INTO station VALUES (40, 40, 'Conception Nord');
INSERT INTO station VALUES (41, 41, 'Conception Ouest');
INSERT INTO station VALUES (42, 42, 'Conception Sud');
INSERT INTO station VALUES (43, 43, 'Conception Est');
INSERT INTO station VALUES (44, 44, 'Conception Centre');
INSERT INTO station VALUES (45, 45, 'Petite Cigale');
INSERT INTO station VALUES (46, 46, 'Grande Cigale');
INSERT INTO station VALUES (47, 47, 'Therese Sud');
INSERT INTO station VALUES (48, 48, 'Therese Est');
INSERT INTO station VALUES (49, 49, 'Therese Centre');
INSERT INTO station VALUES (50, 50, 'Oreille de Lapin');
INSERT INTO station VALUES (51, 51, 'Therese Ouest');
INSERT INTO station VALUES (52, 52, 'Le Grand Creux');
INSERT INTO station VALUES (53, 53, 'Therese Nord');
INSERT INTO station VALUES (54, 54, 'Sainte Anne Centre');
INSERT INTO station VALUES (55, 55, 'Sainte Anne Sud');
INSERT INTO station VALUES (56, 56, 'Sainte Anne Ouest');
INSERT INTO station VALUES (57, 57, 'Anse Mare Jupe');
INSERT INTO station VALUES (58, 58, 'La Retraite');
INSERT INTO station VALUES (59, 59, 'Sainte Anne Est');
INSERT INTO station VALUES (60, 60, 'Ma Constance');
INSERT INTO station VALUES (61, 61, 'Ile au Cerf Nord');
INSERT INTO station VALUES (62, 62, 'Ile au Cerf Est');
INSERT INTO station VALUES (63, 63, 'Viewpoint Cerf');
INSERT INTO station VALUES (64, 64, 'L\'Habitation');
INSERT INTO station VALUES (65, 65, 'Ile au Cerf Sud');
INSERT INTO station VALUES (66, 66, 'St. James Chapel');
INSERT INTO station VALUES (67, 67, 'Cascade');
INSERT INTO station VALUES (68, 68, 'Salazie-Track');
INSERT INTO station VALUES (69, 69, 'Baie Sainte Anne Nord');
INSERT INTO station VALUES (70, 70, 'Baie Sainte Anne Sud');
INSERT INTO station VALUES (71, 71, 'Praslin Sud');
INSERT INTO station VALUES (72, 72, 'Vallée de Mai');
INSERT INTO station VALUES (73, 73, 'Praslin Centre');
INSERT INTO station VALUES (74, 74, 'Anse Boudin');
INSERT INTO station VALUES (75, 75, 'Union Estate Farm');
INSERT INTO station VALUES (76, 76, 'Island Bungalow');
INSERT INTO station VALUES (77, 77, 'La Digue Est');
INSERT INTO station VALUES (78, 78, 'La Digue Ouest');
INSERT INTO station VALUES (79, 79, 'La Digue Centre');
INSERT INTO station VALUES (80, 80, 'Anse aux Cedres');
INSERT INTO station VALUES (81, 81, 'Anse Marron');


/*--------------------------   Table Hotel  ----------------------------------
-- id_hotel, id_position, id_island, id_station, beach, name, stars, price  -- 
------------------------------------------------------------------------------*/
INSERT INTO hotel VALUES (1, 1, 1, 1, 'Baie Beau Vallon', 'Berjaya Beau Vallon Bay', 3, 180); # -4.614931, 55.426747
INSERT INTO hotel VALUES (2, 2, 1, 2, 'Anse Louis', 'MAIA Luxury Resort', 5, 2005); # -4.716797, 55.479342
INSERT INTO hotel VALUES (3, 3, 2, 3, 'Anse La Passe', 'La Belle Tortue', 4, 425); # -4.485815, 55.253051
INSERT INTO hotel VALUES (4, 4, 2, 4, 'Anse La Passe', 'Hilton Seychelles Labriz', 5, 336); # -4.481282, 55.248330
INSERT INTO hotel VALUES (5, 5, 3, 5, 'Anse Lion', 'Le lion d\'or', 3, 155); # -4.660673, 55.362001
INSERT INTO hotel VALUES (6, 6, 3, 6, 'Anse Vénus', 'Vénus', 4, 199); # -4.666522, 55.371957
INSERT INTO hotel VALUES (7, 7, 4, 7, 'Anse Thérèse', 'Sainte Thérèse', 2, 115); # -4.669209, 55.397591
INSERT INTO hotel VALUES (8, 8, 4, 8, 'Anse Pluton', 'Pluton', 5, 399); # -4.678122, 55.405005
INSERT INTO hotel VALUES (9, 9, 5, 9, 'Anse Mercure', 'Mercure', 4, 245); # -4.610455, 55.496891
INSERT INTO hotel VALUES (10, 10, 5, 10, 'De Quincy', 'Le Quincys', 3, 150); # -4.599804, 55.499345
INSERT INTO hotel VALUES (11, 11, 6, 11, 'Providence', 'Cerf Island Resort', 4, 413); # -4.630498, 55.493472
INSERT INTO hotel VALUES (12, 12, 6, 12, 'Anse Jupiter', 'Jupiter', 3, 185); # -4.639362, 55.500801
INSERT INTO hotel VALUES (13, 13, 7, 13, 'Petite Anse Kerlan', 'Constance Lemuria', 5, 718); # -4.299230, 55.681470
INSERT INTO hotel VALUES (14, 14, 7, 14, 'Anse Gouvernement', 'Hotel L\'Archipel', 4, 349); # -4.319137, 55.763596
INSERT INTO hotel VALUES (15, 15, 8, 15, 'Anse Patates', 'L\'Ocean', 2, 139); # -4.337518, 55.832570
INSERT INTO hotel VALUES (16, 16, 8, 16, 'Anse La Reunion', 'La Digue Island Lodge', 4, 228); # -4.354841, 55.826255
INSERT INTO hotel VALUES (17, 17, 1, 17, 'Anse Nord D\'est', 'Hilltop Boutique Hotel', 3, 119); # -4.622245, 55.446411
INSERT INTO hotel VALUES (18, 18, 1, 18, 'Anse Royale', 'Le Nautique Luxury Beachfront Apartments', 4, 204); # -4.747073, 55.515514

/*-----------------------------------   Table Site  -------------------------------------
-- id_site, id_position, id_island, id_station, name, type, activity, monument, price  -- 
-----------------------------------------------------------------------------------------*/
# 1
INSERT INTO site VALUES (1, 19, 1, 19, 'Pointe au Sel', 'historic', NULL, 'Domaine de Val des Prés', 10); # -4.710817, 55.519360
INSERT INTO site VALUES (2, 20, 1, 20, 'Francis Rachel St', 'historic', NULL, 'Horloge de Victoria', 0); # -4.623168, 55.452309
INSERT INTO site VALUES (3, 21, 1, 21, 'Victoria', 'historic', NULL, 'Eglise Sainte Thérèse Plaisance', 0); # -4.641255, 55.465292
INSERT INTO site VALUES (4, 22, 1, 22, 'Rue De La Poudrière', 'historic', NULL, 'Victoria Mosque', 0); # -4.625628, 55.452397
INSERT INTO site VALUES (5, 23, 1, 23, 'Cap Matoopa', 'historic', NULL, 'Buste de Jean Jaurès', 0); # -4.639464, 55.375215
INSERT INTO site VALUES (6, 24, 1, 24, 'Anse Major Trail', 'activity', 'Randonnée', NULL, 57); # -4.621595, 55.391576
INSERT INTO site VALUES (7, 25, 1, 25, 'Mare Aux Cochons Trail', 'activity', 'Randonnée', NULL, 59); # -4.626966, 55.420058
INSERT INTO site VALUES (8, 26, 1, 26, 'Dans Gallas Trail', 'activity', 'Randonnée', NULL, 45); # -4.624341, 55.426691
INSERT INTO site VALUES (9, 27, 1, 27, 'Glacis La Reserve Trail', 'activity', 'Randonnée', NULL, 49); # -4.706771, 55.500458
INSERT INTO site VALUES (10, 28, 1, 28, 'Vacoa Nature Trail', 'activity', 'Randonnée', NULL, 35); # -4.682461, 55.455898
INSERT INTO site VALUES (11, 29, 1, 29, 'Anse Capucin Trail', 'activity', 'Randonnée', NULL, 35); # -4.786514, 55.525911
INSERT INTO site VALUES (12, 30, 1, 30, 'Morne Blanc Trail', 'activity', 'Randonnée', NULL, 44); # -4.660455, 55.437482
INSERT INTO site VALUES (13, 31, 1, 31, 'Salazie Trail', 'activity', 'Randonnée', NULL, 60); # -4.652031, 55.445115
INSERT INTO site VALUES (14, 32, 1, 32, 'Copolia Trail', 'activity', 'Randonnée', NULL, 59); # -4.646963, 55.452784

# 2
INSERT INTO site VALUES (15, 33, 2, 33, 'Silhouette Est', 'historic', NULL, 'Epaves des Premiers Hommes', 0); # -4.504413, 55.255792
INSERT INTO site VALUES (16, 34, 2, 34, 'Plage de la Grande Guerre', 'historic', NULL, 'Vestiges de guerre', 0); # -4.466778, 55.245835
INSERT INTO site VALUES (17, 35, 2, 35, 'Sihouette Nord', 'historic', NULL, 'Eglise de Silhouette', 0); # -4.466108, 55.21219
INSERT INTO site VALUES (18, 36, 2, 36, 'Grand Barbe', 'activity', 'Randonnée Plant Trail', NULL, 25); # -4.502474, 55.225150
INSERT INTO site VALUES (19, 37, 2, 37, 'Petite Barbe', 'activity', 'Surf', NULL, 25); # -4.488199, 55.212361
INSERT INTO site VALUES (20, 38, 2, 38, 'Silhouette Sud', 'activity', 'Jetski', NULL, 35); # -4.512171, 55.23811
INSERT INTO site VALUES (21, 39, 2, 39, 'Silhouette Centre', 'activity', 'Accrobranche', NULL, 29); # -4.488056, 55.232961

# 3
INSERT INTO site VALUES (22, 40, 3, 40, 'Conception Nord', 'historic', NULL, 'Mosquée de Conception', 0); # -4.659746, 55.364574
INSERT INTO site VALUES (23, 41, 3, 41, 'Conception Ouest', 'historic', NULL, 'Falaises sculptées', 0); # -4.664939, 55.363372
INSERT INTO site VALUES (24, 42, 3, 42, 'Conception Sud', 'historic', NULL, 'Temple autochtone', 0); # -4.666582, 55.369037
INSERT INTO site VALUES (25, 43, 3, 43, 'Conception Est', 'activity', 'Surf', NULL, 27); # -4.662922, 55.37011
INSERT INTO site VALUES (26, 44, 3, 44, 'Conception Centre', 'activity', 'Escalade', NULL, 45); # -4.663517, 55.366269
INSERT INTO site VALUES (27, 45, 3, 45, 'Petite Cigale', 'activity', 'Voilier', NULL, 55); # -4.661283, 55.360986
INSERT INTO site VALUES (28, 46, 3, 46, 'Grande Cigale', 'activity', 'Discothèque', NULL, 10); # -4.666911, 55.373517

# 4
INSERT INTO site VALUES (29, 47, 4, 47, 'Therese Sud', 'historic', NULL, 'Musée naval', 10); # -4.67941, 55.40379
INSERT INTO site VALUES (30, 48, 4, 48, 'Therese Est', 'historic', NULL, 'Grand phare de l\'Est', 0); # -4.675681, 55.406794
INSERT INTO site VALUES (31, 49, 4, 49, 'Therese Centre', 'historic', NULL, 'Village historique', 15); #  -4.673521, 55.400099
INSERT INTO site VALUES (32, 50, 4, 50, 'Oreille de Lapin', 'activity', 'Parapente', NULL, 35); # -4.667312, 55.401472
INSERT INTO site VALUES (33, 51, 4, 51, 'Therese Ouest', 'activity', 'Plongée', NULL, 65); # -4.675546, 55.399927
INSERT INTO site VALUES (34, 52, 4, 52, 'Le Grand Creux', 'activity', 'Jetski', NULL, 49); # -4.670399, 55.40173
INSERT INTO site VALUES (35, 53, 4, 53, 'Therese Nord', 'activity', 'Voilier', NULL, 75); #  -4.669508, 55.396923


# 5
INSERT INTO site VALUES (36, 54, 5, 54, 'Sainte Anne Centre', 'historic', NULL, 'Ferme traditionnelle', 15); # -4.605047, 55.503517
INSERT INTO site VALUES (37, 55, 5, 55, 'Sainte Anne Sud', 'historic', NULL, 'Visite d\'un bateau pirate', 0); # -4.610625, 55.50467
INSERT INTO site VALUES (38, 56, 5, 56, 'Sainte Anne Ouest', 'historic', NULL, 'Grande Ancre de Sainte Anne', 0); # -4.601751, 55.497287
INSERT INTO site VALUES (39, 57, 5, 57, 'Anse Mare Jupe, Saffron Avenue', 'activity', 'Tenis', NULL, 20); # -4.613921, 55.499825
INSERT INTO site VALUES (40, 58, 5, 58, 'La Retraite', 'activity', 'Rencontre animale', NULL, 45); # -4.605297, 55.494748
INSERT INTO site VALUES (41, 59, 5, 59, 'Sainte Anne Est', 'activity', 'Volleyball', NULL, 0); #  -4.605737, 55.511477
INSERT INTO site VALUES (42, 60, 5, 60, 'North Coast Road, Ma Constance', 'activity', 'Plongée', NULL, 79); # -4.600122, 55.505016

# 6
INSERT INTO site VALUES (43, 61, 6, 61, 'Ile au Cerf Nord', 'historic', NULL, 'Port historique de l\'Ile au Cerf', 0); # -4.628564, 55.494748
INSERT INTO site VALUES (44, 62, 6, 62, 'Ile au Cerf Est', 'historic', NULL, 'Eglise de l\'Ile au Cerf', 0); # -4.63347, 55.505593
INSERT INTO site VALUES (45, 63, 6, 63, 'Viewpoint Cerf, Cinnamon Drive', 'historic', NULL, 'Cimetière des cerfs', 0); # -4.632071, 55.499248
INSERT INTO site VALUES (46, 64, 6, 64, 'L\'Habitation, Cinnamon Drive', 'activity', 'Production locale de rhum', NULL, 0); # -4.633317, 55.492903
INSERT INTO site VALUES (47, 65, 6, 65, 'Ile au Cerf Sud', 'activity', 'Discothèque', NULL, 15); # -4.639737, 55.501786
INSERT INTO site VALUES (48, 66, 6, 66, 'St. James Chapel, Cinnamon Drive', 'activity', 'Escalade', NULL, 59); # -4.634467, 55.497287
INSERT INTO site VALUES (49, 67, 6, 67, 'Cascade', 'activity', 'Voilier', NULL, 69); # -4.629886, 55.501671
# 7
INSERT INTO site VALUES (50, 68, 7, 68, 'Salazie-Track, Grande Anse', 'historic', NULL, 'Musée de Praslin', 0); # -4.320583, 55.749477
INSERT INTO site VALUES (51, 69, 7, 69, 'Baie Sainte Anne Nord', 'historic', NULL, 'Grotte de Praslin', 0); # -4.330251, 55.775721
INSERT INTO site VALUES (52, 70, 7, 70, 'Baie Sainte Anne Sud', 'historic', NULL, 'Plantation traditionnelle', 0); # -4.339714, 55.766107
INSERT INTO site VALUES (53, 71, 7, 71, 'Praslin Sud', 'activity', 'Randonnée', NULL, 39); # -4.358976, 55.755104
INSERT INTO site VALUES (54, 72, 7, 72, 'Réserve naturelle, Vallée de Mai', 'activity', 'Visite de la réserve naturelle', NULL, 49); # -4.329098, 55.740148
INSERT INTO site VALUES (55, 73, 7, 73, 'Praslin Centre', 'activity', 'Escalade', NULL, 49); # -4.321836, 55.718036
INSERT INTO site VALUES (56, 74, 7, 74, 'Anse Boudin', 'activity', 'Pêche traditionnelle', NULL, 50); # -4.297904, 55.708742

# 8
INSERT INTO site VALUES (57, 75, 8, 75, 'L\'Union Estate Farm, Allée Kersley', 'historic', NULL, 'Ferme taditionnelle sur plantation coloniale', 9); # -4.363827, 55.825754
INSERT INTO site VALUES (58, 76, 8, 76, 'Island Bungalow, Allée Kersley', 'historic', NULL, 'Musée de La Digue', 10); # -4.341461, 55.833822
INSERT INTO site VALUES (59, 77, 8, 77, 'La Digue Est', 'historic', NULL, 'Eglise de la Digue', 0); # -4.359234, 55.848928
INSERT INTO site VALUES (60, 78, 8, 78, 'La Digue Ouest', 'activity', 'Pêche', NULL, 10); # -4.350448, 55.829702
INSERT INTO site VALUES (61, 79, 8, 79, 'La Digue Centre', 'activity', 'Equitation', NULL, 25); # -4.360005, 55.838628
INSERT INTO site VALUES (62, 80, 8, 80, 'Anse aux Cedres, Way to Anse Marron', 'activity', 'Surf', NULL, 35); # -4.378633, 55.833135
INSERT INTO site VALUES (63, 81, 8, 81, 'Anse Marron, Way to Anse Marron', 'activity', 'Rencontre animale', NULL, 50); # -4.381942, 55.8388

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

INSERT INTO s_belongs_to_l VALUES (101, 33, 1, 8);
INSERT INTO s_belongs_to_l VALUES (102, 3, 1, 7);
INSERT INTO s_belongs_to_l VALUES (103, 4, 1, 6);
INSERT INTO s_belongs_to_l VALUES (104, 34, 1, 5);
INSERT INTO s_belongs_to_l VALUES (105, 39, 1, 4);
INSERT INTO s_belongs_to_l VALUES (106, 35, 1, 3);
INSERT INTO s_belongs_to_l VALUES (107, 37, 1, 2);
INSERT INTO s_belongs_to_l VALUES (108, 36, 1, 1);
INSERT INTO s_belongs_to_l VALUES (109, 38, 1, 0);

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

INSERT INTO s_belongs_to_l VALUES (110, 46, 2, 8);
INSERT INTO s_belongs_to_l VALUES (111, 43, 2, 7);
INSERT INTO s_belongs_to_l VALUES (112, 40, 2, 6);
INSERT INTO s_belongs_to_l VALUES (113, 5, 2, 5);
INSERT INTO s_belongs_to_l VALUES (114, 45, 2, 4);
INSERT INTO s_belongs_to_l VALUES (115, 41, 2, 3);
INSERT INTO s_belongs_to_l VALUES (116, 44, 2, 2);
INSERT INTO s_belongs_to_l VALUES (117, 42, 2, 1);
INSERT INTO s_belongs_to_l VALUES (118, 6, 2, 0);

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

INSERT INTO s_belongs_to_l VALUES (119, 7, 3, 8);
INSERT INTO s_belongs_to_l VALUES (120, 51, 3, 7);
INSERT INTO s_belongs_to_l VALUES (121, 47, 3, 6);
INSERT INTO s_belongs_to_l VALUES (122, 8, 3, 5);
INSERT INTO s_belongs_to_l VALUES (123, 48, 3, 4);
INSERT INTO s_belongs_to_l VALUES (124, 49, 3, 3);
INSERT INTO s_belongs_to_l VALUES (125, 52, 3, 2);
INSERT INTO s_belongs_to_l VALUES (126, 50, 3, 1);
INSERT INTO s_belongs_to_l VALUES (127, 53, 3, 0);

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

INSERT INTO s_belongs_to_l VALUES (128, 59, 4, 8);
INSERT INTO s_belongs_to_l VALUES (129, 54, 4, 7);
INSERT INTO s_belongs_to_l VALUES (130, 55, 4, 6);
INSERT INTO s_belongs_to_l VALUES (131, 57, 4, 5);
INSERT INTO s_belongs_to_l VALUES (132, 9, 4, 4);
INSERT INTO s_belongs_to_l VALUES (133, 58, 4, 3);
INSERT INTO s_belongs_to_l VALUES (134, 56, 4, 2);
INSERT INTO s_belongs_to_l VALUES (135, 10, 4, 1);
INSERT INTO s_belongs_to_l VALUES (136, 60, 4, 0);

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

INSERT INTO s_belongs_to_l VALUES (137, 11, 5, 8);
INSERT INTO s_belongs_to_l VALUES (138, 61, 5, 7);
INSERT INTO s_belongs_to_l VALUES (139, 67, 5, 6);
INSERT INTO s_belongs_to_l VALUES (140, 62, 5, 5);
INSERT INTO s_belongs_to_l VALUES (141, 63, 5, 4);
INSERT INTO s_belongs_to_l VALUES (142, 12, 5, 3);
INSERT INTO s_belongs_to_l VALUES (143, 65, 5, 2);
INSERT INTO s_belongs_to_l VALUES (144, 66, 5, 1);
INSERT INTO s_belongs_to_l VALUES (145, 64, 5, 0);

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

INSERT INTO s_belongs_to_l VALUES (146, 13, 6, 8);
INSERT INTO s_belongs_to_l VALUES (147, 73, 6, 7);
INSERT INTO s_belongs_to_l VALUES (148, 72, 6, 6);
INSERT INTO s_belongs_to_l VALUES (149, 71, 6, 5);
INSERT INTO s_belongs_to_l VALUES (150, 70, 6, 4);
INSERT INTO s_belongs_to_l VALUES (151, 69, 6, 3);
INSERT INTO s_belongs_to_l VALUES (152, 14, 6, 2);
INSERT INTO s_belongs_to_l VALUES (153, 68, 6, 1);
INSERT INTO s_belongs_to_l VALUES (154, 74, 6, 0);

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

INSERT INTO s_belongs_to_l VALUES (155, 15, 7, 8);
INSERT INTO s_belongs_to_l VALUES (156, 78, 7, 7);
INSERT INTO s_belongs_to_l VALUES (157, 16, 7, 6);
INSERT INTO s_belongs_to_l VALUES (158, 75, 7, 5);
INSERT INTO s_belongs_to_l VALUES (159, 80, 7, 4);
INSERT INTO s_belongs_to_l VALUES (160, 81, 7, 3);
INSERT INTO s_belongs_to_l VALUES (161, 79, 7, 2);
INSERT INTO s_belongs_to_l VALUES (162, 77, 7, 1);
INSERT INTO s_belongs_to_l VALUES (163, 76, 7, 0);

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

INSERT INTO s_belongs_to_l VALUES (164, 1, 8, 13);
INSERT INTO s_belongs_to_l VALUES (165, 24, 8, 12);
INSERT INTO s_belongs_to_l VALUES (166, 25, 8, 11);
INSERT INTO s_belongs_to_l VALUES (167, 26, 8, 10);
INSERT INTO s_belongs_to_l VALUES (168, 32, 8, 9);
INSERT INTO s_belongs_to_l VALUES (169, 31, 8, 8);
INSERT INTO s_belongs_to_l VALUES (170, 2, 8, 7);
INSERT INTO s_belongs_to_l VALUES (171, 17, 8, 6);
INSERT INTO s_belongs_to_l VALUES (172, 29, 8, 5);
INSERT INTO s_belongs_to_l VALUES (173, 19, 8, 4);
INSERT INTO s_belongs_to_l VALUES (174, 21, 8, 3);
INSERT INTO s_belongs_to_l VALUES (175, 18, 8, 2);
INSERT INTO s_belongs_to_l VALUES (176, 22, 8, 1);
INSERT INTO s_belongs_to_l VALUES (177, 20, 8, 0);


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

INSERT INTO s_belongs_to_l VALUES (178, 20, 9, 7);
INSERT INTO s_belongs_to_l VALUES (179, 32, 9, 6);
INSERT INTO s_belongs_to_l VALUES (180, 31, 9, 5);
INSERT INTO s_belongs_to_l VALUES (181, 30, 9, 4);
INSERT INTO s_belongs_to_l VALUES (182, 28, 9, 3);
INSERT INTO s_belongs_to_l VALUES (183, 2, 9, 2);
INSERT INTO s_belongs_to_l VALUES (184, 27, 9, 2);
INSERT INTO s_belongs_to_l VALUES (185, 19, 9, 1);
INSERT INTO s_belongs_to_l VALUES (186, 21, 9, 0);

# LINE BOAT(1)
INSERT INTO s_belongs_to_l VALUES (87, 33, 1, 0);
INSERT INTO s_belongs_to_l VALUES (88, 1, 1, 1);

INSERT INTO s_belongs_to_l VALUES (187, 33, 1, 1);
INSERT INTO s_belongs_to_l VALUES (188, 1, 1, 0);

# LINE BOAT(2)
INSERT INTO s_belongs_to_l VALUES (89, 46, 2, 0);
INSERT INTO s_belongs_to_l VALUES (90, 7, 2, 1);

INSERT INTO s_belongs_to_l VALUES (189, 46, 2, 1);
INSERT INTO s_belongs_to_l VALUES (190, 7, 2, 0);

# LINE BOAT(3)
INSERT INTO s_belongs_to_l VALUES (91, 8, 3, 0);
INSERT INTO s_belongs_to_l VALUES (92, 2, 3, 1);

INSERT INTO s_belongs_to_l VALUES (191, 8, 3, 1);
INSERT INTO s_belongs_to_l VALUES (192, 2, 3, 0);

# LINE BOAT(4)
INSERT INTO s_belongs_to_l VALUES (93, 18, 4, 0);
INSERT INTO s_belongs_to_l VALUES (94, 12, 4, 1);

INSERT INTO s_belongs_to_l VALUES (193, 18, 4, 1);
INSERT INTO s_belongs_to_l VALUES (194, 12, 4, 0);

# LINE BOAT(5)
INSERT INTO s_belongs_to_l VALUES (95, 1, 5, 0);
INSERT INTO s_belongs_to_l VALUES (96, 9, 5, 1);

INSERT INTO s_belongs_to_l VALUES (195, 1, 5, 1);
INSERT INTO s_belongs_to_l VALUES (196, 9, 5, 0);

# LINE BOAT(6)
INSERT INTO s_belongs_to_l VALUES (97, 59, 6, 0);
INSERT INTO s_belongs_to_l VALUES (98, 13, 6, 1);

INSERT INTO s_belongs_to_l VALUES (197, 59, 6, 1);
INSERT INTO s_belongs_to_l VALUES (198, 13, 6, 0);

# LINE BOAT(7)
INSERT INTO s_belongs_to_l VALUES (99, 14, 7, 0);
INSERT INTO s_belongs_to_l VALUES (100, 15, 7, 1);

INSERT INTO s_belongs_to_l VALUES (199, 14, 7, 1);
INSERT INTO s_belongs_to_l VALUES (200, 15, 7, 0);
