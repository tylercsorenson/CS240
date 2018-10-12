create table users (
	username text not null primary key,
	password text not null,
	name text not null,
	email text not null,
	firstName text not null,
	lastName text not null,
	gender text check (gender="f" or gender="m"),
	personID text not null
);

create table tokens (
	username text not null primary key,
	authorizationToken text not null
);

create table persons (
	personID text not null primary key,
	descendantUsername text not null,
	firstName text not null,
	lastName text not null,
	gender text check (gender="f" or gender="m"),
	fatherID text,
	motherID text,
	spouseID text
);

create table events (
	eventID text not null primary key,
	descendantUsername text not null,
	personID text not null,s
	latitude real not null,
	longitude real not null,
	country text not null,
	city text not null,
	eventType text check (eventType="birth" or eventType="baptism" or eventType="christening" or eventType="marriage" or eventType="death")
);