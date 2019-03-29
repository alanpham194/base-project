mkdir /home/ubuntu/env/
cd /home/ubuntu/travala/travala-orders
aws s3 cp s3://trav-env/trav-dev2/travala_orders_dev.properties /home/ubuntu/env/orders.properties
sudo docker-compose down
sudo docker-compose up -d