# Steps to Run project 

#import project in eclipse as maven project
# Run the IpmanagementApplication.java as Spring boot app or Java Main class
# It will run on default 8080 port
# If in your machine 8080 is not free please add server.port = "port number". eg server.port=8082
in application.properties file

# While running the Application it will insert the following data in H2 data base 
insert into ip_pool (id,description,lower_bound,total_capacity,upper_bound,used_capacity)

values (1,'This pool is reserved for Prime user','10.70.26.0',255,'10.70.26.255',0);

insert into ip_pool (id,description,lower_bound,total_capacity,upper_bound,used_capacity)

values (2,'This pool is reserved for normal user','10.70.28.0',255,'10.70.28.255',0);

insert into ip_pool (id,description,lower_bound,total_capacity,upper_bound,used_capacity)

values (3,'This pool is reserved for VIP user','10.70.27.0',255,'10.70.27.255',0);


# H2 console URL to see the data : http://localhost:8080/h2
# Swagger URl for api test or documentation : http://localhost:8080/swagger-ui.html
