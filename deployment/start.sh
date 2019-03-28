mkdir /home/ubuntu/env/
cd /home/ubuntu/travala/travala-users
aws s3 cp s3://trav-env/trav-dev2/travala_users_dev.properties /home/ubuntu/env/users.properties
sudo docker-compose up -d