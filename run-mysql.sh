#!/bin/bash

docker run --name mysql1 -e MYSQL_ROOT_PASSWORD=12345 -e MYSQL_DATABASE=teste -d -p 3306:3306 mysql:5.6
