package ru.geekbrains.spring1.lesson5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            Product p = productDao.findById(1l);
            List<Product> productList = productDao.findAll();
            System.out.println(productList);

            productDao.deleteById(1l);
            List<Product> productList1 = productDao.findAll();
            System.out.println(productList1);

            Product product = new Product(4l, "newProduct", 10);

            productDao.saveOrUpdate(product);

            List<Product> productList2 = productDao.findAll();
            System.out.println(productList2);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }


    }
}
