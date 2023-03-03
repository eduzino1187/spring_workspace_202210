package client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//안드로이드로 폰의 사진 전송을 하려면,  javaSE 의 Http 통신을 다룰줄 알아야 한다. 
public class RegistForm extends JFrame{
	
	JTextField t_category_idx;
	JTextField t_product_name;
	JTextField t_brand;
	JTextField t_price;
	JTextField t_discount;
	JTextArea t_detail;
	JButton bt_file; //파일 탐색기 띄우기 
	JButton bt_regist; //서버에 전송하기 
	JFileChooser chooser;
	
	//Http 통신을 위한 객체 
	HttpURLConnection con;
	String host="http://172.30.1.27:7777/admin/rest/product";
	String hypen="--";
	String boundary="**********";  //하이픈으로 감쌀, 데이터의 경계기준 문자열
	String line="\r\n";
	
	public RegistForm() {
		t_category_idx = new JTextField("1", 25);
		t_product_name = new JTextField(25);
		t_brand = new JTextField(25);
		t_price = new JTextField("250000",25);
		t_discount = new JTextField("195000",25);
		t_detail = new JTextArea();
		bt_file = new JButton("파일찾기");
		bt_regist = new JButton("서버전송");
		chooser = new JFileChooser("C:/js_workspace/images");

		t_detail.setPreferredSize(new Dimension(270, 160));
		
		setLayout(new FlowLayout());
		add(t_category_idx);
		add(t_product_name);
		add(t_brand);
		add(t_price);
		add(t_discount);
		add(t_detail);
		add(bt_file);
		add(bt_regist);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		bt_file.addActionListener((c)->{
			selectFile();
		});
		
		bt_regist.addActionListener((c)->{
			int result=JOptionPane.showConfirmDialog(RegistForm.this, "서버로 전송하시겠어요?");
			if(result !=JOptionPane.OK_OPTION) {
				return;
			}
			
			//네트워크 통신은 별도의 쓰레드로 처리하는게 안정적임..
			//(안드로이드에서는 메인쓰레드 사용금지)
			Thread thread = new Thread() {
				public void run() {
					try {
						regist();
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();	
		});		
	}
	
	public void selectFile() {
		
	}
	
	//text 뿐아니라, 바이너리 파일도 함께 Http방식으로 전송해야 하므로 
	//multipart/form-data로 전송해야 한다...
	public void regist() throws MalformedURLException,IOException{
		
		URL url = new URL(host);
		con=(HttpURLConnection)url.openConnection();
		
		//웹전송을 위한 머리와 몸을 구성하자!!!

		//머리(header)구성하기
		con.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary="+boundary);
		con.setRequestMethod("POST");
		con.setDoOutput(true); //서버에 보낼때
		con.setDoInput(true);//서버에서 가져올때 
		con.setUseCaches(false);
		con.setConnectTimeout(2500);
		
		//body구성하기 (스트림으로 처리)
		DataOutputStream ds=new DataOutputStream(con.getOutputStream());
		
		//텍스트 파라미터의 시작을 알리는 구분자선언 
		ds.writeBytes(hypen+boundary+line);//시작할때
		//바디를 구성하는 요소들간에는 줄바꿈으로 구분한다
		ds.writeBytes("Content-Disposition:form-data;name=\"category.category_idx\""+line);
		ds.writeBytes("Content-Type:text/plaint;charset=UTF-8"+line);
		ds.writeBytes(line);//값 지정 직후에는 라인으로 또 구분
		ds.writeBytes(t_category_idx.getText()+line);
		
		ds.writeBytes(hypen+boundary+line);//시작할때
		//바디를 구성하는 요소들간에는 줄바꿈으로 구분한다
		ds.writeBytes("Content-Disposition:form-data;name=\"product_name\""+line);
		ds.writeBytes("Content-Type:text/plaint;charset=UTF-8"+line);
		ds.writeBytes(line);//값 지정 직후에는 라인으로 또 구분
		ds.writeBytes(t_product_name.getText()+line);
		
		//전송 
		ds.writeBytes(line);
		ds.writeBytes(hypen+boundary+hypen+line);//끝맺을때...
		ds.flush(); //버퍼처리된 출력스트림의 경우  flush()가 사용됨 
		ds.close();
		
		//웹서버부터 받은 http 상태코드로 성공여부를 따져보자 
		int status = con.getResponseCode();
		
		if(status == HttpURLConnection.HTTP_OK) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	public static void main(String[] args) {
		new RegistForm();
	}
}





