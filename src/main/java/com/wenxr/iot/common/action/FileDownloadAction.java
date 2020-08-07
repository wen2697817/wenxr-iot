package com.wenxr.iot.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.wenxr.iot.core.BaseAction;
public class FileDownloadAction extends BaseAction
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputStream fileInputStream;
	String fileName;
	String pathName;
	public String execute(){
		pathName = request.getSession().getServletContext().getRealPath("/"+pathName); 
		File file = new File(pathName); 
		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	
}