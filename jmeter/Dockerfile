FROM hauptmedia/jmeter

ENV p_personfile=/Data/persons.csv
ENV p_server=payara
ENV p_port=8080
ENV p_site=/Payara-Soak-Tests-1.0-SNAPSHOT
ENV p_users=30
ENV p_loops=10
ENV p_ramp_up_secs=15
ENV p_response_timeout=8000

COPY persons.csv /Data/persons.csv

COPY SoakTests.jmx /Config/SoakTests.jmx

ENTRYPOINT bin/jmeter -n -t /Config/SoakTests.jmx -l /Data/results.jtl
