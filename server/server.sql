create table users (
	userName text not null primary key,
	password text not null,
	email text not null,
	firstName text not null,
	lastName text not null,
	gender text check (gender="f" or gender="m"),
	personID text not null
);

create table tokens (
	userName text not null primary key,
	authToken text not null,
	personID text not null
);

create table persons (
	personID text not null primary key,
	descendant text not null,
	firstName text not null,
	lastName text not null,
	gender text check (gender="f" or gender="m"),
	father text,
	mother text,
	spouse text
);

create table events (
	eventID text not null primary key,
	descendant text not null,
	personID text not null,
	latitude real not null,
	longitude real not null,
	country text not null,
	city text not null,
	eventType text not null,
	year integer not null
);