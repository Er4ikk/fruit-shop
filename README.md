# fruit-shop

basic app that manages a small fruit shop:
-insert new slot of products
-delete slot of products
-show current slots 
-modify slot by id
-sell slot/s
-show current sales and the iva

# docker
for running the app we first must install docker

command to build the image (current one is -> relateiq/oracle-java8)
docker build -t <image_tag> .

command to run the image (-it is for interactive shell)
docker run --name <container_name> -it <image_name>

commando to start the container
docker start <container_name>

command to attach container(press some numbers after the command to view the ui)
docker attach <container_name>


# docker-compose
command for running the app:
docker-compose run --rm <service_name>
