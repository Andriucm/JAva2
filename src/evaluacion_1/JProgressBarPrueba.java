package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class JProgressBarPrueba extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 24637375452420510L;

	private JPanel contentPane;

	private Timer timer;
	private JButton btnStart;
	private JProgressBar progressBar;
	private JButton btnStop;
	private JButton btnReiniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JProgressBarPrueba frame = new JProgressBarPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JProgressBarPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 89);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblProgreso = new JLabel("Progreso");
		panel.add(lblProgreso);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		panel.add(progressBar);

		timer = new Timer(100, this);

		btnStart = new JButton("Start");
		btnStart.setBackground(SystemColor.activeCaptionBorder);
		btnStart.addActionListener(this);
		panel.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setBackground(SystemColor.activeCaptionBorder);
		btnStop.addActionListener(this);
		panel.add(btnStop);

		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBackground(SystemColor.activeCaptionBorder);
		btnReiniciar.addActionListener(this);
		panel.add(btnReiniciar);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();

		if (o == btnStart) {
			progressBar.setValue(progressBar.getMinimum());
			timer.start();
		} else {
			if (o == btnReiniciar) {
				progressBar.setValue(0);
				timer.stop();
			} else {
				if (o == btnStop) {
					timer.stop();
				}

				else {
					int valor;
					valor = progressBar.getValue();
					valor++;
					progressBar.setValue(valor);
					if (valor == progressBar.getMaximum()) {
						timer.stop();
					}
				}
			}
		}

	}
}
