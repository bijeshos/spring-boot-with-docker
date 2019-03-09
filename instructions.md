# Instructions

## Get the project to local machine
- Clone the repo to ~/demo directory
    - mkdir ~/demo
    - cd ~/demo
	 - git clone https://github.com/bijeshos/spring-boot-with-docker-demo.git

- Change directory to project root
	 - $ cd ~/demo/spring-boot-with-docker-demo


## Build the project
- Perform Maven Build/Package
    - $ mvn package -f pom.xml

## Docker (Basic)
### Cleanup Docker
- Check locally available docker images
	 - $ docker images

- Check all containers
	 - $ docker ps -a

- Remove any unwanted containers (by specifyig respective container id)
	 - $ docker rm \<container-id>

- Remove any unwanted docker images (by specifying respective image id)
	 - $ docker rmi \<image-id>

### Deploy on Docker
- Build a docker image
	 - $ docker build --tag bijeshos/spring-boot-with-docker-demo:0.1 .

- Run the docker image
	 - $ docker run -p 8080:8080 --name spring-boot-with-docker-demo bijeshos/spring-boot-with-docker-demo:0.1 

- Verify that health-check Rest API endpoint is accessible
	 - $ curl http://localhost:9090/spring-boot-with-docker-demo/v0.1/health-check
	 - $ curl http://127.0.0.1:9090/spring-boot-with-docker-demo/v0.1/health-check

### Cleanup Docker
- Remove container
	 - $ docker rm \<container-id>

- Remove docker image
	 - $ docker rmi \<image-id>


## Docker Swarm (Basic)

### Deploy on Docker Swarm Cluster
- Initialize Docker Swam cluster
	 - $ docker swarm init

- Deploy using Docker compose file
	 - $ docker stack deploy -c docker-compose-01-basic.yml spring-boot-with-docker-demo-stk

- Check Docker Stack
	 - $ docker stack ls
	 - $ docker stack ps spring-boot-with-docker-demo-stk

- Check Docker Services
	 - $ docker service ls
	 - $ docker service ps spring-boot-with-docker-demo-stk_web

- Verify that health-check Rest API endpoint is accessible
	 - $ curl http://localhost:4000/spring-boot-with-docker-demo/v0.1/health-check
	 - $ curl http://127.0.0.1:4000/spring-boot-with-docker-demo/v0.1/health-check

## Docker Swarm (with Visualizer)
- Deploy using Docker compose file
	 - $ docker stack deploy -c docker-compose-02-with-visualizer spring-boot-with-docker-demo-stk

- Check the visualize at:
	 - http://127.0.0.1:5000/

### Cleanup Docker Swarm Cluster
- Remove docker stack
	 - $ docker stack rm spring-boot-with-docker-demo-stk

- Shutdown Docker Swarm Cluster
	 - $ docker swarm leave --force

## Assumptions
- Docker commands can be executed directly as current user
	 - If this is not correctly setup, prefix ***sudo*** with above mentioned docker commands (On Debian machines)
