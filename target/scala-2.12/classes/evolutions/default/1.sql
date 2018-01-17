# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table apikey (
  id                            bigint auto_increment not null,
  key                           varchar(255),
  version                       bigint not null,
  fecha_creacion                timestamp not null,
  fecha_modificacion            timestamp not null,
  constraint pk_apikey primary key (id)
);

create table cocinero (
  id                            bigint auto_increment not null,
  nombre                        varchar(255) not null,
  apellido                      varchar(255),
  tipo                          varchar(255),
  restaurante                   varchar(255),
  key_id                        bigint,
  version                       bigint not null,
  fecha_creacion                timestamp not null,
  fecha_modificacion            timestamp not null,
  constraint uq_cocinero_key_id unique (key_id),
  constraint pk_cocinero primary key (id)
);

create table ingrediente (
  id                            bigint auto_increment not null,
  nombre                        varchar(255) not null,
  version                       bigint not null,
  fecha_creacion                timestamp not null,
  fecha_modificacion            timestamp not null,
  constraint pk_ingrediente primary key (id)
);

create table ingrediente_receta (
  ingrediente_id                bigint not null,
  receta_id                     bigint not null,
  constraint pk_ingrediente_receta primary key (ingrediente_id,receta_id)
);

create table paso (
  id                            bigint auto_increment not null,
  tiempo                        bigint,
  descripcion                   varchar(255) not null,
  indice                        bigint,
  p_receta_id                   bigint,
  version                       bigint not null,
  fecha_creacion                timestamp not null,
  fecha_modificacion            timestamp not null,
  constraint pk_paso primary key (id)
);

create table receta (
  id                            bigint auto_increment not null,
  titulo                        varchar(255) not null,
  tipo                          varchar(255),
  r_cocinero_id                 bigint,
  version                       bigint not null,
  fecha_creacion                timestamp not null,
  fecha_modificacion            timestamp not null,
  constraint pk_receta primary key (id)
);

create table tag (
  id                            bigint auto_increment not null,
  texto                         varchar(255) not null,
  t_receta_id                   bigint,
  version                       bigint not null,
  fecha_creacion                timestamp not null,
  fecha_modificacion            timestamp not null,
  constraint pk_tag primary key (id)
);

alter table cocinero add constraint fk_cocinero_key_id foreign key (key_id) references apikey (id) on delete restrict on update restrict;

alter table ingrediente_receta add constraint fk_ingrediente_receta_ingrediente foreign key (ingrediente_id) references ingrediente (id) on delete restrict on update restrict;
create index ix_ingrediente_receta_ingrediente on ingrediente_receta (ingrediente_id);

alter table ingrediente_receta add constraint fk_ingrediente_receta_receta foreign key (receta_id) references receta (id) on delete restrict on update restrict;
create index ix_ingrediente_receta_receta on ingrediente_receta (receta_id);

alter table paso add constraint fk_paso_p_receta_id foreign key (p_receta_id) references receta (id) on delete restrict on update restrict;
create index ix_paso_p_receta_id on paso (p_receta_id);

alter table receta add constraint fk_receta_r_cocinero_id foreign key (r_cocinero_id) references cocinero (id) on delete restrict on update restrict;
create index ix_receta_r_cocinero_id on receta (r_cocinero_id);

alter table tag add constraint fk_tag_t_receta_id foreign key (t_receta_id) references receta (id) on delete restrict on update restrict;
create index ix_tag_t_receta_id on tag (t_receta_id);


# --- !Downs

alter table cocinero drop constraint if exists fk_cocinero_key_id;

alter table ingrediente_receta drop constraint if exists fk_ingrediente_receta_ingrediente;
drop index if exists ix_ingrediente_receta_ingrediente;

alter table ingrediente_receta drop constraint if exists fk_ingrediente_receta_receta;
drop index if exists ix_ingrediente_receta_receta;

alter table paso drop constraint if exists fk_paso_p_receta_id;
drop index if exists ix_paso_p_receta_id;

alter table receta drop constraint if exists fk_receta_r_cocinero_id;
drop index if exists ix_receta_r_cocinero_id;

alter table tag drop constraint if exists fk_tag_t_receta_id;
drop index if exists ix_tag_t_receta_id;

drop table if exists apikey;

drop table if exists cocinero;

drop table if exists ingrediente;

drop table if exists ingrediente_receta;

drop table if exists paso;

drop table if exists receta;

drop table if exists tag;

