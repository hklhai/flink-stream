CREATE TABLE cartinfo (cartid String,userid string,productid string,	num string,	productamount string,	createtime string,merchantid string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE sale(saleid string, salename string,salestarttime string,saleendtime string,productid string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE mechart(merchantid string, merchantname string,merchantarea string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE merchartshop(merchantshopid string, merchantshopname string,merchantid string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE order(orderid string,userid string,merchantid string,orderamount string,paytype string,paytime string,red string,cashcoupon string,productid string,saleid string,createtime string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE product(productid string,productname string,producttypeid string,price string,activityprice string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE producttype(productcategoryid string,productcategoryname string,producttypelevel string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

CREATE TABLE userinfo(userid string,username string,age string,area string,telephone string,birthday string,email string) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t';

