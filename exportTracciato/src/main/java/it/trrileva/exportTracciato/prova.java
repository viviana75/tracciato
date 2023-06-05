package it.trrileva.exportTracciato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class prova {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        Easter easter = new Easter();
        
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date pasquetta = new Date();
        Calendar calendar = new GregorianCalendar();

        try {
            pasquetta = simpleDateFormat.parse("2022-04-18");
            calendar.setTime(pasquetta);
        } catch (ParseException ex) {
            Logger.getLogger(prova.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            System.out.println(easter.isEaster(calendar.getTime()));
        } catch (Easter.YearOutOfRangeException ex) {
            Logger.getLogger(prova.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	/**
	 * Create the application.
	 */
	public prova() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
