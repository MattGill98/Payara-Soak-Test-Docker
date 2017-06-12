FROM payara/server-full

COPY Payara-Soak-Tests-1.0-SNAPSHOT.war $DEPLOY_DIR

COPY mysql-connector-java-5.1.39.jar ${PAYARA_PATH}/glassfish/domains/${PAYARA_DOMAIN}/lib/ext/

COPY initialise.asadmin ${PAYARA_PATH}/user-commands.asadmin

RUN  ${PAYARA_PATH}/bin/asadmin start-domain ${PAYARA_DOMAIN} && \
     ${PAYARA_PATH}/bin/asadmin --user admin --passwordFile /opt/pwdfile multimode --file ${PAYARA_PATH}/user-commands.asadmin && \
     ${PAYARA_PATH}/bin/asadmin stop-domain ${PAYARA_DOMAIN}

RUN git clone git://github.com/vishnubob/wait-for-it

ENTRYPOINT wait-for-it/wait-for-it.sh mariadb:3306 -t 0 -- echo "MariaDB instance detected" && \
           ${PAYARA_PATH}/generate_deploy_commands.sh && ${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile ${DEPLOY_COMMANDS} ${PAYARA_DOMAIN}
