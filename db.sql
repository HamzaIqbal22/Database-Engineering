
CREATE TABLE player(
playerID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
name VARCHAR (255)  NOT NULL,
age INTEGER NOT NULL,
position VARCHAR (255) NOT NULL,
Country VARCHAR(255) NOT NULL,
team_name VARCHAR (255) NOT NULL,
CONSTRAINT fk_team_name FOREIGN KEY (team_name) REFERENCES team (teamName)
)
;

INSERT INTO player VALUES (1,'LeBron James',38,'SF','USA','Los Angeles Lakers');
INSERT INTO player VALUES (2,'Kevin Durant',34,'SF','USA','Phoenix Suns');
INSERT INTO player VALUES (3,'Stephen Curry',34,'PG','USA','Golden State Warriors');
INSERT INTO player VALUES (4,'Ja Morant',23,'PG','USA','Memphis Grizzlies');
INSERT INTO player VALUES (5,'Joel Embiid',28,'C','Cameroon','Philadelphia 76ers');
INSERT INTO player VALUES (6,'Luka Doncic',24,'SF','USA','Dallas Mavericks');
INSERT INTO player VALUES (7,'Jayson Tatum',33,'SF','USA','Boston Celtics');
INSERT INTO player VALUES (8,'Andrew Wiggins',28,'SF','Canada','Golden State Warriors');
INSERT INTO player VALUES (9,'Nikola Jokic',28,'C','Serbia','Denver Nuggets');
INSERT INTO player VALUES (10,'Giannis Antetokounmpo',28,'PF','Greece','Milwaukee Bucks');



CREATE TABLE stats(
statID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,    
name VARCHAR (255) NOT NULL,
pointsPG REAL NOT NULL,
assistsPG REAL NOT NULL,
reboundsPG REAL NOT NULL,
blocksPG REAL NOT NULL,
stealsPG REAL NOT NULL)
;

CREATE TABLE awards(
awardID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,   
awardee_name VARCHAR (255) NOT NULL,
MVPS INTEGER NOT NULL,
NumofAllStars INTEGER NOT NULL,
NumofChampionships INTEGER NOT NULL)
;

CREATE TABLE physicalprofile(    
profileID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
name VARCHAR (255) PRIMARY KEY NOT NULL,
height VARCHAR NOT NULL,
weight REAL NOT NULL,
Wingspan VARCHAR NOT NULL)
;

CREATE TABLE team(
teamID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
teamName VARCHAR (255) UNIQUE NOT NULL,
conference VARCHAR (255) NOT NULL,
wins INTEGER NOT NULL,
losses INTEGER  NOT NULL,
ranking INTEGER UNIQUE NOT NULL)
;


CREATE TABLE player_possess_profile(
playerID INTEGER PRIMARY KEY AUTO INCREMENT NOT NULL,
profileID INTEGER UNIQUE NOT NULL,
CONSTRAINT fkprofileID FOREIGN KEY (profileID) REFERENCES physicalprofile (profileID))
;

CREATE TABLE player_accumulate_stats(
playerID INTEGER PRIMARY KEY, AUTOINCREMENT NOT NULL,
statID INTEGER UNIQUE NOT NULL,
CONSTRAINT fkstatID FOREIGN KEY (statID) REFERENCES stats (statID))
;

CREATE TABLE player_earn_awards(
awardID INTEGER PRIMARY KEY, AUTOINCREMENT NOT NULL,  
playerID INTEGER UNIQUE, AUTOINCREMENT NOT NULL,    
cONSTRAINT fkplayerID FOREIGN KEY (playerID) REFERENCES player (playerID))
;

CREATE TABLE stats_results_in_awards(
awardID INTEGER PRIMARY KEY, AUTOINCREMENT NOT NULL,
statID INTEGER UNIQUE, AUTOINCREMENT NOT NULL,   
awardee_name VARCHAR (255) PRIMARY KEY NOT NULL,
CONSTRAINT fkstatID FOREIGN KEY (sp_name) REFERENCES stats (statID),
CONSTRAINT fkawardee_name FOREIGN KEY (awardee_name) REFERENCES awards (awardee_name))
;



