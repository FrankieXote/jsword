
package org.crosswire.jsword.view.swing.passage;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import org.crosswire.jsword.passage.Passage;

/**
 * The PassageTreeModel class implements TreeModel using various custom
 * TreeNodes, and simply extending DefaultTreeModel.
 * PENDING(joe): I think we oughtn't to need to pass the tree in here.
 * 
 * <p><table border='1' cellPadding='3' cellSpacing='0'>
 * <tr><td bgColor='white' class='TableRowColor'><font size='-7'>
 *
 * Distribution Licence:<br />
 * JSword is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License,
 * version 2 as published by the Free Software Foundation.<br />
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br />
 * The License is available on the internet
 * <a href='http://www.gnu.org/copyleft/gpl.html'>here</a>, or by writing to:
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
 * MA 02111-1307, USA<br />
 * The copyright to this program is held by it's authors.
 * </font></td></tr></table>
 * @see docs.Licence
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 * @see DefaultTreeModel
 * @see PassageTreeNode
 */
public class PassageTreeModel extends DefaultTreeModel
{
    /**
    * Basic constructor
    */
    public PassageTreeModel(Passage ref, JTree tree)
    {
        super(new PassageTreeNode(ref, tree));
        this.ref = ref;
    }

    /** The Passagethat we are modeling */
    private Passage ref;
}