create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table festivos (
 id int(11) not null auto_increment,
 fecha date null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 cantidad int(11) null,
 precio decimal(20.0) null,
 primary key (id)
);

create table pedido (
 id int(11) not null auto_increment,
 fecha datetime not null,
 domicilio decimal(20.0) null,
 primary key (id)
);

create table pedido_producto (
 id int(11) not null auto_increment,
 id_pedido int(11) null,
 id_producto int(11) null,
 cantidad int(11) null,
 precio decimal(20.0) null,
 primary key (id)
);