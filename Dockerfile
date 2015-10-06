FROM debian:jessie
MAINTAINER Jean-Christophe Sirot <jcsirot@chelonix.com>

RUN apt-get update -qq && apt-get install -yqq curl

# Install java
RUN curl -s -k -L -C - -b "oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u60-b27/server-jre-8u60-linux-x64.tar.gz | tar xfz - -C /

ENV JAVA_HOME /jdk1.8.0_60
ENV PATH $PATH:$JAVA_HOME/bin

# Install maven
RUN curl -s http://apache.crihan.fr/dist/maven/maven-3/3.3.3/binaries/apache-maven-3.3.3-bin.tar.gz | tar xzf - -C /

ENV MAVEN_HOME /apache-maven-3.3.3
ENV PATH $PATH:$MAVEN_HOME/bin

WORKDIR /home/atmo

ADD . /home/atmo
RUN mvn package -DskipTests

EXPOSE 8080
ENTRYPOINT ["java", "-DPROD_MODE=true", "-Xmx2G", "-jar", "target/atmo-calc.jar"]
