/*
 VerticalGrowJPanel.java:  A JPanel that grows vertically while maintaining the with of it's parent JScrollpane

 Copyright (C) 2009-2014  Richard Eigenmann.
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or any later version. This program is distributed
 in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 more details. You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 The license is in gpl.txt.
 See http://www.gnu.org/copyleft/gpl.html for the details.
 */
package org.tagcloud;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

/**
 * A JPanel that grows vertically while maintaining the with of it's parent
 * JScrollpane. This class was created to work in conjunction with a JScrollPane
 * and FlowLayout. When adding components FlowLayout adds them to the right of
 * each other until the width is filled up. Then FlowLayout adds a line. This
 * class implements Scrollable as this allows us to trap the getPreferredSize
 * and grow the JPanel vertically to show the components. FlowLayout stops
 * horizontally because getScrollableTracksViewportWidth is defined to return
 * true;
 *
 * This is based on the article found here:
 * <a href="http://forums.sun.com/thread.jspa?forumID=57&threadID=5117549&start=7">...</a>
 *
 * @author Richard Eigenmann
 */
public class VerticalGrowJPanel extends JPanel implements Scrollable {

    /**
     * Defines the logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger( VerticalGrowJPanel.class.getName() );

    /**
     * This method gets called by the JScrollPane to figure out the size of the
     * Viewport. The getScrollableTracksViewportWidth prevents the components
     * from growing horizontally but we need to figure out the height.
     *
     * @return the preferred size based on the getWidth and getPreferredHeight
     */
    @Override
    public Dimension getPreferredSize() {
        //LOGGER.fine( String.format( "getPreferredSize is returning Dimension (%d,%d)", d.width, d.height ) );
        return new Dimension( getWidth(), getPreferredHeight() );
    }

    /**
     * This method figures out the height of panel by looking at the location
     * and height of the stacked components. FlowLayout will have taken care of
     * the wrap around. Source:
     * http://forums.sun.com/thread.jspa?forumID=57&threadID=5117549&start=7
     *
     * @return the suggested height
     */
    private int getPreferredHeight() {
        int rv = 0;
        for ( int k = 0, count = getComponentCount(); k < count; k++ ) {
            Component comp = getComponent( k );
            Rectangle r = comp.getBounds();
            int height = r.y + r.height;
            if ( height > rv ) {
                rv = height;
            }
        }
        rv += ( (FlowLayout) getLayout() ).getVgap();
        return rv;
    }

    /**
     * Source:
     * http://forums.sun.com/thread.jspa?forumID=57&threadID=5117549&start=7
     *
     * @return super.getPreferredSize()
     */
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return super.getPreferredSize();
    }

    /**
     * Source:
     * http://forums.sun.com/thread.jspa?forumID=57&threadID=5117549&start=7
     *
     * @param visibleRect The visible rectangle
     * @param orientation The orientation
     * @param direction The direction
     * @return the scrollable block increment
     */
    @Override
    public int getScrollableBlockIncrement( Rectangle visibleRect, int orientation, int direction ) {
        return orientation == SwingConstants.VERTICAL ? getParent().getHeight() : getParent().getWidth();
    }

    /**
     * Allows the JPanel to grow vertically beyond the height of the JScrollPane
     * Viewport.
     *
     * @return false in this case
     */
    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    /**
     * Forces FlowLayout to stop growing horizontally at the width of the
     * JScrollPane's Viewport width.
     *
     * @return true in this class
     */
    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    /**
     * Source:
     * http://forums.sun.com/thread.jspa?forumID=57&threadID=5117549&start=7
     *
     * @param visibleRect The visible rectangle
     * @param orientation The orientation
     * @param direction The direction
     * @return the scrollable unit increment
     */
    @Override
    public int getScrollableUnitIncrement( Rectangle visibleRect, int orientation, int direction ) {
        int scrollAmount = ( orientation == SwingConstants.VERTICAL
                ? getParent().getHeight() : getParent().getWidth() ) / 20;
        return ( scrollAmount == 0 ? 1 : scrollAmount );
    }
}
