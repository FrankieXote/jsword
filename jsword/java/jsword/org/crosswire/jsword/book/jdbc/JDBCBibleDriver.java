
package org.crosswire.jsword.book.jdbc;

import java.io.IOException;
import java.net.MalformedURLException;

import org.crosswire.jsword.book.Bible;
import org.crosswire.jsword.book.BibleDriverManager;
import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.book.basic.LocalURLBibleDriver;
import org.crosswire.jsword.book.basic.LocalURLBibleMetaData;
import org.crosswire.jsword.book.events.ProgressListener;

/**
 * This represents all of the JDBCBibles.
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
 */
public class JDBCBibleDriver extends LocalURLBibleDriver
{
    /**
     * Some basic driver initialization. If we couldn't get a Bibles root
     * then just give a warning but do no more. Perhaps there are other
     * BibleDrivers that can cope, so this needent be a big error.
     */
    private JDBCBibleDriver() throws MalformedURLException, IOException
    {
        super("jdbc");
    }

    /**
     * Some basic info about who we are
     * @param A short identifing string
     */
    public String getDriverName()
    {
        return "Database";
    }

    /**
     * Do the real creation using the right meta data
     */
    public Bible getBible(LocalURLBibleMetaData bbmd) throws BookException
    {
        return new JDBCBible(bbmd);
    }

    /**
     * We are read-only so do nothing
     * @param name The name of the version to create
     * @exception BookException If the name is not valid
     */
    public Bible create(Bible source, ProgressListener li) throws BookException
    {
        throw new BookException("jdbc_driver_readonly");
    }

    /**
     * We are read-only so do nothing
     */
    public Bible createBible(LocalURLBibleMetaData lbmd, Bible source, ProgressListener li) throws BookException
    {
        throw new BookException("jdbc_driver_readonly");
    }

    /** The singleton driver */
    protected static JDBCBibleDriver driver;

    /**
     * Register ourselves with the Driver Manager
     */
    static
    {
        try
        {
            driver = new JDBCBibleDriver();
            BibleDriverManager.registerDriver(driver);
        }
        catch (Exception ex)
        {
            log.info("JDBCBibleDriver init failure", ex);
        }
    }
}
