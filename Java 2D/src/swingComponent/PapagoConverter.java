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
import javax.swing.WindowConstants;

public class PapagoConverter extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	

    private JButton convertBtn;
    private JButton cancelBtn;
    private JTextArea textIn;
    private JTextArea textOut;

    private static String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
    private static String text;
    private Map<String, String> requestHeaders = new HashMap<>();;

    public PapagoConverter() {
        super("���İ� API �ѱ� ������");

        Dotenv dotenv = Dotenv.load();
        requestHeaders.put("X-Naver-Client-Id", dotenv.get("CLIENT_ID"));
        requestHeaders.put("X-Naver-Client-Secret", dotenv.get("CLIENT_SECRET"));

        textIn = new JTextArea(10, 14);
        textOut = new JTextArea(10, 14);
        textIn.setLineWrap(true);
        textOut.setLineWrap(true);
        textOut.setEditable(false);
        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);
        convertBtn = new JButton("��ȯ");
        cancelBtn = new JButton("���");
        convertBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        JPanel btnPanel = new JPanel();
        btnPanel.add(convertBtn);
        btnPanel.add(cancelBtn);
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertBtn && textIn.getText().length() != 0) {
            textOut.setText("");
            String result = toEnglish(textIn.getText());
            textOut.append(result);
        } else if (e.getSource() == cancelBtn) {
            textOut.setText("");
        }
    }

    private String toEnglish(String korean) {
        try {
            text = URLEncoder.encode(korean, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("���ڵ� ����", e);
        }

        String responseBody = post(apiURL, requestHeaders, text);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(responseBody);
        JsonObject message = jsonObject.getAsJsonObject("message");
        JsonObject result = message.getAsJsonObject("result");

        JsonElement translatedTextJson = result.get("translatedText");
        String translatedText = translatedTextJson.getAsString();
        return translatedText;
    }

    public static void main(String[] args) {
        new PapagoConverter();

    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text) {
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; // �������: �ѱ��� (ko) -> �������: ���� (en)
        try {
            con.setRequestMethod("POST");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ����
                return readBody(con.getInputStream());
            } else { // ���� ����
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ��û�� ���� ����", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
        }
    }
}

