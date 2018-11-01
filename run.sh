docker build -t murilo/banco ./postgres
docker run -p 5433:5432  --name banco  -d murilo/banco 
# O Projeto nao foi feito com maven
# Precisa fazer o build no netbeans
# mvn clean package
docker build -t murilo/app .
docker run -p 8084:8080 --name app --link banco:host-banco -d murilo/app 
