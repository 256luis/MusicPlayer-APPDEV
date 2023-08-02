.open "songs.db"

create table if not exists songs (
       id integer primary key autoincrement not null,
       artist varchar(50) not null,
       song_name varchar(50) not null,
       song_length integer not null,
       file_path varchar(100) not null,
       lyrics_path varchar(100) not null,

       unique (id)
);

insert into songs values (
       1,
       'Eraserheads',
       'Ang Huling El Bimbo',
       450,
       'songs/Ang Huling El Bimbo.mp3',
       'lyrics/Ang Huling El Bimbo.txt'
);

insert into songs values (
       2,
       'Taylor Swift',
       'Speak Now (Taylor''s Version)',
       242,
       'songs/Speak Now (Taylor''s Version).mp3',
       'lyrics/Speak Now (Taylor''s Version).txt'
);

insert into songs values (
       3,
       'Taylor Swift',
       'Enchanted (Taylor''s Version)',
       353,
       'songs/Enchanted (Taylor''s Version).mp3',
       'lyrics/Enchanted (Taylor''s Version).txt'
);

insert into songs values (
       4,
       'FM Static',
       'Tonight',
       218,
       'songs/Tonight.mp3',
       'lyrics/Tonight.txt'    
);

insert into songs values (
       5,
       'Taylor Swift',
       'Maroon',
       218,
       'songs/Maroon.mp3',
       'lyrics/Maroon.txt'    
);


insert into songs values (
       6,
       'Lola Amour',
       'Raining In Manila',
       292,
       'songs/Raining In Manila.mp3',
       'lyrics/Raining In Manila.txt'
);

insert into songs values (
       7,
       'Hillsong Worship',
       'Mighty To Save',
       292,
       'songs/Mighty To Save.mp3',
       'lyrics/Mighty To Save.txt'
);
       
insert into songs values (
       8,
       'The Beatles',
       'Here Comes The Sun - Remastered 2009',
       185,
       'songs/Here Comes The Sun - Remastered 2009.txt',
       'lyrics/Here Comes The Sun - Remastered 2009.txt'       
);
       
       
insert into songs values (
       9,
       'Kamikazee',
       'Halik',
       222,
       'songs/Halik.mp3',
       'lyrics/Halik.txt'
);
              
insert into songs values (
       10,
       'Anderson .Paak',
       'Heart Don''t Stand a Chance',
       222,
       'songs/Heart Don''t Stand a Chance.mp3',
       'lyrics/Heart Don''t Stand a Chance.txt'
);
       
