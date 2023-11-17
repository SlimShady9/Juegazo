-- Room domain
DROP TABLE PlayerInfo IF EXISTS;
DROP TABLE EnemyInfo IF EXISTS;
DROP TABLE Player IF EXISTS;
DROP TABLE Enemy IF EXISTS;
DROP TABLE Room IF EXISTS;

CREATE TABLE Room (
    idRoom bigint primary key,
    nameRoom varchar(32) unique not null,
    roomState varchar(32) not null,

    constraint chk_roomState check (roomState in (
        'ACTIVE', 'INACTIVE'
    ))
);

CREATE TABLE Player (

    idPlayer bigint primary key ,
    playerType varchar(32),
    experience bigint,
    constraint chk_playerType check (typePlayer in (
        'TANK', 'WARRIOR', 'MAGE'
    ))
    
);

CREATE TABLE PlayerInfo(
    player bigint foreign key references Player(idPlayer),
    room bigint foreign key references Room(idRoom),
    playerState varchar(32),
    xPosition int,
    yPosition int,
    CONSTRAINT chk_playerState check (playerState in (
        'COMBAT', 'FREE', 'DISCONNECTED', 'DEATH'
    ))

);

alter table PlayerInfo add primary key (player, room);

CREATE TABLE Enemy (
    idEnemy bigint primary key,
    health int,
    damage int,
    enemyType varchar(32),
    levelEnemy int,

    CONSTRAINT CHK_enemyType check (enemyType in (
        'GOBLIN', 'BOSS'
    ))
);


CREATE TABLE EnemyInfo(
    enemy bigint foreign key references Enemy(idEnemy),
    room bigint foreign key references Room(idRoom),
    enemyState varchar(32),
    xPosition int,
    yPostition int,

    CONSTRAINT CHK_enemyState check (enemyState in (
        'COMBAT', 'DEATH', 'ALIVE'
    ))

);






