#!/usr/bin/env bash

#set -euo pipefail
#which psql > /dev/null || (echo "Please ensure that postgres client is in your PATH" && exit 1)

mkdir -p $HOME/docker/volumes/postgres
rm -rf $HOME/docker/volumes/postgres/data

docker run --rm --name pg-docker -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -v $HOME/docker/volumes/postgres:/var/lib/postgresql postgres
sleep 3
export PGPASSWORD=postgres

#psql -U postgres -d dev -h localhost -f schema.sql
#psql -U postgres -d dev -h localhost -f V1__Initial.sql

#docker run -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v ./schema.sql:/docker-entrypoint-initdb.d/schema.sql pg-docker
#docker run -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v ./V1__Initial.sql:/docker-entrypoint-initdb.d/V1__Initial.sql pg-docker


docker cp ./schema.sql pg-docker:/docker-entrypoint-initdb.d/schema.sql
docker cp ./data.sql pg-docker:/docker-entrypoint-initdb.d/data.sql
docker exec -u postgres pg-docker psql postgres postgres -f docker-entrypoint-initdb.d/schema.sql
docker exec -u postgres pg-docker psql postgres postgres -f docker-entrypoint-initdb.d/data.sql

