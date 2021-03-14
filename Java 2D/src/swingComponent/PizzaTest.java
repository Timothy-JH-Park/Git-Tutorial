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
	// 문구, 타입, 토핑, 크기 패널 생성
	
	TypePanel TypePanel = new TypePanel();
	ToppingPanel ToppingPanel = new ToppingPanel();
	SizePanel SizePanel = new SizePanel();
	
	
	public MyFrame() {
		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("피자 주문");
		
		this.order_button = new JButton("주문");
		
		this.order_button.addActionListener(this);
		this.cancle_button = new JButton("취소");
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
//            System.out.println("타입:" + temp1 + ", 토핑:" + temp2 + ", 사이즈:" + temp3);
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
			message = new JLabel("자바 피자에 오신 것을 환영합니다.");
			this.add(message);
		}
	}
	
	class TypePanel extends JPanel implements ActionListener {
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup bg;
		
		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			
			combo = new JRadioButton("콤보", true);
			combo.addActionListener(this);
			
			potato = new JRadioButton("포테이토");
			potato.addActionListener(this);
			
			bulgogi = new JRadioButton("불고기");
			bulgogi.addActionListener(this);
			
			bg = new ButtonGroup();
			bg.add(combo);
			bg.add(bulgogi);
			bg.add(potato);
			
			setBorder(BorderFactory.createTitledBorder("종류"));
			
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
			
			pepper = new JRadioButton("피망", true);
			pepper.addActionListener(this);
			
			cheese = new JRadioButton("치즈");
			cheese.addActionListener(this);
			
			peperoni = new JRadioButton("페페로니");
			peperoni.addActionListener(this);
			
			bacon = new JRadioButton("베이컨");
			bacon.addActionListener(this);
			
			bg = new ButtonGroup();
			bg.add(pepper);
			bg.add(cheese);
			bg.add(peperoni);
			bg.add(bacon);
			
			setBorder(BorderFactory.createTitledBorder("추가토핑"));
			
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
			
			
			setBorder(BorderFactory.createTitledBorder("크기"));
			
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
