package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 파일 다운로드 처리 서블릿
 */
public class FileDownloadListServlet extends HttpServlet {

	private String fileRepository;

	@Override
	public void init() throws ServletException {
		fileRepository = getServletContext().getInitParameter("Location");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fileName = request.getParameter("file");
		if (fileName != null) {
 
			String filePath = fileRepository + fileName;
			File file = new File(filePath);

			// 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정

			response.setContentType("application/octet-stream"); // String 타입으로 무조건 다운받음
			fileName = URLEncoder.encode(fileName, "utf-8"); // 인코딩해서 보내는것
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
			response.setHeader("Content-Length", "" + file.length());

			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
			try {
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = in.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out2 = response.getWriter();
		out2.println("<!DOCTYPE html>");
		out2.println("<html>");
		out2.println("<head>");
		out2.println("<meta charset=\"utf-8\">");
		out2.println("<title></title>");
		out2.println("</head>");
		out2.println("<body>");
		out2.println("<table>");
		out2.println("<tr>\r\n" + "<th>번호</th>\r\n" + "<th>파일명</th>\r\n" + "<th>파일크기</th>\r\n"
				+ "     <th>다운로드</th>\r\n</tr>");

		File path = new File(fileRepository);
		File[] list = path.listFiles();
		for (int i = 0; i < list.length; i++) {
			out2.println("<tr>\r\n" + "<td>" + (i + 1) + "</td>\r\n" + "<td>" + list[i].getName() + "</td>\r\n" + "<td>"
					+ (list[i].length()/1024) + "KB</td>\r\n"
					+ "     <td><input type=\"button\" value=\"다운로드\" onclick=\"location.href='list.do?file="
					+ list[i].getName() + "';\"></td>\r\n</tr>");
		}
		out2.println("</table>");
		out2.println("</body>");
		out2.println("</html>");

		
		
	}
}
