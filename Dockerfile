FROM payara/server-full

COPY mysql-connector-java-5.1.42-bin.jar $PAYARA_HOME/glassfish/domains/domain1/lib 

COPY Payara-Soak-Tests-1.0-SNAPSHOT.war $DEPLOY_DIR

COPY initialise.asadmin ${PAYARA_PATH}/user-commands.asadmin

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && \
  cat ${PAYARA_PATH}/user-commands.asadmin >> ${PAYARA_PATH}/post-boot-aggregate.asadmin && \
  cat ${PAYARA_PATH}/post-boot-commands.asadmin >> ${PAYARA_PATH}/post-boot-aggregate.asadmin && \
  ${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile post-boot-aggregate.asadmin ${PAYARA_DOMAIN}
