DROP TABLE PlayerInfo IF EXISTS;
DROP TABLE Player IF EXISTS;
DROP TABLE Enemy IF EXISTS;
DROP TABLE Room IF EXISTS;
DROP TABLE RegisteredUser IF EXISTS;

CREATE TABLE Room (
    idRoom bigint primary key,
    nameRoom varchar(32) unique not null,
    roomState varchar(32) not null,

    constraint chk_roomState check (roomState in (
        'ACTIVE', 'INACTIVE'
    ))
);


CREATE TABLE RegisteredUser (
    idRegisteredUser bigint primary key,
    nameUser varchar(32)
);

CREATE TABLE Player (

    idPlayer bigint primary key,
    playerType varchar(32),
    experience bigint,
    registeredUser bigint,

    constraint chk_playerType check (playerType in (
        'TANK', 'WARRIOR', 'MAGE'
    )),

    constraint fk_registeredUser_player foreign key (registeredUser) references RegisteredUser(idRegisteredUser)
    
);

CREATE TABLE PlayerInfo(
    player bigint,
    room bigint,
    playerState varchar(32),
    xPosition int,
    yPosition int,
    CONSTRAINT chk_playerState check (playerState in (
        'COMBAT', 'FREE', 'DISCONNECTED', 'DEATH'
    )),

    CONSTRAINT fk_player_playerInfo foreign key (player) references Player(idPlayer),
    CONSTRAINT fk_room_playerInfo foreign key (room) references Room(idRoom),
    PRIMARY KEY (player, room)

);


CREATE TABLE Enemy (
    idEnemy bigint primary key,
    enemyType varchar(32),
    levelEnemy int,
    enemyState varchar(32),
    xPosition int,
    yPostition int,

    room bigint,

    CONSTRAINT CHK_enemyType check (enemyType in (
        'GOBLIN', 'BOSS'
    )),
    CONSTRAINT CHK_enemyState check (enemyState in (
        'COMBAT', 'DEATH', 'ALIVE'
    )),

    CONSTRAINT fk_room_enemy foreign key (room) references Room(idRoom)
);