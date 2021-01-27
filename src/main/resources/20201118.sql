alter table wcss_product modify is_deleted TINYINT(1)  default 0
alter table wcss_sku modify is_deleted TINYINT(1)  default 0
alter table wcss_product_image modify is_deleted TINYINT(1)  default 0