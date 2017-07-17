package com.github.abhinavmishra14.chatbot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The Class ChatBot.
 */
public class ChatBot extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2467686849887115320L;

	/** The typing area txt. */
	private final JTextField typingAreaTxt = new JTextField();

	/** The chat area. */
	private final JTextArea chatArea = new JTextArea();

	/**
	 * Instantiates a new my bot.
	 */
	public ChatBot() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("MyChatBot");

		typingAreaTxt.setLocation(2, 540);
		typingAreaTxt.setSize(590, 30);

		typingAreaTxt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent actionEvent) {
				final String userText = typingAreaTxt.getText();
				chatArea.append("You: " + userText + "\n");
				if (userText.toLowerCase().contains("hi")) {
					botResponse("Hello there!");
				} else if (userText.toLowerCase().contains("how are you")) {
					int decider = (int) (Math.random() * 2 + 1);
					if (decider == 1) {
						botResponse("I'm doing well, thanks");
					} else if (decider == 2) {
						botResponse("Not too bad");
					}
				} else {
					int decider = (int) (Math.random() * 3 + 1);
					if (decider == 1) {
						botResponse("I didn't get that");
					} else if (decider == 2) {
						botResponse("Please rephrase that");
					} else if (decider == 3) {
						botResponse("I am not sure.");
					}
				}
				typingAreaTxt.setText("");
			}
		});

		chatArea.setLocation(15, 5);
		chatArea.setSize(560, 510);
		chatArea.setEditable(false);

		this.add(typingAreaTxt);
		this.add(chatArea);
	}

	/**
	 * Bot response.
	 *
	 * @param answer the answer
	 */
	public void botResponse(final String answer) {
		chatArea.append("Bot: " + answer + "\n");
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		new ChatBot();
	}
}