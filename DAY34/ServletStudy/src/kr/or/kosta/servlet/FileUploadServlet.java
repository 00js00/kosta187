package kr.or.kosta.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Apache 파일 업로드 API를 이용한 파일 업로드 처리 서블릿
 */
public class FileUploadServlet extends HttpServlet {

//	private String fileRepository = "C:\\KOSTA187\\workspace\\ServletStudy\\uploadFiles\\";
	private String fileRepository;

	@Override
	public void init() throws ServletException {
		fileRepository = getServletContext().getInitParameter("Location");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

	
//		  String writer = request.getParameter("writer"); //멀티파일 .. 은 못받아옴 --> null
//		  System.out.println("작성자: " + writer); String file =
//		  request.getParameter("upfile"); System.out.println(file);
//		  
//		  // 서블릿 API를 이용한 업로드 파일 데이터 직접 수신 InputStream in = request.getInputStream();
//		  byte[] buffer = new byte[1024]; int count = 0; while((count=in.read(buffer))
//		  != -1){ String data = new String(buffer, 0, count); System.out.println(data);
//		  } in.close();
//		 

		// 아파치 파일 업로드 API를 이용한 파일 수신 및 서버 디렉토리에 저장
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setSizeMax(500 * 1024 * 1024); // 업로드 파일 용량 제한 (필요에 따라 제한)

		List<FileItem> fileList = null;

		try {
			fileList = fileUpload.parseRequest(request); // 파일 정보 전달 전달을 list로 주기
			for (FileItem item : fileList) {
				if (item.isFormField()) {
					String writer = item.getString("utf-8"); // 인코딩 방법의 지정
					System.out.println("작성자: " + writer);
				} else {// 업로드 파일인 경우
					String fileName = item.getName(); // 파일 이름
					System.out.println("업로드 파일명: " + fileName);
					// fileName = c:\xxx\yyy\업로드파일명 : explore는 절대경로로 /chrome은 상대경로로 보내기 때문에
					// 모든 경로에 대한 정보 알 필요 없이 파일명만 알고 싶기 때문에
					// split을 통해 구분자를 지워준다.
					String[] tokens = fileName.split("\\\\");
					fileName = tokens[tokens.length - 1];// 파일명만 추출

					long fileSize = item.getSize();// 파일 용량
					System.out.println("파일사이즈: " + fileSize);

					// 업로드된 파일을 서버의 특정 디렉토리에 저장
					File saveFile = new File(fileRepository + fileName);
					item.write(saveFile);
				}
			}
			// 업로드 결과 Response
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>파일 업로드 완료!</h2>");
			out.println("</body>");
			out.println("</html>");

			// response.sendRedirect("/파일목록처리 서블릿");
		} catch (Exception e) {
			new ServletException(e.getMessage());
		}

	}
}
