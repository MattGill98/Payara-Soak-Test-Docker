docker run -d --rm --name mariadb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test mariadb

docker run -d --rm --name payara --link mariadb:mariadb -p 8080:8080 -p 4848:4848 mattgill98/soak-test-payara

docker run -d --rm --name jmeter --link payara:payara mattgill98/soak-test-jmeter
