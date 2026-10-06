INSERT INTO organization (name,description,default_latitude,default_longitude,default_zoom,created_at,updated_at) VALUES ('Greenfield Collective','Local demo organization',45.2550,19.8400,14,NOW(),NOW());
INSERT INTO app_user (email,display_name,active,created_at,updated_at) VALUES ('ana@example.local','Ana',TRUE,NOW(),NOW());
INSERT INTO organization_member (organization_id,user_id,role,created_at) VALUES (1,1,'ADMIN',NOW());
INSERT INTO community_map (organization_id,name,description,visibility,center_latitude,center_longitude,default_zoom,created_at,updated_at) VALUES (1,'Neighborhood atlas','Shared map for local testing','PRIVATE',45.2550,19.8400,14,NOW(),NOW());
INSERT INTO category (map_id,name,description,color,icon,active,created_at,updated_at) VALUES
(1,'Environmental risk','Pollution and environmental concerns','#d95c68','warning',TRUE,NOW(),NOW()),(1,'Community asset','Useful shared places and resources','#2d9877','groups',TRUE,NOW(),NOW()),(1,'Idea','Ideas and proposals','#d99a31','lightbulb',TRUE,NOW(),NOW()),(1,'Water source','Public water points','#4b9bd2','water',TRUE,NOW(),NOW());
INSERT INTO status_definition (map_id,name,display_order,terminal) VALUES (1,'Reported',1,FALSE),(1,'Verified',2,FALSE),(1,'Resolved',3,TRUE);
INSERT INTO map_item (map_id,category_id,status_id,title,description,latitude,longitude,address,created_by,updated_by,created_at,updated_at) VALUES
(1,1,1,'Illegal dumping site','Construction waste beside the creek access road.',45.2670,19.8330,'North Creek trail',1,1,NOW(),NOW()),
(1,2,2,'Riverside community garden','Shared garden with active plots and a compost station.',45.2580,19.8460,'Riverside district',1,1,NOW(),NOW()),
(1,3,1,'Oak tree preservation idea','Protect mature oaks during road works.',45.2520,19.8370,'Old Mill neighborhood',1,1,NOW(),NOW()),
(1,4,3,'Drinking water fountain','Public fountain available for the neighborhood.',45.2550,19.8530,'Central square',1,1,NOW(),NOW());
