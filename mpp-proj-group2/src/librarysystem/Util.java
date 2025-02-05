package librarysystem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.*;

public class Util {
	public static final Color DARK_BLUE = Color.BLUE.darker();
	public static final Color ERROR_MESSAGE_COLOR = Color.RED.darker(); //dark red
	public static final Color INFO_MESSAGE_COLOR = new Color(24, 98, 19); //dark green
	public static final Color LINK_AVAILABLE = DARK_BLUE;
	public static final Color LINK_NOT_AVAILABLE = Color.gray;
	//rgb(18, 75, 14)
	
	public static Font makeSmallFont(Font f) {
        return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
    }

	public static void adjustLabelFont(JComponent label, Color color, boolean bigger) {
		if(bigger) {
			Font f = new Font(label.getFont().getName(), 
					label.getFont().getStyle(), (label.getFont().getSize()+2));
			label.setFont(f);
		} else {
			Font f = new Font(label.getFont().getName(), 
					label.getFont().getStyle(), (label.getFont().getSize()-2));
			label.setFont(f);
		}
		label.setForeground(color);
		
	}
	/** Sorts a list of numeric strings in natural number order */
	public static List<String> numericSort(List<String> list) {
		Collections.sort(list, new NumericSortComparator());
		return list;
	}
	
	static class NumericSortComparator implements Comparator<String>{
		@Override
		public int compare(String s, String t) {
			if(!isNumeric(s) || !isNumeric(t)) 
				throw new IllegalArgumentException("Input list has non-numeric characters");
			int sInt = Integer.parseInt(s);
			int tInt = Integer.parseInt(t);
			if(sInt < tInt) return -1;
			else if(sInt == tInt) return 0;
			else return 1;
		}
	}
	
	public static boolean isNumeric(String s) {
		if(s==null) return false;
		try {
			Integer.parseInt(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}

	public static ImageIcon createGreenCheckIcon() {
		// Create a green checkmark icon
		int size = 32;
		BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(5, size / 2, size / 2 - 2, size - 5);
		g2d.drawLine(size / 2 - 2, size - 5, size - 5, 5);
		g2d.dispose();
		return new ImageIcon(image);
	}
}
