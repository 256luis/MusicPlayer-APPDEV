.open "songs.db"

create table if not exists songs (
       id integer primary key autoincrement not null,
       artist varchar(50) not null,
       song_name varchar(50) not null,
       song_length integer not null,
       file_path varchar(100) not null,

       unique (id)
);

insert into songs values (
       1,
       'Eraserheads',
       'Ang Huling El Bimbo',
       450,
       'songs/Ang Huling El Bimbo.mp3'
);

insert into songs values (
       2,
       'Taylor Swift',
       'Speak Now (Taylor''s Version)',
       242,
       'songs/Speak Now (Taylor''s Version).mp3'
);
