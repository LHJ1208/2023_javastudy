package day39.com.ict.exam;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class test {
	
	public static void main(String[] args) {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String pathname = "D:" + File.separator + "njm" + File.separator + "오늘날씨.txt";
		File file = new File(pathname);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			String msg = null;
			StringBuffer sb = new StringBuffer();
			while((msg = br.readLine()) != null) {
				sb.append(msg + '\n');
			}
			
			InputSource in = new InputSource(new StringReader(sb.toString()));
			// XML 파싱 : DOM 방식
			
			DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(in);
			
			//원하는 태그 찾기 (local 태그 찾기)
			NodeList locals = new ;
			StringBuffer sb2 = new StringBuffer();
			
			for(int i = 0; i < locals.getLength(); i++) {
				//태그의 텍스트 구하기
				
				String txt = ;
				
				
				String attr1 = ;
				String attr2 = ;
				sb2.append(txt + "\t");
				sb2.append(attr1 + "\t");
				sb2.append(attr2 + "\t");
			}
			System.out.println("도시\t온도\t상태");
			System.out.println(sb2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
