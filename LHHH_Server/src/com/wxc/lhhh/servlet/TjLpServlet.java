package com.wxc.lhhh.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wxc.lhhh.model.LiPin;
import com.wxc.lhhh.util.MySQLUtil;

public class TjLpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// ��ȡsession
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("index.jsp?page=tjlp");
			return;
		}

		// �õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		String savePath = this.getServletContext().getRealPath("/upload");
		// �ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		String tempPath = this.getServletContext().getRealPath("/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// ������ʱĿ¼
			tmpFile.mkdir();
		}

		// ��Ϣ��ʾ
		String message = "";
		try {
			// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			// 1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
			factory.setSizeThreshold(1024 * 100);// ���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
			// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
			factory.setRepository(tmpFile);
			// 2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			// 3���ж��ύ�����������Ƿ����ϴ���������
			if (!ServletFileUpload.isMultipartContent(request)) {
				// ���մ�ͳ��ʽ��ȡ����
				return;
			}

			// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024 * 10�ֽڣ�Ҳ����10MB
			upload.setFileSizeMax(1024 * 1024 * 10);
			// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
			upload.setSizeMax(1024 * 1024 * 10);
			// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);

			// ����û��ύ�Ĳ���
			String lpbh = list.get(0).getString("UTF-8");
			String lpmc = list.get(1).getString("UTF-8");
			String lpdj = list.get(2).getString("UTF-8");
			String lpzs = list.get(3).getString("UTF-8");
			String kcsl = list.get(4).getString("UTF-8");
			String zplj = "";

			for (FileItem item : list) {
				// ���fileitem�з�װ������ͨ�����������
				if (!item.isFormField()) {
					// ���fileitem�з�װ�����ϴ��ļ�
					// �õ��ϴ����ļ����ƣ�
					String filename = item.getName();
					// System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺
					// c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					

					// �õ��ϴ��ļ�����չ��
					// String fileExtName =
					// filename.substring(filename.lastIndexOf(".") + 1);
					// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
					// System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
					
					// ��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					// �õ��ļ����������
					String saveFilename = makeFileName(filename);
					// �õ��ļ��ı���Ŀ¼
					String realSavePath = makePath(saveFilename, savePath);
					// ����һ���ļ������
					
					//windows
					//FileOutputStream out = new FileOutputStream(realSavePath
					//		+ "\\" + saveFilename);
					
					//linux
					FileOutputStream out = new FileOutputStream(realSavePath
							+ "/" + saveFilename);

					// ����һ��������
					byte buffer[] = new byte[1024];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while ((len = in.read(buffer)) > 0) {
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
						// + filename)����
						out.write(buffer, 0, len);
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					// item.delete();
					zplj = realSavePath.replaceAll(".*upload", "upload") + "/"
							+ saveFilename;

					message = "<div class='yes_img'></div><p>��ӳɹ���</p>";
				}
			}

			LiPin lp = new LiPin();
			lp.setLpbh(lpbh);
			lp.setLpmc(lpmc);
			lp.setLpdj(Integer.parseInt(lpdj));
			lp.setLpzs(Integer.parseInt(lpzs));
			lp.setKcsl(Integer.parseInt(kcsl));
			lp.setZplj(zplj);

			// ���浽���ݿ�
			MySQLUtil.saveLipin(lp);
		} catch (FileUploadBase.FileSizeLimitExceededException e) {

			request.getSession().setAttribute("message",
					"<div class='no_img'></div><p>�ϴ��ļ�̫��</p>");
			response.sendRedirect("message.jsp");
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			request.getSession().setAttribute("message",
					"<div class='no_img'></div><p>�ϴ��ļ�̫��</p>");
			response.sendRedirect("message.jsp");
			return;
		} catch (Exception e) {
			message = "<div class='no_img'></div><p>�ϴ�ʧ�ܣ�</p>";
		}
		request.getSession().setAttribute("message", message);
		response.sendRedirect("message.jsp");
	}

	/**
	 * @Method: makeFileName
	 * @Description: �����ϴ��ļ����ļ������ļ����ԣ�uuid+"_"+�ļ���ԭʼ����
	 * @param filename
	 *            �ļ���ԭʼ����
	 * @return uuid+"_"+�ļ���ԭʼ����
	 */
	private String makeFileName(String filename) { // 2.jpg
		// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString() + "_" + filename;
	}

	/**
	 * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
	 * 
	 * @Method: makePath
	 * @param filename
	 *            �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
	 * @param savePath
	 *            �ļ��洢·��
	 * @return �µĴ洢Ŀ¼
	 */
	private String makePath(String filename, String savePath) {
		// �õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		// �����µı���Ŀ¼
		
		// windows
		// String dir = savePath + "\\" + dir1 + "\\" + dir2;

		// linux
		String dir = savePath + "/" + dir1 + "/" + dir2;
		// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file = new File(dir);
		// ���Ŀ¼������
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
