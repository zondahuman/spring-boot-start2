# spring-boot-cassandra:


create keyspace guru_keyspace with replication = {'class':'SimpleStrategy', 'replication_factor':1};

use guru_keyspace;

CREATE TABLE products (
       id uuid PRIMARY KEY,
       description text,
       price decimal,
       imageUrl text
    );

use guru_keyspace;

select * from  products ;

apache-cassandra-2.2.9

apache-cassandra-3.11.1

# Table Data Type :
http://docs.datastax.com/en/archived/cql/3.0/cql/cql_reference/create_table_r.html








