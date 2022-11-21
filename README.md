# LibertyApp

Aplicação SpringBoot rodando no Liberty

Transação distribuída com Atomikos Postgres e IBMMQ


## Rodar App

docker build -t libertyapp:1.0-SNAPSHOT .

docker compose up -d


## Rodar banco standalone

docker run -d --name banco -p 5432:5432 -e POSTGRES_PASSWORD=passwd -e POSTGRES_USER=xauser -e POSTGRES_DB=xadb postgres

## Rodar MQ standalone

docker run -d --name mq -p 1414:1414 -e LICENSE='accept' -e MQ_QMGR_NAME='QM1' ibmcom/mq