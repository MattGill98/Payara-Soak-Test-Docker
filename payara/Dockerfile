FROM payara/server-full

ADD soak-test.war $DEPLOY_DIR/

HEALTHCHECK --interval=10s --timeout=5s --retries=2 \
     CMD curl -f localhost:8080/soak-test/
