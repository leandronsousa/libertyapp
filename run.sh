
#Executa banco
docker-compose -f docker-compose.yml run -d -p 127.0.0.1:5432:5432 --name banco banco

#Executa MQ
docker-compose -f docker-compose.yml run -d -p 127.0.0.1:1415:1415 --name mq mq