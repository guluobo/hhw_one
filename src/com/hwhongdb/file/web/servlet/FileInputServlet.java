package com.hwhongdb.file.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.hwhongdb.file.common.MsgError;
import com.hwhongdb.file.common.Page;
import com.hwhongdb.file.domain.Music;
import com.hwhongdb.file.service.FileInputService;
import com.hwhongdb.file.service.impl.FileInputServiceImpl;
import com.hwhongdb.file.util.FillBeanUtil;
import com.hwhongdb.file.util.PathUtil;

@WebServlet("/servlet/FileInputServlet")
public class FileInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FileInputService fis = new FileInputServiceImpl();
	
    public FileInputServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		// System.out.println(op);
		if("fileinput".equals(op)){
			dispatcherInput(request,response);
		}else if("input".equals(op)) {
			
			try {
				fileInput(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}else if("music".equals(op)) {
			musicPlayer(request,response);
		}else if("table".equals(op)) {
			musicTable(request,response);
		}else if("update".equals(op)) {
			musicFind(request,response);
		}else if("updateMusic".equals(op)) {			
			musicUpdate(request,response);
		}else if("delete".equals(op)) {
			musicDelete(request,response);
		}
	}

	
	private void musicDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		fis.delectMusic(id);
		
		musicTable(request,response);
	}

	private void musicUpdate(HttpServletRequest request, HttpServletResponse response) {
		try {
			fileInput(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void musicFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		Music music = fis.findByMusic(id);
		request.setAttribute("music", music);
		request.setAttribute("num", num);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	private void musicTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		Page page = fis.findAllPageMusic(num);
		page.setUrl("/servlet/FileInputServlet?op=table");
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/table.jsp").forward(request, response);
	}

	private void musicPlayer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Music> list = fis.findAllMusic();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/music.jsp").forward(request, response);
	}

	private void fileInput(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			request.setAttribute("msg","你的表单为错误！");
			request.getRequestDispatcher("/fileinput.jsp").forward(request, response);
			return;
		}
		
		String op = request.getParameter("op");
		MsgError msgError = new MsgError();
		boolean isError = false;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items =  sfu.parseRequest(request);

		Music music = new Music();
		for (FileItem fileItem : items) {
			if (fileItem.isFormField()) {
				String fieldName = fileItem.getFieldName();
				String fieldValue = fileItem.getString(request.getCharacterEncoding());
				
				FillBeanUtil.setProperty(music, fieldName, fieldValue);
				if (fieldValue == null || "".equals(fieldValue)) {
					if ("title".equals(fieldName)) {
						msgError.setTitle("请输入歌名！");
						isError = true;
					}else if ("singer".equals(fieldName)) {
						msgError.setSinger("请输入歌手！");
						isError = true;
					}
					
				}
			}else {
				String file = fileItem.getFieldName();
//				System.out.println(file + "file");
				String fileName = fileItem.getName();
//				System.out.println(fileName+"fileName");
				if (fileName != null && !"".equals(fileName.trim())) {
					String temp = "";
					if ("song".equals(file)) {
						temp += "music";
					}else if("picture".equals(file)) {
						temp += "picture";
					}else if("lyrics".equals(file)) {
						temp += "lyrics";
					}
					
					fileName = temp + UUID.randomUUID().toString() + "." +FilenameUtils.getExtension(fileName);
					String storeDiretory ="/home/file";
//					String storeDiretory = "f://file";
					String path = PathUtil.makeDir(storeDiretory, fileName);
					
					FillBeanUtil.setProperty(music, file, fileName);
					FillBeanUtil.setProperty(music, file + "Path", path);
					
					try {
						fileItem.write(new File(storeDiretory + path + "/" +fileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if ("input".equals(op)) {
					if (fileName == null || "".equals(fileName)) {
						if ("song".equals(file)) {
							msgError.setSong("请上传的歌曲！");
							isError = true;
						}
					}
				}
				
			}
		}
		if (isError) {
			request.setAttribute("msgError",msgError);
			request.getRequestDispatcher("/fileinput.jsp").forward(request, response);
			return;
		}
		
//		System.out.println(msgError);
		
		if("input".equals(op)) {
			fis.addMusic(music);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}else if("updateMusic".equals(op)) {
			fis.updateMusic(music);

			musicTable(request, response);
			return;
		}
	}

	private void dispatcherInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileinput.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
