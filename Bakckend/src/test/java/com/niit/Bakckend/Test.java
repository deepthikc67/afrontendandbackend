package com.niit.Bakckend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Config.DBConfig;
import com.niit.DAO.CategoryDAO;
import com.niit.Model.Category;

public class Test {
public static void main(String[] args) {
	ApplicationContext c=new AnnotationConfigApplicationContext(DBConfig.class);
	
	CategoryDAO cdao=(CategoryDAO)c.getBean("cdao");
	
	Category cc=new Category();
	
	//cc.setName("Second cat");
	//cdao.addCategory(cc);
	cdao.deleteCategory(1);
}
}
