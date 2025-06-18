0create table options (
 option_id int primary key auto_increment,
 option_name VARCHAR (30) not null,
 option_price varchar (30)
);

INSERT INTO options VALUES
(null, 'tunaCut', '130'),
(null, 'omochiBreak', '6'),
(null, 'osakeBreak', '9'),
(null, 'champagne', '20'),
(null, 'pinata', '2'),
(null, 'hamburgerCut', '7'),
(null, 'sushiCake', '25'),
(null, 'fireWork', '6.5'),
(null, 'pumpkin', '6');