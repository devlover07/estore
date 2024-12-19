
create table category (id bigint not null, created_at date, is_deleted bit not null, last_updated_at date, name varchar(255), 
						primary key (id))

create table category_seq (next_val bigint)

insert into category_seq values ( 1 )

create table jt_instructor (favorite_student varchar(255), user_id bigint not null, primary key (user_id))

create table jt_mentor (average_rating float(53) not null, user_id bigint not null, primary key (user_id))

create table jt_user (id bigint not null, email varchar(255), name varchar(255), primary key (id))

create table ms_instructor (id bigint not null, email varchar(255), name varchar(255), favorite_student varchar(255), 
							primary key (id))

create table ms_mentor (id bigint not null, email varchar(255), name varchar(255), average_rating float(53) not null, 
						primary key (id))

create table product (id bigint not null, created_at date, is_deleted bit not null, last_updated_at date, 
						description varchar(255), image_url varchar(255), price float(53), title varchar(255), 
						category_id bigint, primary key (id))
						
create table product_seq (next_val bigint)

insert into product_seq values ( 1 )

create table st_user (user_type integer not null, id bigint not null, email varchar(255), name varchar(255), 
						favorite_student varchar(255), average_rating float(53), primary key (id))
						
create table tbc_instructor (id bigint not null, email varchar(255), name varchar(255), favorite_student varchar(255), 
								primary key (id))

create table tbc_mentor (id bigint not null, email varchar(255), name varchar(255), average_rating float(53) not null, 
							primary key (id))
							
create table tbc_user (id bigint not null, email varchar(255), name varchar(255), primary key (id))

alter table jt_instructor add constraint FK4od6mbg1v99qri5dtqreaayou foreign key (user_id) references jt_user (id)

alter table jt_mentor add constraint FK74kd6ct4a7jq51dr84f8m7usr foreign key (user_id) references jt_user (id)

alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id)