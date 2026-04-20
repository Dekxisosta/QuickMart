package gui.util;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

@SuppressWarnings("serial")
public class AutoHideScrollPane extends JScrollPane {

    private final JScrollBar vBar;

    public AutoHideScrollPane(Component view) {
        super(view);

        setBorder(null);
        setOpaque(false);
        getViewport().setOpaque(false);

        vBar = getVerticalScrollBar();
        vBar.setUnitIncrement(16);

        styleScrollBar();
        setupAutoHide();
    }

    private void styleScrollBar() {
        vBar.setOpaque(false);
        vBar.setPreferredSize(new Dimension(6, Integer.MAX_VALUE));
        vBar.setVisible(false);

        vBar.setUI(new BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(120, 120, 120, 160);
                this.trackColor = new Color(0, 0, 0, 0);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton b = new JButton();
                b.setPreferredSize(new Dimension(0, 0));
                b.setMinimumSize(new Dimension(0, 0));
                b.setMaximumSize(new Dimension(0, 0));
                return b;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                // no track
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(thumbColor);
                g2.fillRoundRect(r.x + 2, r.y + 2, r.width - 4, r.height - 4, 10, 10);

                g2.dispose();
            }
        });
    }

    private void setupAutoHide() {
        Runnable show = () -> vBar.setVisible(true);
        Runnable hide = () -> vBar.setVisible(false);

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                show.run();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                hide.run();
            }
        });

        vBar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                show.run();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                hide.run();
            }
        });
    }
}