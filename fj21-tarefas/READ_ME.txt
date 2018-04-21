Coisas para fazer e conseguir usar a aplicacao:

1. criar um banco fj21
2. criar tabelas

mysql> show tables;
+----------------+
| Tables_in_fj21 |
+----------------+
| contato        |
| tarefas        |
| usuarios       |
+----------------+

3. detalhes
mysql> desc contato;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| id             | int(11)      | NO   | PRI | NULL    | auto_increment |
| nome           | varchar(255) | YES  |     | NULL    |                |
| email          | varchar(255) | YES  |     | NULL    |                |
| endereco       | varchar(255) | YES  |     | NULL    |                |
| dataNascimento | date         | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+

desc tarefas;
+-----------------+--------------+------+-----+---------+----------------+
| Field           | Type         | Null | Key | Default | Extra          |
+-----------------+--------------+------+-----+---------+----------------+
| id              | int(11)      | NO   | PRI | NULL    | auto_increment |
| descricao       | varchar(255) | YES  |     | NULL    |                |
| dataFinalizacao | date         | YES  |     | NULL    |                |
| finalizado      | tinyint(1)   | YES  |     | NULL    |                |
+-----------------+--------------+------+-----+---------+----------------+

desc usuarios;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | int(11)      | NO   | PRI | NULL    | auto_increment |
| login | varchar(255) | YES  |     | NULL    |                |
| senha | varchar(255) | YES  |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
