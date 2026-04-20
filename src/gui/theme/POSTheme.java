package gui.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class POSTheme {
	public static final String[] CATEGORIES = {"Beverages", "Snacks", "Meals", "Desserts", "Bakery"};
	public static final Image ICON = new ImageIcon(POSTheme.class.getResource("/icons/icon.png")).getImage();
	public static final Image TEXTURE3 = new ImageIcon(POSTheme.class.getResource("/images/texture3.png")).getImage();
	public static final Image BG_IMAGE = new ImageIcon(POSTheme.class.getResource("/images/bg_image.jpeg")).getImage();
	public static final Font FONT_MAIN = new Font("Arial", Font.PLAIN, 16);
    public static final Font FONT_BOLD = new Font("Arial", Font.BOLD, 12);
    public static final Font FONT_CART = new Font("Arial", Font.PLAIN, 14);
    public static final Color COLOR_DARK = new Color(120, 90, 170);
    public static final Color COLOR_BG = new Color(45, 35, 75);
}
