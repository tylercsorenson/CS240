create table user
(
	username text not null primary key,
	password text not null,
	name text not null,
   email text not null,
	firstName text not null,
	lastName text not null,
	
	
Gender: User’s gender (string: “f” or “m”)
Person ID: Unique Person ID assigned to this user’s generated Person object - see Family
History Information section for details (non-empty string)
);