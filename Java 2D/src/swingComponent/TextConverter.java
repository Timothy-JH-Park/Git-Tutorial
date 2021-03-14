package swingComponent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TextConverter extends JFrame {

	JButton converter;
	JButton canceler;
	JTextArea textIn;
	JTextArea textOut;
	
	public TextConverter() {
		super("텍스트 변환");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEnabled(false);
		
		// 텍스트 영역을 관리할 패널
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		//버튼
		converter = new JButton("변환");
		canceler = new JButton("취소");
		converter.addActionListener(new ButtonActionListener());
		canceler.addActionListener(new ButtonActionListener());
		
		//버튼 패널
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(canceler);
		buttonPanel.add(converter);
		
		//메인 패널
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(BorderLayout.CENTER, textAreaPanel);
		mainPanel.add(BorderLayout.SOUTH, buttonPanel);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(mainPanel);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
		
		private class ButtonActionListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == converter) {
					textOut.setText("");
					String result = toEnglish(textIn.getText());
					textOut.append(result);
				}
				if (e.getSource() == canceler) {
					textOut.setText("");
				}
				
				
			}
			
			private String toEnglish(String korean) {
				String result = korean;
				result = result.replace("텍스트", "Text");
				result = result.replace("영어", "English");
				
				return result;                                                  
			
			}
		}
		
		
		public static void main(String[] args) {
			TextConverter t = new TextConverter();
		
		}
		

		
		
	}
	
	