INSERT INTO player VALUES ('LeBron James',38,'SF','USA','Los Angeles Lakers');
INSERT INTO player VALUES ('Kevin Durant',34,'SF','USA','Phoenix Suns');
INSERT INTO player VALUES ('Stephen Curry',34,'PG','USA','Golden State Warriors');
INSERT INTO player VALUES ('Ja Morant',23,'PG','USA','Memphis Grizzlies');
INSERT INTO player VALUES ('Joel Embiid',28,'C','Cameroon','Philadelphia 76ers');
INSERT INTO player VALUES ('Luka Doncic',24,'SF','USA','Dallas Mavericks');
INSERT INTO player VALUES ('Jayson Tatum',33,'SF','USA','Boston Celtics');
INSERT INTO player VALUES ('Andrew Wiggins',28,'SF','Canada','Golden State Warriors');
INSERT INTO player VALUES ('Nikola Jokic',28,'C','Serbia','Denver Nuggets');
INSERT INTO player VALUES ('Giannis Antetokounmpo',28,'PF','Greece','Milwaukee Bucks');

INSERT INTO stats VALUES ('LeBron James',28.3,7.3,6.4,1.2,2.3);
INSERT INTO stats VALUES ('Kevin Durant',30.1,4.1,7.5,2.6,1.9);
INSERT INTO stats VALUES ('Stephen Curry',27.7,7.7,4.2,0.6,1.7);
INSERT INTO stats VALUES ('Ja Morant',25.4,8.4,6.7,1.2,4.1);
INSERT INTO stats VALUES ('Joel Embiid',28.2,1.6,12.2,3.4,0.8);
INSERT INTO stats VALUES ('Luka Doncic',24.3,8.8,7.2,0.6,0.9);
INSERT INTO stats VALUES ('Jayson Tatum',30.1,5.5,8.3,1.5,1.7);
INSERT INTO stats VALUES ('Andrew Wiggins',21.5,2.2,7.4,1.6,2.2);
INSERT INTO stats VALUES ('Nikola Jokic',28.5,8.9,11.1,2.8,0.4);
INSERT INTO stats VALUES ('Giannis Antetokounmpo',32.2,7.8,11.1,4.2,2.1);


INSERT INTO awards VALUES ('LeBron James',4,19,4);
INSERT INTO awards VALUES ('Kevin Durant',1,13,2);
INSERT INTO awards VALUES ('Stephen Curry',2,9,4);
INSERT INTO awards VALUES ('Ja Morant',1,2,0);
INSERT INTO awards VALUES ('Joel Embiid',0,6,0);
INSERT INTO awards VALUES ('Luka Doncic',0,4,0);
INSERT INTO awards VALUES ('Jayson Tatum',0,4,0);
INSERT INTO awards VALUES ('Andrew Wiggins',0,1,1);
INSERT INTO awards VALUES ('Nikola Jokic',2,5,0);
INSERT INTO awards VALUES ('Giannis Antetokounmpo',2,7,1);



INSERT INTO physicalprofile VALUES ('LeBron James',"6'8",260,"7'0");
INSERT INTO physicalprofile VALUES ('Kevin Durant',"6'11",250,"7'4");
INSERT INTO physicalprofile VALUES ('Stephen Curry',"6'3",190, "6'3.5");
INSERT INTO physicalprofile VALUES ('Ja Morant',"6'3",180,"6'6");
INSERT INTO physicalprofile VALUES ('Joel Embiid',"7'0",280,"7'5");
INSERT INTO physicalprofile VALUES ('Luka Doncic',"6'7",230,"6'11");
INSERT INTO physicalprofile VALUES ('Jayson Tatum',"6'8",230,"6'11");
INSERT INTO physicalprofile VALUES ('Andrew Wiggins',"6'7",210,"6'10");
INSERT INTO physicalprofile VALUES ('Nikola Jokic',"6'10",270,"7'3");
INSERT INTO physicalprofile VALUES ('Giannis Antetokounmpo',"7'0",250,"7'3");



INSERT INTO team VALUES ('Los Angeles Lakers','West',54,28,5);
INSERT INTO team VALUES ('Phoenix Suns','West',56,26,3);
INSERT INTO team VALUES ('Golden State Warriors','West',64,18,2);
INSERT INTO team VALUES ('Memphis Grizzlies','West',50,32,6);
INSERT INTO team VALUES ('Philadelphia 76ers','East',55, 27,4);
INSERT INTO team VALUES ('Dallas Mavericks','West',19, 64,10);
INSERT INTO team VALUES ('Boston Celtics','East',49, 33,7);
INSERT INTO team VALUES ('Toronto Raptors','East',30, 52,9);
INSERT INTO team VALUES ('Denver Nuggets','West',40, 42,8);
INSERT INTO team VALUES ('Milwaukee Bucks','East',66,16,1);


