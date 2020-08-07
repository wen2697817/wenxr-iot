package com.wenxr.iot.common.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.wenxr.iot.core.BaseAction;
import com.wenxr.iot.util.Tools;

/**
 * 描述：
 * 
 * <p>
 * &nbsp;&nbsp;&nbsp;&nbsp;通用文件上传类
 * </p>
 * 
 * 创建日期 2016-8-31
 * 
 * @author wxr
 * @version 1.0
 * 
 */
public class FileUploadAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String path = null, name = null;

	private File file = null;
	private String fileFileName = null;
	private String fileContentType;

	public String upload() {
		try {
			if (file == null || !file.exists()) {
				return failure("202", "上传文件为空");
			}
			if ("base64".equals(request.getParameter("method"))) {
				return this.success("上传成功！", Tools.file2Base64Str(file));
			}
			if (StringUtils.isEmpty(path)) {
				path = "upload/_tmp/";
			}
			name = StringUtils.isEmpty(name) ? UUID.randomUUID().toString()
					: name;
			Date date = new Date();
			String fileName = date.getTime() + fileFileName;
			
			if (!path.startsWith("/")) {
				path = "/" + path;
			}
			if (!path.endsWith("/")) {
				path += "/";
			}
			if ("remote".equals(request.getParameter("type"))) {
				// 上传至文件服务器
				// String p = path.startsWith("upload/") ?
				// path.substring(path.indexOf("/") + 1) : path;

				// new MinaSender(p, fileName, this.file, false).run();//
				// 不删除文件，让struts管理；不使用线程
			} else {
				String contextPath = path + fileName;
				FileUtils.copyFile(this.file, new File(basePath + contextPath));
			}
			return this.success("上传成功！", fileName);
		} catch (Exception e) {
			return failure(e.getMessage());
		}
	}

	/**
	 * ckeditor上传图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ckeditorUpload() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String callback = ServletActionContext.getRequest().getParameter(
				"CKEditorFuncNum");
		// 对文件进行校验
		if (file == null || fileContentType == null || fileFileName == null) {
			out.print("<font color=\"red\" size=\"2\">*请选择上传文件</font>");
			return null;
		}

		if ((fileContentType.equals("image/pjpeg") || fileContentType
				.equals("image/jpeg"))
				&& fileFileName.substring(fileFileName.length() - 4)
						.toLowerCase().equals(".jpg")) {
			// IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
		} else if (fileContentType.equals("image/png")
				&& fileFileName.substring(fileFileName.length() - 4)
						.toLowerCase().equals(".png")) {

		} else if (fileContentType.equals("image/gif")
				&& fileFileName.substring(fileFileName.length() - 4)
						.toLowerCase().equals(".gif")) {

		} else if (fileContentType.equals("image/bmp")
				&& fileFileName.substring(fileFileName.length() - 4)
						.toLowerCase().equals(".bmp")) {

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
			out.println("</script>");
			return null;
		}

		if (file.length() > 600 * 1024) {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'文件大小不得大于600k');");
			out.println("</script>");
			return null;
		}

		String fileName = UUID.randomUUID().toString()
				+ Tools.getExtention(fileFileName);
		String name = "upload/store/" + fileName;
		FileUtils.copyFile(this.file, new File(basePath + name));
		// 设置返回“图像”选项卡

		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
				+ ",'" + this.requestPath() + "upload/store/" + fileName
				+ "','')");
		out.println("</script>");

		return null;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the fileFileName
	 */
	public String getFileFileName() {
		return fileFileName;
	}

	/**
	 * @param fileFileName
	 *            the fileFileName to set
	 */
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * @return the fileContentType
	 */
	public String getFileContentType() {
		return fileContentType;
	}

	/**
	 * @param fileContentType
	 *            the fileContentType to set
	 */
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
