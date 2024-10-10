# Roomer

Hey!
This is a Roomer Java Spring application. The idea behind this app is to find a roommate as quickly as you can image!

application is still in the development stage

# First look
![image](https://github.com/heesos/Roomer/assets/60614375/3029d083-b7bf-4652-8da1-c8f9112bdd2f)

# How to run
You can run this application using the docker-compose.yml example file below.

      services:  
      roomer:  
        image: hesos123/roomer:0.0.1  
        depends_on:  
          - postgres  
        ports:  
          - "8081:8081"  
      environment:  
          DATASOURCE_URL: jdbc:postgresql://postgres:5432/postgres  
          DATASOURCE_USERNAME: postgres  
          DATASOURCE_PASSWORD: admin  
      postgres:  
        image: postgres:13  
        container_name: postgres_container  
        environment:  
          POSTGRES_USER: postgres  
          POSTGRES_PASSWORD: admin  
          POSTGRES_DB: postgres  
        ports:  
          - "5433:5432"
          
Then head to your browser and put http://localhost:8081/login
