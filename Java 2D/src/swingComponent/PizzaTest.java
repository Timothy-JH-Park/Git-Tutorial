package swingComponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener {
	
	private int sum, temp1, temp2, temp3;
	private JButton order_button, cancle_button;
	
	private JPanel down_panel;
	private JTextField text;
	
	WelcomePanel welcom_panel = new WelcomePanel();
	// ����, Ÿ��, ����, ũ�� �г� ����
	
	TypePanel TypePanel = new TypePanel();
	ToppingPanel ToppingPanel = new ToppingPanel();
	SizePanel SizePanel = new SizePanel();
	
	
	public MyFrame() {
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("���� �ֹ�");
		
		this.order_button = new JButton("�ֹ�");
		
		this.order_button.addActionListener(this);
		this.cancle_button = new JButton("���");
		this.cancle_button.addActionListener(this);
		
		this.text = new JTextField();
		text.setEditable(false);
		text.setColumns(6);
		
		down_panel = new JPanel();
		down_panel.add(this.order_button);
		down_panel.add(this.cancle_button);
		down_panel.add(this.text);
		
		this.setLayout(new BorderLayout());
		
		this.add(welcom_panel, BorderLayout.NORTH);
		this.add(down_panel, BorderLayout.SOUTH);
		this.add(SizePanel, BorderLayout.EAST);
		this.add(TypePanel, BorderLayout.WEST);
		this.add(ToppingPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.order_button) {
			
			
//			this.text.setText(" " + );
			sum = 0;
			
            switch (temp1) {
            case 0:
                sum += 1000;
                break;
            case 1:
                sum += 2000;
                break;
            case 2:
                sum += 3000;
                break;
            default:
                break;
            }

            switch (temp2) {
            case 0:
                sum += 1000;
                break;
            case 1:
                sum += 2000;
                break;
            case 2:
                sum += 1500;
                break;
            case 3:
                sum += 2000;
                break;
            default:
                break;
            }

            switch (temp3) {
            case 0:
                sum += 12000;
                break;
            case 1:
                sum += 15000;
                break;
            case 2:
                sum += 18000;
                break;
            default:
                break;
            }
            this.text.setText(" " + sum);
//            text.setText(String.valueOf(sum));
//            System.out.println("Ÿ��:" + temp1 + ", ����:" + temp2 + ", ������:" + temp3);
		}
		
		if (e.getSource() == this.cancle_button) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			
			this.text.setText(" " + sum);
		}
	}
	
	class WelcomePanel extends JPanel {
		private JLabel message;
		
		public WelcomePanel() {
			message = new JLabel("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ActionListener {
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup bg;
		
		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			
			combo = new JRadioButton("�޺�", true);
			combo.addActionListener(this);
			
			potato = new JRadioButton("��������");
			potato.addActionListener(this);
			
			bulgogi = new JRadioButton("�Ұ��");
			bulgogi.addActionListener(this);
			
			bg = new ButtonGroup();
			bg.add(combo);
			bg.add(bulgogi);
			bg.add(potato);
			
			setBorder(BorderFactory.createTitledBorder("����"));
			
			add(combo);
			add(potato);
			add(bulgogi);
			
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == combo) {
	            temp1 = 0;
	            
	         } else if (e.getSource() == potato) {
	            temp1 = 1;
	            
	         } else if (e.getSource() == bulgogi) {
	            temp1 = 2;
	         }
		}
	}
	
	class ToppingPanel extends JPanel implements ActionListener {
		
		private JRadioButton pepper, cheese, peperoni, bacon;
		
		private ButtonGroup bg;
		
		public ToppingPanel() {
			setLayout(new GridLayout(4, 1));
			
			pepper = new JRadioButton("�Ǹ�", true);
			pepper.addActionListener(this);
			
			cheese = new JRadioButton("ġ��");
			cheese.addActionListener(this);
			
			peperoni = new JRadioButton("����δ�");
			peperoni.addActionListener(this);
			
			bacon = new JRadioButton("������");
			bacon.addActionListener(this);
			
			bg = new ButtonGroup();
			bg.add(pepper);
			bg.add(cheese);
			bg.add(peperoni);
			bg.add(bacon);
			
			setBorder(BorderFactory.createTitledBorder("�߰�����"));
			
			add(pepper);
			add(cheese);
			add(peperoni);
			add(bacon);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pepper) {
				temp2 = 0;
            } else if (e.getSource() == cheese) {
                temp2 = 1;
            } else if (e.getSource() == peperoni) {
                temp2 = 2;
            } else if (e.getSource() == bacon) {
                temp2 = 3;
            }
        }
	
	}
	
	class SizePanel extends JPanel implements ActionListener {
		private JRadioButton small, medium, large;
		private ButtonGroup bg;
		
		public SizePanel() {
			setLayout(new GridLayout(3, 1));
			
			small = new JRadioButton("Small", true);
			small.addActionListener(this);
			
			medium = new JRadioButton("Medium");
			medium.addActionListener(this);
			
			large = new JRadioButton("Large");
			large.addActionListener(this);
			
			bg = new ButtonGroup();
			bg.add(small);
			bg.add(medium);
			bg.add(large);
			
			
			setBorder(BorderFactory.createTitledBorder("ũ��"));
			
			add(small);
			add(medium);
			add(large);
		}
		
		@Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == small) {
                temp3 = 0;
            } else if (e.getSource() == medium) {
                temp3 = 1;
            } else if (e.getSource() == large) {
                temp3 = 2;
            }
        }
    
	}
	
}


public class PizzaTest {
	

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
