FROM openjdk:8-jdk-alpine

COPY apache-jmeter-3.2.tgz .
RUN tar -xvf apache-jmeter-3.2.tgz
WORKDIR apache-jmeter-3.2

ENV p_server=payara
ENV p_port=8080
ENV p_site=/soak-test
ENV p_users=300
ENV p_loops=3
ENV p_ramp_up_secs=1
ENV p_response_timeout=8000

COPY persons.csv . 
COPY SoakTests.jmx .

ENTRYPOINT sh bin/jmeter \ 
	-Jp_personfile=persons.csv \
	-Jp_server=$p_server \
	-Jp_port=$p_port \
        -Jp_site=$p_site \
        -Jp_users=$p_users \
        -Jp_loops=$p_loops \
        -Jp_ramp_up_secs=$p_ramp_up_secs \
        -Jp_response_timeout=$p_response_timeout \
	-n -t SoakTests.jmx -l rslts.jtl
