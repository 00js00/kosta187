import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class FileExample {

	public static void main(String[] args) throws IOException {
		String path = "C:/some.dat";
		File file = new File(path);
		System.out.println("존재여부 : " + file.exists());

		path= "C:\\KOSTA187\\설치프로그램\\eclipse-inst-win64.exe";
		file = new File(path);
		System.out.println("파일용량: " + file.length());
		
		System.out.println("변경날자 : " + String.format("%1$tF %1$tT", file.lastModified()));
		
		long ms = file.lastModified();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(ms);
		String ymd = String.format("%1$tF", calendar);
		String time = String.format(" %1$tp %1$tI:%1$tM:%1$tS",calendar);
		System.out.println(ymd + time);
		
		
		
		path = "C:/KOSTA187";
		file = new File(path);
		String temp = null;
		if (file.isDirectory()) {
			temp = "디렉토리";
		}else if( file.isFile()) {
			temp = "파일";
		}
		
		String[] dirNames = file.list()	;
		for ( String name: dirNames) {
			System.out.println(name);
		}
		
		File[] list = file.listFiles()	;
		for (File f : list) {
			if(f.isDirectory()) {
				System.out.println("<DIR>"+ f.getName());
			} else {
				System.out.println(f.getName() +"  " + f.length());
			}
		}
		System.out.println("패스가 디렉토리인지 파일인지 출력" /*+ file3.isDirectory()*/);
		System.out.println(temp);
		System.out.println("디렉토리일 경우 이 디렉토리의 서브디렉토리 목록 출력");
		
		
		path = "example.dat";
		file = new File(path);
		System.out.println("이 파일의 절대경로 출력" + file.getAbsolutePath());
		
		System.out.println(file.toURI());
		
		
		//조작관련 기능들..
		path = "xxx.dat";
		file= new File(path);
		System.out.println(file.createNewFile());
		
		File tempp = File.createTempFile("some", ".data");
		System.out.println(tempp.getAbsolutePath());
		FileOutputStream out = new FileOutputStream(tempp);
		out.write(10);
		
		tempp.deleteOnExit();
		File dir = new File ("c:/KOSTA187/xxx");
//		System.out.println(dir.mkdirs());
		dir.delete();
		File[] drives = File.listRoots()	;
		for (File file2 : drives) {
			System.out.println(file2);
		}
		
	}

}
