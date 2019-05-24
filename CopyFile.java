package com.lql.learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class CopyFile {
	public static void main(String[] args) {
		//copy(copyFile,dest)
		copy("src","dest");
	}
	
	public static void copy(String src,String dest) {

		    
	        //复制文件，目标文件
			File srcFile = new File(src);
			File destFile = new File(dest);
			
			//判断src是否存在
			boolean isExist = srcFile.exists();
			if(isExist) {
				//判断src是否是文件
				boolean isFile = srcFile.isFile();
				if(isFile) {
					//选择流
					InputStream is = null;
					OutputStream os = null;
					
					try {
						is = new FileInputStream(srcFile);
						os = new FileOutputStream(destFile,true);
						
						byte[] flush = new byte[1024];
						int len = -1;
						while((len=is.read(flush))!=-1) {
							os.write(flush,0,len);
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						//先打开的后关闭
						try {
							if(os!=null) {os.close();}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							if(is!=null) {is.close();}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					}
					
				}else {
					//递归地调用
					destFile.mkdir();
					
					for(File file:srcFile.listFiles()) {
						String destName = dest+"/"+file.getName();
						copy(file.getAbsolutePath(),destName);
					}
				}
			}
			
			
	
			
	}
 }

