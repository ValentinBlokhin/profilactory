DROP TABLE ROOM
IF EXISTS;

CREATE TABLE ROOM
(
  room_id     BIGINT IDENTITY PRIMARY KEY,
  room_number INTEGER NOT NULL,
  seats       INTEGER NOT NULL
);