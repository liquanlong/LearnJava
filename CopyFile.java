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

		    
	        //�����ļ���Ŀ���ļ�
			File srcFile = new File(src);
			File destFile = new File(dest);
			
			//�ж�src�Ƿ����
			boolean isExist = srcFile.exists();
			if(isExist) {
				//�ж�src�Ƿ����ļ�
				boolean isFile = srcFile.isFile();
				if(isFile) {
					//ѡ����
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
						//�ȴ򿪵ĺ�ر�
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
					//�ݹ�ص���
					destFile.mkdir();
					
					for(File file:srcFile.listFiles()) {
						String destName = dest+"/"+file.getName();
						copy(file.getAbsolutePath(),destName);
					}
				}
			}
			
			
	
			
	}
 }

