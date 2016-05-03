FROM ubuntu

MAINTAINER Richard Schiller <RichardJSchiller@gmail.com>
 
RUN apt-get update && apt-get install -y python-software-properties software-properties-common postgresql postgresql-client postgresql-contrib \
&& apt-get install -y default-jdk \
&& apt-get install -y maven \
&& apt-get install -y git \
&& apt-get install -y gawk \
&& apt-get install -y realpath \
&& mkdir /data && chown -R postgres /data

# RJS ENHANCEMENT FOR UBUNTU 16 which sets up the java repository for JAVA 8
RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" | tee /etc/apt/sources.list.d/webupd8team-java.list
RUN echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update
# update java to Oracle!
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && apt-get install -y oracle-java8-installer

USER postgres

# This image does nothing much other than set a volume where the data directory # is: i.e., where the nt file sits.  For now the assumption is that
# its unzipped and it exists in the /data dir.  All temporary files get written 
# to that directory.

WORKDIR /data

# Clone the quetzal repository
#    it was in https://github.com/Quetzal-RDF/quetzal
RUN /etc/init.d/postgresql start \
&& git clone https://github.com/rjschiller/quetzal.git \
&& cd /data/quetzal/com.ibm.research.quetzal.core/ &&  mvn verify -DskipTests

# to connect to this afterward you follow this command
# docker images
# docker run -it <container id> /bin/bash

# This is how it is launched:
# docker --label=[tag=ibmresearch/quetzal_postgres] build https://raw.githubusercontent.com/rjschiller/quetzal/master/com.ibm.research.quetzal.core/docker/postgresql/Dockerfile
# tag the docker image
#     docker tag <the image from above> ibmresearch/quetzal_postgres
