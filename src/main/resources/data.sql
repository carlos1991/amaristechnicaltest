INSERT INTO prices
  (id, brand_id, start_date, end_date,
   fare, product_id, priority, price,
   currency)
VALUES
  (1, 1, parsedatetime('2020-06-14 00:00:00', 'yyyy-MM-dd hh:mm:ss'), parsedatetime('2020-12-31 23:59:59', 'yyyy-MM-dd hh:mm:ss'),
   1, 35455, 0, 35.50,
   'EUR');

INSERT INTO prices
  (id, brand_id, start_date, end_date,
   fare, product_id, priority, price,
   currency)
VALUES
  (2, 1, parsedatetime('2020-06-14 15:00:00', 'yyyy-MM-dd hh:mm:ss'), parsedatetime('2020-06-14 18:30:00', 'yyyy-MM-dd hh:mm:ss'),
   2, 35455, 1, 25.45,
   'EUR');

INSERT INTO prices
  (id, brand_id, start_date, end_date,
   fare, product_id, priority, price,
   currency)
VALUES
  (3, 1, parsedatetime('2020-06-15 00:00:00', 'yyyy-MM-dd hh:mm:ss'), parsedatetime('2020-06-15 11:00:00', 'yyyy-MM-dd hh:mm:ss'),
   3, 35455, 1, 30.50,
   'EUR');

INSERT INTO prices
  (id, brand_id, start_date, end_date,
   fare, product_id, priority, price,
   currency)
VALUES
  (4, 1, parsedatetime('2020-06-15 16:00:00', 'yyyy-MM-dd hh:mm:ss'), parsedatetime('2020-12-31 23:59:59', 'yyyy-MM-dd hh:mm:ss'),
   4, 35455, 1, 38.95,
   'EUR');