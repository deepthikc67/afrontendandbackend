package com.niit.Impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.ProductDAO;
import com.niit.Model.Category;
import com.niit.Model.Product;;

@Repository("ProductDAO")
public class ProductImpl implements ProductDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	//addProduct
	@Transactional
	public boolean addProduct(Product product) 
	{	
		try
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	//getProduct()
	
	public Product getProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}

/*	//deleteProduct()
	@Transactional
	public boolean deleteProduct(Product productId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
            session.beginTransaction(); 
          Product product=(Product)session.get(Product.class,productId);
            session.delete(product);
            session.getTransaction().commit();
            session.close();  
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}*/
	
	
	
	
	
	@Transactional
	public boolean deleteProduct(int ProductId) 
	{
      try
      {
		Session session=sessionFactory.openSession();
        session.beginTransaction(); 
        Product p=session.get(Product.class, ProductId);
        session.delete(p);
        session.getTransaction().commit();
        session.close();
        return true;
	}
	catch (Exception e) {
		System.out.println("Exception Arised:" + e);
		return false;
	}
	}
	
	
	
	
	
	//updateProduct()
	@Transactional
	public boolean updateProduct(Product product) 
	{
		try
		{

			Session session=sessionFactory.openSession();
	        session.beginTransaction(); session.update(product);
		    session.getTransaction().commit();
		    session.close();
		    return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	
	}

	/*//listProduct()	
	public List<Product> getProducts() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=(List<Product>)query.list();
		return listProducts;
	}*/

	
	public List<Product> getProducts() 
	{
		Session session=sessionFactory.openSession();
		List<Product> listProducts=	session.createQuery("from Product").getResultList();
		return listProducts;
	}
	
	
/*	
	
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}
	*/
	
	
	

}



	
	



