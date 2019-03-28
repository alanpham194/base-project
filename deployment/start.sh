mkdir /home/ubuntu/env/
cd /home/ubuntu/travala/travala-searching
aws s3 cp s3://trav-env/trav-dev2/travala_searching_dev.properties /home/ubuntu/env/searching.properties
sudo docker-compose up -d