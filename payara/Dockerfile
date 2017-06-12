FROM payara/server-full

COPY Payara-Soak-Tests-1.0-SNAPSHOT.war $DEPLOY_DIR

COPY mysql-connector-java-5.1.39.jar ${PAYARA_PATH}/glassfish/domains/${PAYARA_DOMAIN}/lib/ext/

COPY initialise.asadmin ${PAYARA_PATH}/user-commands.asadmin

RUN  ${PAYARA_PATH}/bin/asadmin start-domain ${PAYARA_DOMAIN} && \
     ${PAYARA_PATH}/bin/asadmin --user admin --passwordFile /opt/pwdfile multimode --file ${PAYARA_PATH}/user-commands.asadmin && \
     ${PAYARA_PATH}/bin/asadmin stop-domain ${PAYARA_DOMAIN}

