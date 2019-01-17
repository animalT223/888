package service;

import java.util.List;

import baseDao.stuDao;

import baseDao.impl.stuImpl;

import entity.stu;

public class stuservice {
		private stuDao stuone=new stuImpl();
		
		public int getSumPageService(){
			return stuone.getSumPage();
		}
		
		public List<stu> getInfoService(){
			
		
			return stuone.getInfo();
		}
		
		public int setUpdaService(String sname,String sno){
			return stuone.setUpda(sname, sno);
		}
		public int setDelService(String sno){
			return stuone.setDel(sno);
		}
		public int setInsService(String name,String no){
			return stuone.setIns(name, no);
		}
		
	
		public boolean getNameService(String name,String pwd){
			return stuone.getName(name, pwd);
		}
		
}
