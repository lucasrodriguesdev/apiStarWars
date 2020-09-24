# apiStarWars

Projeto realizado com as seguintes tecnologias:
- Java jdk 8
- Spring boot(Spring tools suite)
- MySql 
- PostMan
- Junit

API externa = https://swapi.dev/;

Como configurar:
- Clonar projeto
- Com Spring tools suite instalada, importar
- Alterar arquivo application.properties com suas informações, em "...\planeta\src\main\resources\application.properties"
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/<DATABASE>?useSSL=false&useTimezone=true&serverTimezone=UTC
    spring.datasource.username=<USER>
    spring.datasource.password=<PASSWORD>
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.hibernate.ddl-auto=update
    ```
 - Run application pela classe PlanetaApplication
 
 Funcionalidades:
 - Listar todos planetas do banco de dados: ``` GET http://localhost:8080/api/planetas/ ```
 - Buscar planeta por ID no banco de dados: ``` GET http://localhost:8080/api/planetas/1 ``` onde 1 é o ID
 - Buscar planeta por nome no banco de dados: ``` GET http://localhost:8080/api/planetas/marte ``` onde marte é o NOME do planeta
 - Inserir planeta no banco de dados: ``` POST http://localhost:8080/api/planetas/ ```
 BODY:
```
  {
    "name": "Marte",
    "climate": "Arido",
    "terrain": "Deserto"
  }
```
 - Deletar planeta do banco de dados por ID: ``` DELETE http://localhost:8080/api/planetas/1 ``` onde 1 é o ID
 - Listar todos planetas em API externa: ``` GET http://localhost:8080/api/planetas/consume ```
 - Buscar planeta por ID em API externa: ``` GET http://localhost:8080/api/planetas/consume/1 ``` onde 1 é o ID 
 *Aqui irá listar as informações:Name,Climate,Terrain e o numero de aparições em filmes*
 
 
 
