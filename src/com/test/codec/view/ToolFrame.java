package com.test.codec.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.test.codec.tool.Base64CodecTool;

public class ToolFrame extends JFrame implements ActionListener{

	private FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER,15,5);
	private JPanel panel=new JPanel();
	private JButton encoderButton=new JButton("编码");
	private JButton decoderButton=new JButton("解码");
	private JLabel inputLabel=new JLabel("输入:");
	private JLabel outputLabel=new JLabel("输出:");
	/*private JTextField inputText=new JTextField(20);
	private JTextField outputText=new JTextField(20);*/
	private JTextArea inputText=new JTextArea(5,30);
	private JTextArea outputText=new JTextArea(5,30);
	private JButton menu1=new JButton("字符串操作");
	private JButton menu2=new JButton("图片操作");
	private Base64CodecTool base64Tool=null;
	
	public ToolFrame() {
		base64Tool=new Base64CodecTool();
		panel.setLayout(flowLayout);
		//panel.add(menuBar);
		panel.add(inputLabel);
		panel.add(inputText);
		panel.add(outputLabel);
		panel.add(outputText);
		panel.add(encoderButton);
		panel.add(decoderButton);
		
		encoderButton.addActionListener(this);
		decoderButton.addActionListener(this);
		this.setTitle("BASE64编解码工具");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setSize(400,300);
		// 窗体大小不变
		this.setResizable(false);
		this.setVisible(true);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("come in");
		if(e.getSource()==encoderButton) {
			String in=inputText.getText();
			String out=base64Tool.encodeString(in);
			outputText.setText(out);
			
		}else if(e.getSource()==decoderButton) {
			String in=inputText.getText();
			String out=base64Tool.decodeString(in);
			outputText.setText(out);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToolFrame toolFreame=new ToolFrame();
	}
}
