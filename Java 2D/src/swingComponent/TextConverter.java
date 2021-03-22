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
		super("�ؽ�Ʈ ��ȯ");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEnabled(false);
		
		// �ؽ�Ʈ ������ ������ �г�
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		//��ư
		converter = new JButton("��ȯ");
		canceler = new JButton("���");
		converter.addActionListener(new ButtonActionListener());
		canceler.addActionListener(new ButtonActionListener());
		
		//��ư �г�
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(canceler);
		buttonPanel.add(converter);
		
		//���� �г�
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
				result = result.replace("�ؽ�Ʈ", "Text");
				result = result.replace("����", "English");
				
				return result;                                                  
			
			}
		}
		
		
		public static void main(String[] args) {
			TextConverter t = new TextConverter();
		
		}
		

		
		
	}
	
	

