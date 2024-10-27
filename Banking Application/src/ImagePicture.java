import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-0-22
 * Description: Inherits from the Picture class, draws ImageIcons
 */
public class ImagePicture extends Picture {
	
	// private data
	private ImageIcon image;

	/**
	 * constructor that takes only an image
	 */
	public ImagePicture(ImageIcon image) {
		// calls the Picture Constructor
		super();
		this.image = image;
		
		// calls Picture setMyWidth and setMyHeight
		setMyWidth(image.getIconWidth());
		setMyHeight(image.getIconHeight());
	}
	
	/**
	 * Constructor to allow an object to be placed in a given x and y
	 */
	public ImagePicture(ImageIcon image, int x, int y) {
		// calling the picture contructor that takes x, y, width, and height
		super(x, y, image.getIconWidth(), image.getIconHeight());
		this.image = image;
	}
	
	/**
	 * create a setter method for the image
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	// overide the paint method
	public void paint(Graphics g) {
		// paint my image
		this.image.paintIcon(this, g, getxPos(), getyPos());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self testing, declare and create an JFrame object
		JFrame f = new JFrame("Testing");
		
		// set size
		f.setSize(400, 350);
		
		// create ImagePicture
		ImagePicture i = new ImagePicture(new ImageIcon("minion.png"));
		
		// add object
		f.add(i);
		
		// set picture visible
		f.setVisible(true);
		
		// wait message
		JOptionPane.showMessageDialog(null, "Wait to move");
		i.setxPos(50);
		i.setyPos(80);
		
		// repaint the frame
		f.repaint();
		
		// wait message
		JOptionPane.showMessageDialog(null, "Wait to place a new object");
		
		// create second ImagePicture
		ImagePicture i2 = new ImagePicture(new ImageIcon("gru.png"), 150, 100);
		
		// add object
		f.add(i2);
		
		// set second picture visible
		f.setVisible(true);
		
		// wait message
		JOptionPane.showMessageDialog(null, "Wait to change the icon");
		
		// set new image to i2
		i2.setImage(new ImageIcon("minion.png"));
		
		// repaint the frame
		f.repaint();

	}

}
